package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;
import android.graphics.RectF;

public class Selector extends Sprite implements IRHGameObject{
    private static final float SPEED = 2.0f;
    private static final float RADIUS = 1.7f;
    protected RectF collisionRect = new RectF();

    public Selector() {
        super(R.mipmap.test_selector);
        x = Metrics.width / 2;
        y = -RADIUS;
        setPosition(x, y, RADIUS);
        dy = SPEED;
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
        if(dstRect.top > Metrics.height) {
            Scene.top().remove(MainScene.Layer.selector.ordinal(), this);
        }
        collisionRect.set(dstRect);
        collisionRect.inset(0.35f, 0.7f);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();
        float width = dstRect.width() * 0.7f;
        canvas.translate(x - width / 2, dstRect.bottom);
        canvas.scale(width, width);
        canvas.restore();
    }

    public static Selector get() { return new Selector(); }
}
