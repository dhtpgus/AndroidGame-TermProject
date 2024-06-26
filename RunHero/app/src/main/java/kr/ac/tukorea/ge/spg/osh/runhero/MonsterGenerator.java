package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;

public class MonsterGenerator extends Generator{

    public MonsterGenerator() {
        genInterval = 14.f;
        genTime = 0;
        genType = GenType.MONSTER;
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

        scene.add(MainScene.Layer.monster.ordinal(), Monster.get());
    }
    @Override
    public void draw(Canvas canvas) {

    }
}
