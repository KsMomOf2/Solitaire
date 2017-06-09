package com.bishopireton.solitaire;
//package com.example.innisa.solitaireproject;


        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import java.util.ArrayList;

public class scrnGame extends AppCompatActivity {
  private Deck d1;
  private Deck d2;
  private ImageButton imgCardPlay;
  private ImageButton imgCard1;
  private ImageButton imgCard2;
  private ImageButton imgCard3;
  private ImageButton imgCard4;
  private ImageButton imgCard5;
  private ImageButton imgCard6;
  private ImageButton imgCard7;
  private ImageButton imgDeckDiamond;
  private ImageButton imgDeckSpade;
  private ImageButton imgDeckClub;
  private ImageButton imgDeckHeart;
  private ImageButton imgDeck;

  private ImageView rRidge1;
  private ImageView rRidge2;
  private ImageView rRidge3;
  private ImageView rRidge4;
  private ImageView rRidge5;
  private ImageView rRidge6;
  private ImageView rRidge7;

  private ImageView wRidge1;
  private ImageView wRidge2;
  private ImageView wRidge3;
  private ImageView wRidge4;
  private ImageView wRidge5;
  private ImageView wRidge6;
  private ImageView wRidge7;

  private Button btnRestart;

  private boolean isPlayClick;
  private boolean isDeckClick;

  private Card pick;
  private Card c1;
  private Card c2;
  private Card c3;
  private Card c4;
  private Card c5;
  private Card c6;
  private Card c7;
  private Card deckClick;
  private Card cDiamond;
  private Card cClub;
  private Card cHeart;
  private Card cSpade;

  private int intClick;
  ///ps when set oe object to another they point to the same card--so like be careful of that Alice

  //store the number or red ridges for eah pile
  // private int rRidgeCount1;
  private int rRidgeCount2;
  private int rRidgeCount3;
  private int rRidgeCount4;
  private int rRidgeCount5;
  private int rRidgeCount6;
  private int rRidgeCount7;

  //store the number of white ridges for each pile
  private int wRidgeCount1;
  private int wRidgeCount2;
  private int wRidgeCount3;
  private int wRidgeCount4;
  private int wRidgeCount5;
  private int wRidgeCount6;
  private int wRidgeCount7;

  private ArrayList<Card> p1;
  private ArrayList<Card> p2;
  private ArrayList<Card> p3;
  private ArrayList<Card> p4;
  private ArrayList<Card> p5;
  private ArrayList<Card> p6;
  private ArrayList<Card> p7;
  private ArrayList<Card> pMove;
  private ArrayList<Card> pDiamond;
  private ArrayList<Card> pHeart;
  private ArrayList<Card> pSpade;
  private ArrayList<Card> pClub;

