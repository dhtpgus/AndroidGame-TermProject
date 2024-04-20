package kr.ac.tukorea.ge.spg.osh.runhero;

import android.view.MotionEvent;

public class MainScene extends Scene{
    private static final String TAG = MainScene.class.getSimpleName();
    private final Hero hero;

    public MainScene() {
        Metrics.setGameSize(9.0f, 16.0f);

        this.hero = new Hero();
        add(hero);
    }

    @Override
    public boolean onTouch(MotionEvent event) {
        return hero.onTouch(event);
    }
}
