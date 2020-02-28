package IHANGMAN;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        char n;
        String m;
        int o, counter = 0;
        System.out.println("Enter the maximum number of chances you want");
        Scanner read = new Scanner(System.in);
        o = read.nextInt();
        hangman x = new hangman();
        x.setDictionary(x.words);
        m=x.selectRandomSecretWord();
        x.setMaxWrongGuesses(o);

        m=x.get_gussed();
        System.out.println(m);
       while (true) {
            n = read.next().charAt(0);
            m = x.guess(n);
            if(x.win){
                System.out.println("you win");
            }
            else if (x.lose){System.out.println("you lose the secret word is: "+x.secret_word);}
            counter++;
        }

    }
}

