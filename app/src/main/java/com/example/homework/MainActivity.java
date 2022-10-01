package com.example.homework;
/*
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}*/

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
//import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
//import android.widget.Toast;
//import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//    private Button button;
    private Fragment fragment1,fragment2,fragment3,fragment4;
    private FragmentManager manager;
//    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button=findViewById(R.id.button);
/*        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView textView = findViewById(R.id.textView2);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText(rating+"星");
            }
        });
*/
        LinearLayout linearLayout1 = findViewById(R.id.LinerLayout1);
        LinearLayout linearLayout2 =findViewById(R.id.LinerLayout2);
        LinearLayout linearLayout3 =findViewById(R.id.LinerLayout3);
        LinearLayout linearLayout4 =findViewById(R.id.LinerLayout4);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();
        manager=getSupportFragmentManager();

        initial();
        hidden();
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

    }

    private void initial() {
        FragmentTransaction transaction=manager.beginTransaction()
                .add(R.id.textview1,fragment1)
                .add(R.id.textview2,fragment2)
                .add(R.id.textview3,fragment3)
                .add(R.id.textview4,fragment4);
        transaction.commit();

    }

    @Override
    public void onClick(View v) {           //view为所有控件的父类,从而能够接受所有的控件点击
        switch (v.getId()){
            case R.id.LinerLayout1: select(1);
                break;
            case R.id.LinerLayout2: select(2);
                break;
            case R.id.LinerLayout3: select(3);
                break;
            case R.id.LinerLayout4: select(4);
                break;
        }
    }

    private void select(int i) {
        hidden();
        switch(i){
            case 1:showfragment(fragment1);
                break;
            case 2:showfragment(fragment2);
                break;
            case 3:showfragment(fragment3);
                break;
            case 4:showfragment(fragment4);
                break;
        }
    }

    private void hidden() {
        manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4)
                .commit();

/**       transaction=manager.beginTransaction()
 .hide()
 .hide()
 .hide()
 .hide();
 transaction.commit;
 **/
    }

    private void showfragment(Fragment fragment) {
        manager.beginTransaction()
                .show(fragment)
                .commit();
    }
}