  private int deckNum=0; //stores number of deck if isDeckClicked is false




  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrn_game);
    //do original initializations

    //create a deck
    d1= new Deck();
    d2= new Deck();
    d2.emptyDeck();

    imgCardPlay= (ImageButton) findViewById(R.id.imgCardPlay);
    imgCard1= (ImageButton) findViewById(R.id.imgCard1);
    imgCard2= (ImageButton) findViewById(R.id.imgCard2);
    imgCard3= (ImageButton) findViewById(R.id.imgCard3);
    imgCard4= (ImageButton) findViewById(R.id.imgCard4);
    imgCard5= (ImageButton) findViewById(R.id.imgCard5);
    imgCard6= (ImageButton) findViewById(R.id.imgCard6);
    imgCard7= (ImageButton) findViewById(R.id.imgCard7);

    imgDeckDiamond= (ImageButton) findViewById(R.id.imgDeckDiamond) ;
    imgDeckClub=(ImageButton)findViewById(R.id.imgDeckClub);
    imgDeckSpade=(ImageButton)findViewById(R.id.imgDeckSpade);
    imgDeckHeart=(ImageButton)findViewById(R.id.imgDeckHeart);
    imgDeck=(ImageButton)findViewById(R.id.imgDeck);

    rRidge1=(ImageView)findViewById(R.id.imgRRidge1);
    rRidge2= (ImageView)findViewById(R.id.imgRRidge2);
    rRidge3=(ImageView)findViewById(R.id.imgRRidge3);
    rRidge4=(ImageView)findViewById(R.id.imgRRidge4);
    rRidge5=(ImageView)findViewById(R.id.imgRRidge5);
    rRidge6=(ImageView)findViewById(R.id.imgRRidge6);
    rRidge7=(ImageView)findViewById(R.id.imgRRidge7);

    wRidge1=(ImageView)findViewById(R.id.imgWRidge1);
    wRidge2=(ImageView)findViewById(R.id.imgWRidge2);
    wRidge3=(ImageView)findViewById(R.id.imgWRidge3);
    wRidge4=(ImageView)findViewById(R.id.imgWRidge4);
    wRidge5=(ImageView)findViewById(R.id.imgWRidge5);
    wRidge6=(ImageView)findViewById(R.id.imgWRidge6);
    wRidge7=(ImageView)findViewById(R.id.imgWRidge7);

    btnRestart=(Button)findViewById(R.id.btnRestart);

    //PUT STUFF ON THE LAYOUT
    reset();

    //when imgCardPlay is clicked change a variable to see if anything else is changed
    //maybe if time when clicked take the borders off the image--extension
   imgCardPlay.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        //isPlayClick= true; //reminder when anything else is clicked change this
        if (isPlayClick == true)
          isPlayClick = false;
        else
          isPlayClick = true;
        isDeckClick=false;
      }
    });

    //resets the game when this button is clicked
   btnRestart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //restartGame();//TODO fix this
      }
    });

    //set the onclickListeners for the deck
    imgDeck.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        regulateDeck();
        isPlayClick=false;
      }
    });

    //onclick listeners for each piles
    pileOnClickListener(imgCard1);
    pileOnClickListener(imgCard2);
    pileOnClickListener(imgCard3);
    pileOnClickListener(imgCard4);
    pileOnClickListener(imgCard5);
    pileOnClickListener(imgCard6);
    pileOnClickListener(imgCard7);

    //set onclick listeners for each suit pile
    suitOnClickListener(imgDeckClub);
    suitOnClickListener(imgDeckDiamond);
    suitOnClickListener(imgDeckHeart);
    suitOnClickListener(imgDeckSpade);

  }

  //set the onclick listeners for the piles
  public void pileOnClickListener(ImageButton b){
    b.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        imgDeckOnClickListener((ImageButton)findViewById(v.getId()));

        //caste as button etc//v.getId and save it somewhere as the button
        deckMoveOnClickListener((ImageButton)findViewById(v.getId()));
      }
    });
  }

  //set the onClickListeners for the suit cards
  public void suitOnClickListener(ImageButton b){
    b.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {//TODO come back to this once finish deck OnClickListener
        moveToSuitOnClick((ImageButton)findViewById(v.getId()));//caste as button etc//v.getId and save it somewhere as the button
      }
    });
  }
  //method to check if a deck is already clicked//called when a deck is clicked and moves one deck to another
  public void deckMoveOnClickListener(ImageButton b){

    //if a deck is clicked first, store its information
    if(isDeckClick!=true) {
      isDeckClick = true;
      deckClick=btnToCard(b);
      pMove=btnToPile(b);
      intClick=btnToInt(b);
    }

    //if its the second deck clicked-- move the first deck to the second
   else {
      isDeckClick = false;

      if(deckClick!=null && pMove.size()!=0){
        Card cCheck= pMove.get(0); //get card at the bottom of the pile

        //everything to move one pile to the other
        if(cCheck.isBellow(pick)){
          int intMoveTo= btnToInt(b);
          if(intMoveTo!=intClick) {
            //add to the correct piles the cards from the second pile(intClick)
            if (intMoveTo == 1) {
              //TODO  check pMove
              p1 = combinePiles(p1, pMove);
              wRidgeCount1 = p1.size() - 1;
              setWRidgeImage(wRidgeCount1, wRidge1);
            } else if (intMoveTo == 2) {
              p2 = combinePiles(p2, pMove);
              wRidgeCount2 = p2.size() - 1;
              setWRidgeImage(wRidgeCount2, wRidge2);
            } else if (intMoveTo == 3) {
              p3 = combinePiles(p3, pMove);
              wRidgeCount3 = p3.size() - 1;
              setWRidgeImage(wRidgeCount3, wRidge3);
            } else if (intMoveTo == 4) {
              p4 = combinePiles(p4, pMove);
              wRidgeCount4 = p4.size() - 1;
              setWRidgeImage(wRidgeCount4, wRidge4);
            } else if (intMoveTo == 5) {
              p5 = combinePiles(p5, pMove);
              wRidgeCount5 = p5.size() - 1;
              setWRidgeImage(wRidgeCount5, wRidge5);
            } else if (intMoveTo == 6) {
              p6 = combinePiles(p6, pMove);
              wRidgeCount6 = p6.size() - 1;
              setWRidgeImage(wRidgeCount6, wRidge6);
            } else if (intMoveTo == 7) {
              p7 = combinePiles(p7, pMove);
              wRidgeCount7 = p7.size() - 1;
              setWRidgeImage(wRidgeCount7, wRidge7);
            }/*

            //set first click pile to a drawn card
            if (intClick == 1) {
              p1 = new ArrayList<>();
              //p1.add(createCard(imgCard1)); ADD NEW CARD LATER BC MIGHT LEAVE SLOT EMPTY-IF RED CARD FLIP IF NO RED CARD LEAVE BLANK

            }//todo check AND UNCOMMENT BUT NEED TO THINK THROUGH FIRST
            */
            if (intClick == 2) {//todo make else if
              p2 = new ArrayList<>();
              if (rRidgeCount2 > 0) {
                p2.add(createCard(imgCard2));
                rRidgeCount2 -= 1;
              } else {
                c2 = new Card("", 0);
                imgCard2.setImageDrawable(null);
              }
            }
            else if (intClick == 3) {
              p3 = new ArrayList<>();
              if (rRidgeCount3 > 0) {
                p3.add(createCard(imgCard3));
                rRidgeCount3 -= 1;
              } else {
                c3 = new Card("", 0);
                imgCard3.setImageDrawable(null);
              }
            } else if (intClick == 4) {
              p4 = new ArrayList<>();
              if (rRidgeCount4 > 0) {
                p4.add(createCard(imgCard4));
                rRidgeCount4 -= 1;
              } else {
                c4 = new Card("", 0);
                imgCard4.setImageDrawable(null);
              }
            } else if (intClick == 5) {
              p5 = new ArrayList<>();
              if (rRidgeCount5 > 0) {
                p5.add(createCard(imgCard5));
                rRidgeCount5 -= 1;
              } else {
                c5 = new Card("", 0);
                imgCard5.setImageDrawable(null);
              }
            } else if (intClick == 6) {
              p6 = new ArrayList<>();
              if (rRidgeCount6 > 0) {
                p6.add(createCard(imgCard6));
                rRidgeCount6 -= 1;
              } else {
                c6 = new Card("", 0);
                imgCard6.setImageDrawable(null);
              }
            } else if (intClick == 7) {
              p7 = new ArrayList<>();
              if (rRidgeCount7 > 0) {
                p7.add(createCard(imgCard7));
                rRidgeCount7 -= 1;
              } else {
                c7 = new Card("", 0);
                imgCard7.setImageDrawable(null);
              }
            }
            //set the redRidges
            setRRidgeImage(rRidgeCount2, rRidge2);
            setRRidgeImage(rRidgeCount3, rRidge3);
            setRRidgeImage(rRidgeCount4, rRidge4);
            setRRidgeImage(rRidgeCount5, rRidge5);
            setRRidgeImage(rRidgeCount6, rRidge6);
            setRRidgeImage(rRidgeCount7, rRidge7);

          }
        }
      }
    }
  }

  //move cards from play to other piles
  public void imgDeckOnClickListener(ImageButton b){
    Card corrWithImg;
    corrWithImg=btnToCard(b);


    //check to see if the card works
    if(pick.isBellow(corrWithImg)&& isPlayClick) {
      //if statement to see what card to change
      //change b to p's image
      if (b.equals(imgCard1)) {
        p1.add(pick);//todo check
        c1 = pick;
        setCardImage(imgCard1, c1);
      } else if (b.equals(imgCard2)) {
        p2.add(pick);
        c2 = pick;
        setCardImage(imgCard2, c2);
      } else if (b.equals(imgCard3)) {
        p3.add(pick);
        c3 = pick;
        setCardImage(imgCard3, c3);
      } else if (b.equals(imgCard4)) {
        p4.add(pick);
        c4 = pick;
        setCardImage(imgCard4, c4);
      } else if (b.equals(imgCard5)) {
        p5.add(pick);
        c5 = pick;
        setCardImage(imgCard5, c5);
      } else if (b.equals(imgCard6)) {
        p5.add(pick);
        c6 = pick;
        setCardImage(imgCard6, c6);
      } else {
        p6.add(pick);
        c7 = pick;
        setCardImage(imgCard7, c7);
      }

      //when move card pick- show the last card pick, if there even is one
      if(d2.size()>0) {
        pick = d2.getCard(d2.size() - 1);
        setCardImage(imgCardPlay, pick);
      }
      else
        pick= createCard(imgCardPlay);
      isPlayClick=false;

      //modify the white ridges
      if(b.equals(imgCard1)){
        wRidgeCount1+=1;
        setWRidgeImage(wRidgeCount1, wRidge1);
      }
      else if(b.equals(imgCard2)){
        wRidgeCount2+=1;
        setWRidgeImage(wRidgeCount2, wRidge2);
      }
      else if(b.equals(imgCard3)){
        wRidgeCount3+=1;
        setWRidgeImage(wRidgeCount3,wRidge3);
      }
      else if(b.equals(imgCard4)) {
        wRidgeCount4 += 1;
        setWRidgeImage(wRidgeCount4, wRidge4);
      }
      else if(b.equals(imgCard5)) {
        wRidgeCount5 += 1;
        setWRidgeImage(wRidgeCount5, wRidge5);
      }
      else if(b.equals(imgCard6)) {
        wRidgeCount6 += 1;
        setWRidgeImage(wRidgeCount6, wRidge6);
      }
      else {
        wRidgeCount7 += 1;
        setWRidgeImage(wRidgeCount6,wRidge6);
      }

    }



  }
  //when the deck is clicked change image play and add the old image play to bottonis method
  //call everytime deck is clicked //when move imageplay dont get new card set play to the end of d2
  //everytime deck is clicked call this method
  public void regulateDeck(){
    d2.addCard(pick);
    createCard(imgCardPlay);//TODO like it works, but not more than 10 times
  }

  //reset the app/ run at beginning too
  public void reset(){
    //shuffle the deck
    d1=new Deck();
    d1.shuffleDeck();

    //pick random cards for all the cards displayed at the beginning, also changes the images
    pick= createCard(imgCardPlay);
    c1= createCard(imgCard1);
    c2= createCard(imgCard2);
    c3= createCard(imgCard3);
    c4= createCard(imgCard4);
    c5= createCard(imgCard5);
    c6= createCard(imgCard6);
    c7= createCard(imgCard7);
    cDiamond=new Card(0, "Diamonds");
    cClub=new Card(0, "Clubs");
    cHeart=new Card(0,"Hearts");
    cSpade=new Card(0, "Spades");

    //set initial values
    isPlayClick=false;
    isDeckClick=false;
    deckClick=null;
    intClick=0;


    rRidgeCount2=1;
    rRidgeCount3=2;
    rRidgeCount4=3;
    rRidgeCount5=4;
    rRidgeCount6=5;
    rRidgeCount7=6;

    wRidgeCount1=0;
    wRidgeCount2=0;
    wRidgeCount3=0;
    wRidgeCount4=0;
    wRidgeCount5=0;
    wRidgeCount6=0;
    wRidgeCount7=0;

    //reset all ridge images
    setRRidgeImage(rRidgeCount2, rRidge2);
    setRRidgeImage(rRidgeCount3, rRidge3);
    setRRidgeImage(rRidgeCount4, rRidge4);
    setRRidgeImage(rRidgeCount5, rRidge5);
    setRRidgeImage(rRidgeCount6, rRidge6);
    setRRidgeImage(rRidgeCount7, rRidge7);

    setWRidgeImage(wRidgeCount1, wRidge1);
    setWRidgeImage(wRidgeCount2, wRidge2);
    setWRidgeImage(wRidgeCount3, wRidge3);
    setWRidgeImage(wRidgeCount4, wRidge4);
    setWRidgeImage(wRidgeCount5, wRidge5);
    setWRidgeImage(wRidgeCount6, wRidge6);
    setWRidgeImage(wRidgeCount7, wRidge7);

    //create arraylists to store each pile of cards and add the first card to them
    p1=new ArrayList<>();
    p1.add(c1);
    p2=new ArrayList<>();
    p2.add(c2);
    p3=new ArrayList<>();
    p3.add(c3);
    p4=new ArrayList<>();
    p4.add(c4);
    p5=new ArrayList<>();
    p5.add(c5);
    p6=new ArrayList<>();
    p6.add(c6);
    p7=new ArrayList<>();
    p7.add(c7);
    pMove = new ArrayList<>();
    pDiamond= new ArrayList<>();
    pClub= new ArrayList<>();
    pHeart= new ArrayList<>();
    pSpade= new ArrayList<>();

    //set the initial images of the suit piles
    imgDeckClub.setImageResource(R.drawable.blankclubs);
    imgDeckDiamond.setImageResource(R.drawable.blankdiamonds);
    imgDeckHeart.setImageResource(R.drawable.blankhearts);
    imgDeckSpade.setImageResource(R.drawable.blankspades);

  }


  //create a card- pick it randomly from the deck and remove it
  public Card createCard(ImageButton img){
    if(d1.size()==0) {
      d1 = d2;
      d2.emptyDeck();
    }
    Card c = d1.pickACard();
    //c = d1.removeCard(c);
    setCardImage(img, c);
    return c;

  }


  //send in an image button and returns a card
  public Card btnToCard(ImageButton b){
    if(b.equals(imgCard1)) //==
      return c1;
    else if (b.equals(imgCard2))
      return c2;
    else if(b.equals(imgCard3))
      return c3;
    else if(b.equals(imgCard4))
      return c4;
    else if(b.equals(imgCard5))
      return c5;
    else if(b.equals(imgCard6))
      return c6;
    else if(b.equals(imgCard7))
      return c7;
    else
      return null;
  }
  //send in an image button and returns the corresponding pile/arraylist
  public ArrayList<Card> btnToPile(ImageButton b){
    if(b.equals(imgCard1))
      return p1;
    else if(b.equals(imgCard2))
      return p2;
    else if(b.equals(imgCard3))
      return p3;
    else if(b.equals(imgCard4))
      return p4;
    else if(b.equals(imgCard5))
      return p5;
    else if(b.equals(imgCard6))
      return p6;
    else if(b.equals(imgCard7))
      return p7;
    else
      return null;

  }

  //return a number that corresponds with the sent in button
  public int btnToInt(ImageButton b){
    if(b.equals(imgCard1))
      return 1;
    else if(b.equals(imgCard2))
      return 2;
    else if(b.equals(imgCard3))
      return 3;
    else if(b.equals(imgCard4))
      return 4;
    else if(b.equals(imgCard5))
      return 5;
    else if(b.equals(imgCard6))
      return 6;
    else if(b.equals(imgCard7))
      return 7;
    else
      return 0;
  }

  //combines two piles and returns the new pile
  public ArrayList<Card> combinePiles(ArrayList<Card> a, ArrayList<Card> b){
    for(int i=0;i<b.size();i++){
      a.add(b.get(i));
    }
    return a;
  }

