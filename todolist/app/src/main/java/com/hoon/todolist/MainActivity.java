package com.hoon.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * setContentView(R.layout.activity_main);
         * *layout.xml 파일을 읽어서 화면을 만드는 method
         * setContentView는 한개의 파일을 읽어서
         *      한개의 전체 화면을 만드는 것
         */
        setContentView(R.layout.activity_main);
    }
}