package com.vincentfong.spyder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @reference https://www.cnblogs.com/ncy1/p/9684330.html
 */
public class Https {
    static String get(String url) {
        StringBuffer buffer = null;
        try {
            SSLContext context = SSLContext.getInstance("SSL");
            TrustManager[] managers = { new FakeX509TrustManager() };
            context.init(null, managers, new java.security.SecureRandom());

            SSLSocketFactory factory = context.getSocketFactory();
            URL Url = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection)Url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("GET");
            // Fake Browser
            connection.setRequestProperty("User-agent", "	Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0");
            connection.setSSLSocketFactory(factory);
            connection.connect();

            InputStream stream = connection.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(stream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            buffer = new StringBuffer();
            String line = null;
            while( (line = bufferedReader.readLine()) != null ) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String url = "https://www.bilibili.com";
        System.out.println( get(url) );
    }
}
