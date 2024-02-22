package classes;

import processing.core.PApplet;
import java.util.ArrayList; 
//import java.util.List;

public class Hangman {
    private String secretWord;
    private char[] guessedLetters;

    private ArrayList<Character> wrongGuesses = new ArrayList<Character>(); 

    public Hangman(String word){
        secretWord = word.toLowerCase();

        //init partial word, and set all
        //letters to '_'
        guessedLetters = new char[word.length()];
        for (int i = 0; i < guessedLetters.length; i++){
            guessedLetters[i] = '_';
        }
    }

    public char[] getGuessedLetters(){
        return guessedLetters;
    }

    public boolean guess(char letter){
        char lowerCase = Character.toLowerCase(letter);
        
        boolean letterInSecretWord = false;
        for (int i = 0; i < secretWord.length(); i++){
            if (secretWord.charAt(i) == lowerCase){
              guessedLetters[i] = lowerCase;
              letterInSecretWord = true;
            } else if (wrongGuesses.contains(lowerCase)== false ){
                wrongGuesses.add(lowerCase);
            }
          }
        return letterInSecretWord;
    }

    public void drawGuessedLetters(PApplet p){
        //draw word on screen
        p.textSize(32);
        for (int i = 0; i < guessedLetters.length; i++){
            //draw guessed letter in center of the screen
            p.text(guessedLetters[i], p.width/2+20*i-
                guessedLetters.length*20/2, p.height/2);
        }
    }

    public boolean isAlive(){
        // 5 fordi vi starter på 0 og har 6 liv
        if(wrongGuesses.size() > 5 ){
            return false;
        }
        else{
            return true;
        }
        
        
    }
}
