package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;

public class Background extends Sprite{
    private final float speed;
    private final float height;

    public static final int[] BACKGROUND_IMAGES = {R.mipmap.test_map};
    public Background(int[] bitmapResId, float speed) {
        super(bitmapResId);
        this.height = bitmap.getHeight() * Metrics.width / bitmap.getWidth();
        setPosition(Metrics.width / 2, Metrics.height / 2, Metrics.width, height);
        this.speed = speed;
    }

    @Override
    public void update(float elapsedSeconds) {
        this.y += speed * elapsedSeconds;
//        if(this.y > Metrics.height) {
//            this.y = 0;
//        }
//        setPosition(x,y,Metrics.width,height);
    }

    @Override
    public void draw(Canvas canvas) {
        float curr = y % height;
        if(curr > 0) curr -= height;
        while (curr < Metrics.height) {
            dstRect.set(0, curr, Metrics.width, curr + height);
            canvas.drawBitmap(bitmap, null, dstRect, null);
            curr += height;
        }
    }
}