//suit on click listener
  //moves all different sorts of objects into the suit piles
  public void moveToSuitOnClick(ImageButton b){

    //when click on pick then a suit card
    Card suitCard;
    //suitCard=btnToCard(b);//make sure not null//TODO un comment!!!!!!!!!!!!!!!!!
    suitCard=new Card(7,"Spades");

    //do move deck to suit after first do pile

    //moving card pick to a suit stack
    if(pick.canAddSuitStack(suitCard)&& isPlayClick && suitCard!=null){
      //figure out what suit pile using --from imagebutton
      // in this part  add card to suitpile, draw a new card, set the suit card to pick, change images
      if(b.equals(imgDeckClub)) {
        pClub.add(pick);
        cClub=pick;
        setCardImage(imgDeckClub,pick);
      }
      else if(b.equals(imgDeckDiamond)){
        pDiamond.add(pick);
        cDiamond=pick;
        setCardImage(imgDeckDiamond,pick);
      }
      else if(b.equals(imgDeckHeart)){
        pHeart.add(pick);
        cHeart=pick;
        setCardImage(imgDeckHeart,pick);
      }
      else if(b.equals(imgDeckSpade)) {
        pSpade.add(pick);
        cSpade=pick;
        setCardImage(imgDeckSpade,pick);
      }
      //createCard(imgCardPlay);
      if(d2.size()>0) {
        pick = d2.getCard(d2.size() - 1);
        setCardImage(imgCardPlay, pick);
      }
      else
        pick= createCard(imgCardPlay);
    }

    //for if trying to move an ace to a suit pile
    else if(isPlayClick&&suitCard.getRank()==0&&pick.getRank()==1){
      if(b.equals(imgDeckClub)){
        pClub.add(pick);
        cClub=pick;
        setCardImage(imgDeckClub,pick);
      }
      else if(b.equals(imgDeckDiamond)){
        pDiamond.add(pick);
        cDiamond=pick;
        setCardImage(imgDeckDiamond,pick);
      }
      else if(b.equals(imgDeckHeart)){
        pHeart.add(pick);
        cHeart= pick;
        setCardImage(imgDeckHeart,pick);
      }
      else if(b.equals(imgDeckSpade)){
        pSpade.add(pick);
        cSpade=pick;
        setCardImage(imgDeckHeart,pick);
      }
      if(d2.size()>0) {
        pick = d2.getCard(d2.size() - 1);
        setCardImage(imgCardPlay, pick);
      }
      else
        pick= createCard(imgCardPlay);

    }
    //for moving a deck to a suit pile
    //todo make sure I change is deckClick
     if(isDeckClick&&deckClick.canAddSuitStack(suitCard)&&suitCard!=null&&deckClick!=null){
      if(b.equals(imgDeckClub)) {
        pClub.add(deckClick);
        cClub=deckClick;
        setCardImage(imgDeckClub, deckClick);
      }
      else if(b.equals(imgDeckDiamond)){
        pDiamond.add(deckClick);
        cDiamond=deckClick;
        setCardImage(imgDeckDiamond,deckClick);
      }
      else if(b.equals(imgDeckHeart)){
        pHeart.add(deckClick);
        cHeart=deckClick;
        setCardImage(imgDeckHeart,deckClick);
      }
      else if(b.equals(imgDeckSpade)) {
        pSpade.add(deckClick);
        cSpade=deckClick;
        setCardImage(imgDeckSpade,deckClick);
      }

      //change the image of the pile
      //todo make sure change images here
       //todo so it moves 8 to a suit pile but also leaves 8
      if(intClick==1) {
        if(wRidgeCount1>0) {
          c1= p1.get(1);
          setCardImage(imgCard1,c1);
          //c1 = createCard(imgCard1);//todo check
          wRidgeCount1-=1;
          setWRidgeImage(wRidgeCount1,wRidge1);
          }
        else
          c1=new Card("",0);
          imgCard1.setImageDrawable(null);//todo when change image do i have to make this not null

      }
      else if(intClick==2) {
        if(p2.size()==1&&rRidgeCount2>=1){//if need to flip over a red card
          //take a card from red
          rRidgeCount2-=1;
          setRRidgeImage(rRidgeCount2, rRidge2);
          c2= createCard(imgCard2);
          //p2.remove(0); TODO check if need add this
        }
        else if(checkIfBlank(wRidgeCount2,rRidgeCount2)) {//if no ridges at all make blank
          c2=new Card("",0);
          imgCard2.setImageDrawable(null);
        }//make blank
        else if(p2.size()>1){//need to take from white ridges
          //c2 = p2.get(p2.size()-2);
          //remove one card from pile
          //remove one from white ridges
         // p2.remove(p2.size()-1);
          p2.remove(0);
          //c2=p2.get(0);//TODO why isnt this working
          wRidgeCount2-=1;
          setWRidgeImage(wRidgeCount2, wRidge2);
          setCardImage(imgCard2, c2);
        }
//TODO mehhhhhh do this laterrrrrrrrrrrrrr
      }
      else if(intClick==3){
        if(p3.size()==1 &&rRidgeCount3>=1){
          rRidgeCount3-=1;
          c3=createCard(imgCard3);
          setRRidgeImage(rRidgeCount3, rRidge3);
        }
        else if(p3.size()==1){
          c3=new Card("",0);
          imgCard3.setImageDrawable(null);
        }
        else if(p3.size()>1){
          c3= p3.get(p3.size()-2);
          p3.remove(p3.size()-1);
          wRidgeCount3-=1;
          setWRidgeImage(wRidgeCount3, wRidge3);
          setCardImage(imgCard3, c3);
        }
      }

      else if(intClick==4){
        if(p4.size()==1 && rRidgeCount4>=1){
          rRidgeCount4-=1;
          c4= createCard(imgCard4);
          setRRidgeImage(rRidgeCount4, rRidge4);
        }
        else if(p4.size()==1){
          c4=new Card("",0);
          imgCard4.setImageDrawable(null);
        }
        else if(p4.size()>1){
          c4=p4.get(p4.size()-2);
          p4.remove(p4.size()-1);
          wRidgeCount4-=1;
          setWRidgeImage(wRidgeCount4, wRidge4);
          setCardImage(imgCard4, c4);
        }
      }

      else if(intClick==5){
        if(p5.size()==1&&rRidgeCount5>=1){
          rRidgeCount5-=1;
          c5=createCard(imgCard5);
          setRRidgeImage(rRidgeCount5,rRidge5);
        }
        else if(p5.size()==1){
          c5=new Card("",0);
          imgCard5.setImageDrawable(null);
        }
        else if(p5.size()>1){
          c5= p5.get(p5.size()-2);
          p5.remove(p5.size()-1);
          wRidgeCount5-=1;
          setWRidgeImage(wRidgeCount5, wRidge5);
          setCardImage(imgCard5, c5);
        }
      }
      else if(intClick==6){
        if(p6.size()==1&&rRidgeCount6>=1){
          rRidgeCount6-=1;
          c6=createCard(imgCard6);
          setRRidgeImage(rRidgeCount6,rRidge6);
        }
        else if(p6.size()==1){
          c6=new Card("",0);
          imgCard6.setImageDrawable(null);
        }
        else if(p6.size()>1){
          c6= p6.get(p6.size()-2);
          p6.remove(p6.size()-1);
          wRidgeCount6-=1;
          setWRidgeImage(wRidgeCount6, wRidge6);
          setCardImage(imgCard6, c6);
        }
      }
      // c6=createCard(imgCard6);
      else if(intClick==7) {
        if(p7.size()==1 &&rRidgeCount7>=1){
          rRidgeCount7-=1;
          c7=createCard(imgCard7);
          setRRidgeImage(rRidgeCount7,rRidge7);
        }
        else if(p7.size()==1){
          c7=new Card("",0);
          imgCard7.setImageDrawable(null);
        }
        else if(p7.size()>1){
          c7=p7.get(p7.size()-2);
          p7.remove(p7.size()-1);
          wRidgeCount7-=1;
          setWRidgeImage(wRidgeCount7,wRidge7);
          setCardImage(imgCard7, c7);
        }
      }
    }

  }

  //method that takes in an imagebutton and a card and sets the iamge of the image button bassed on that
  public void setCardImage(ImageButton b, Card c){
    int rankCheck= c.getRank();
    if(c.getSuit().equals("Diamonds")){

      switch(rankCheck){
        case 0: b.setImageResource(R.drawable.blankcard);
          break;
        case 1: b.setImageResource(R.drawable.diamondsace);
          break;
        case 2: b.setImageResource(R.drawable.diamonds2);
          break;
        case 3: b.setImageResource(R.drawable.diamonds3);
          break;
        case 4: b.setImageResource(R.drawable.diamonds4);
          break;
        case 5: b.setImageResource(R.drawable.diamonds5);
          break;
        case 6: b.setImageResource(R.drawable.diamonds6);
          break;
        case 7: b.setImageResource(R.drawable.diamonds7);
          break;
        case 8: b.setImageResource(R.drawable.diamonds8);
          break;
        case 9: b.setImageResource(R.drawable.diamonds9);
          break;
        case 10: b.setImageResource(R.drawable.diamonds10);
          break;
        case 11: b.setImageResource(R.drawable.diamondsjack);
          break;
        case 12: b.setImageResource(R.drawable.diamondsqueen);
          break;
        case 13: b.setImageResource(R.drawable.diamondsking);
          break;
        default:b.setImageResource(R.drawable.fillercard);
      }
    }
    else if(c.getSuit().equals("Clubs")){
      switch (rankCheck){
        case 1: b.setImageResource(R.drawable.clubsace);
          break;
        case 2: b.setImageResource(R.drawable.clubs2);
          break;
        case 3: b.setImageResource(R.drawable.clubs3);
          break;
        case 4: b.setImageResource(R.drawable.clubs4);
          break;
        case 5: b.setImageResource(R.drawable.clubs5);
          break;
        case 6: b.setImageResource(R.drawable.clubs6);
          break;
        case 7: b.setImageResource(R.drawable.clubs7);
          break;
        case 8: b.setImageResource(R.drawable.clubs8);
          break;
        case 9: b.setImageResource(R.drawable.clubs9);
          break;
        case 10: b.setImageResource(R.drawable.clubs10);
          break;
        case 11: b.setImageResource(R.drawable.clubsjack);
          break;
        case 12: b.setImageResource(R.drawable.clubsqueen);
          break;
        case 13: b.setImageResource(R.drawable.clubsking);
          break;
        default:b.setImageResource(R.drawable.fillercard);
      }
    }
    else if(c.getSuit().equals("Spades")){
      switch (rankCheck){
        case 1: b.setImageResource(R.drawable.spadesace);
          break;
        case 2: b.setImageResource(R.drawable.spades2);
          break;
        case 3: b.setImageResource(R.drawable.spades3);
          break;
        case 4: b.setImageResource(R.drawable.spades4);
          break;
        case 5: b.setImageResource(R.drawable.spades5);
          break;
        case 6: b.setImageResource(R.drawable.spades6);
          break;
        case 7: b.setImageResource(R.drawable.spades7);
          break;
        case 8: b.setImageResource(R.drawable.spades8);
          break;
        case 9: b.setImageResource(R.drawable.spades9);
          break;
        case 10: b.setImageResource(R.drawable.spades10);
          break;
        case 11: b.setImageResource(R.drawable.spadesjack);
          break;
        case 12: b.setImageResource(R.drawable.spadesqueen);
          break;
        case 13: b.setImageResource(R.drawable.spadeskings);
          break;
          default:b.setImageResource(R.drawable.fillercard);

      }
    }
    else if(c.getSuit().equals("Hearts")){
      switch (rankCheck){
        case 1: b.setImageResource(R.drawable.heartsace);
          break;
        case 2: b.setImageResource(R.drawable.hearts2);
          break;
        case 3: b.setImageResource(R.drawable.hearts3);
          break;
        case 4: b.setImageResource(R.drawable.hearts4);
          break;
        case 5: b.setImageResource(R.drawable.hearts5);
          break;
        case 6: b.setImageResource(R.drawable.hearts6);
          break;
        case 7: b.setImageResource(R.drawable.hearts7);
          break;
        case 8: b.setImageResource(R.drawable.hearts8);
          break;
        case 9: b.setImageResource(R.drawable.hearts9);
          break;
        case 10: b.setImageResource(R.drawable.hearts10);
          break;
        case 11: b.setImageResource(R.drawable.heartsjack);
          break;
        case 12: b.setImageResource(R.drawable.heartsqueen);
          break;
        case 13: b.setImageResource(R.drawable.heartsking);
          break;
        default:b.setImageResource(R.drawable.fillercard);
      }
    }
  }

  //change the white ridges images
  public void setWRidgeImage(int i, ImageView btn){
    switch(i){
      case 0:btn.setImageDrawable(null);
        break;
      case 1: btn.setImageResource(R.drawable.whiteridge1);
        break;
      case 2: btn.setImageResource(R.drawable.whiteridge2);
        break;
      case 3: btn.setImageResource(R.drawable.whiteridge3);
        break;
      case 4: btn.setImageResource(R.drawable.whiteridge4);
        break;
      case 5: btn.setImageResource(R.drawable.whiteridge5);
        break;
      case 6: btn.setImageResource(R.drawable.whiteridge6);
        break;
      case 7: btn.setImageResource(R.drawable.whiteridge7);
        break;
      case 8: btn.setImageResource(R.drawable.whiteridge8);
        break;
      case 9: btn.setImageResource(R.drawable.whiteridge9);
        break;
      case 10: btn.setImageResource(R.drawable.whiteridge10);
        break;
      case 11: btn.setImageResource(R.drawable.whiteridge11);
        break;
      case 12: btn.setImageResource(R.drawable.whiteridge12);
        break;
      case 13: btn.setImageResource(R.drawable.whiteridge13);
        break;
      default: btn.setImageDrawable(null);
    }
  }

  //change the red ridge images
  public void setRRidgeImage(int i, ImageView btn){// check to make sure ridges are image buttons
    switch (i){
      case 0: btn.setImageDrawable(null);
        break;
      case 1: btn.setImageResource(R.drawable.redridge1);
        break;
      case 2: btn.setImageResource(R.drawable.redridge2);
        break;
      case 3: btn.setImageResource(R.drawable.redridge3);
        break;
      case 4: btn.setImageResource(R.drawable.redridge4);
        break;
      case 5: btn.setImageResource(R.drawable.redridge5);
        break;
      case 6: btn.setImageResource(R.drawable.redridge6);
        break;
      default:btn.setImageDrawable(null);
    }
  }


  //if the user has a king in each suit pile they win---if they win set something to win //todo call this method
  public void checkIfWin(){
    if(cDiamond.getRank()==13 && cClub.getRank()==13 && cHeart.getRank()==13 && cSpade.getRank()==13){
      btnRestart.setText("WINNER! TO RESTART CLICK HERE");
    }
  }

//check if a card would be blank
  public boolean checkIfBlank(int wCount, int rCount){
    if(wCount==0 &&rCount==0)
      return true;
    else
      return false;
  }
}
