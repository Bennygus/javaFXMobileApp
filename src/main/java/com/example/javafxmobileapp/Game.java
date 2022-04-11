package com.example.javafxmobileapp;

public class Game extends User {



    private Long gameId;
    private String message;
    private String playerOne ;
    private String playerTwo ;
    private String result;
    private String choiceOne;
    private String choiceTwo;
    private String state;

    @Override
    public String toString() {

        return  state +" Game " + gameId +
                ": Challenger " + playerOne +
                " vs " + playerTwo +
                " = result: " + result
                ;
    }

    public Game() {
    }




    public Game(String message, String playerOne, String playerTwo, String result, String choiceOne,String choiceTwo,String state) {

        this.message = message;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.result = result;
        this.choiceOne = choiceOne;
        this.choiceTwo = choiceTwo;
        this.state = state;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getChoiceOne() {
        return choiceOne;
    }

    public void setChoiceOne(String choiceOne) {
        this.choiceOne = choiceOne;
    }

    public String getChoiceTwo() {
        return choiceTwo;
    }

    public void setChoiceTwo(String choiceTwo) {
        this.choiceTwo = choiceTwo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
