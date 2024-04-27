package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class Hero extends AnimSprite{
    private static final float RADIUS = 0.9f;
    private static final float SPEED = 4.0f;
    private float targetX;
    private static final int[] HERO_ANIMS = {R.mipmap.hero_walkforward, R.mipmap.hero_walkleft,
            R.mipmap.hero_walkright};

    public Hero() {
        super(R.mipmap.hero_walkforward, 4.f);
        x = Metrics.width / 2;
        y = Metrics.height;
        setPosition(x, y, RADIUS);
        targetX = x;
    }

    public boolean onTouch(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                float[] pts = Metrics.fromScreen(event.getX(), event.getY());
                setTargetX(pts[0]);
                return true;
        }
        return false;
    }

    @Override
    public void update(float elapsedSeconds) {
        if(targetX < x) {
            dx = -SPEED;
            setAnimationResource(R.mipmap.hero_walkleft, 4.f, 6);
        } else if (x < targetX) {
            dx = SPEED;
            setAnimationResource(R.mipmap.hero_walkright, 4.f, 6);
        } else {
            dx = 0;
            setAnimationResource(R.mipmap.hero_walkforward, 4.f, 3);
        }
        super.update(elapsedSeconds);
        float adjx = x;
        if((dx < 0 && x < targetX) || (dx > 0 && x > targetX)) {
            adjx = targetX;
        } else {
            adjx = Math.max(RADIUS, Math.min(x, Metrics.width - RADIUS));
        }
        if(adjx != x) {
            setPosition(adjx, y, RADIUS);
        }
    }

    private void setTargetX(float x) {
        targetX = Math.max(RADIUS, Math.min(x, Metrics.width - RADIUS));
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        super.draw(canvas);
        canvas.restore();
    }
}
