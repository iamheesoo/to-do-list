package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    // Adapter는 MainActivity와 RecyclerView 사이를 연결해주는 역할
    private ArrayList<Todo> mData;

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView item_text;
        protected Button item_delete;

        public ViewHolder(View itemView){
            // ViewHolder를 이용하면 매번 findViewById() 호출하지 않아도 되므로 성능 향상
            super(itemView);

            this.item_text=itemView.findViewById(R.id.item_text);
            this.item_delete=itemView.findViewById(R.id.item_delete);

            item_delete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int position=getAdapterPosition(); // item이 있을 경우에만 해당 position을 반환
                    if(position!=RecyclerView.NO_POSITION){
                        mData.remove(position); // list에서 제거
                        notifyDataSetChanged(); // 어댑터에게 데이터가 변경되었음을 알림
                    }
                }
            });
        }
    }

    TodoAdapter(ArrayList<Todo> list){
        mData=list;
    }

    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){ // ViewHolder를 생성
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.recyclerview_item, parent, false);
        TodoAdapter.ViewHolder vh=new TodoAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(TodoAdapter.ViewHolder holder, int position){
        holder.item_text.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }
}
