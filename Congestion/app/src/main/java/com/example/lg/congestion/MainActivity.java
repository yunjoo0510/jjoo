package com.example.lg.congestion;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lg.congestion.R;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    Button btn;
    ImageView btn1, btn2;
    AutoCompleteTextView edit;
    String[] items = {"강남역","역삼역", "선릉역", "삼성역", "종합운동장역", "신천역",
            "잠실역", "잠실나루역", "강변역", "구의역", "건대입구역",
            "성수역", "뚝섬역", "한양대역", "왕십리역", "상왕십리역",
            "신당역", "동대문역사문화공원역", "을지로4가역", "을지로3가역", "을지로입구역",
            "시청역", "충정로역", "아현역", "이대역", "신촌역",
            "홍대입구역", "합정역", "당산역", "영등포구청역", "문래역",
            "신도림역", "대림역", "구로디지털단지역", "신대방역", "신림역",
            "봉천역", "서울대입구역", "낙성대역", "사당역", "방배역",
            "서초역", "교대역"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, com.example.lg.congestion.Splash.class));

        btn = (Button) this.findViewById(R.id.btn);
        btn.setOnClickListener(this);
        btn1 = (ImageView) this.findViewById(R.id.start);
        btn1.setOnClickListener(this);
        btn2 = (ImageView) this.findViewById(R.id.map);
        btn2.setOnClickListener(this);

        edit = (AutoCompleteTextView) this.findViewById(R.id.edit);
        edit.addTextChangedListener(this);

        ArrayAdapter<String> item = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        edit.setAdapter(item);

    }

    public void onClick(View v) {

        if(v.getId() == R.id.btn) {
            if(Arrays.asList(items).contains(edit.getText().toString())) {
                Intent intent = new Intent(this, com.example.lg.congestion.SecondActivity.class);
                intent.putExtra("main_station", edit.getText().toString());
                startActivity(intent);
            }
            else{
                new AlertDialog.Builder(this)
                        .setTitle("앗!")
                        .setMessage("잘못된 역 이름입니다.\n" + "다시 입력해주세요.")
                        .setNeutralButton("네", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {}
                        })
                        .show();
            }
        }
        if(v.getId() == R.id.start) {
            Intent intent2 = new Intent(this, com.example.lg.congestion.TimeActivity.class);
            startActivity(intent2);
        }
        if(v.getId() == R.id.map) {
            Intent intent3 = new Intent(this, com.example.lg.congestion.MapActivity.class);
            startActivity(intent3);
        }

    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void afterTextChanged(Editable s) {
    }
}
