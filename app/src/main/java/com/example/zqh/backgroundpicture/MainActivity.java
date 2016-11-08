package com.example.zqh.backgroundpicture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bg_btn;
    private Button bg2_btn;
    /**
     * 亮度
     */
    public static float mLumValue = 0F;



    /**
     * SeekBar的中间值
     */
    public static final int MIDDLE_VALUE = 127;// 127

    /**
     * SeekBar的最大值
     */
    public static final int MAX_VALUE = 255;//255

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg_btn = (Button) findViewById(R.id.bg_btn);
        bg2_btn=(Button)findViewById(R.id.bg2_btn);

        bg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BackgroundPictureActivity.class);
                startActivity(intent);
            }
        });
        bg2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowBackgroundActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 设置亮度值
     * @param lum
     */
    public static void setLum(int lum) {
        mLumValue=(lum - 50) * 2 * 80 * 0.01f;
//        mLumValue = (lum - MIDDLE_VALUE) * 1.0F / MIDDLE_VALUE * 180;
        Log.i("Hsvcolor","progress: "+lum+"\n"+"mLumValue: "+mLumValue);
    }
}
