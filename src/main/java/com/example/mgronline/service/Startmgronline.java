package com.example.mgronline.service;

import org.json.JSONArray;
import org.json.JSONObject;

public class Startmgronline {
    public static void main(String[] args) {
        Getlink link = new Getlink();

        JSONArray urls = link.inputlink("https://mgronline.com/tags/%E0%B8%A2%E0%B8%B2%E0%B8%AA%E0%B8%B9%E0%B8%9A");
    
        for(int i=0; i<urls.length(); i++){

            Getcontent content = new Getcontent();
            JSONObject obj = content.inputurl(urls.get(i).toString());

            Changecontent es = new Changecontent();
            es.inputcontent(obj);
        }
    
    }
}
