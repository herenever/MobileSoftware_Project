package com.example.ms_shoppingmall;

import static java.util.List.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class MainActivity extends AppCompatActivity{
        Button center_btn,item_btn;
        FloatingActionButton menu_btn;
        String user_name;

        //이벤트 뷰페이저
        ViewPager vp;
        CircleIndicator indicator;
        private ArrayList<Integer> event_image;
        int currentPage = 0;
        Timer timer;
        final long DELAY_MS = 3000;
        final long PERIOD_MS = 5000;

        // 랭킹,md 리사이클러뷰
        private RecyclerView rankView,mdView;
        private RecyclerView.LayoutManager rankLayoutManager,mdLayoutManager;
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<Item> mdList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        user_name = i.getStringExtra("username");

        viewPagerInit();
        rankInit();
        mdInit();

        center_btn = findViewById(R.id.center_btn);
        item_btn = findViewById(R.id.item_btn);
        menu_btn = findViewById(R.id.menu_btn);
        vp = findViewById(R.id.viewpager);
        indicator = findViewById(R.id.indicator);
        rankView = findViewById(R.id.recyclerview1);
        mdView = findViewById(R.id.recyclerview2);
        rankView.setHasFixedSize(true);
        mdView.setHasFixedSize(true);
        rankLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mdLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rankView.setLayoutManager(rankLayoutManager);
        mdView.setLayoutManager(mdLayoutManager);
        ItemAdapter itemAdapter = new ItemAdapter(itemList);
        ItemAdapter mdAdapter = new ItemAdapter(mdList);
        rankView.setAdapter(itemAdapter);
        mdView.setAdapter(mdAdapter);

        vp.setAdapter(new EventAdapter(this,event_image));
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if(currentPage ==4){
                    currentPage = 0;
                }
                vp.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        },DELAY_MS,PERIOD_MS);

        indicator.setViewPager(vp);

        center_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Center.class);
                startActivity(intent);
            }
        });

        item_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Shop.class);
                startActivity(intent);
            }
        });




    }

    private void viewPagerInit(){
        event_image = new ArrayList<>();
        event_image.add(R.drawable.event1);
        event_image.add(R.drawable.event2);
        event_image.add(R.drawable.event3);
        event_image.add(R.drawable.event4);

    }

    private void rankInit(){

        ArrayList<Integer> detail1  = new ArrayList<>();
        ArrayList<String> info1 = new ArrayList<>();
        ArrayList<Integer> detail2  = new ArrayList<>();
        ArrayList<String> info2 = new ArrayList<>();
        ArrayList<Integer> detail3  = new ArrayList<>();
        ArrayList<String> info3 = new ArrayList<>();
        ArrayList<Integer> detail4  = new ArrayList<>();
        ArrayList<String> info4 = new ArrayList<>();

        detail1.add(R.drawable.rank_dim1_1);
        detail1.add(R.drawable.rank_dim1_2);
        detail1.add(R.drawable.rank_dim1_3);
        info1.add("DH2482-100");
        info1.add("21/12/03");
        info1.add("WHITE/WHITE-WHITE");
        itemList.add(new Item("Kwondo White","Nike","450,000원",R.drawable.rank_image1,
                detail1,info1));
        detail2.add(R.drawable.rank_dim2_1);
        detail2.add(R.drawable.rank_dim2_2);
        info2.add("2488/009");
        info2.add("21/12/06");
        info2.add("GREY");
        itemList.add(new Item("Oversized Sweater Gray","Ader Error","290,000원",R.drawable.rank_image2,detail2,info2));


        detail3.add(R.drawable.rank_dim3_1);
        detail3.add(R.drawable.rank_dim3_2);
        info3.add("-");
        info3.add("21/12/06");
        info3.add("WHITE");
        itemList.add(new Item("Woven Fullover White","IAB Studio","149,000원",R.drawable.rank_image3,detail3,info3));


        detail4.add(R.drawable.rank_dim4_1);
        detail4.add(R.drawable.rank_dim4_2);
        info4.add("-");
        info4.add("21/12/06");
        info4.add("GREEN");
        itemList.add(new Item("SweatShirt Green","IAB Studio","129,000원",R.drawable.rank_image4,detail4,info4));
    }

    private void mdInit(){
        ArrayList<Integer> detail1  = new ArrayList<>();
        ArrayList<String> info1 = new ArrayList<>();
        ArrayList<Integer> detail2  = new ArrayList<>();
        ArrayList<String> info2 = new ArrayList<>();
        ArrayList<Integer> detail3  = new ArrayList<>();
        ArrayList<String> info3 = new ArrayList<>();
        ArrayList<Integer> detail4  = new ArrayList<>();
        ArrayList<String> info4 = new ArrayList<>();

        detail1.add(R.drawable.md_dim1_1);
        detail1.add(R.drawable.md_dim1_2);
        detail1.add(R.drawable.md_dim1_3);
        info1.add("DD1391-100");
        info1.add("21/01/14");
        info1.add("WHITE/BLACK");
        mdList.add(new Item("Dunk Low Retro Black","Nike","338,000원",R.drawable.md_image1,
                detail1,info1));

        detail2.add(R.drawable.md_dim2_1);
        detail2.add(R.drawable.md_dim2_2);
        detail2.add(R.drawable.md_dim2_3);
        info2.add("DM7866-140");
        info2.add("21/08/13");
        info2.add("SAIL/BLACK/MILITARY BLUE");
        mdList.add(new Item("Jordan1 Retro Low OG SP","Nike","1,729,000원",R.drawable.md_image2,
                detail2,info2));

        detail3.add(R.drawable.md_dim3_1);
        detail3.add(R.drawable.md_dim3_2);
        info3.add("DD6056-010");
        info3.add("21/11/22");
        info3.add("BLACK/PHOTON DUST/PHOTON DUST");
        mdList.add(new Item("Swoosh Bomber Black","Nike","224,000원",R.drawable.md_image3,
                detail3,info3));

        detail4.add(R.drawable.md_dim4_1);
        detail4.add(R.drawable.md_dim4_2);
        detail4.add(R.drawable.md_dim4_3);
        info4.add("555088-134");
        info4.add("21/03/06");
        info4.add("WHITE/UNIVERSITY BLUE/BLACK");
        mdList.add(new Item("Jordan 1 Retro High OG","Nike","480,000원",R.drawable.md_image4,
                detail4,info4));






    }
}