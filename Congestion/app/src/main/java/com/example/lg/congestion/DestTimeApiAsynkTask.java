package com.example.lg.congestion;

import android.os.AsyncTask;

import java.util.HashMap;
import java.util.Map;


public class DestTimeApiAsynkTask extends AsyncTask<Map<String,Object>,Void,Map<String, Object>> {

    @Override
    protected Map<String, Object> doInBackground(Map<String, Object>... params) {
        MetroAPIConnecter metroAPIConnecter = new MetroAPIConnecter();

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

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("lineNum", line_num);
        resultMap.put("stationNm", station_nm);

        return resultMap;
    }
}
