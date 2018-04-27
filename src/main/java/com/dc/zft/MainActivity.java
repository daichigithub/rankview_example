package com.dc.zft;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private String[] mTitles = new String[] { "01", "02", "03", "04",
            "05", "06" };
    private int [] mValues = new int[]{ 95,90,80,70,60,50};

    private int [] mColors = new int[] { 0xFFEC7161, 0xFFEFAF4B, 0xFF9777A8,
            0xFFEC7161, 0xFFEFAF4B, 0xFF9777A8};

    private int [] mHintColors = new int[] { 0xFF566978, 0xFF566978, 0xFF566978,
            0xFF566978, 0xFF566978, 0xFF566978};

    private String [] mHints = new String[]{"张三丰(桃源乡河道)","张三丰(桃源乡河道)","张三丰(桃源乡河道)",
            "张三丰(桃源乡河道)","张三丰(桃源乡河道)","张三丰(桃源乡河道)"};

    private int itemCount = 6;

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.ll);

        for(int i = 0; i < itemCount; i ++){
            ZftConfig config = new ZftConfig();
            config.rectHeight = 60;
            config.rectColor = mColors[i];
            config.hint = mHints[i];
            config.hintColor = mHintColors[i];
            config.max = 100;
            config.value = mValues[i];
            config.rightLeftWidth = 100;
            config.rankTitle= mTitles[i];
            ZftView zft = new ZftView(this, config/*, i*/);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
//            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
//            zft.setLayoutParams(layoutParams);
//            zft.setId(i);

            ll.addView(zft,layoutParams);
        }
    }
}
