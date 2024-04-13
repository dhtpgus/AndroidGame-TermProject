package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;

public interface IRHGameObject {
    public void update(float elapsedSeconds);
    public void draw(Canvas canvas);
}
