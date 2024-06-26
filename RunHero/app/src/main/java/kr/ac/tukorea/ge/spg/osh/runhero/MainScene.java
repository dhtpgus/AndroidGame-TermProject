package kr.ac.tukorea.ge.spg.osh.runhero;

import android.view.MotionEvent;

public class MainScene extends Scene{
    private static final String TAG = MainScene.class.getSimpleName();
    private final Hero hero;
    public final Generator generator;

    public enum Layer {
        bg, selector, monster, player, projectile, controller, generator, COUNT
    }
    public MainScene() {
        Metrics.setGameSize(9.0f, 16.0f);
        this.hero = new Hero();
        initLayers(Layer.COUNT.ordinal());

        add(Layer.player.ordinal(), hero);
        //add(Layer.monster.ordinal(), new Monster());

        add(Layer.bg.ordinal(), new Background(R.mipmap.background, 0.5f));
        add(Layer.bg.ordinal(), new Background(R.mipmap.tree_background, 0.7f));

        add(Layer.controller.ordinal(), new CollisionChecker());

        generator = new Generator();
        add(Layer.generator.ordinal(), generator);
        generator.addGenerator(new SelectorGenerator());
        generator.addGenerator(new MonsterGenerator());

    }

    @Override
    public boolean onTouch(MotionEvent event) {
        return hero.onTouch(event);
    }
}

