package com.example.mgronline.service;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

public class Getlink {

    public JSONArray inputlink(String newslink) {

        JSONArray mglinklists = new JSONArray();
        
        try {
            Document doc = Jsoup.connect(newslink).get();
            Elements mglinks = doc.select(".article-content .link");
            Elements newslinks = mglinks.select("a[href]");

            for (int i = 0; i < newslinks.size(); i++) {
                mglinklists.put(newslinks.get(i).attr("href"));
            }
            System.out.println(mglinklists.toString(2));


        } catch (Exception e) {
            // TODO: handle exception
        }
        return mglinklists;
    }

}
