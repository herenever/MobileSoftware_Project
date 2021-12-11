package com.example.ms_shoppingmall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Join extends AppCompatActivity {

    EditText email,password,name;
    Button join_btn;
    CheckBox check1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_btn = findViewById(R.id.join);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        check1 =findViewById(R.id.check1);

        join_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("") || password.getText().toString().equals("")
                        || name.getText().toString().equals("") || ! check1.isChecked()){

                    AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                    builder.setTitle("Information");
                    builder.setMessage("입력사항을 모두 입력해주세요");
                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();


                }else{

                    if(isalready(view)){
                        addStudent(view);
                        Intent intent = new Intent(Join.this,Login.class);
                        startActivity(intent);
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                        builder.setTitle("Information");
                        builder.setMessage("이미 존재하는 email 입니다.\n 변경하여 주십시오");
                        AlertDialog alertDialog = builder.create();

                        alertDialog.show();
                    }

                }

            }
        });
    }

    public void addStudent(View view){
        ContentValues addValues = new ContentValues();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        String semail = email.getText().toString();
        String spassword = password.getText().toString();
        String sname = name.getText().toString();

        addValues.put(MyContentProvider.EMAIL,semail);
        addValues.put(MyContentProvider.PASSWORD,spassword);
        addValues.put(MyContentProvider.NAME,sname);
        getContentResolver().insert(MyContentProvider.CONTENT_URI,addValues);

        Toast.makeText(getBaseContext(),"회원가입에 성공하였습니다.",Toast.LENGTH_LONG).show();
    }

    public boolean isalready(View view){
        String[] columns =  new String[]{"_id","email","password","name"};
        Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI,columns,null,null,null);
        if(c!=null){
            email = findViewById(R.id.email);
            while(c.moveToNext()){
                if(email.getText().toString().equals(c.getString(1))){
                    return false;
                }
            }
        }
        return true;
    }

}