package com.vincentfong.spyder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @reference https://blog.csdn.net/pleasecallmewhy/article/details/17594303
 */
public class Http {
    static String get(String url) {
        String response = "";
        BufferedReader stream = null;
        try {
            URL Url = new URL(url);
            URLConnection Connection = Url.openConnection();
            Connection.connect();
            stream = new BufferedReader( new InputStreamReader( Connection.getInputStream() ) );
            String line;
            while ( ( line = stream.readLine() ) != null ) {
                response += line;
            }
        } catch (Exception e) {
            System.out.println("Get Error" + e);
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        }
        return response;
    }

    public static void main(String[] args) {
        String url = "https://www.bilibili.com";
        System.out.println( get(url) );
    }
}
