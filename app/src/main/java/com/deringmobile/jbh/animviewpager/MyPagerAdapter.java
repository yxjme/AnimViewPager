package com.deringmobile.jbh.animviewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/**
 * Created by zbsdata on 2017/8/12.
 */

public class MyPagerAdapter extends PagerAdapter {

    /**数据源  说白了就是页数*/
    private List<View> list;
    public MyPagerAdapter(List<View> list) {
        this.list=list;
    }

    /**当销毁掉上次的item*/
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
//        mViewPager.setObjectForPosition(imageView, position);
        return list.get(position);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }
}
