package com.example.zqh.backgroundpicture;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;

public class BackgroundPictureActivity extends AppCompatActivity {

    private SeekBar hue_seekbar_v;

    private View tint_iv;
    private ImageView show_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_picture);

        findView();
    }

    private void findView() {
        hue_seekbar_v = (SeekBar) findViewById(R.id.hue_seekbar_v);
        show_iv = (ImageView) findViewById(R.id.show_iv);
        tint_iv = (View) findViewById(R.id.tint_iv);

        hue_seekbar_v.setMax(100);
        hue_seekbar_v.setProgress(50);

//        hue_seekbar_v.setMax(MainActivity.MAX_VALUE);
//        hue_seekbar_v.setProgress(MainActivity.MIDDLE_VALUE);

        hue_seekbar_v.setProgressDrawable(new MyShapeDrawable(this, new RectShape(), getVColor(Color.BLACK, 0.3f)));
        hue_seekbar_v.setOnSeekBarChangeListener(seekbarlistener);

    }

    SeekBar.OnSeekBarChangeListener seekbarlistener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
            if (!fromUser)
                return;
            MainActivity.setLum(i);

            float[] hsv = {0f, 0f, ((float) hue_seekbar_v.getProgress()) / 100f};//seekbar_v.getProgress()-100

            int alpha = hue_seekbar_v.getProgress();
            float showAlpha = ((float) alpha) / 100f;
            if (alpha > 50) {//变白
                showAlpha =showAlpha-0.5f;
            } else if (alpha < 50) {//变黑
                showAlpha = 0.5f - showAlpha;
            } else {
                showAlpha = 0f;
            }
            showAlpha=showAlpha*255;
            int color = Color.HSVToColor((int)showAlpha,hsv);
            tint_iv.setBackgroundColor(color);
//            setVColor(color);
//            setAlpthaBg();

//            ColorDrawable colorDrawable=new ColorDrawable(color);
//            colorDrawable.setAlpha((int)showAlpha);
//            int newcolor=colorDrawable.getColor();
//            int[] colors = new int[3];
//            colors[0] = newcolor;
//            colors[1] = newcolor;
//            colors[2] = newcolor;
//            show_iv.setImageTintList(new ColorStateList(mPressedEnableStates,colors));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };


    /**
     * 覆盖层的颜色渐变
     * @param color
     */
    private void setVColor(int color){
        int alpha = hue_seekbar_v.getProgress();
        float showAlpha = ((float) alpha) / 100f;
        if (alpha > 50) {//变白
            showAlpha =showAlpha-0.5f;
        } else if (alpha < 50) {//变黑
            showAlpha = 0.5f - showAlpha;
        } else {
            showAlpha = 0f;
        }
//        tint_iv.setAlpha(showAlpha);
        tint_iv.setBackgroundColor(color);
    }

    /**
     * 设置透明度渐变
     */
    private void setAlpthaBg(){
        int alpha = hue_seekbar_v.getProgress();
        float showAlpha = ((float) alpha) / 100f;
        show_iv.setAlpha(showAlpha+0.2f);

    }



    /**
     * 获取按钮按下的颜色（改变明暗度）
     *
     * @param color 进行调整的颜色值
     * @return 返回经过0.9f明暗度调整后的颜色值
     */
    public static int getVColor(@ColorInt int color, float vf) {
        float[] v = new float[3];
        Color.colorToHSV(color, v);
        v[2] = 0.3f;
        return Color.HSVToColor(v);
    }

    public final static int[][] mPressedEnableStates = new int[][]{
            new int[]{android.R.attr.state_pressed},
            new int[]{android.R.attr.state_enabled},
            new int[]{-android.R.attr.state_enabled}};
}
