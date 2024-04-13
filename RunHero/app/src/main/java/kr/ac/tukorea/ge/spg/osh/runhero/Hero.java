package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Hero implements IRHGameObject{
    private static final float RADIUS = 1.25f;
    private Bitmap bitmap;
    private float x, y;
    private RectF dstRect = new RectF();
    public Hero(Bitmap bitmap) {
        x = 5.0f;
        y = 12.0f;
        dstRect.set(x-RADIUS, y, x+RADIUS, y+2*RADIUS);
        this.bitmap = bitmap;
    }

    @Override
    public void update(float elapsedSeconds) {
        dstRect.set(x-RADIUS, y-RADIUS, x+RADIUS, y+RADIUS);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(bitmap, null, dstRect, null);
        canvas.restore();
    }
}
