package com.example.homework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*子类newadapter.MyHolder 替代所有 父类RecyclerView.ViewHolder 作为基类
* 
* */
public class newadapter extends RecyclerView.Adapter<newadapter.MyHolder> {

    private View view;
    private Context context;
    private List<String> list;

    public newadapter(Context context, List<String> list) {
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*holder负责将数据项与控件项联系起来，
        *       可视为指针
        * viewholder为单行视图
        * */
        view= LayoutInflater.from(context).inflate(R.layout.item,parent,false); //inflate方法压缩item为view
        MyHolder holder;
        holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //数据插入，插入到viewholder，bind方法自带循环
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        //告诉控件，有多少行，需要多少数据
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
