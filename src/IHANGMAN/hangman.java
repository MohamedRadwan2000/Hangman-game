package IHANGMAN;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class hangman implements IHangman {
    public  String[]words=new String[850];
    public String secret_word;
    public String guessed ;
    public boolean lose=false;
    public boolean win=false;
    private int chances=1;
    private char[]choices=new char[800];
    private int choice=0;



    public void setDictionary(String [] words   ) {
        try{

            Scanner read1 = new Scanner(new File("hangman.txt"));
            for(int i=0;i<words.length;i++){
                words[i]=read1.next();
            }
        }
        catch (Exception e){
            System.out.println("FIle not found");
        }
    }


    public String selectRandomSecretWord() {
        int random=new Random().nextInt(words.length);
        secret_word=words[random];
        guessed=secret_word.replaceAll("\\S","-");
        secret_word=secret_word.toLowerCase();
        return secret_word;
    }
    public void intialize(){
        secret_word = secret_word.toLowerCase();
        guessed=secret_word.replaceAll("\\S","-");}
    public String get_gussed(){
        return this.guessed;
    }
   public String guess(Character c) {
        if((c!='/')&&(c!='&')&&(c!='*')&&(c!='^')&&(c!='#')&&(c!='@')&&(c!='-')&&(c!='+')&&(c!='!')&&(c!='_')&&(c!=')')&&(c!='(')&&(c!='=')&&(c!='$')&&(c!='~')&&(c!='.')&&(c!=',')&&(c!='0')&&(c!='4')&&(c!='3')&&(c!='2')&&(c!='1')&&(c!='3')&&(c!='4')&&(c!='5')&&(c!='6')&&(c!='7')&&(c!='8')&&(c!='9')&&(c!='"')&&(c!='{')&&(c!='}')&&(c!=';')&&(c!=':')&&(c!='`')&&(c!='%')&&(c!='?')&&(c!='|')) {
            String l;
            l = c.toString();
            l = l.toLowerCase();
            c = l.charAt(0);
            if (!lose) {
                boolean x = false;
                if (secret_word.equals(guessed)) {
                    System.out.println("'you win");
                } else {
                    if (chances > 0) {
                        for (int i = 0; i < choices.length; i++) {
                            if (choices[i] == c) {
                                x = true;
                            }
                        }
                        if (!x) {
                            choices[choice] = c;
                            choice++;

                            boolean y = false;


                            for (int i = 0; i < secret_word.length(); i++) {
                                if (secret_word.charAt(i) == c) {
                                    guessed = guessed.substring(0, i) + c + guessed.substring(i + 1);
                                    y = true;
                                }
                            }
                            if (secret_word.equals(guessed)) {
                                win = true;
                            }
                            if (!y) {
                                chances--;
                            }
                            System.out.println(guessed);
                        } else {
                            System.out.println("you already choose this character");
                            System.out.println(guessed);
                        }
                    } else {
                        System.out.println("you lose that game");
                        System.out.println("the secret word is " + secret_word);
                    }
                }
                System.out.println("the available chances :" + chances);
                if (chances == 0) {
                    lose = true;
                }
            } else {
                throw new RuntimeException("maximum number of chances");
            }
        }
        else {System.out.println("wrong info");}
    return guessed;
   }

    @Override
    public void setMaxWrongGuesses(Integer max) {
        chances=max;
        choices=new char[max+secret_word.length()];

    }


}
