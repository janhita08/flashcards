class Main {
  public static void main(String[] args) {
    Flashcard set = new Flashcard(5);
    set.inputCards();
    set.learnCards();
    set.removeCards();
    set.addCards(2);
    set.editCards();
    set.learnCards();

    
  }
}