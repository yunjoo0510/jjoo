package com.example.lg.congestion;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by LG on 2017-06-17.
 */

public class ThirdMKServerRecieveCo2 extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {
        URL url = null;
        try {
            url = new URL("http://192.168.20.52:8081/SeinerProjectServer03/Co2Servlet");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // 문자열로 URL 표현
        System.out.println("URL :" + url.toExternalForm());

        // HTTP Connection 구하기
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 요청 방식 설정 ( GET or POST or .. 별도로 설정하지않으면 GET 방식 )
        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        // 연결 타임아웃 설정
        conn.setConnectTimeout(3000); // 3초
        // 읽기 타임아웃 설정
        conn.setReadTimeout(3000); // 3초

        /*// 요청 방식 구하기
        System.out.println("getRequestMethod():" + conn.getRequestMethod());
        // 응답 콘텐츠 유형 구하기
        System.out.println("getContentType():" + conn.getContentType());
        // 응답 코드 구하기
        System.out.println("getResponseCode():"    + conn.getResponseCode());
        // 응답 메시지 구하기
        System.out.println("getResponseMessage():" + conn.getResponseMessage());*/

        String s = "";

        // 응답 내용(BODY) 구하기
        try {
            try (InputStream in = conn.getInputStream();
                 ByteArrayOutputStream out = new ByteArrayOutputStream()) {

                byte[] buf = new byte[1024 * 8];
                int length = 0;
                while ((length = in.read(buf)) != -1) {
                    out.write(buf, 0, length);
                }
                System.out.println(new String(out.toByteArray(), "UTF-8"));

                s =new String(out.toByteArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 접속 해제
        conn.disconnect();

        return s;
    }
}
