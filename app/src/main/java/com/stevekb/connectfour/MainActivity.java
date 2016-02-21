package com.stevekb.connectfour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {

    private BoardView myBoardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("5DA56B53019C0A99B3AF21C923250D0F").build();
        mAdView.loadAd(adRequest);

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