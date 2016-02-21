package com.stevekb.connectfour;

public class Board {

    public Player[][] spots = {
            {Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
            {Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
            {Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
            {Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
            {Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
            {Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},
            {Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK, Player.BLANK},};

    public Board() {
    }

    public enum Player {

        BLANK, RED, BLACK, TIE
    }

    public enum WinType {

        HORIZONTAL, VERTICAL, DIAG_POS, DIAG_NEG
    }
}
