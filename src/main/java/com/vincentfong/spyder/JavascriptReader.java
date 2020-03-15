package com.vincentfong.spyder;

import java.io.*;

/**
 * @reference https://blog.csdn.net/IManiy/article/details/83834360
 */
public class JavascriptReader {
    static String read(String path) {
        // String path="C:/Users/Admin/Desktop/products.txt";
        File file=new File(path);
        BufferedReader reader = null;
        String tempString = null;
        String wholeStirng = "";
        int line =1;
        try {
            // System.out.println("以行为单位读取文件内容，一次读一整行：");
            System.out.println("读取中：");
            System.out.println( path );
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((tempString = reader.readLine()) != null) {
                // System.out.println("Line"+ line + ":" +tempString);
                System.out.println(tempString);
                wholeStirng += tempString;
                line ++ ;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return wholeStirng;
    }
}
