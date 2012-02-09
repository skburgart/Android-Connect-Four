package com.stevekb.connectfour;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	private BoardView myBoardView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        myBoardView = (BoardView) findViewById(R.id.boardView);
    }
}