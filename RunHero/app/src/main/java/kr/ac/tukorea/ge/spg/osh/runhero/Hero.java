package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class Hero extends AnimSprite{
    private static final float RADIUS = 0.9f;
    private static final float SPEED = 4.0f;
    private static final float FIRE_INTERVAL = 0.25f;
    private float fireCoolTime = FIRE_INTERVAL;
    private float targetX;
    private static final int[] HERO_ANIMS = {R.mipmap.hero_walkforward, R.mipmap.hero_walkleft,
            R.mipmap.hero_walkright};

    public Hero() {
        super(R.mipmap.hero_walkforward, 4.f);
        x = Metrics.width / 2;
        y = Metrics.height - 1;
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

        fireProjectile(elapsedSeconds);
    }

    private void setTargetX(float x) {
        targetX = Math.max(RADIUS, Math.min(x, Metrics.width - RADIUS));
    }

    private void fireProjectile(float elapsedSeconds) {
        MainScene scene = (MainScene)Scene.top();
        if(scene == null) return;
        fireCoolTime -= elapsedSeconds;
        if(fireCoolTime > 0) return;

        fireCoolTime = FIRE_INTERVAL;

        int power = 10;
        Projectile projectile = Projectile.get(x, y-0.8f, power);

        scene.add(MainScene.Layer.projectile.ordinal(), projectile);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        super.draw(canvas);
        canvas.restore();
    }
}
