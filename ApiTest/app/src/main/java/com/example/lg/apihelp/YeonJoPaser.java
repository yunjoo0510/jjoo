package com.example.lg.apihelp;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class YeonJoPaser {

   
   public String jsonPasing(String jsonResult,String whatyouWant){
      JsonElement jelement = new JsonParser().parse(jsonResult);
       JsonObject  jobject = jelement.getAsJsonObject();
       jobject = jobject.getAsJsonObject("SearchSTNTimeTableByIDService");
       JsonArray jarray = jobject.getAsJsonArray("row");
       jobject = jarray.get(0).getAsJsonObject();
       String result = jobject.get(whatyouWant).toString();
      
       return result;
       
   }
   
}