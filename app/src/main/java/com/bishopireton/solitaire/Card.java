//package com.example.innisa.solitaireproject;
package com.bishopireton.solitaire;

import android.widget.ImageButton;

/**
 * Created by innisa on 4/6/2017.
 */

public class Card {
  //declare fields rank and suit
  private int rank;
  private String suit;
  //private ImageButton img; //NEED TO SET IN ON CREATE
  // private String img;
  //use r .
  //wait for images in card class until get images from image editing class
  //for project add image

  //declare constants for the names of non-numerical card ranks
  private final int ACE=1;
  private final int JACK = 11;
  private final int QUEEN = 12;
  private final int KING = 13;

  //declare constants for the numerical value of suits
  private final int CLUB = 0;
  private final int DIAMOND = 1;
  private final int HEART = 2;
  private final int SPADE = 3;

  //decalre constants for the string value of each suit
  private final String CLUB_STRING= "Clubs";
  private final String DIAMOND_STRING="Diamonds";
  private final String HEART_STRING= "Hearts";
  private final String SPADE_STRING= "Spades";

  //default constructor
  public Card(){
    suit=SPADE_STRING;
    rank=ACE;
    //IDKK
    //set image to find view by id?
    // img= (ImageButton)findViewById(R.)
    //do I even have to set the image

  }

  //constructor taking in the rank then suit
  public Card(int r, String s){
    rank=r;
    suit=s;
  }

  //constructor inputting suit then rank
  public Card(String s, int r) {
    rank=r;
    suit=s;
  }

  //copy constructor
  public Card(Card c) {
    rank=c.getRank();
    suit= c.getSuit();
  }

  //getters
  //returns the rank field
  public int getRank(){
    return rank;
  }

  //getter- returns the suit field
  public String getSuit(){
    return suit;
  }

  //toString method prints out fields
  public String toString(){
    switch(rank) {
      case ACE: return("Rank: Ace\t\t" + "Suit: " + suit+ "\n");
      case JACK: return("Rank: Jack\t\t" + "Suit: " + suit+ "\n");
      case QUEEN: return("Rank: Queen\t\t" + "Suit: " + suit+ "\n");
      case KING: return("Rank: King\t\t" + "Suit: " + suit+ "\n");
      default: return("Rank: " + rank+ "\t\t" + "Suit: " + suit+ "\n");
    }
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

  //check if one card is a correct soduko match
  public boolean isBellow(Card c){
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

  //check if can add to a suit stack-- if suit is same--if rank is above
  public boolean canAddSuitStack(Card c){
    /*if(rank==0)
      return true;
    if(rank== (c.getRank() +1)){
      if(suit.equals(c.getSuit()))
        return true;
    }

    return false;*/
    return true;
  }
}
