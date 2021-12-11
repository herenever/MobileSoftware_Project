package com.example.ms_shoppingmall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Iterator;

public class Shop extends AppCompatActivity {
    EditText editText;
    Button search_btn;
    RecyclerView shoeView,clothesView,accView;
    RecyclerView.LayoutManager shoeLayoutManager,clothesLayoutManager,accLayoutManager;
    ArrayList<Item> shoeList = new ArrayList<>();
    ArrayList<Item> clothesList = new ArrayList<>();
    ArrayList<Item> accList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        shoeInit();
        clothesInit();
        accInit();

        editText = findViewById(R.id.editText);
        search_btn = findViewById(R.id.search_btn);
        shoeView = findViewById(R.id.recyclerview1);
        clothesView = findViewById(R.id.recyclerview2);
        accView = findViewById(R.id.recyclerview3);
        shoeView.setHasFixedSize(true);
        clothesView.setHasFixedSize(true);
        accView.setHasFixedSize(true);
        shoeLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        clothesLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        accLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        shoeView.setLayoutManager(shoeLayoutManager);
        clothesView.setLayoutManager(clothesLayoutManager);
        accView.setLayoutManager(accLayoutManager);
        ItemAdapter shoeAdapter = new ItemAdapter(shoeList);
        ItemAdapter clothesAdapter = new ItemAdapter(clothesList);
        ItemAdapter accAdapter = new ItemAdapter(accList);
        shoeView.setAdapter(shoeAdapter);
        clothesView.setAdapter(clothesAdapter);
        accView.setAdapter(accAdapter);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int shoeindex = getshoeIndex(editText.getText().toString());
                int clothesindex = getclothesIndex(editText.getText().toString());
                int accindex = getaccIndex(editText.getText().toString());

