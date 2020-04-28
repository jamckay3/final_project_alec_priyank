package com.example.finalproject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class TempScrape {
    public void test() throws IOException {
        Document doc;
        doc = Jsoup.connect("http://catalog.illinois.edu/courses-of-instruction/").get();
    }
}
