package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button insertButton;
    EditText todoEdit;
    private ArrayList<Todo> todoArrayList; // item 넣을 리스트
    private TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        todoArrayList=new ArrayList<>();
        todoAdapter=new TodoAdapter(todoArrayList);
        recyclerView.setAdapter(todoAdapter);

        insertButton=(Button) findViewById(R.id.button);
        todoEdit=(EditText) findViewById(R.id.editText);

        insertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Todo newTodo=new Todo(todoEdit.getText().toString());
                todoArrayList.add(newTodo);
                todoAdapter.notifyDataSetChanged();
                todoEdit.setText(null);
            }
        });
    }
}