package com.example.mgronline.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Getcontent {
        public JSONObject inputurl(String url) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("Y-M-d HH:mm:ss");
        
        JSONObject mgronline = new JSONObject();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements titles = doc.select(".header-article h1");
            Elements date = doc.select(".article time");
            Elements contents = doc.select(".article-content");
            Elements sources = doc.select(".logo-lbtn");
            Elements source = sources.select("img");

            
            mgronline.put("text_title", titles.text());    
            mgronline.put("text_description", contents.text());
            mgronline.put("text_date", date.text());
            mgronline.put("language", "th");
            mgronline.put("source", source.attr("title"));
            mgronline.put("url",url);
            //mgronline.put("datetime", dateFormat.format(new Date()));

           
        } catch (Exception e) {
            //TODO: handle exception
        }
         return mgronline;
    }
}
