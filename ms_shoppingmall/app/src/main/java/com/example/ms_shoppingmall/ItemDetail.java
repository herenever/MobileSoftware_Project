package com.example.ms_shoppingmall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ItemDetail extends AppCompatActivity {
    TextView name,brand,price,model,date,color;
    ViewPager vp;
    CircleIndicator indicator;
    Spinner sp;
    ArrayList<Integer> detail_cut = new ArrayList<>();
    ArrayList<String> info = new ArrayList<>();
    String[] items ={"사이즈를 선택해주세요","XL","L","M","S","XS"};
    String size="";
    Button buy,like;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Intent i = getIntent();
        String sname = i.getStringExtra("name");
        String sbrand = i.getStringExtra("brand");
        String sprice = i.getStringExtra("price");
        detail_cut = i.getIntegerArrayListExtra("detail_image");
        info = i.getStringArrayListExtra("info");

        name = findViewById(R.id.name);
        brand = findViewById(R.id.brand);
        price = findViewById(R.id.price);
        model = findViewById(R.id.modelnum);
        date = findViewById(R.id.date);
        color = findViewById(R.id.color);
        buy = findViewById(R.id.buy_btn);
        like = findViewById(R.id.like_btn);

        sp = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                size=items[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        vp = findViewById(R.id.viewpager);
        indicator = findViewById(R.id.indicator);
        vp.setAdapter(new EventAdapter(this,detail_cut));
        indicator.setViewPager(vp);

        name.setText(sname);
        brand.setText(sbrand);
        price.setText(sprice);
        model.setText(info.get(0));
        date.setText(info.get(1));
        color.setText(info.get(2));


        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (size.equals("사이즈를 선택해주세요")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ItemDetail.this);
                        builder.setTitle("Information");
                        builder.setMessage("사이즈를 선택해주세요!");
                        AlertDialog alertDialog = builder.create();

                        alertDialog.show();

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ItemDetail.this);
                        builder.setTitle("Information");
                        builder.setMessage(sname + " " + size + " 구매하셨습니다.");
                        AlertDialog alertDialog = builder.create();

                        alertDialog.show();

                    }
                }

        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (size.equals("사이즈를 선택해주세요")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ItemDetail.this);
                    builder.setTitle("Information");
                    builder.setMessage("사이즈를 선택해주세요!");
                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ItemDetail.this);
                    builder.setTitle("Information");
                    builder.setMessage(sname + " " + size + " 찜하셨습니다.");
                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();

                }

            }
        });


    }
}