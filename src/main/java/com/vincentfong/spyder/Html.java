package com.vincentfong.spyder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @reference https://www.cnblogs.com/sam-uncle/p/10922366.html
 */
public class Html {
    static void extractBilibili(String html) {
        Document document = Jsoup.parse(html);
        Elements titles = document.getElementsByClass("title");
        for (Element title : titles) {
            System.out.println(title.text());
        }
    }
}
