package com.example.junghyun.mt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-02-10.
 */

public class AddPageActivity extends AppCompatActivity {
    private PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        initViews();
    }

    @SuppressWarnings("ConstantConditions")
    private void initViews() {
        AddPageAdapter adapter = new AddPageAdapter();
        adapter.setData(createPageList());

        final ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(adapter);

        pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(pager);
        pageIndicatorView.setAnimationType(AnimationType.DROP);
    }

    @NonNull
    private List<View> createPageList() {
        List<View> pageList = new ArrayList<>();
        pageList.add(createPageView(R.layout.first_page));
        pageList.add(createPageView(R.layout.second_page));
        pageList.add(createPageView(R.layout.third_page));


        return pageList;
    }

    @NonNull
    private View createPageView(int layout) {
        View view = (View) getLayoutInflater().
                inflate(layout, null);

        return view;
    }

}