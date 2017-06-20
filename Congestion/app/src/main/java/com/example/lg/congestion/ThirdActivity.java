package com.example.lg.congestion;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;

/**
 * Created by LG on 2017-04-12.
 */

public class ThirdActivity extends AppCompatActivity implements Button.OnClickListener {
    public ImageView image1, image2,image3, image4, image5, image6, image7, image8, image9, image10, density;
    TextView small1, small2, small3, big1, big2, big3;
    Button button;
    public static int[] color = new int[30];
    public static String[] station = new String[6];
    public static String[] a = new String[37];
    public static String result = null;
    private ThirdMKServerRecieveCo2 thirdMKServerRecieveCo2 = new ThirdMKServerRecieveCo2();
    private MKThread mkThread = new MKThread();
    //private TextView tvServerMessage;
    TextView myText;
    private boolean myTextOn = true;
    private final MyHandler mHandler = new MyHandler(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        image1 = (ImageView) this.findViewById(R.id.imageView1);
        image2 = (ImageView) this.findViewById(R.id.imageView2);
        image3 = (ImageView) this.findViewById(R.id.imageView3);
        image4 = (ImageView) this.findViewById(R.id.imageView4);
        image5 = (ImageView) this.findViewById(R.id.imageView5);
        image6 = (ImageView) this.findViewById(R.id.imageView6);
        image7 = (ImageView) this.findViewById(R.id.imageView7);
        image8 = (ImageView) this.findViewById(R.id.imageView8);
        image9 = (ImageView) this.findViewById(R.id.imageView9);
        image10 = (ImageView) this.findViewById(R.id.imageView10);
        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);
        density = (ImageView) this.findViewById(R.id.density);

        image1.setImageResource(R.drawable.metro1);
        image2.setImageResource(R.drawable.metro1);
        image3.setImageResource(R.drawable.metro1);
        image4.setImageResource(R.drawable.metro1);
        image5.setImageResource(R.drawable.metro1);
        image6.setImageResource(R.drawable.metro1);
        image7.setImageResource(R.drawable.metro1);
        image8.setImageResource(R.drawable.metro1);
        image9.setImageResource(R.drawable.metro1);
        image10.setImageResource(R.drawable.metro1);

        density.setImageResource(R.drawable.density3);

        small1 = (TextView) this.findViewById(R.id.small1);
        small2 = (TextView) this.findViewById(R.id.small2);
        small3 = (TextView) this.findViewById(R.id.small3);
        big1 = (TextView) this.findViewById(R.id.big1);
        big2 = (TextView) this.findViewById(R.id.big2);
        big3 = (TextView) this.findViewById(R.id.big3);

        //small1.setText("1 번칸");
        //small2.setText("3 번칸");
        //small3.setText("4 번칸");
        //big1.setText("5 번칸");
        //big2.setText("6 번칸");
        //big3.setText("7 번칸");


        //image1.setBackgroundColor(Color.rgb(209, 255, 202));
        //image2.setBackgroundColor(Color.rgb(255,255 , 72));
        // image3.setBackgroundColor(Color.rgb(83, 255, 76));
        // image4.setBackgroundColor(Color.rgb(209, 255, 202));
        // image5.setBackgroundColor(Color.rgb(255, 108, 108));
        // image6.setBackgroundColor(Color.rgb(255, 0, 0));
        // image7.setBackgroundColor(Color.rgb(255, 183, 183));
        // image8.setBackgroundColor(Color.rgb(255, 89, 89));
        //image9.setBackgroundColor(Color.rgb(255, 0, 0));

