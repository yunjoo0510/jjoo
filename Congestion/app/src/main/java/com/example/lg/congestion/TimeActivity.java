package com.example.lg.congestion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Hashtable;

/**
 * Created by LG on 2017-04-18.
 */

public class TimeActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    public Hashtable<String, Integer> Mmap = new Hashtable<String, Integer>();
    public Button btn_ok;
    public String[] list = {" ", " "};
    public AutoCompleteTextView editText1;
    public AutoCompleteTextView editText2;
    public int calculate;
    public ImageView arrow;
    public TextView textView, start, dest;
    public String[] items = {"강남역","역삼역", "선릉역", "삼성역", "종합운동장역", "신천역",
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
        setContentView(R.layout.activity_time);
        btn_ok = (Button)this.findViewById(R.id.ok);
        btn_ok.setOnClickListener(this);
        editText1 = (AutoCompleteTextView)this.findViewById(R.id.editText1);
        editText2 = (AutoCompleteTextView)this.findViewById(R.id.editText2);
        editText1.addTextChangedListener(this);
        editText2.addTextChangedListener(this);
        textView = (TextView)findViewById(R.id.textView2);
        start = (TextView)findViewById(R.id.text_start);
        dest = (TextView)findViewById(R.id.text_dest);
        ArrayAdapter<String> item = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        editText1.setAdapter(item);
        editText2.setAdapter(item);
        arrow = (ImageView)this.findViewById(R.id.img_arrow);

        Mmap.put("강남역", 0);
        Mmap.put("역삼역", 1);
        Mmap.put("선릉역", 2);
        Mmap.put("삼성역", 3);
        Mmap.put("종합운동장역", 4);
        Mmap.put("신천역", 5);
        Mmap.put("잠실역", 6);
        Mmap.put("잠실나루역", 7);
        Mmap.put("강변역", 8);
        Mmap.put("구의역", 9);
        Mmap.put("건대입구역", 10);
        Mmap.put("성수역", 11);
        Mmap.put("뚝섬역", 12);
        Mmap.put("한양대역", 13);
        Mmap.put("왕십리역", 14);
        Mmap.put("상왕십리역", 15);
        Mmap.put("신당역", 16);
        Mmap.put("동대문역사문화공원역", 17);
        Mmap.put("을지로4가역", 18);
        Mmap.put("을지로3가역", 19);
        Mmap.put("을지로입구역", 20);
        Mmap.put("시청역", 21);
        Mmap.put("충정로역", 22);
        Mmap.put("아현역", 23);
        Mmap.put("이대역", 24);
        Mmap.put("신촌역", 25);
        Mmap.put("홍대입구역", 26);
        Mmap.put("합정역", 27);
        Mmap.put("당산역", 28);
        Mmap.put("영등포구청역", 29);
        Mmap.put("문래역", 30);
        Mmap.put("신도림역", 31);
        Mmap.put("대림역", 32);
        Mmap.put("구로디지털단지역", 33);
        Mmap.put("신대방역", 34);
        Mmap.put("신림역", 35);
        Mmap.put("봉천역", 36);
        Mmap.put("서울대입구역", 37);
        Mmap.put("낙성대역", 38);
        Mmap.put("사당역", 39);
        Mmap.put("방배역", 40);
        Mmap.put("서초역", 41);
        Mmap.put("교대역", 42);

    }

    public void onClick(View v) {
        int startnum;
        int arrivalnum;
        int differ1;
        int size = 43;

        if(v.getId() == R.id.ok) {
            list[0] = (editText1.getText().toString());
            //Toast.makeText(getApplication(), "출발역 설정", Toast.LENGTH_SHORT).show();

            list[1] = (editText2.getText().toString());
            //Toast.makeText(getApplication(), list[1], Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplication(), " " + Mmap.equals("강남"), Toast.LENGTH_SHORT).show();

            start.setText(editText1.getText().toString());
            dest.setText(editText2.getText().toString());
            arrow.setImageResource(R.drawable.arrow);

            if(Mmap.containsKey(list[0]) && Mmap.containsKey(list[1])) {
                startnum = Mmap.get(list[0]);
                arrivalnum = Mmap.get(list[1]);
                differ1 = Math.abs(arrivalnum - startnum);

                if(arrivalnum - startnum > 0) {
                    if(differ1 >= 22) {
                        calculate = (startnum - arrivalnum + 43) * 2;
                    }
                    else
                        calculate = (arrivalnum - startnum) * 2;
                }
                else if (arrivalnum - startnum < 0) {
                    if(differ1 >= 22) {
                        calculate = (arrivalnum - startnum + 43) * 2;
                    }
                    else
                        calculate = (startnum - arrivalnum) * 2;
                }
            }
            else {
                Toast.makeText(getApplication(), "잘못 입력하였습니다. 다시 입력하세요.", Toast.LENGTH_SHORT).show();
            }
            textView.setText(calculate + "분");
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    /* public Hashtable<String, Integer> getMmap() {
        int startnum;
        int arrivalnum;
        int differ;

        if(Mmap.equals(list [0]) && Mmap.equals(list[1])){
            startnum =  Mmap.get(list [0]);
            arrivalnum = Mmap.get(list[1]);
            differ = (arrivalnum - startnum);
            if (differ >= 22){
                calculate=((startnum - arrivalnum) + 43)*2;
            }
            else{
                calculate=(arrivalnum - startnum)*2;
            }
        }
        else
            Toast.makeText(getApplication(), "다시 입력해 주세요", Toast.LENGTH_SHORT).show();

        return Mmap;
    } */
}
