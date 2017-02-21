package com.lym.rvdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LYM on 2017/2/14.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<String> mdatas;

    public void setItemClickLinstener(onItemClickLinstener itemClickLinstener) {
        this.itemClickLinstener = itemClickLinstener;
    }

    private onItemClickLinstener itemClickLinstener;

    public MyAdapter(List<String> mdatas){
        this.mdatas=mdatas;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvcontent.setText(mdatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvcontent;
        public ViewHolder(View itemView) {
            super(itemView);
            tvcontent = (TextView) itemView.findViewById(R.id.tvcontent);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(itemClickLinstener!=null) {
                        itemClickLinstener.onItemClick(v,getLayoutPosition(),mdatas.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    interface onItemClickLinstener{
        void onItemClick(View view,int position,String city);
    }

    public void addData(int position,String city){
        mdatas.add(position,city);
        notifyItemInserted(position);
    }

    public void removeData(int position){
        mdatas.remove(position);
        notifyItemRemoved(position);
    }
}
