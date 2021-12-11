package com.example.ms_shoppingmall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Center extends AppCompatActivity {

    Button call,email,map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        call = findViewById(R.id.call_btn);
        email = findViewById(R.id.email_btn);
        map = findViewById(R.id.map_btn);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: 010-4798-3944"));
                startActivity(intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] TO = {"herenever@naver.com"};
                String[] CC = {""};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"문의 email 발송");
                //emailIntent.putExtra(Intent.EXTRA_TEXT, "이메일 연습 1, 이메일 연습 2");
                try {
                    startActivity(Intent.createChooser(emailIntent,"이메일 보내기..."));

                } catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(getApplicationContext(), "이메일 클라이언트가 없네요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);

            }
        });
    }
}