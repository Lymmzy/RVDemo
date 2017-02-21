package com.lym.rvdemo;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by LYM on 2017/2/14.
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    //设置item的边距
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }

    @Override
    //渲染item前调用此方法，如底色
    public void onDraw(Canvas c, RecyclerView parent) {
        super.onDraw(c, parent);
    }

    @Override
    //渲染item后调用此方法
    public void onDrawOver(Canvas c, RecyclerView parent) {
        super.onDrawOver(c, parent);
    }
}
