package com.hoon.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.hoon.todolist.adapter.TodoAdapter;
import com.hoon.todolist.model.TodoVO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // todo 메시지를 전달하는 view 들
    private EditText txt_msg;
    private AppCompatButton btn_send;

    // todo 메시지를 표현할 view 들
    private RecyclerView todo_list_view;
    private TodoAdapter todoAdapter;
    private List<TodoVO> todoList;

    // firebase와 연결하는 Connection을 위한 객체 선언하기
    private DatabaseReference dbRef;


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

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);
        todo_list_view = findViewById(R.id.todo_list_view);

        // 0 보여줄 데이터 객체 생성
        todoList = new ArrayList<TodoVO>();

        // 1. Adapter 객체 생성
        // Adapter 객체를 생성할때 보여줄 데이터 객체를
        // 생성자 매개변수로 주입해 주어야 한다.
        todoAdapter = new TodoAdapter(todoList);

        // 2. RecyclerView.Adapter와 RecyclerView를 서로 연결
        todo_list_view.setAdapter(todoAdapter);

        // 3. RecyclerView의 데이터를 표현한데 사용할
        // Layout 매니저를 설정하기



    }
}















