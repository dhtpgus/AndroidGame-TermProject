package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;
import android.graphics.RectF;

public class Monster extends AnimSprite implements IBoxCollidable{
    private static final float SPEED = 2.0f;
    private static final float RADIUS = 1.7f;
    protected RectF collisionRect = new RectF();
    private int life, maxLife;
    protected static Gauge gauge = new Gauge(0.1f, R.color.enemy_gauge_fg, R.color.enemy_gauge_bg);

    Monster() {
        super(R.mipmap.monster, 5.f);
        init();
    }

    private void init() {
        x = Metrics.width / 2;
        y = -RADIUS;
        setPosition(x, y, RADIUS);
        dy = SPEED;
        this.life = this.maxLife = 100;
    }

    public static Monster get() {
        return new Monster();
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
        if(dstRect.top > Metrics.height) {
            Scene.top().remove(MainScene.Layer.monster.ordinal(), this);
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
        gauge.draw(canvas, (float)life / maxLife);
        canvas.restore();
    }

    @Override
    public RectF getCollisionRect() {
        return collisionRect;
    }

    public boolean decreaseLife(int power) {
        life -= power;
        return life <= 0;
    }
}
