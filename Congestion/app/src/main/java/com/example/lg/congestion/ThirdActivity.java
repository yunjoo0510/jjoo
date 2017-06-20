package com.example.lg.congestion;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ThirdActivity extends Activity implements Button.OnClickListener{

    public ImageView image1, image2, image3, image4, image5,
            image6, image7, image8, image9, image10, density;
    TextView small1, small2, small3,
            big1, big2, big3;
    Button button;
    public static int[] color = new int[30];
    public static String[] station = new String[6];
    public static String[] a = new String[37];
    public static String result = null;
    //private TextView tvServerMessage;

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
        button = (Button)this.findViewById(R.id.button);
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

        small1 = (TextView)this.findViewById(R.id.small1);
        small2 = (TextView)this.findViewById(R.id.small2);
        small3 = (TextView)this.findViewById(R.id.small3);
        big1 = (TextView)this.findViewById(R.id.big1);
        big2 = (TextView)this.findViewById(R.id.big2);
        big3 = (TextView)this.findViewById(R.id.big3);

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


        ClientAsyncTask clientAST = new ClientAsyncTask();
        clientAST
               .execute(new String[]{"192.168.43.119", "8889", "?"});
    }



    class ClientAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            try {
                Socket socket = new Socket(params[0],
                        Integer.parseInt(params[1]));
                InputStream is = socket.getInputStream();
                PrintWriter out = new PrintWriter(socket.getOutputStream(),
                        true);
                out.println(params[2]);
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(is));
                result = br.readLine();
                socket.close();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;}


        @Override
        protected void onPostExecute(String result) { // Write server message to
            //tvServerMessage.setText(result);

           //rgffrf Toast.makeText(getApplication(), result, Toast.LENGTH_SHORT).show();

           // String[] a = new String[37];
           // int[] color = new int[30];
           // String[] station = new String[6];

            a = result.split("/");

            for (int i = 1; i < 31; i++) {

                color[i - 1] = Integer.parseInt(new String(a[i]));

            }
            for (int i = 31; i < 37; i++){
                station[i-31] = a[i];
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
    }

    @Override
    public void onClick(View v) {
        ClientAsyncTask clientAST = new ClientAsyncTask();
        clientAST
                .execute(new String[]{"192.168.43.119", "8889", "?"});
       // int[] color = new int[30];
       // String[] station = new String[6];




        a = result.split("/");

        for (int i = 1; i < 31; i++) {

            color[i - 1] = Integer.parseInt(new String(a[i]));

        }
        for (int i = 31; i < 37; i++){
            station[i-31] = a[i];
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
}


