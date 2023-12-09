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
    int numTrue = 1;

    for(int i = 0; i < flashcards[0].length; i++){

      System.out.println("Card " + (randCard+1) + ": " + flashcards[0][randCard]);
      System.out.println("What is the definition of this card? ");
      answer = keyboard.nextLine();

      if(answer.equals(flashcards[1][randCard])){
        System.out.println("Correct!");
        correct++;
      }
      else{
        System.out.println("Incorrect. The correct answer is " + flashcards[1][randCard]);
      }

      do{
        randCard = (int)(Math.random() * flashcards[0].length);
      } while((check[randCard] == true) && numTrue < flashcards[0].length);
      check[randCard] = true;
      numTrue++;
      
    }
    
    System.out.println("You got " + correct + " cards correct!");
    System.out.print("Study again (Y/N): ");

    if(keyboard.nextLine().toUpperCase().equals("Y")){
      studyCards();
    }
    
  }

  public void addCards(int toAdd){

    String[][] temp = flashcards;
    flashcards = new String[2][temp[0].length + toAdd];
    for(int i = 0; i < temp[0].length; i++){
      flashcards[0][i] = temp[0][i];
      flashcards[1][i] = temp[1][i];
    }
    
    Scanner keyboard = new Scanner(System.in);
    
    for(int i = temp[0].length; i < flashcards[0].length; i++){
      System.out.print("Enter front of card " + (i+1) + ": ");
      flashcards[0][i] = keyboard.nextLine();
      System.out.print("Enter back of card " + (i+1) + ": ");
      flashcards[1][i] = keyboard.nextLine();
    }
  }

  public void removeCards(){

    Scanner keyboard = new Scanner(System.in);
    System.out.print("What card do you want to remove: ");
    int toRemove = keyboard.nextInt();
    keyboard.nextLine();
      String[][] temp = flashcards;
      flashcards = new String[2][temp[0].length - 1];
      for(int i = 0; i < toRemove; i++){
        flashcards[0][i] = temp[0][i];
        flashcards[1][i] = temp[1][i];
      }
      for(int i = toRemove; i < flashcards[0].length; i++){
        flashcards[0][i] = temp[0][i+1];
        flashcards[1][i] = temp[1][i+1];
      }
    
  }

  public void editCards(){

    Scanner keyboard = new Scanner(System.in);
    System.out.println("What card do you want to edit: ");
    int toEdit = keyboard.nextInt();
    keyboard.nextLine();
    System.out.print("Enter new front of card " + toEdit + ": ");
    flashcards[0][toEdit-1] = keyboard.nextLine();
    System.out.print("Enter new back of card " + toEdit + ": ");
    flashcards[1][toEdit-1] = keyboard.nextLine();
    String answer;
    System.out.println("Edit again (Y/N): ");
    answer = keyboard.nextLine();
    if(answer.toUpperCase().equals("Y")){
      editCards();
    }
  }

  public void seeCards(){

      for(int i = 0; i < flashcards[0].length; i++){
        System.out.println("Card " + (i+1) + ": " + flashcards[0][i]);
        System.out.println("Definition: " + flashcards[1][i]);
      }
  }
}