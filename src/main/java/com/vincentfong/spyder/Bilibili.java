package com.vincentfong.spyder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class Bilibili {
    static String url = "https://www.bilibili.com";

    /**
     * @reference https://www.cnblogs.com/sam-uncle/p/10922366.html
     */
    static void getTitlesByJsoup(String html) {
        Document document = Jsoup.parse(html);
        Elements titles = document.getElementsByClass("title");
        for (Element title : titles) {
            System.out.println(title.text());
        }
    }

    static void getTitlesBySelenium(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String path = Bilibili.class.getClassLoader().getResource("static/ScrollToBottom.js").getPath();
        String script = JavascriptReader.read(path);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(script);
        Thread.sleep(15 * 1000);
        driver.findElements(By.className("title"))
                .stream()
                .filter(title->!title.getText().isEmpty())
                .collect(Collectors.toList())
                .forEach(
                    item -> {
                        System.out.println(item.getText());
                    }
                );
    }

    public static void main(String[] args) throws InterruptedException {
        // String html = Https.get(url);
        // getTitlesByJsoup(html);
        getTitlesBySelenium(url);
    }
}
