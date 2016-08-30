package com.zzh.floatingmusic.mytext.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.zzh.floatingmusic.R;
import com.zzh.floatingmusic.mytext.fragment.Fragment1;
import com.zzh.floatingmusic.mytext.fragment.Fragment2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout frameLayout;
    public FragmentManager fragmentManager;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Button btnOne, btnTwo, btnNext;
    public static final int FRAGMENT_ONE = 0;
    public static final int FRAGMENT_TWO = 1;
    private Fragment1 oneFm;
    private Fragment2 twoFm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = (Button) findViewById(R.id.first);
        btnTwo = (Button) findViewById(R.id.second);
        btnNext = (Button) findViewById(R.id.next);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        fragmentManager=getSupportFragmentManager();
        showFragment(FRAGMENT_ONE);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.first:
                showFragment(FRAGMENT_ONE);
                break;
            case R.id.second:
                showFragment(FRAGMENT_TWO);
                break;
            case R.id.next:
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
        }
    }

    public void showFragment(int index) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        hideFragment(ft);

        switch (index) {

            case FRAGMENT_ONE:

                /**
                 * 如果Fragment为空，就新建一个实例
                 * 如果不为空，就将它从栈中显示出来
                 */
                if (oneFm == null) {
                    oneFm = new Fragment1();
                    ft.add(R.id.fragment, oneFm);
                } else {
                    ft.show(oneFm);
                }

                break;
            case FRAGMENT_TWO:


                if (twoFm == null) {
                    twoFm = new Fragment2();
                    ft.add(R.id.fragment, twoFm);
                } else {
                    ft.show(twoFm);
                }

                break;
        }

        ft.commit();
    }

    public void hideFragment(FragmentTransaction ft) {
        //如果不为空，就先隐藏起来
        if (oneFm != null) {
            ft.hide(oneFm);
        }
        if (twoFm != null) {
            ft.hide(twoFm);
        }
    }

}