                if(shoeindex != -1){
                    Item item = shoeList.get(shoeindex);
                    Intent i = new Intent(getApplicationContext(),ItemDetail.class);
                    i.putExtra("name",item.getName());
                    i.putExtra("brand",item.getBrand());
                    i.putExtra("price",item.getPrice());
                    i.putIntegerArrayListExtra("detail_image",item.getDetail_image());
                    i.putStringArrayListExtra("info",item.getInfo());
                    startActivity(i);


                }else if(clothesindex != -1){
                    Item item = clothesList.get(clothesindex);
                    Intent i = new Intent(getApplicationContext(),ItemDetail.class);
                    i.putExtra("name",item.getName());
                    i.putExtra("brand",item.getBrand());
                    i.putExtra("price",item.getPrice());
                    i.putIntegerArrayListExtra("detail_image",item.getDetail_image());
                    i.putStringArrayListExtra("info",item.getInfo());
                    startActivity(i);

                }else if(accindex != -1){
                    Item item = accList.get(accindex);
                    Intent i = new Intent(getApplicationContext(),ItemDetail.class);
                    i.putExtra("name",item.getName());
                    i.putExtra("brand",item.getBrand());
                    i.putExtra("price",item.getPrice());
                    i.putIntegerArrayListExtra("detail_image",item.getDetail_image());
                    i.putStringArrayListExtra("info",item.getInfo());
                    startActivity(i);

                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Shop.this);
                    builder.setTitle("Information");
                    builder.setMessage("찾으시는 상품이 없습니다.");
                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();

                }
            }
        });


    }

    private void shoeInit(){
        ArrayList<Integer> detail1  = new ArrayList<>();
        ArrayList<String> info1 = new ArrayList<>();
        ArrayList<Integer> detail2  = new ArrayList<>();
        ArrayList<String> info2 = new ArrayList<>();
        ArrayList<Integer> detail3  = new ArrayList<>();
        ArrayList<String> info3 = new ArrayList<>();
        ArrayList<Integer> detail4  = new ArrayList<>();
        ArrayList<String> info4 = new ArrayList<>();
        ArrayList<Integer> detail5  = new ArrayList<>();
        ArrayList<String> info5 = new ArrayList<>();

        detail1.add(R.drawable.rank_dim1_1);
        detail1.add(R.drawable.rank_dim1_2);
        detail1.add(R.drawable.rank_dim1_3);
        info1.add("DH2482-100");
        info1.add("21/12/03");
        info1.add("WHITE/WHITE-WHITE");
        shoeList.add(new Item("Kwondo White","Nike","450,000원",R.drawable.rank_image1,
                detail1,info1));

        detail2.add(R.drawable.md_dim1_1);
        detail2.add(R.drawable.md_dim1_2);
        detail2.add(R.drawable.md_dim1_3);
        info2.add("DD1391-100");
        info2.add("21/01/14");
        info2.add("WHITE/BLACK");
        shoeList.add(new Item("Dunk Low Retro Black","Nike","338,000원",R.drawable.md_image1,
                detail2,info2));

        detail3.add(R.drawable.md_dim2_1);
        detail3.add(R.drawable.md_dim2_2);
        detail3.add(R.drawable.md_dim2_3);
        info3.add("DM7866-140");
        info3.add("21/08/13");
        info3.add("SAIL/BLACK/MILITARY BLUE");
        shoeList.add(new Item("Jordan1 Retro Low OG SP","Nike","1,729,000원",R.drawable.md_image2,
                detail3,info3));

        detail4.add(R.drawable.md_dim4_1);
        detail4.add(R.drawable.md_dim4_2);
        detail4.add(R.drawable.md_dim4_3);
        info4.add("555088-134");
        info4.add("21/03/06");
        info4.add("WHITE/UNIVERSITY BLUE/BLACK");
        shoeList.add(new Item("Jordan 1 Retro High OG","Nike","480,000원",R.drawable.md_image4,
                detail4,info4));

        detail5.add(R.drawable.shoe_dim1);
        detail5.add(R.drawable.shoe_dim2);
        detail5.add(R.drawable.shoe_dim3);
        info5.add("M992GR");
        info5.add("20/04/13");
        info5.add("GREY");
        shoeList.add(new Item("New Balance 992 Standard","New Balance","413,000원",R.drawable.shoe_image,
                detail5,info5));
    }

    private void clothesInit(){
        ArrayList<Integer> detail1  = new ArrayList<>();
        ArrayList<String> info1 = new ArrayList<>();
        ArrayList<Integer> detail2  = new ArrayList<>();
        ArrayList<String> info2 = new ArrayList<>();
        ArrayList<Integer> detail3  = new ArrayList<>();
        ArrayList<String> info3 = new ArrayList<>();
        ArrayList<Integer> detail4  = new ArrayList<>();
        ArrayList<String> info4 = new ArrayList<>();
        ArrayList<Integer> detail5  = new ArrayList<>();
        ArrayList<String> info5 = new ArrayList<>();

        detail1.add(R.drawable.rank_dim2_1);
        detail1.add(R.drawable.rank_dim2_2);
        info1.add("2488/009");
        info1.add("21/12/06");
        info1.add("GREY");
        clothesList.add(new Item("Oversized Sweater Gray","Ader Error","290,000원",R.drawable.rank_image2,
                detail1,info1));

        detail2.add(R.drawable.rank_dim3_1);
        detail2.add(R.drawable.rank_dim3_2);
        info2.add("-");
        info2.add("21/12/06");
        info2.add("WHITE");
        clothesList.add(new Item("Woven Fullover White","IAB Studio","149,000원",R.drawable.rank_image3,
                detail2,info2));

        detail3.add(R.drawable.rank_dim4_1);
        detail3.add(R.drawable.rank_dim4_2);
        info3.add("-");
        info3.add("21/12/06");
        info3.add("GREEN");
        clothesList.add(new Item("SweatShirt Green","IAB Studio","129,000원",R.drawable.rank_image4,
                detail3,info3));

        detail4.add(R.drawable.md_dim3_1);
        detail4.add(R.drawable.md_dim3_2);
        info4.add("DD6056-010");
        info4.add("21/11/22");
        info4.add("BLACK/PHOTON DUST/PHOTON DUST");
        clothesList.add(new Item("Swoosh Bomber Black","Nike","224,000원",R.drawable.md_image3,
                detail4,info4));

        detail5.add(R.drawable.clo_dim1);
        detail5.add(R.drawable.clo_dim2);
        detail5.add(R.drawable.clo_dim3);
        info5.add("-");
        info5.add("19/12/26");
        info5.add("PAPER PRINT");
        clothesList.add(new Item("Paper Print Nuptse Jacket","Supreme","1,670,000원",R.drawable.clo_image,
                detail5,info5));


    }

    private void accInit(){
        ArrayList<Integer> detail1  = new ArrayList<>();
        ArrayList<String> info1 = new ArrayList<>();
        ArrayList<Integer> detail2  = new ArrayList<>();
        ArrayList<String> info2 = new ArrayList<>();
        ArrayList<Integer> detail3  = new ArrayList<>();
        ArrayList<String> info3 = new ArrayList<>();

        detail1.add(R.drawable.acc_dim1_1);
        detail1.add(R.drawable.acc_dim1_2);
        info1.add("-");
        info1.add("21/09/09");
        info1.add("BLACK");
        accList.add(new Item("Waxed Cotton Cam Cap","Supreme","139,000원",R.drawable.acc_image1,
                detail1,info1));

        detail2.add(R.drawable.acc_dim2_1);
        info2.add("-");
        info2.add("21/12/06");
        info2.add("WHITE");
        accList.add(new Item("de Coeur Classic Scarf","AMI","288,000원",R.drawable.acc_image2,
                detail2,info2));

        detail3.add(R.drawable.acc_dim3_1);
        detail3.add(R.drawable.acc_dim3_2);
        detail3.add(R.drawable.acc_dim3_3);
        info3.add("S56UI0128P0399T8013");
        info3.add("-");
        info3.add("BLACK");
        accList.add(new Item("Keyring Wallet Black","Masion Margiela","368,000원",R.drawable.acc_image3,
                detail3,info3));

    }

    private int getshoeIndex(String name){
        Iterator<Item> it1 = shoeList.iterator();
        int index=0;
        while(it1.hasNext()){
            if(it1.next().getName().equals(name)){
                return index;
            }
            index++;
        }
        return -1;

    }

    private int getclothesIndex(String name){
        Iterator<Item> it1 = clothesList.iterator();
        int index=0;
        while(it1.hasNext()){
            if(it1.next().getName().equals(name)){
                return index;
            }
            index++;
        }
        return -1;

    }

    private int getaccIndex(String name){
        Iterator<Item> it1 = accList.iterator();
        int index=0;
        while(it1.hasNext()){
            if(it1.next().getName().equals(name)){
                return index;
            }
            index++;
        }
        return -1;


    }
}