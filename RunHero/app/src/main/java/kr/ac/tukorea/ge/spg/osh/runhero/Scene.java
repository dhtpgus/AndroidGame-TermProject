package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Scene {
    private static final String TAG = Scene.class.getSimpleName();
    private static ArrayList<Scene> stack = new ArrayList<>();

    public static Scene top() {
        int top = stack.size() - 1;
        if (top < 0) {
            Log.e(TAG, "Scene Stack is empty in Scene.top()");
            return null;
        }
        return stack.get(top);
    }
    public static void push(Scene scene) {
        Scene prev = top();
        if (prev != null) {
            prev.onPause();
        }
        stack.add(scene);
        scene.onStart();
    }
    public void push() {
        push(this);
    }
    public static void pop() {
        Scene scene = top();
        if (scene == null) {
            Log.e(TAG, "Scene Stack is empty in Scene.pop()");
            return;
        }
        scene.onEnd();
        stack.remove(scene);

        scene = top();
        if (scene == null) {
            Log.i(TAG, "Last scene is being popped");
            finishActivity();
            return;
        }
        scene.onResume();
    }

    public static void finishActivity() {
        //GameView gameView = null;
        //gaveView.getActivity().finish();
        RHGameActivity.activity.finish();
    }

    protected ArrayList<ArrayList<IRHGameObject>> layers = new ArrayList<>();

    protected void initLayers(int layerCount) {
        layers = new ArrayList<>();
        for (int i = 0; i < layerCount; i++) {
            layers.add(new ArrayList<>());
        }
    }

    public ArrayList<IRHGameObject> objectsAt(int layerIndex) {
        return layers.get(layerIndex);
    }

    public void update(float elapsedSeconds) {
        for (ArrayList<IRHGameObject> objects : layers) {
            int count = objects.size();
            for (int i = count - 1; i >= 0; i--) {
                IRHGameObject gameObject = objects.get(i);
                gameObject.update(elapsedSeconds);
            }
        }
    }
    protected static Paint bboxPaint;
    public void draw(Canvas canvas) {
        for (ArrayList<IRHGameObject> objects : layers) {
            for(IRHGameObject gameObject : objects) {
                gameObject.draw(canvas);
            }
        }
        if(BuildConfig.DEBUG) {
            if (bboxPaint == null) {
                bboxPaint = new Paint();
                bboxPaint.setStyle(Paint.Style.STROKE);
                bboxPaint.setColor(Color.RED);
            }
            for (ArrayList<IRHGameObject> objects: layers) {
                for (IRHGameObject gobj : objects) {
                    if (gobj instanceof IBoxCollidable) {
                        RectF rect = ((IBoxCollidable) gobj).getCollisionRect();
                        canvas.drawRect(rect, bboxPaint);
                    }
                }
            }
        }
    }

    public boolean onTouch(MotionEvent event) {
        return false;
    }

    //////////////////////////////////////////////////
    // Overridables


    protected void onStart() {
    }
    protected void onEnd() {
    }

    protected void onPause() {
    }
    protected void onResume() {
    }

    public boolean onBackPressed() {
        return false;
    }

    //////////////////////////////////////////////////
    // Game Object Management
    public void add(int layerIndex, IRHGameObject gameObject) {
        ArrayList<IRHGameObject> objects = layers.get(layerIndex);
        objects.add(gameObject);
    }

    public void remove(int layerIndex, IRHGameObject gameObject) {
        ArrayList<IRHGameObject> objects = layers.get(layerIndex);
        objects.remove(gameObject);
    }
}
