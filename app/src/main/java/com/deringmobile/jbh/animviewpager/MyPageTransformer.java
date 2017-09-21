package com.deringmobile.jbh.animviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by zbsdata on 2017/8/12.
 */

public class MyPageTransformer implements ViewPager.PageTransformer {


    private static final float MIN_SCALE = 0.8f;
    private static final float MAX_SINGLE = 20;
    private static final float MIN_ALPHA = 0.5f;

    public static BannerType type=BannerType.SCALE;


    public MyPageTransformer(){


    }

    @Override
    public void transformPage(View page, float position) {
        int width = page.getWidth();
        switch (type){
            case ROTATE:
                page.setRotationY(0);
                page.setScaleY(1);
                page.setAlpha(1);
                page.setTranslationX(0);
                if(position<-1){                   //[-x , -1]
                    page.setScaleY(MIN_SCALE);
                    page.setRotationY(-MAX_SINGLE);
                }else if(position<=0&&position>=-1){ //[0 ,-1]
                    float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
                    page.setScaleY(scaleFactor);
                    page.setRotationY(MAX_SINGLE*(position));
                }else if(position>=0&&position<=1){  //[1 , 0];
                    float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
                    page.setScaleY(scaleFactor);
                    page.setRotationY(MAX_SINGLE*position);
                }else if(position>1){                //[1 , x]
                    page.setScaleY(MIN_SCALE);
                    page.setRotationY(MAX_SINGLE);
                }
                break;

            case SCALE:
                page.setRotationY(0);
                page.setAlpha(1);
                page.setScaleY(1);
                page.setTranslationX(0);
                if(position<-1){                   //[-x , -1]
                    page.setScaleY(MIN_SCALE);
                }else if(position<=0&&position>=-1){ //[0 ,-1]
                    float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
                    page.setScaleY(scaleFactor);
                }else if(position>=0&&position<=1){  //[1 , 0];
                    float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
                    page.setScaleY(scaleFactor);
                }else if(position>1){                //[1 , x]
                    page.setScaleY(MIN_SCALE);
                }
                break;

            case ALPHA:
                page.setRotationY(0);
                page.setScaleY(1);
                page.setTranslationX(0);
                if(position<-1){                   //[-x , -1]
                    page.setAlpha(MIN_ALPHA);
                }else if(position<=0&&position>=-1){ //[0 ,-1]
                    float scaleFactor = Math.abs(1-position) ;
                    page.setAlpha(scaleFactor);
                }else if(position>=0&&position<=1){  //[1 , 0];
                    float scaleFactor = 1-position;
                    page.setAlpha(scaleFactor);
                }else if(position>1){                //[1 , x]
                    page.setAlpha(MIN_ALPHA);
                }
                break;


            case ROTATE1:
                page.setAlpha(1);
                page.setRotationY(0);
                page.setScaleY(1);
                page.setTranslationX(0);
                if(position<-1){                   //[-x , -1]
                    page.setScaleY(MIN_SCALE);
//                    page.setRotationY(MAX_SINGLE);
                    page.setRotationY(60);
                }else if(position<=0&&position>=-1){ //[0 ,-1]
                    float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
                    page.setScaleY(scaleFactor);

                    page.setRotationY(60*position);
                    page.setTranslationX(500 * position);
                }else if(position>=0&&position<=1){  //[1 , 0];
                    float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
                    page.setScaleY(scaleFactor);
                    page.setRotationY(60*(1-position));
                    page.setTranslationX(width * -position);
                }else if(position>1){                //[1 , x]
                    page.setScaleY(MIN_SCALE);
                    page.setRotationY(-60);
                }
                break;

            case TRANTATION:
                page.setRotationY(0);
                page.setScaleY(1);
                page.setAlpha(1);
                if(position<-1){                   //[-x , -1]
                    page.setAlpha(0);
                }else if(position<=0&&position>=-1){ //[0 ,-1]
                    page.setAlpha(1+position);
                }else if(position>=0&&position<=1){  //[1 , 0];
                    page.setTranslationX(-width*position);
                    page.setAlpha(1-position);
                }else if(position>1){                //[1 , x]
                    page.setAlpha(0);
                }
                 break;
        }
    }
}
