package com.robototes.scouting.scoutingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private enum Stage {
        AUTO(R.string.auto_stage), TELEOP(R.string.teleop_stage);

        public final int nameId;

        Stage(int nameId) {
            this.nameId = nameId;
        }
    }

    private static <T> T getRandFromArray(@NonNull T[] arr) {
        int index = (int) (arr.length * Math.random());
        return arr[index];
    }

    private Stage stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadMenu();
    }

    private void loadMenu() {
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        TextView splashText = (TextView) findViewById(R.id.splash_view);
        String[] splashes = res.getStringArray(R.array.splashes);
        splashText.setText(getRandFromArray(splashes));

        Button startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener((View view) -> {
            loadAuto();
        });

        EditText matchNumber = (EditText) findViewById(R.id.match_number);
        EditText teamNumber = (EditText) findViewById(R.id.team_number);
        EditText name = (EditText) findViewById(R.id.name);
    }

    private void loadAuto() {
        setContentView(R.layout.auto_layout);
        stage = Stage.AUTO;

        loadField();
        loadMatchInfo();

        CheckBox autoLine = (CheckBox) findViewById(R.id.auto_line_checkbox);
        Button toTeleopButton = (Button) findViewById(R.id.to_teleop_button);
        toTeleopButton.setOnClickListener((View view) -> {
            loadTeleop();
        });
    }

    private void loadTeleop() {
        setContentView(R.layout.teleop_layout);
        stage = Stage.TELEOP;

        loadField();
        loadMatchInfo();

        Button doneButton = (Button) findViewById(R.id.done_button);
        doneButton.setOnClickListener((View view) -> {
            loadMenu();
        });
        SeekBar climbSlider = (SeekBar) findViewById(R.id.climb_slider);
        SeekBar defenseSlider = (SeekBar) findViewById(R.id.defense_slider);
    }

    private void loadField() {
        TextView shotCount = (TextView) findViewById(R.id.shot_display);
        Button undoButton = (Button) findViewById(R.id.undo_button);
        Button highGoal = (Button) findViewById(R.id.high_goal);
        Button lowGoal = (Button) findViewById(R.id.low_goal);
    }

    private void loadMatchInfo() {
        Button abortButton = (Button) findViewById(R.id.abort_button);
        abortButton.setOnClickListener((View view) -> {
            loadMenu();
        });
        TextView matchNum = (TextView) findViewById(R.id.match_num_display);
        TextView teamNum = (TextView) findViewById(R.id.team_num_display);
        TextView stageView = (TextView) findViewById(R.id.stage);
        stageView.setText(getString(stage.nameId));
    }
}