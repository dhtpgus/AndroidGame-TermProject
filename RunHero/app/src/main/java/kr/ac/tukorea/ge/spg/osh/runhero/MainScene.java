package kr.ac.tukorea.ge.spg.osh.runhero;

import android.view.MotionEvent;

public class MainScene extends Scene{
    private static final String TAG = MainScene.class.getSimpleName();
    private final Hero hero;

    public enum Layer {
        player, COUNT
    }
    public MainScene() {
        Metrics.setGameSize(9.0f, 16.0f);
        this.hero = new Hero();
        initLayers(Layer.COUNT.ordinal());

        add(Layer.player.ordinal(), hero);

//        AnimSprite animSprite = new AnimSprite(R., 4.f);
//        animSprite.setAnimationResource(R.mipmap.hero_walkforward0, 4, 3);
//        animSprite.setPosition(4.5f, 4.5f, 0.9f);
//        add(animSprite);
    }

    @Override
    public boolean onTouch(MotionEvent event) {
        return hero.onTouch(event);
    }
}
