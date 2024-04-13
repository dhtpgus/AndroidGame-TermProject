package kr.ac.tukorea.ge.spg.osh.runhero;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.Choreographer;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class RHGameView extends View implements Choreographer.FrameCallback {
    private final Activity activity;
    private long previousNanos = 0;
    private float elapsedSeconds;
    private ArrayList<IRHGameObject> gameObjects = new ArrayList<>();

    public RHGameView(Context context) {
        super(context);
        this.activity = (Activity)context;

        borderPaint = makeBorderPaint();

        setFullScreen();
    }

    @NonNull
    private Paint makeBorderPaint() {
        final Paint borderPaint;
        borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(0.1f);
        borderPaint.setColor(Color.RED);
        return borderPaint;
    }

    public void setFullScreen() {
        int flags = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        setSystemUiVisibility(flags);
    }

    private static final float SCREEN_WIDTH = 9.0f;
    private static final float SCREEN_HEIGHT = 16.0f;
    private final PointF transformOffset = new PointF();
    private float transformScale = 1;
    private final RectF borderRect = new RectF(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
    private final Paint borderPaint;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        float view_ratio = (float)w / (float)h;
        float game_ratio = SCREEN_WIDTH / SCREEN_HEIGHT;

        if(view_ratio > game_ratio) {
            transformOffset.set((w-h*game_ratio)/2, 0);
            transformScale = h / SCREEN_HEIGHT;
        } else {
            transformOffset.set(0, (h-w/game_ratio)/2);
            transformScale = w / SCREEN_WIDTH;
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(transformOffset.x, transformOffset.y);
        canvas.scale(transformScale, transformScale);
        canvas.drawRect(borderRect, borderPaint);
        for(IRHGameObject rhGameObject : gameObjects) {
            rhGameObject.draw(canvas);
        }
        canvas.restore();
    }

    @Override
    public void doFrame(long frameTimeNanos) {
        long elapsedNanos = frameTimeNanos - previousNanos;
        elapsedSeconds = elapsedNanos / 1_000_000_000f;
        if(previousNanos != 0){
            update();
        }
        invalidate();
        if(isShown()) {
            scheduleUpdate();
        }
        previousNanos = frameTimeNanos;
    }

    private void scheduleUpdate() {
        Choreographer.getInstance().postFrameCallback(this);
    }

    private void update() {
        for(IRHGameObject rhGameObject : gameObjects) {
            rhGameObject.update(elapsedSeconds);
        }
    }
}
