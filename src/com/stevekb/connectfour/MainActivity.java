package com.stevekb.connectfour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private BoardView myBoardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myBoardView = (BoardView) findViewById(R.id.boardView);

        myBoardView.setGameOverLayout((LinearLayout) findViewById(R.id.gameOverLayout));
        myBoardView.setGameOverText((TextView) findViewById(R.id.textGameOver));
    }

    public void buttonRematch(View v) {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void buttonQuit(View v) {
        finish();
    }
}