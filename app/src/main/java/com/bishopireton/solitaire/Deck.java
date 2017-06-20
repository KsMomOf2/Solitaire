package com.bishopireton.solitaire;
//package com.example.innisa.solitaireproject;

        import java.util.ArrayList;
/**
 * Created by innisa on 4/6/2017.
 */

public class Deck extends Card{
  public static final int SIZE_RANK= 13;
  public static final int NUM_SUITS= 4;
  public static final int CLUBS_INT= 0;
  public static final int DIAMONDS_INT=1;
  public static final int HEARTS_INT=2;
  public static final int SPADES_INT=3;
  public static final int S_DECK=52;

  private ArrayList<Card> deck;

  //constructor
  public Deck(){
    resetDeck();
  }

  //copy constructor
  // TODO this does not copy the other deck - needs to actually instantiate a new set of cards
  public Deck(Deck other) {
    this.deck=other.deck;
  }

  //create empty deck
  public void emptyDeck (){
    deck= new ArrayList<Card>();
  }

  //shuffle the deck
  // TODO this puts the initial card back into place??
  public void shuffleDeck(){
    //Collections.shuffle(deck);
    Card temp;
    for(int x = 1; x<=1000; x++)
    {
      int rand1 = (int)(Math.random() * deck.size());
      int rand2 = (int)(Math.random() * deck.size());
      temp = deck.get(rand1);
      deck.set(rand1, deck.get(rand2));
      deck.set(rand1, temp);
    }
  }

  //fill deck in order
  public ArrayList resetDeck() {
    emptyDeck();
    for(int s=0; s<NUM_SUITS; s++) {
      for(int r=1; r<=SIZE_RANK; r++) {
        String suit= Card.convertIntSuit(s);
        Card c1= new Card(r, suit);
        deck.add(c1);
      }
    }
    return(deck);
  }
  //return size of deck
  public int size(){
    return(deck.size());
  }

  //return a string of every card in position
  public String toString(){
    String deckString = "";
    for(int i = 0; i < size(); i++){
      deckString += deck.get(i);
    }
    return deckString;
  }
  //generates a random number and uses removeCard to return and remove that random card from the deck
  public Card pickACard(){
    int i= (int)(Math.random()*S_DECK);
    return(deck.remove(i));
  }
  // TODO replace this with the arrayList index of method
  //Mrs.Kelly on the worksheet you said to use a for loop but I think it could be easier/shorter to use the ArrayList.indexOf method

  //takes a card as a parameter, using a for loop, finds the card, and returns the position in the ArrayLIst
  //if the card is not found, the method should return -1
  public int findCard(Card c){
    for(int i=0; i<deck.size();i++) {
      if (deck.get(i).is(c))
        return i;
    }
    return -1;
  }
  //takes a card as a parameter, calls find Card to find the position, then removes and returns the card
  //if the position of the Card is -1--return null
  public Card removeCard(Card c) {
    int pos= findCard(c);
    if (pos<deck.size()-1 && pos>0){
      return deck.remove(pos);
    }
    else
      return null;
  }

  public void addCard(Card c){
    deck.add(c);
  }

  public Card getCard(int i){
    return deck.get(i);
  }
}
