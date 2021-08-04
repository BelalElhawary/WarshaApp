package com.santraf4.warsha.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.santraf4.warsha.R;

import java.util.List;

public class CustomView extends View {

    private static final int SQUARE_SIZE = 100;

    private Rect mRectSquare;
    private Paint mPaintSquare;

    private int mSquareColor;
    private int mSquareSize;

    private float[] x;
    private float[] y;

    private Path vectorPath;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        mRectSquare = new Rect();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);

        if(set == null)
            return;

        TypedArray te = getContext().obtainStyledAttributes(set, R.styleable.CustomView);

        mSquareColor = te.getColor(R.styleable.CustomView_square_color, Color.GREEN);
        mSquareSize = te.getDimensionPixelSize(R.styleable.CustomView_square_size, 100);
        mPaintSquare.setColor(mSquareColor);
        te.recycle();
    }

    public void swapColor()
    {
        mPaintSquare.setColor(mPaintSquare.getColor() == mSquareColor? Color.RED : mSquareColor);

        postInvalidate();
    }

    public void MakeShape(float[] vx, float[] vy)
    {
        x = vx;
        y = vy;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        mRectSquare.left = 10;
        mRectSquare.top = 10;
        mRectSquare.right = mRectSquare.left + mSquareSize;
        mRectSquare.bottom = mRectSquare.top + mSquareSize;

        vectorPath = new Path();

        vectorPath.moveTo(6 * 10, 0);
        vectorPath.lineTo((6 + 5.7f) * 10, 4.14f * 10);
        vectorPath.lineTo((11.7f - 4.14f) *10, (4.14f + 5.7f) *10);
        vectorPath.lineTo(((11.7f - 4.14f)-7.05f) *10, (4.14f + 5.7f) *10);
        /*
        vectorPath.moveTo(x[0], y[0]);

        for(int i = 1; i < x.length; i++)
        {
            vectorPath.lineTo(x[i], y[i]);
        }
        */
        vectorPath.close();
        //canvas.drawRect(mRectSquare, mPaintSquare);
        canvas.drawPath(vectorPath, mPaintSquare);
    }
}
