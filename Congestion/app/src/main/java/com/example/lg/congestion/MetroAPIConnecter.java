package com.example.lg.congestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class MetroAPIConnecter {

   public String callMetroDataGET(String key, String STATION_CD, String WEEK_TAG, String INOUT_TAG) {
      URL url = null;

      URLConnection urlConnection = null;

      // URL 주소
      // String key="616147767479756e3538704c4b616d";
      String serviceName = "SearchSTNTimeTableByIDService";
      // String STATION_CD="0151";
      // String WEEK_TAG="1";
      // String INOUT_TAG="1";

      String sUrl = "http://openAPI.seoul.go.kr:8088/" + key + "/json/" + serviceName + "/1/999/" + STATION_CD + "/"
            + WEEK_TAG + "/" + INOUT_TAG + "/";
      String jsonResult = null;
      try {

         // Get방식으로 전송 하기

         url = new URL(sUrl);

         urlConnection = url.openConnection();

         // Response받기

         StringBuffer sb = new StringBuffer();

         BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

         for (;;) {

            String line = br.readLine();

            if (line == null)
               break;

            sb.append(line + "\n");

         }

         jsonResult = sb.toString();
         // System.out.println(jsonResult);

      } catch (Exception e) {

         e.printStackTrace();

      }
      return jsonResult;

   }

}