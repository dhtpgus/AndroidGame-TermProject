package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;

public class MonsterGenerator implements IRHGameObject{
    private float MONSTER_GEN_INTERVAL = 5.0f;
    private float monsterTime = 0;
    @Override
    public void update(float elapsedSeconds) {
        monsterTime -= elapsedSeconds;
        if(monsterTime < 0) {
            generate();
            monsterTime = MONSTER_GEN_INTERVAL;
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
