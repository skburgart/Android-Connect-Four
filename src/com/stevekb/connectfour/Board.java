package com.stevekb.connectfour;

public class Board {
	
	public enum Player {BLANK, RED, BLACK};
	
	public Player[][] spots = {
			{Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
			{Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
			{Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
			{Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
			{Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
			{Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
			{Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
	};
			
	public Board() {
		
	}
	
}
