package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class Hero extends Sprite{
    private static final float RADIUS = 1.25f;
    private static final float SPEED = 4.0f;
    private float targetX;

    public Hero() {
        super(R.mipmap.hero_walkforward0);
        x = Metrics.width / 2;
        y = Metrics.height - 3;
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
        } else if (x < targetX) {
            dx = SPEED;
        } else {
            dx = 0;
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
        //canvas.rotate(angle + 90, x, y);
        super.draw(canvas);
        canvas.restore();
    }
}
