package com.zzh.floatingmusic.mytext.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zzh.floatingmusic.R;

/**
 * @author Created by zhihao on 2016/8/23.
 * @describe
 * @version_
 **/
public class TwoActivity extends AppCompatActivity {

    TextView mText;
    TextView btnnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actovity_two);
        mText = (TextView) findViewById(R.id.back);
        btnnext= (TextView) findViewById(R.id.next);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TwoActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
