package com.example.ms_shoppingmall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button login_btn,join_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = findViewById(R.id.login_btn);
        join_btn = findViewById(R.id.join_btn);
        email =findViewById(R.id.email);
        password = findViewById(R.id.password);

        join_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Join.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("") || password.getText().toString().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setTitle("Information");
                    builder.setMessage("입력사항을 모두 입력해주세요");
                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();

                }else{
                    if(isalready(view).equals("")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                        builder.setTitle("Information");
                        builder.setMessage("해당하는 ID가 없거나 Password가 틀렸습니다.");
                        AlertDialog alertDialog = builder.create();

                        alertDialog.show();

                    }else{
                        String name = isalready(view);
                        Intent intent = new Intent(Login.this,MainActivity.class);
                        intent.putExtra("username",name);
                        Toast.makeText(getApplicationContext(),name+"님 환영합니다!",Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                }
            }
        });



    }

    public String isalready(View view){
        String[] columns =  new String[]{"_id","email","password","name"};
        Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI,columns,null,null,null);
        if(c!=null){
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);
            while(c.moveToNext()){
                if(email.getText().toString().equals(c.getString(1)) && password.getText().toString().equals(c.getString(2))){
                    return c.getString(3);
                }
            }
        }
        return "";
    }
}