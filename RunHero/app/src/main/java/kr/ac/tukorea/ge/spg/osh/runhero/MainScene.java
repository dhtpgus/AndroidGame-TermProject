package kr.ac.tukorea.ge.spg.osh.runhero;

import android.view.MotionEvent;
import kr.ac.tukorea.ge.spg.osh.runhero.Hero;
import kr.ac.tukorea.ge.spg.osh.runhero.Scene;

public class MainScene extends Scene{
    private static final String TAG = MainScene.class.getSimpleName();
    private final Hero player;

    public MainScene() {
        Metrics.setGameSize(9.0f, 16.0f);

        this.player = new Hero();
        add(player);
    }

    @Override
    public boolean onTouch(MotionEvent event) {
        return false;
    }
}
