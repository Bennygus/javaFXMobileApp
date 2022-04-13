package com.example.javafxmobileapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    Game game = new Game();


    @Test
    void testChoiceFalse(){

        var test = game.getChoiceOne();
        var test2 = game.getChoiceOne();

        test = "Rock";
        test2 = "Paper";



        assertFalse(game.checkIfTie(test,test2));



    }

    @Test
    void testChoiceEquals(){

        var test = game.getChoiceOne();
        var test2 = game.getChoiceOne();

        test = "Rock";
        test2 = "Rock";



        assertTrue(game.checkIfTie(test,test2));

    }






}