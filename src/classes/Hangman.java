package classes;

import processing.core.PApplet;
import java.util.ArrayList; 
//import java.util.List;

public class Hangman {
    private String secretWord;
    private char[] guessedLetters;
// en arrayliste til at holde styr på de forkerte gæt vi har lavet 
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
        
        // vil tjekke om det er et bogstav eller tal
        if (!Character.isLetter(lowerCase)) {
            return letterInSecretWord;
        } else{

        for (int i = 0; i < secretWord.length(); i++){
            if (secretWord.charAt(i) == lowerCase){
              guessedLetters[i] = lowerCase;
              letterInSecretWord = true;
             
            } 
          }
          if (wrongGuesses.contains(lowerCase)== false && letterInSecretWord == false ){
            wrongGuesses.add(lowerCase);// tilføger de forkerte bogstaver til listen hvis de ikke allerede er der
        }
          return letterInSecretWord;
        }
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
        // hvis den er større end 5 fordi vi starter på 0 og har 6 liv
        if(wrongGuesses.size() > 5 ){
            return false;
        }
        else{
            return true;
        }
        
        
    }
}
