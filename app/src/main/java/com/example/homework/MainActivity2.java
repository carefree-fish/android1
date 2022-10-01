package com.example.homework;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private newadapter myadapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list=new ArrayList<String>(){};
        for(int i=0;i<9;i++)
            list.add("这是第"+i+"个例子");
        //list= Arrays.asList(new String[]{"a","b","c","d"});

        recyclerView=findViewById(R.id.a);
        myadapter = new newadapter(this, list);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myadapter);


    }
}