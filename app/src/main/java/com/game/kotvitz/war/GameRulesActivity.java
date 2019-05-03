package com.game.kotvitz.war;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameRulesActivity extends AppCompatActivity {

    private GameMedia gameMedia = new GameMedia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_rules);
        ScreenDesigner.callFullScreenMode(getWindow());
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        TextView rulesText = findViewById(R.id.rulesText);
        rulesText.setMovementMethod(new ScrollingMovementMethod());
        Button backButton = findViewById(R.id.backButtonRules);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameMedia.playClickSound(getBaseContext());
                onBackPressed();
            }
        });
    }
}
