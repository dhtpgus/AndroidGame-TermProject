package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;

public class SelectorGenerator extends Generator{

    public SelectorGenerator() {
        genInterval = 14.f;
        genTime = 7;
        genType = GenType.SELECTOR;
    }

    @Override
    public void update(float elapsedSeconds) {
        genTime -= elapsedSeconds;
        if(genTime < 0) {
            generate();
            genTime = genInterval;
        }
    }

    private void generate() {
        Scene scene = Scene.top();
        if(scene == null) return;

        scene.add(MainScene.Layer.selector.ordinal(), Selector.get());
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
