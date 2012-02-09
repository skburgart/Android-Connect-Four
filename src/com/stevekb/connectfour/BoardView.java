package com.stevekb.connectfour;

import com.stevekb.connectfour.Board.Player;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class BoardView extends SurfaceView implements
		SurfaceView.OnTouchListener {

	private float BOARD_MARGIN = 25;

	private int previewSpot = -1;
	private RectF boardRect;
	private Player onPlayer = Player.RED;

	private static final int BOARD_COLOR = Color.YELLOW;
	private static final int BG_COLOR = Color.rgb(232, 232, 232);
	private static final Paint boardPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private static final Paint bgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private static final Paint borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private static final Paint playerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private Context context;
	private Board myBoard = new Board();

	public BoardView(Context context, AttributeSet attrs) {
		super(context, attrs);

		this.context = context;
		this.setOnTouchListener(this);

		this.setBackgroundColor(BG_COLOR);
		boardPaint.setColor(BOARD_COLOR);
		bgPaint.setColor(BG_COLOR);
		borderPaint.setColor(Color.BLACK);
	}

	@Override
	protected void onDraw(Canvas c) {
		super.onDraw(c);

		float maxY = this.getHeight();
		float maxX = this.getWidth();

		DrawBoard(c, maxX, maxY);
	}

	private void DrawBoard(Canvas c, float maxX, float maxY) {

		boardRect = new RectF(maxX * 0.05f, maxY * 0.1f, maxX * 0.95f,
				maxY * 0.95f);
		RectF borderRect = new RectF(maxX * 0.05f - 1, maxY * 0.1f - 1,
				maxX * 0.95f + 1, maxY * 0.95f + 1);

		if (previewSpot != -1)
			ShowPreviewSpot(c);

		c.drawRoundRect(borderRect, 20f, 20f, borderPaint);
		c.drawRoundRect(boardRect, 20f, 20f, boardPaint);

		DrillHoles(c);
	}

	private void ShowPreviewSpot(Canvas c) {
		float deltaX = (boardRect.right - boardRect.left - BOARD_MARGIN) / 7;
		float initial = boardRect.left + ((deltaX + BOARD_MARGIN) / 2);
		float pieceRadius = deltaX * 0.425f;

		if (onPlayer == Player.RED)
			playerPaint.setColor(Color.RED);
		else
			playerPaint.setColor(Color.BLACK);

		c.drawCircle(initial + deltaX * previewSpot, boardRect.top - pieceRadius / 2, pieceRadius + 1, borderPaint);
		c.drawCircle(initial + deltaX * previewSpot, boardRect.top - pieceRadius / 2, pieceRadius, playerPaint);
	}

	private void DrillHoles(Canvas c) {

		float deltaX = (boardRect.right - boardRect.left - BOARD_MARGIN) / 7;
		float deltaY = (boardRect.bottom - boardRect.top - BOARD_MARGIN) / 7;

		int xSpot = 0, ySpot = 6;
		for (float yPos = boardRect.top + ((deltaY + BOARD_MARGIN) / 2); ySpot >= 0; yPos += deltaY, ySpot--) {
			for (float xPos = boardRect.left + ((deltaX + BOARD_MARGIN) / 2); xSpot < 7; xPos += deltaX, xSpot++) {

				if (myBoard.spots[ySpot][xSpot] == Player.RED)
					playerPaint.setColor(Color.RED);
				else if (myBoard.spots[ySpot][xSpot] == Player.BLACK)
					playerPaint.setColor(Color.BLACK);
				else
					playerPaint.setColor(BG_COLOR);

				float pieceRadius = deltaX * 0.425f;

				c.drawCircle(xPos, yPos, pieceRadius + 1, borderPaint);
				c.drawCircle(xPos, yPos, pieceRadius, playerPaint);
			}

			xSpot = 0;
		}
	}

	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN
				|| event.getAction() == MotionEvent.ACTION_MOVE) {

			previewSpot = touchToSpot(event.getX());

			invalidate();
			
			return true;
		} else if (event.getAction() == MotionEvent.ACTION_UP) {

			previewSpot = -1;
			int toDrop = touchToSpot(event.getX());

			for (int i = 0; i < 7; i++) {
				if (myBoard.spots[i][toDrop] == Player.BLANK) {
					myBoard.spots[i][toDrop] = onPlayer;

					onPlayer = (onPlayer == Player.BLACK) ? Player.RED
							: Player.BLACK;

					break;
				}
			}

			invalidate();
			CheckGameState();
			return true;
		}
		return false;
	}
	
	private void CheckGameState() {
		
	}

	private int touchToSpot(float x) {
		float deltaX = (boardRect.right - boardRect.left - BOARD_MARGIN) / 7;
		float initial = boardRect.left + BOARD_MARGIN / 2;

		if (x < initial + (deltaX * 1))
			return 0;
		else if (x < initial + (deltaX * 2))
			return 1;
		else if (x < initial + (deltaX * 3))
			return 2;
		else if (x < initial + (deltaX * 4))
			return 3;
		else if (x < initial + (deltaX * 5))
			return 4;
		else if (x < initial + (deltaX * 6))
			return 5;
		else
			return 6;
	}
}
