package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import classes.*;

public class HangmanTest {
    @Test
    public void charArraySet(){
        final Hangman game = new Hangman("fisk");

        char[] charArray = game.getGuessedLetters();

        assertEquals(4, charArray.length);
        
        for (char letter : charArray){
            assertSame(null, letter, '_');
        }
    }

    @Test
    public void guessTrue(){
        final Hangman game = new Hangman("kitten");

        assertTrue(game.guess('k'));
    }

    @Test
    public void guessFalse(){
        final Hangman game = new Hangman("kitten");

        assertFalse(game.guess('z'));
    }

    @Test
    public void guessMultipel(){
        final Hangman game = new Hangman("kitten");

        game.guess('t');

        assertTrue(game.getGuessedLetters()[2] == 't');
        assertTrue(game.getGuessedLetters()[3] == 't');
    }

    @Test
    public void guessCaseInsensitiv(){
        final Hangman game = new Hangman("KITTEN");

        game.guess('N');

        assertTrue(game.getGuessedLetters()[5] == 'n');
    }


}
