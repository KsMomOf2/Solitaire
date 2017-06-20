//package com.example.innisa.solitaireproject;
package com.bishopireton.solitaire;

/**
 * Created by innisa on 4/6/2017, based on class created in
 *                                AP CS A, 2016
 */

public class Card {
  //declare fields rank and suit
  private int rank;
  private String suit;

  //declare constants for the names of non-numerical card ranks
  private static final int ACE=1;
  private static final int JACK = 11;
  private static final int QUEEN = 12;
  private static final int KING = 13;
  private static final String[] strRanks = new String[] {"", "Ace", "Two",
          "Three", "Four", "Five","Six","Seven","Eight","Nine",
          "Ten","Jack","Queen","King","Ace"};


  // declare constants for the names of non-numerical card ranks
  private static final String ACE_STRING = "Ace";
  private static final String JACK_STRING = "Jack";
  private static final String QUEEN_STRING = "Queen";
  private static final String KING_STRING = "King";

  //declare constants for the numerical value of suits
  private static final int CLUB = 0;
  private static final int DIAMOND = 1;
  private static final int HEART = 2;
  private static final int SPADE = 3;

  //decalre constants for the string value of each suit
  private static final String CLUB_STRING= "Clubs";
  private static final String DIAMOND_STRING="Diamonds";
  private static final String HEART_STRING= "Hearts";
  private static final String SPADE_STRING= "Spades";

  // declare constants for suits
  private static final String[] strSuits = new String[] {"",
          CLUB_STRING, DIAMOND_STRING, HEART_STRING, SPADE_STRING};
  //default constructor
  public Card(){
    suit=SPADE_STRING;
    rank=ACE;
  }

  //constructor taking in the rank then suit
  public Card(int r, String s){
    rank=r;
    if (s.substring(s.length()-1).equals("s"))
       suit=s;
    else
        suit = s + "s";
  }

  //constructor taking in suit then rank
  public Card(String s, int r) {
    rank=r;
    if (s.substring(s.length()-1).equals("s"))
      suit=s;
    else
      suit = s + "s";
  }
  //copy constructor
  public Card(Card c) {
    rank=c.getRank();
    suit= c.getSuit();
  }
  //returns the rank field
  public int getRank(){
    return rank;
  }

  //getter- returns the suit field
  public String getSuit(){
    return suit;
  }

  public String getRankAsString() {
    return(strRanks[rank]);
  }
  public static String convertIntSuit(int suitNum) {
    return (strSuits[suitNum]);

  }
    //toString method prints out fields
  public String toString(){
    return getRankAsString() + " of " + suit;
  }
  //returns true if the rank and the suit of the card sent in equals this card's suit and rank
  public boolean is(Card c){
    if((rank == c.getRank()) && (suit.equals(c.getSuit())))
      return true;
    else
      return false;
  }
  //returns true if the rank of the card sent in equals the rank of this card, regardless of the suit
  public boolean equals(Card c){
    if(rank == c.getRank())
      return true;
    else
      return false;
  }
  //returns the difference of this.rank and the rank of the card sent in, regardless of the suit
  public int compareTo(Card c){
    return c.getRank() - rank;
  }
    //TODO THIS METHOD DOES NOT BELONG IN CARD - it is time to remove it.
  //check if can add to a suit stack-- if suit is same--if rank is above
  public boolean canAddSuitStack(Card c){
    if(rank==0)
      return true;
    if(rank == (c.getRank() +1)){
      if(suit.equals(c.getSuit()))
        return true;
    }
    return false;
  }

  //check if one card is a correct soduko match
  public boolean isBelow(Card c){
    /*if(c.getRank()==0)
      return true;
    if(rank== (c.getRank() -1)){
       // return true;
      //check if opposite color
      if(suit.equals(CLUB_STRING) || suit.equals(DIAMOND_STRING)){
        if(c.getSuit().equals(SPADE_STRING) || c.getSuit().equals(HEART_STRING))
          return true;
      }
      if(suit.equals(SPADE_STRING) || suit.equals(HEART_STRING)){
        if(c.getSuit().equals(CLUB_STRING) || c.getSuit().equals(DIAMOND_STRING))
          return true;
      }
     return true;
    }
    return false;*/
    return true;
  }

}
