package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;

public class Hero extends Sprite{
    private static final float RADIUS = 1.25f;
    private static final float SPEED = 8.0f;
    private static final String TAG = Hero.class.getSimpleName();

    public Hero() {
        super(R.mipmap.hero_walk);
        //super(R.mipmap.plane_240);
        x = Metrics.width / 2;
        y = 2 * Metrics.height / 3;
        setPosition(x, y, RADIUS);

    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        //canvas.rotate(angle + 90, x, y);
        super.draw(canvas);
        canvas.restore();
    }
}
