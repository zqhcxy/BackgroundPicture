package com.example.zqh.backgroundpicture;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;

//图片的饱和度，对比度，亮度调节！！
public class edit {


    int imgHeight, imgWidth;

    //设置饱和度
    public Bitmap Saturation(Bitmap map, float s) {//s的值在0-1

        imgHeight = map.getHeight();
        imgWidth = map.getWidth();
        Bitmap bmp = Bitmap.createBitmap(imgWidth, imgHeight,
                Config.ARGB_8888);
        ColorMatrix cMatrix = new ColorMatrix();
        // 设置饱和度  .
        cMatrix.setSaturation(s);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(cMatrix));
        Canvas canvas = new Canvas(bmp);
        // 在Canvas上绘制一个已经存在的Bitmap。这样，dstBitmap就和srcBitmap一摸一样了
        canvas.drawBitmap(map, 0, 0, paint);
        return bmp;
    }

    //设置对比度
    public Bitmap Contrast(Bitmap map, float c) {//c的值0-
        imgHeight = map.getHeight();
        imgWidth = map.getWidth();
        Bitmap bmp = Bitmap.createBitmap(imgWidth, imgHeight,
                Config.ARGB_8888);
        float contrast = c;
        ColorMatrix cMatrix = new ColorMatrix();
        cMatrix.set(new float[]{contrast, 0, 0, 0, 0, 0,
                contrast, 0, 0, 0,// 改变对比度
                0, 0, contrast, 0, 0, 0, 0, 0, 1, 0});

        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(cMatrix));

        Canvas canvas = new Canvas(bmp);
        // 在Canvas上绘制一个已经存在的Bitmap。这样，dstBitmap就和srcBitmap一摸一样了
        canvas.drawBitmap(map, 0, 0, paint);
        return bmp;
    }

    //设置亮度
    public Bitmap Brightness(Bitmap map, int b) {//b的值正数变亮，负数变暗

        imgHeight = map.getHeight();
        imgWidth = map.getWidth();
        Bitmap bmp = Bitmap.createBitmap(imgWidth, imgHeight,
                Config.ARGB_8888);
        int brightness = b;
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
