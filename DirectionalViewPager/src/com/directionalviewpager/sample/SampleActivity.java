package com.directionalviewpager.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.directionalviewpager.DirectionalViewPager;
import com.viewpagerindicator.CirclePageIndicator;

public class SampleActivity extends FragmentActivity {

    DirectionalViewPager pager;
    CirclePageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_circles);
        pager = (DirectionalViewPager) findViewById(R.id.pager);
        //pager.setOrientation(DirectionalViewPager.VERTICAL);
        pager.setOnTouchListener(new MyOnSwipeTouchListener(this));
        pager.setAdapter(new TestFragmentAdapter(getSupportFragmentManager()));
        mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(pager);
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private class MyOnSwipeTouchListener extends OnSwipeTouchListener {
        public MyOnSwipeTouchListener(Context c) {
            super(c);
        }

        @Override
        public void onSwipeDown() {
            pager.setOrientation(DirectionalViewPager.VERTICAL);
            showToast("Swiped down!");
        }

        @Override
        public void onSwipeLeft() {
            pager.setOrientation(DirectionalViewPager.HORIZONTAL);
            showToast("Swiped left!");
        }

        @Override
        public void onSwipeRight() {
            pager.setOrientation(DirectionalViewPager.HORIZONTAL);
            showToast("Swiped right!");
        }

        @Override
        public void onSwipeUp() {
            pager.setOrientation(DirectionalViewPager.VERTICAL);
            showToast("Swiped up!");
        }
    }

}
