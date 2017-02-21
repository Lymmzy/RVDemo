package com.lym.rvdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private List<String> datas=new ArrayList<>();
    private MyAdapter myAdapter;
    private SwipeRefreshLayout refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView)findViewById(R.id.rv);
        initDatas();

        initRecyclerView();

        initRefreshLayout();
    }

    private  void initRecyclerView(){
        myAdapter=new MyAdapter(datas);
        myAdapter.setItemClickLinstener(new MyAdapter.onItemClickLinstener() {
            @Override
            public void onItemClick(View view, int position, String city) {
                Toast.makeText(MainActivity.this, ""+city, Toast.LENGTH_SHORT).show();
            }
        });
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        rv.setItemAnimator(new DefaultItemAnimator());
    }

    private  void initRefreshLayout(){
        refresh = (SwipeRefreshLayout)findViewById(R.id.refresh);
        refresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_red_dark);
        refresh.setDistanceToTriggerSync(100);
        refresh.setProgressBackgroundColorSchemeResource(android.R.color.darker_gray);
        refresh.setSize(SwipeRefreshLayout.LARGE);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i=0;i<10;i++){
                            myAdapter.addData(i,"new City:"+i);

                        }
                        myAdapter.notifyItemRangeChanged(0,10);
                        rv.scrollToPosition(0);
                        refresh.setRefreshing(false);
                    }
                },3000);
            }
        });
    }

    private void initDatas(){
        datas.add("New York");
        datas.add("Boston");
        datas.add("Washington");
        datas.add("San Francisco");
        datas.add("California");
        datas.add("Chicago");
        datas.add("Houston");
        datas.add("Phoenix");
        datas.add("Philadelphia");
        datas.add("Pennsylvania");
        datas.add("San Antonio");
        datas.add("Austin");
        datas.add("Milwaukee");
        datas.add("Las Vegas");
        datas.add("Oklahoma");
        datas.add("Portland");
        datas.add("Mexico");
    }
}
