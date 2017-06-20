package com.example.lg.congestion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;

public class SecondActivity extends Activity implements View.OnClickListener{
    String station;
    Calendar cal = Calendar.getInstance();

    String[] items = {"강남역","역삼역", "선릉역", "삼성역", "종합운동장역", "신천역",
            "잠실역", "잠실나루역", "강변역", "구의역", "건대입구역",
            "성수역", "뚝섬역", "한양대역", "왕십리역", "상왕십리역",
            "신당역", "동대문역사문화공원역", "을지로4가역", "을지로3가역", "을지로입구역",
            "시청역", "충정로역", "아현역", "이대역", "신촌역",
            "홍대입구역", "합정역", "당산역", "영등포구청역", "문래역",
            "신도림역", "대림역", "구로디지털단지역", "신대방역", "신림역",
            "봉천역", "서울대입구역", "낙성대역", "사당역", "방배역",
            "서초역", "교대역"};

    int[] timetable = { 546, 602,    612,    619,    626,    630,    636,    642,    649,    655,    659,
            702,    709,    713,    716,    723,    727,    730,    734,    737,    741,    745,    749,    752,    756,    759,
            803,    806,    809,    812,    816,    819,    822,    825,    829,    832,    835,    838,    842,    846,    849,    852,   856,
            900,    903,    906,    909,    913,    917,    921,    924,    927,    931,    934,    937,    940,    944,    947,    950,   953,    956,    959,
            1002,    1009,    1012,    1016,    1022,    1026,    1029,    1033,    1039,    1043,    1048,    1052,    1058,
            1102,    1108,    1111,    1114,   1120,    1123,    1126,    1132,    1139,    1145,    1151,    1157,
            1203    ,1208    ,1213    ,1219    ,1228    ,1233    ,1238    ,1244    ,1250,  1256,
            1302,    1308,    1314,    1321,    1326,    1332,    1337,    1342,    1349,   1357,
            1403,    1408,    1414,    1420,    1426,    1432,    1438,    1444,    1450   ,1456,
            1502,    1507,    1512,    1519,    1527,    1533,    1538,    1544,    1550,    1556,
            1602,    1608,    1614,    1620,    1626,   1632,    1637,    1643,    1648,    1653,    1657,
            1703,    1708,    1714,    1720,    1726,    1732,    1738,   1743,    1746,    1750,    1753,    1756,    1759,
            1802,    1807,    1810,    1813,    1816,    1819,    1823,    1827,    1830,    1833,    1838,    1841,    1844,   1847,    1850,    1853,    1856,    1859,
            1902,    1905,    1908,    1911,    1914,    1917 ,   1920   , 1923   , 1926 ,   1930   , 1932  ,  1935  ,  1937  ,  1940 ,   1943  ,  1946 ,   1950   , 1953 ,   1957,
            2000,    2003,    2007,    2011,    2014,    2017,    2020,    2023,    2026,    2030,    2035,    2038,    2041,    2045,    2050,    2053,    2057,
            2101,    2105,    2109,    2113,    2118,   2123,    2127,    2131,    2137,    2142,    2148,    2154,
            2200,    2205,    2211,    2216,   2222,    2227,    2232,   2238,    2243,    2248,    2254,
            2301,    2307,    2312,    2318,    2325,    2330,    2335,    2341,    2346,    2352,    2356,
            2403,    2409,    2419,    2431,    2443,    2456};

    int[] timetable2 = {  535    ,548    ,554, 600,    606,    611,    617,    622,    627,    632,    636,    641,    646,    651,    656,
            701,    706,    711,    715,    721,    725,    728,   731,    734,    736,    739,    742,    745,    748,    751,    754,    756,    759,
            801,    804,    806,    809,    811,    814,    816,    819,    821,    824,    826,    829,    831,    834,    836,    839,    841,    844,    848,    850,    854,    858,
            901,    904,    906,    909,    912,    915,    918,    923,    926 ,   929,    931,    934,    939,    941,    943,    945,    948,    950,    953,    955,    958 ,
            1003,    1008,    1010    ,1013 ,     1018,    1021,    1027 ,   1031 ,   1036 , 1042 ,   1048,    1053,    1059,
            1104,    1108,    1113,    1118,    1123,    1128,    1133,    1139,    1143,    1149,    1156,
            1201,    1206,    1212,    1218,    1223,    1229,    1234,    1239,    1244,    1249,    1254,    1259,
            1304,    1309,    1314,    1319,    1325,    1331,    1336,    1342,    1348,    1354,    1359,
            1404,    1409,    1414,    1419,    1424,    1429,    1434,    1439,    1444,    1449,    1455,
            1501,    1506,    1512,    1518,    1524,    1529,    1534,    1539,    1544,    1549,    1554,    1559,
            1604,   1609,    1614,    1620,    1625,    1631,    1636,    1642,    1648 ,   1651,    1654,
            1700,    1704,    1708,    1712 ,   1715,    1719 ,   1724 ,   1728 ,   1732 ,   1735 ,   1739,    1743,   1747,   1750,    1754,    1758,
            1802,    1806,   1809,    1812,    1815,    1818,    1821,    1824,    1827,    1830 ,   1834,    1838,    1842 ,   1845,    1849,    1854,    1858,
            1902,    1905,    1909,    1913,    1917,    1920,    1924,   1928,    1932,    1936,    1939,    1945,    1948,    1951,    1957,
            2001,    2008,    2012,    2019,    2024,    2028,    2032,    2036,    2043,    2048,    2053,    2058,
            2103,    2109,    2115,    2121,    2128,    2134,    2142,    2149,    2154,
            2203,    2212,    2218,    2223,    2229,    2234,    2241,    2250,    2258,
           2305,    2313,    2324,    2334,    2342,    2349,
            2400,    2412,   2428,    2445  };



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String second_station = "";
        Bundle extras = getIntent().getExtras();
        int hour = cal.get(cal.HOUR_OF_DAY) ;
        int min = cal.get ( cal.MINUTE );
        int time = hour*100 + min;
        int temp;
        int temp2;
        int i;
        int j;

