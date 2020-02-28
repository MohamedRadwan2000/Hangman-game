package IHANGMAN;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class hangmanTest {
    @Test
   public void test(){
    hangman x=new hangman();
    x.secret_word="world";
    x.intialize();
    x.guess('w');
    x.guess('o');
    x.guess('r');
    x.guess('l');
    x.guess('d');
     assertEquals(true,x.win);

    }
 @Test
 public void test2(){
  hangman x=new hangman();
  String m;
  x.secret_word="BoOm";
  x.intialize();
  m= x.guess('b');
  assertEquals("b---",m);
  m=x.guess('o');
  assertEquals("boo-",m);
 m= x.guess('m');
 assertEquals("boom",m);
  assertEquals(true,x.win);

 }
 @Test
 //lose_game
 public void test3(){
     //lose the game
  hangman x=new hangman();
  x.secret_word="world";
  x.intialize();
  x.guess('f');
  assertEquals(true,x.lose);
  assertThrows(RuntimeException.class,()->{x.guess('d');});

 }
 @Test
 //lose_game
 public void test4(){
  //lose the game
  hangman x=new hangman();
  x.secret_word="world";
  x.intialize();
  x.setMaxWrongGuesses(3);
  x.guess('f');
  x.guess('b');
  x.guess('p');
  assertEquals(true,x.lose);
  assertThrows(RuntimeException.class,()->{x.guess('d');});
 }
 @Test
 //lose game
 public void test5(){
  //lose the game
  hangman x=new hangman();
  x.secret_word="world";
  x.intialize();
  x.guess('f');
  assertEquals(true,x.lose);
  assertThrows(RuntimeException.class,()->{x.guess('d');});
 }
 @Test
 public void test6(){
     //test set dictionary function & select random word
     String word=null;
     hangman x=new hangman();
     x.setDictionary(x.words);
    word= x.selectRandomSecretWord();
     assertTrue(!word.isEmpty());
 }
}