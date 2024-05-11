package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;

public class CollisionChecker implements IRHGameObject {
    private static final String TAG = CollisionChecker.class.getSimpleName();
    @Override
    public void update(float elapsedSeconds) {
        Scene scene = Scene.top();
        if (scene == null) return;

        ArrayList<IRHGameObject> monsters = scene.objectsAt(MainScene.Layer.monster.ordinal());
        for (int m = monsters.size() - 1; m >= 0; m--) {
            Monster monster = (Monster)monsters.get(m);
            ArrayList<IRHGameObject> projectiles = scene.objectsAt(MainScene.Layer.projectile.ordinal());
            for (int b = projectiles.size() - 1; b >= 0; b--) {
                Projectile projectile = (Projectile)projectiles.get(b);
                if (CollisionHelper.collides(monster, projectile)) {
                    Log.d(TAG, "Collision !!");
                    scene.remove(MainScene.Layer.projectile.ordinal(), projectile);
                    //scene.remove(MainScene.Layer.monster.ordinal(), monster);
                    boolean dead = monster.decreaseLife(projectile.getPower());
                    if(dead) {
                        scene.remove(MainScene.Layer.monster.ordinal(), monster);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {

    }
}
