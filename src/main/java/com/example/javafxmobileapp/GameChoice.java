package com.example.javafxmobileapp;

public enum GameChoice {

     ROCK ("Rock"),
     PAPER("Paper"),
     SCISSOR("Scissor"),
     WINNER("Wins!"),
     TIE("Tie!");


    private final String levelCode;

    GameChoice(String levelCode) {
        this.levelCode = levelCode;
    }
    //needed for not getting caps
    @Override
    public String toString(){
        return levelCode;
    }
}
