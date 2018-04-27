package com.dc.zft;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;

/**
 * Created by Administrator on 2018/4/26 0026.
 */

public class ZftSubView extends View {

    private float mTextSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics());

    public ZftSubView(Context context) {
        super(context);
        init();
    }

    public ZftSubView(Context context, ZftConfig zftConfig){
        super(context);
        setZftConfig(zftConfig);
        init();
    }

    public ZftSubView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ZftSubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Paint mValuePaint;
    Paint mTextPaint;
    void init(){
        mValuePaint = new Paint();
        mValuePaint.setAntiAlias(true);
        mValuePaint.setDither(true);
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setDither(true);
        mTextPaint.setTextSize(mTextSize);

        if (zftConfig != null){
            mValuePaint.setColor(zftConfig.rectColor);
            mTextPaint.setColor(zftConfig.hintColor);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (zftConfig != null) {
            int width = getMeasuredWidth() - zftConfig.rightLeftWidth;
            canvas.drawRect(0, 0, (float) (width * zftConfig.value * 1.0 / zftConfig.max), zftConfig.rectHeight, mValuePaint);

            Path path = new Path();
            float textWidth = mTextPaint.measureText(zftConfig.hint);
            path.addRect(0, zftConfig.rectHeight + 40, textWidth + 100, zftConfig.rectHeight + 40, Path.Direction.CW);
            canvas.drawTextOnPath(zftConfig.hint, path, 0, 0, mTextPaint);
        }
    }

    public ZftConfig zftConfig;
    public void setZftConfig(ZftConfig zftConfig) {
        this.zftConfig = zftConfig;
        invalidate();
    }

    public ZftConfig getZftConfig() {
        return zftConfig;
    }
}
