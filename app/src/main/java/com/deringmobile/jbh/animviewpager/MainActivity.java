package com.deringmobile.jbh.animviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    int[] views = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4};
    MyPagerAdapter adapter;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.rotate)
    Button rotate;
    @Bind(R.id.scale)
    Button scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setPageMargin(100);
        viewPager.setOffscreenPageLimit(3);
        initData();
    }

    private void initData() {
        List<View> images = new ArrayList<>();
        for (int img : views) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setBackgroundResource(img);
            images.add(imageView);
        }
        adapter = new MyPagerAdapter(images);
        viewPager.setClipChildren(false);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new MyPageTransformer());
    }


    @OnClick({R.id.viewpager, R.id.rotate, R.id.scale,R.id.alpha,R.id.rotate1,R.id.trantation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rotate:
                MyPageTransformer.type = BannerType.ROTATE;
                break;
            case R.id.scale:
                MyPageTransformer.type = BannerType.SCALE;
                break;
            case R.id.alpha:
                MyPageTransformer.type = BannerType.ALPHA;
                break;
            case R.id.rotate1:
                MyPageTransformer.type = BannerType.ROTATE1;
                break;
            case R.id.trantation:
                MyPageTransformer.type = BannerType.TRANTATION;
                break;
        }
        adapter.notifyDataSetChanged();
    }
}
