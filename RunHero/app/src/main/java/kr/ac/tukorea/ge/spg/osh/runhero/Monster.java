package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;

public class Monster extends AnimSprite{
    private static final float RADIUS = 1.7f;

    Monster() {
        super(R.mipmap.monster, 5.f);
        x = Metrics.width / 2;
        y = Metrics.height - 10;
        setPosition(x, y, RADIUS);
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
    }

}
