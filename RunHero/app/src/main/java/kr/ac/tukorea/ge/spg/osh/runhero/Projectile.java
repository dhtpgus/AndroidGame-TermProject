package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.RectF;

public class Projectile extends Sprite implements IBoxCollidable{
    private static final float PROJECTILE_W = 0.68f;
    private static final float PROJECTILE_H = PROJECTILE_W * 40 / 28;
    private static final float SPEED = 20.0f;
    private int power;

    private Projectile(float x, float y, int power) {
        super(R.mipmap.hero_walkforward);
        setPosition(x,y,PROJECTILE_W,PROJECTILE_H);
        this.power = power;
        dy = -SPEED;
    }

    public static Projectile get(float x, float y, int power) {
        return new Projectile(x, y, power);
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
        if (dstRect.bottom < 0) {
            Scene.top().remove(MainScene.Layer.projectile.ordinal(), this);
        }
    }

    @Override
    public RectF getCollisionRect() {
        return dstRect;
    }

    public int getPower() {
        return power;
    }
}
