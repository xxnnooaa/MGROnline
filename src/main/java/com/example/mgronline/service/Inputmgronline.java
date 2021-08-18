package com.example.mgronline.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONObject;

public class Inputmgronline {
    public void inputJSONObject(JSONObject obj){
            try {
                String md5 = obj.getString("MD5");
                
                HttpResponse<String> jsonresponse = Unirest.post("http://localhost:9200/mgr_content/_doc/"+md5)
                .header("Content-Type", "application/json")
                .body(obj.toString())
                .asString();
            } catch (UnirestException e) {
                e.printStackTrace();
            }  
    }
}

