package com.example.lg.apihelp;

public class MetroAPITest {

   public static void main(String[] args) {
      
      MetroAPIConnecter apiConnecter=new MetroAPIConnecter();
      YeonJoPaser jPaser=new YeonJoPaser();
      
      
      
       String key="616147767479756e3538704c4b616d";
       String STATION_CD="0151";
       String WEEK_TAG="1";
       String INOUT_TAG="1";
      
      String jsonStr= apiConnecter.callMetroDataGET(key, STATION_CD, WEEK_TAG, INOUT_TAG);
      
      
      String line_num =jPaser.jsonPasing(jsonStr, "LINE_NUM");
      String station_nm=jPaser.jsonPasing(jsonStr, "STATION_NM");
      
      
      System.out.println(line_num );

      System.out.println(station_nm);
      
      
      //System.out.println(jsonStr);
      
      
      
   }

}