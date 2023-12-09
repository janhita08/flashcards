import java.util.*;
public class Flashcard{

  private String[][] flashcards;

  public Flashcard(int numCards){
    flashcards = new String[2][numCards];
  }
  
  public void inputCards(){

    Scanner keyboard = new Scanner(System.in);
    for(int i = 0; i < flashcards[0].length; i++){
      System.out.print("Enter front of card " + (i+1) + ": ");
      flashcards[0][i] = keyboard.nextLine();
      System.out.print("Enter back of card " + (i+1) + ": ");
      flashcards[1][i] = keyboard.nextLine();
    }
    
  }

  public void learnCards(){

    Scanner keyboard = new Scanner(System.in);
   
    do{
      for(int i = 0; i < flashcards[0].length; i++){
        System.out.println("\nCard " + (i + 1) + ": " + flashcards[0][i]);
        System.out.print("Flip card (Y): ");
  
        if( keyboard.nextLine().toUpperCase().equals("Y")){
          System.out.println("Card " + (i + 1) + " Answer: " + flashcards[1][i]);
        }

       
       }
       System.out.print("\nLearn again (Y/N): ");
    } while(keyboard.nextLine().toUpperCase().equals("Y"));
    
  }
  public void studyCards(){
    
    Scanner keyboard = new Scanner(System.in);
    String answer;
    boolean[] check = new boolean[flashcards[0].length];

    int correct = 0;
    int randCard = (int)(Math.random() * flashcards[0].length);
    check[randCard] = true;

    for(int i = 0; i < flashcards[0].length; i++){

      System.out.println("Card " + (randCard+1) + ": " + flashcards[0][randCard]);
      System.out.println("What is the definition of this card? ");
      answer = keyboard.nextLine();

      if(answer.equals(flashcards[1][randCard])){
        System.out.println("Correct!");
        correct++;
      }
      else{
        System.out.println("Incorrect. The correct answer is " + flashcards[i][randCard]);
      }

      do{
        randCard = (int)(Math.random() * flashcards[0].length);
      } while((check[randCard] == true));
      check[randCard] = true;
      
    }
    
    System.out.println("You got " + correct + " cards correct!");
    System.out.print("Study again (Y/N): ");

    if(keyboard.nextLine().toUpperCase().equals("Y")){
      studyCards();
    }
      

    
  }
  
  

}