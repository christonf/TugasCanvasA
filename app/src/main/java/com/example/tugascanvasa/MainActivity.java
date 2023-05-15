package com.example.tugascanvasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaint2 = new Paint();
    private Paint mPaint3 = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    private int mCount = 0;

    private int mColorRectangleTop;
    private int mColorRectangleBottom;
    private int mColorCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorRectangleTop = ResourcesCompat.getColor(getResources(),
                R.color.red, null);
        mColorRectangleBottom = ResourcesCompat.getColor(getResources(),
                R.color.blue, null);
        mColorCircle = ResourcesCompat.getColor(getResources(),
                R.color.white, null);

        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.black, null));

        mPaintText.setTextSize(70);

        mImageView = findViewById(R.id.myImageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawSomething(view, mCount);
                mCount += 1;
            }
        });
    }

    public void drawSomething(View view, int mCount) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        int halfWidth = vWidth/2;
        int halfHeight = vHeight/2;

        if(mCount == 0) {
            mBitmap = Bitmap.createBitmap(vWidth, vHeight,
                    Bitmap.Config.ARGB_8888);
            mImageView.setImageBitmap(mBitmap);
            mCanvas = new Canvas(mBitmap);
        }
        else{
            if(mCount == 1) {
                mPaint.setColor(mColorRectangleTop);
                Point a = new Point(halfWidth+170, halfHeight-340);
                Point b = new Point(halfWidth+385, halfHeight-90);
                Point c = new Point(halfWidth+110, halfHeight+150);
                Point d = new Point(halfWidth-110, halfHeight-90);
                Path path = new Path();
                path.setFillType(Path.FillType.EVEN_ODD);
                path.moveTo(a.x, a.y);
                path.lineTo(b.x, b.y);
                path.lineTo(c.x, c.y);
                path.lineTo(d.x, d.y);
                path.close();
                mPaint.setColor(mColorRectangleTop);
                mCanvas.drawPath(path, mPaint);
            }
            else if(mCount == 2) {
                mPaint2.setColor(mColorRectangleBottom);
                Point e = new Point(halfWidth+90, halfHeight+170);
                Point f = new Point(halfWidth-130, halfHeight-70);
                Point g = new Point(halfWidth-400, halfHeight+170);
                Point h = new Point(halfWidth-180, halfHeight+400);
                Path path = new Path();
                path.setFillType(Path.FillType.EVEN_ODD);
                path.moveTo(e.x, e.y);
                path.lineTo(f.x, f.y);
                path.lineTo(g.x, g.y);
                path.lineTo(h.x, h.y);
                path.close();
                mPaint.setColor(mColorRectangleTop);
                mCanvas.drawPath(path, mPaint2);
            }
            else if(mCount == 3) {
                mPaint3.setColor(mColorCircle);
                mCanvas.drawCircle(halfWidth+140, halfHeight-100,
                        halfHeight / 13, mPaint3);
            }
            else if(mCount == 4) {
                mPaint3.setColor(mColorCircle);
                mCanvas.drawCircle(halfWidth-70, halfHeight+170,
                        halfHeight / 13, mPaint3);
            }
            else if(mCount == 5) {
                mPaint3.setColor(mColorCircle);
                mCanvas.drawCircle(halfWidth-240, halfHeight+170,
                        halfHeight / 13, mPaint3);
            }
        }
        view.invalidate();
    }
}