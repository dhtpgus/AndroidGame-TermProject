package kr.ac.tukorea.ge.spg.osh.runhero;

import android.os.Bundle;


import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;


public class RHGameActivity extends AppCompatActivity {

    public static RHGameActivity activity;
    private RHGameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        gameView = new RHGameView(this);
        //gameView.setFullScreen();
        setContentView(gameView);
        new MainScene().push();

        getOnBackPressedDispatcher().addCallback(onBackPressedCallback);
    }

    private final OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            gameView.onBackPressed();
        }
    };
}