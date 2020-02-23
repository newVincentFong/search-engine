package com.vincentfong.spyder;

import com.vincentfong.spyder.Https;
import com.vincentfong.spyder.Html;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.bilibili.com";
        String html =  Https.get(url);
        Html.extractBilibili(html);
    }
}
