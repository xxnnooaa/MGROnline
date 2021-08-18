package com.example.mgronline.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;

public class Changecontent {
    public  void inputcontent(JSONObject con){

       // JSONObject mgrcontent = new JSONObject();

        try {

            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("http://192.168.0.142:8888/text_analytic")
            .header("Content-Type", "application/json")
            .body(con.toString())
            .asString();

            //  get ข้อมูลที่ได้จากการ call Api 
            String data = response.getBody();

            //  แปลง String เป็น Json 
            JSONObject objs = new JSONObject(data);

            String md5 = DigestUtils.md5Hex(objs.toString());

            objs.put("MD5", md5);
            objs.put("excise_title", con.getString("text_title"));
            objs.put("excise_date", "เผยแพร่: "+ con.getString("text_date"));
            objs.put("language",con.getString("language"));
            objs.put("source", con.getString("source"));
            objs.put("url", con.getString("url"));
            //objs.put("datetime",data);

            /*System.out.println("Data JSON");
            System.out.println("////////////");
            System.out.println(objs.toString(2));
            System.out.println("///////////");*/

            Inputmgronline es = new Inputmgronline();
            es.inputJSONObject(objs);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
