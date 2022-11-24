package com.example.resolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver=getContentResolver();

        ContentValues values=new ContentValues();
        values.put("name","zw");
        values.put("age",20);

        Uri uri=Uri.parse("content://zw.provider/student");//parse前为目标类型，用于强制类型转换
        //把student表明改为zw.provider
        //resolver和provider中增删改查相对应

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.insert(uri,values);
                //resolver给uri和values
            }
        });
    }
}