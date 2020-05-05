package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupMusic extends AppCompatActivity {

    private String songNameBaby;
    private int ranking;

    // gets song ranking form billboard charts
    public String getSong(final int setRanking) {
        ranking = setRanking;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // getting html from billboard
                    Document doc = Jsoup.connect("https://www.billboard.com/charts/billboard-200").get();

                    // getting the ordered list that is for the top 200 songs
                    Element orderedList = doc.select("ol.chart-list__elements").first();

                    // getting each list items from that ordered list
                    Elements listItems = orderedList.children();

                    // getting the list item at the ranking specified
                    Element listItem = listItems.get(setRanking);

                    // these next two steps are b/c the html is structured weirdly
                    // getting child from list item (only child is <button>)
                    Element button = listItem.children().first();

                    // getting children from button
                    Elements buttonChildren = button.children();

                    // getting second element in button children which contains song name inside another nested span
                    Element spanInfo = buttonChildren.get(1);

                    // getting (only) child from spanInfo || note "child(0)" is equivalent to "children().first()"
                    Element spanNested = spanInfo.child(0);

                    // extracting content from spanNested element
                    String songName = spanNested.ownText();

                    songNameBaby = songName;



                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("yoyoyoy i wrote a rap");

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }).start();
        System.out.println("Song name baby " + songNameBaby);
        return songNameBaby;
    }
}