        String up1;
        String up2;
        String up3;
        String down1;
        String down2;
        String down3;

        if (extras != null) {
            second_station = extras.getString("main_station");
        }
        TextView stationName = (TextView)this.findViewById(R.id.station);
        TextView stationName1 = (TextView)this.findViewById(R.id.station2);
        TextView stationName2 = (TextView)this.findViewById(R.id.station3);
        TextView uptime1 = (TextView)this.findViewById(R.id.up1);
        TextView uptime2 = (TextView)this.findViewById(R.id.up2);
        TextView uptime3 = (TextView)this.findViewById(R.id.up3);
        TextView downtime1 = (TextView)this.findViewById(R.id.down1);
        TextView downtime2 = (TextView)this.findViewById(R.id.down2);
        TextView downtime3 = (TextView)this.findViewById(R.id.down3);

        exit_For:
        for(i = 0; i < timetable.length; i++){

            if(timetable[i] > time){
                temp = i;
                break exit_For;
            }
        }
        exit_For:
        for(j = 0; j < timetable2.length; j++){

            if(timetable2[j] > time){
                temp2 = j;
                break exit_For;
            }
        }
        up1 = String.valueOf((timetable[i]- time));
        up2 = String.valueOf(timetable[i+1]- time);
        up3 = String.valueOf(timetable[i+2]- time);
        down1 = String.valueOf(timetable2[j]-time);
        down2 = String.valueOf(timetable2[j+1]-time);
        down3 = String.valueOf(timetable2[j+1]- time);



        if(second_station.equals("강남역")) {
            stationName1.setText("역삼역");
            stationName2.setText("교대역");
        }
        else if(second_station.equals("교대역")){
            stationName1.setText("강남역");
            stationName2.setText("서초역");

        }
        else if((second_station != "강남역") && (second_station != "교대역")) {
            stationName1.setText(items[Arrays.asList(items).indexOf(second_station) + 1]);
            stationName2.setText(items[Arrays.asList(items).indexOf(second_station) - 1]);
        }


        stationName.setText(second_station);
        uptime1.setText(up1+"분");
        uptime2.setText(up2+"분");
        uptime3.setText(up3+"분");
        downtime1.setText(down1 +"분");
        downtime2.setText(down2 +"분");
        downtime3.setText(down3 +"분");

        ImageView metro1 = (ImageView) this.findViewById(R.id.metro1);
        ImageView metro2 = (ImageView) this.findViewById(R.id.metro2);
        ImageView metro3 = (ImageView) this.findViewById(R.id.metro3);
        ImageView metro4 = (ImageView) this.findViewById(R.id.metro4);
        ImageView metro5 = (ImageView) this.findViewById(R.id.metro5);
        ImageView metro6 = (ImageView) this.findViewById(R.id.metro6);

        metro1.setOnClickListener(this);
        metro2.setOnClickListener(this);
        metro3.setOnClickListener(this);
        metro4.setOnClickListener(this);
        metro5.setOnClickListener(this);
        metro6.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.metro1: {
                Intent intent1 = new Intent(this, ThirdActivity.class);
                startActivity(intent1);
                break;
            }
            case R.id.metro2: {
                Intent intent2 = new Intent(this, ThirdActivity.class);
                startActivity(intent2);
                break;
            }
            case R.id.metro3: {
                Intent intent3 = new Intent(this, ThirdActivity.class);
                startActivity(intent3);
                break;
            }
            case R.id.metro4: {
                Intent intent4 = new Intent(this, ThirdActivity.class);
                startActivity(intent4);
                break;
            }
            case R.id.metro5: {
                Intent intent5 = new Intent(this, ThirdActivity.class);
                startActivity(intent5);
                break;
            }
            case R.id.metro6: {
                Intent intent6 = new Intent(this, ThirdActivity.class);
                startActivity(intent6);
                break;
            }

        }

    }
}
