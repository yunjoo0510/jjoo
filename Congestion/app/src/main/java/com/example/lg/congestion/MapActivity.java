package com.example.lg.congestion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by nari on 2015-11-25.
 */
public class MapActivity extends Activity {
    PhotoViewAttacher iattacher;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ImageView img = (ImageView) this.findViewById(R.id.linemap);
        iattacher = new PhotoViewAttacher(img);
    }

}
