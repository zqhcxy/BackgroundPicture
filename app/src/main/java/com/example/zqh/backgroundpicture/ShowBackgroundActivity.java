package com.example.zqh.backgroundpicture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ShowBackgroundActivity extends AppCompatActivity {

    private ImageView showact_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_background);
        showact_iv = (ImageView) findViewById(R.id.showact_iv);

        showImg();


    }


    private void showImg() {
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic3);
        showact_iv.setImageBitmap(Brightness(mBitmap,MainActivity.mLumValue));
    }

    //设置亮度
    public Bitmap Brightness(Bitmap map, float b) {//b的值正数变亮，负数变暗

        int imgHeight = map.getHeight();
        int imgWidth = map.getWidth();
        Bitmap bmp = Bitmap.createBitmap(imgWidth, imgHeight,
                Bitmap.Config.ARGB_8888);
        float brightness = b;
        ColorMatrix cMatrix = new ColorMatrix();
        cMatrix.set(new float[]{1, 0, 0, 0, brightness, 0, 1,
                0, 0, brightness,// 改变亮度
                0, 0, 1, 0, brightness, 0, 0, 0, 1, 0});

        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(cMatrix));

        Canvas canvas = new Canvas(bmp);
        // 在Canvas上绘制一个已经存在的Bitmap。这样，dstBitmap就和srcBitmap一摸一样了
        canvas.drawBitmap(map, 0, 0, paint);
        return bmp;
    }

}