        try {
            //Toast.makeText(this, thirdMKServerRecieveCo2.execute("").get().toString(), Toast.LENGTH_LONG).show();

            //서버랑 hhtp 통신으로 json 문자열을 받아옴 그 결과값이
            // {"timeStamp":"2017-06-17 14:20:10.0","co2Value":5,"metroNum":2}/*
            String gsonresult = thirdMKServerRecieveCo2.execute("").get();

            //문자열을 class로 가져옴
            Co2 co2 = new Gson().fromJson(gsonresult, Co2.class);

            switch (co2.getCo2Value()) {
                case 1:
                    image1.setBackgroundColor(Color.rgb(153, 255, 204));
                    break;
                case 2:
                    image1.setBackgroundColor(Color.rgb(0, 204, 0));
                    break;
                case 3:
                    image1.setBackgroundColor(Color.rgb(204, 204, 204));
                    break;
                case 4:
                    image1.setBackgroundColor(Color.rgb(102, 102, 102));
                    break;
                case 5:
                    image1.setBackgroundColor(Color.rgb(255, 153, 153));
                    break;
                case 6:
                    image1.setBackgroundColor(Color.rgb(204, 0, 0));
                    break;
            }



        //    Toast.makeText(this, co2.toString(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        mkThread = new MKThread();
        mkThread.start();
        Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        a = result.split("/");

        for(int i = 1; i < 31; i++) {
            color[i - 1] = Integer.parseInt(new String(a[i]));
        }

        for (int i = 31; i < 37; i++) {
            station[i - 31] = a[i];
        }

        image1.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
        image2.setBackgroundColor(Color.rgb(color[3], color[4], color[5]));
        image3.setBackgroundColor(Color.rgb(color[6], color[7], color[8]));
        image4.setBackgroundColor(Color.rgb(color[9], color[10], color[11]));
        image5.setBackgroundColor(Color.rgb(color[12], color[13], color[14]));
        image6.setBackgroundColor(Color.rgb(color[15], color[16], color[17]));
        image7.setBackgroundColor(Color.rgb(color[18], color[19], color[20]));
        image8.setBackgroundColor(Color.rgb(color[21], color[22], color[23]));
        image9.setBackgroundColor(Color.rgb(color[24], color[25], color[26]));
        image10.setBackgroundColor(Color.rgb(color[27], color[28], color[29]));
        //add more

        small1.setText(station[0]+"번칸");
        small2.setText(station[1]+"번칸");
        small3.setText(station[2]+"번칸");
        big1.setText(station[3]+"번칸");
        big2.setText(station[4]+"번칸");
        big3.setText(station[5]+"번칸");
    }

    private void handleMessage(Message msg) {
        String gsonresult = null;
        try {
            thirdMKServerRecieveCo2 = new ThirdMKServerRecieveCo2();
            gsonresult = thirdMKServerRecieveCo2.execute("").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //문자열을 class로 가져옴
        Co2 co2 = new Gson().fromJson(gsonresult, Co2.class);

        switch (co2.getCo2Value()) {
            case 1:
                image1.setBackgroundColor(Color.rgb(153, 255, 204));
                break;
            case 2:
                image1.setBackgroundColor(Color.rgb(0, 204, 0));
                break;
            case 3:
                image1.setBackgroundColor(Color.rgb(204, 204, 204));
                break;
            case 4:
                image1.setBackgroundColor(Color.rgb(102, 102, 102));
                break;
            case 5:
                image1.setBackgroundColor(Color.rgb(255, 153, 153));
                break;
            case 6:
                image1.setBackgroundColor(Color.rgb(204, 0, 0));
                break;
        }
    }

    private static class MyHandler extends Handler {
        private final WeakReference<ThirdActivity> mActivity;

        public MyHandler(ThirdActivity activity) {
            mActivity = new WeakReference<ThirdActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ThirdActivity activity = mActivity.get();
            if (activity != null) {
                activity.handleMessage(msg);
            }
        }
    }

    class MKThread extends Thread {
        @Override
        public void run() {
            super.run();

            while (true) {
                try {
                    mHandler.sendMessage(mHandler.obtainMessage());

                    Log.d("~~~~~~~~~~~~~~~~", "스레드 돌아감");
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}