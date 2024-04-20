package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

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

    protected final ArrayList<IRHGameObject> gameObjects = new ArrayList<>();

    public void update(float elapsedSeconds) {
        int count = gameObjects.size();
        for (int i = count - 1; i >= 0; i--) {
            IRHGameObject gameObject = gameObjects.get(i);
            gameObject.update(elapsedSeconds);
        }
    }

    public void draw(Canvas canvas) {
        for (IRHGameObject gameObject : gameObjects) {
            gameObject.draw(canvas);
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
    public void add(IRHGameObject gameObject) {
        gameObjects.add(gameObject);
        Log.d(TAG, gameObjects.size() + " objects in " + getClass().getSimpleName());
    }
}
