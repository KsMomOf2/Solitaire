package com.bishopireton.solitaire;
//package com.example.innisa.solitaireproject;

        import android.graphics.drawable.Drawable;
        import android.media.Image;
        import android.os.Bundle;
        import android.provider.ContactsContract;
//        import android.support.design.widget.FloatingActionButton;
//        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;

        import java.util.ArrayList;

public class scrnGame extends AppCompatActivity {
  private Deck d;
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
  private Card cSpade;//todo see why grey

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
  private int wRidgeCount7; //todo dont i use this when moving one deck to another

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

  //todo quit button
  //todo quit, when lose, when win, when deck runs  out of cards,
  //todo if pile empty and there are red left flip those jaunts
  //todo refresh deck when none
  //todo before test code walk through it all
  //todo win lose make sure on clicks
  //todo watch out for null
  //todo change icon\
  //todo images ---call the method everywhere


//WHAT DOING RN RIDGES/IMAGES

  //so these arraylists- should I make it a deck-- need one for each imgCard --change them when move play to a pile or when move decks
  //when initialize--in reset I guess //should also probably be fields
//    Card dDiamond= createCard(imgDeckDiamond);
//    Card dSpade= createCard(imgDeckSpade);
//    Card dClub= createCard(imgDeckClub);
//    Card dHeart= createCard(imgDeckHeart);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrn_game);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        /*
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,StandingsActivity.class));
        }
    });
        */

    //create a deck
    d= new Deck();
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
    //pick random card - for put down on back(nah just do when turn over)
    // for 7 put up
    //for take out of deck

    //when imgCardPlay is clickedchange a variable to see if anything else is changed
    //maybe if time when clicked take the borders off the image
    imgCardPlay.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        //isPlayClick= true; //reminder when anything else is clicked change this
        if (isPlayClick == true)
          isPlayClick = false;
        else
          isPlayClick = true;
      }
    });

    btnRestart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        reset();
      }
    });
    //set the onclickListeners for each deck

    //send in each suit image
    pileOnClickListener(imgCard1);
    pileOnClickListener(imgCard2);
    pileOnClickListener(imgCard3);
    pileOnClickListener(imgCard4);
    pileOnClickListener(imgCard5);
    pileOnClickListener(imgCard6);
    pileOnClickListener(imgCard7);

    suitOnClickListener(imgDeckClub);
    suitOnClickListener(imgDeckDiamond);
    suitOnClickListener(imgDeckHeart);
    suitOnClickListener(imgDeckSpade);

  }

  //set the onclick listeners for the piles
  public void pileOnClickListener(ImageButton b){
    b.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        imgDeckOnClickListener((ImageButton)findViewById(v.getId()));//caste as button etc//v.getId and save it somewhere as the button
        deckMoveOnClickListener((ImageButton)findViewById(v.getId()));
      }
    });
  }

  //set the onClickListeners for the suit cards
  public void suitOnClickListener(ImageButton b){
    b.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        suitOnClickListener((ImageButton)findViewById(v.getId()));//caste as button etc//v.getId and save it somewhere as the button
      }
    });
  }
  //method to check if a deck is already clicked//called when a deck is clicked
//moves one deck to another
  public void deckMoveOnClickListener(ImageButton b){
    //need to store a field, need to store boolean on if a deck has been clicked, and store what deck was clicked
    if(isDeckClick!=true) {
      //save value of first pile
      isDeckClick = true;
      deckClick=btnToCard(b);
      pMove=btnToPile(b);
      intClick=btnToInt(b);
      //maybe have a method to figure out from a card what image to use
      //then here i would just have to save the card /////////////////////
      //gonna save a number cuz I feel like it might help
    }
    else {
      isDeckClick = false;
      //check if can move first pile to the second
      if(deckClick!=null && pMove!=null){
        //check if bottom of first is bellow top of second
        //find bottom card of deck click
        //make methods for piles
        Card cCheck= pMove.get(1); //get card at the bottom of the pile

        //everything to move one pile to the other
        if(cCheck.isBellow(pick)){
          //move the deck to that deck!-- change the white spaces,change the face card

          //TODO make sure intMoveTo does not equal intClick
          //figure out what piles to do, what pile was just clicked
          int intMoveTo= btnToInt(b);
          //TECHNICALLY COULD USE BTNTOPILE TO SAVE SPACE BUT IDK IF THAT REALLY WORKS
          if(intMoveTo==1){
            //add to pile one the cards from the pile that corresponds to intClick---make a method that takes into 2 arraylists and returns back a new arraylist

            // if(pMove==2)
            //edit number of white ridges
            //TODO IMAGES
            //TODO i think pmove should work here but I would check
            p1=combinePiles(p1,pMove);//todo fix wRidge here?
          }
          else if(intMoveTo==2){
            p2= combinePiles(p2,pMove);
            wRidgeCount2= p2.size()-1;
            setWRidgeImage(wRidgeCount2,wRidge2 );
          }
          else if(intMoveTo==3){
            p3= combinePiles(p3,pMove);
            wRidgeCount3= p3.size()-1;
            setWRidgeImage(wRidgeCount3, wRidge3);
          }
          else if(intMoveTo==4){
            p4= combinePiles(p4,pMove);
            wRidgeCount4= p4.size()-1;
            setWRidgeImage(wRidgeCount4, wRidge4);
          }
          else if(intMoveTo==5){
            p5= combinePiles(p5, pMove);
            wRidgeCount5= p5.size()-1;
            setWRidgeImage(wRidgeCount5, wRidge5);
          }
          else if(intMoveTo==6){
            p6= combinePiles(p6, pMove);
            wRidgeCount6= p6.size()-1;
            setWRidgeImage(wRidgeCount6, wRidge6);
          }
          else if(intMoveTo==7){
            p7=combinePiles(p7, pMove);
            wRidgeCount7= p7.size()-1;
            setWRidgeImage(wRidgeCount7, wRidge7);
          }
          //todo what do when no red and no card
          //set first click pile to a drawn card
          if(intClick==1){
            p1= new ArrayList<>();
            //p1.add(createCard(imgCard1)); ADD NEW CARD LATER BC MIGHT LEAVE SLOT EMPTY-IF RED CARD FLIP IF NO RED CARD LEAVE BLANK

          }//todo is this right????????????? think through if clear the known piles
          else if(intClick==2){
            p2=new ArrayList<>();
            if(rRidgeCount2>0)
              p2.add(createCard(imgCard2));
          }
          //if(intClick==1)
          else if(intClick==3){
            p3=new ArrayList<>();
            if(rRidgeCount3>0)
              p3.add(createCard(imgCard3));
          }
          else if(intClick==4){
            p4= new ArrayList<>();
            if(rRidgeCount4>0)
              p4.add(createCard(imgCard4));
          }
          else if(intClick==5){
            p5=new ArrayList<>();
            if(rRidgeCount5>0)
              p5.add(createCard(imgCard5));
          }
          else if(intClick==6){
            p6= new ArrayList<>();
            if(rRidgeCount6>0)
              p6.add(createCard(imgCard6));
          }
          else if(intClick==7){
            p7= new ArrayList<>();
            if(rRidgeCount7>0)
              p7.add(createCard(imgCard7));
          }

          //TODO WHITE RIDGE COUNT

        }
      }
//todo fix code if move play to deck huh

      //move first to second pile (and check if legal)
      //figure out value of bottom of the bottom card
      //When add piles add to array list
    }

    //so i want to be able to click one deck then click another and move the first deck to the second
    //need to store what deck was clicked so that can set the other deck image to that image. and set the other deck card
    //so do I store both? ya

  }
  //check to make sure img play has been clicked
  //when pile clicked see if its corresponding card works w isClickPlay
  //call this in deckMove on Click probably
  public void imgDeckOnClickListener(ImageButton b){
    //check if works out here bc cant access b inside the other class
    Card corrWithImg;
    corrWithImg=btnToCard(b);


    //check to see if the card works
    if(pick.isBellow(corrWithImg)&& isPlayClick){
      //if statement to see what card to change
      //change b to p's image //idk if need if statement or not

      //maybe modularize
      //can i use a diff method here?
      if(b.equals(imgCard1)) {
        p1.add(pick);//todo figure out where this adds this
        c1 = pick;
        setCardImage(imgCard1,c1);
      }
      else if(b.equals(imgCard2)) {
        p2.add(pick);
        c2 = pick;
        setCardImage(imgCard2,c2);
      }
      else if(b.equals(imgCard3)) {
        p3.add(pick);
        c3 = pick;
        setCardImage(imgCard3,c3);
      }
      else if(b.equals(imgCard4)) {
        p4.add(pick);
        c4 = pick;
        setCardImage(imgCard4,c4);
      }
      else if(b.equals(imgCard5)) {
        p5.add(pick);
        c5 = pick;
        setCardImage(imgCard5,c5);
      }
      else if(b.equals(imgCard6)) {
        p5.add(pick);
        c6 = pick;
        setCardImage(imgCard6,c6);
      }
      else {
        p6.add(pick);
        c7 = pick;
        setCardImage(imgCard7,c7);
      }

      pick= createCard(imgCardPlay);
      isPlayClick=false;
      //if b==imgcard1 add to wRidgeCount1

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
    //todo CHANGE THE IMAGE



  }

  //reset the app/ run at beginning too
  public void reset(){
    //shuffle the deck
    d.shuffleDeck();

    //pick card from top of deck--
    //pick a random card from the deck, set the image of that card (or do that in the card class) ask mrs kelly

    //remove that card- set the first image to that cards image
    //ask if can concise the <code></code>

    //set the card picked (doing first cuz easiest to think through)
    //MODULARIZE MORE
    //returns a card , you put in a button
    //am I just setting the images of these cards to imageButtons
    //do I just change what the image of the iamge button is to change it??????//need images

    pick= createCard(imgCardPlay);
    c1= createCard(imgCard1);
    c2= createCard(imgCard2);
    c3= createCard(imgCard3);
    c4= createCard(imgCard4);
    c5= createCard(imgCard5);
    c6= createCard(imgCard6);
    c7= createCard(imgCard7);
    cDiamond=null;
    cClub=null;
    cHeart=null;
    cSpade=null;
    Card dDiamond= createCard(imgDeckDiamond);
    Card dSpade= createCard(imgDeckSpade);
    Card dClub= createCard(imgDeckClub);
    Card dHeart= createCard(imgDeckHeart);

    isPlayClick=false;
    isDeckClick=false;
    deckClick=null;
    intClick=0;

    //TODO then set the aces ones to blank
    //TODO reset ridge images
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
    pMove = null;
    pDiamond= new ArrayList<>();
    pClub= new ArrayList<>();
    pHeart= new ArrayList<>();
    pSpade= new ArrayList<>();

  }
  //create a card- pick it randomly from the deck and remove it
  public Card createCard(ImageButton img){
    Card c= d.pickACard();
    c= d.removeCard(c);
    setCardImage(img,c);
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


  public void moveToSuitOnClick(ImageButton b){ //WHEN WILL I CALL THIS METHOD
    //when click a card--- then click on a suit pile-- check if same suit and one above(think I have a method for this)--if yes then card for that sui pile is now imageplay and change the image--make sure draw a new card
    //if play is an ace can put in any empty hole--//maybe set the card to rank 0
    //when click one pile than a stack-- check against face card-- if yes then the suit is now that card- delete it from the pile and change images

    //when click on pick then a suit card
    Card suitCard;
    suitCard=btnToCard(b);//make sure not null

    //do move deck to suit after first do pile
    //todo img

    //todo put an image for the empty piles so they know which suit goes w which
    //check to see if the card works
    //figure out what card is on the top of the deck clicked

    if(pick.canAddSuitStack(suitCard)&& isPlayClick && suitCard!=null){
      //figure out what suit pile using --from imagebutton
      // in this part  add card to suitpile
      //draw a new card
      //set the suit card to pick !!
      // change images
      //i think thats it for this part
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
      pick= createCard(imgCardPlay);
    }
    //for if trying to move an ace
    else if(isPlayClick&&suitCard==null&&pick.getRank()==1){//dont even think i need to check if suitCard is null
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
      pick=createCard(imgCardPlay);

    }
    //for moving a deck
    //if is deck click is false when click on a deck then store in a card field its card card

    //tod keep track of isDeckClick
    if(!isDeckClick){
      isDeckClick = true;
      deckClick=btnToCard(b);
      pMove=btnToPile(b);
      intClick=btnToInt(b); //makesure this workds
    }
    //TODO remove one from the pile!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!make sure I double check this method
    else if(isDeckClick&&deckClick.canAddSuitStack(suitCard)&&suitCard!=null&&deckClick!=null){
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
      //todo so if pile has only one check if other red ridges---if has other stuff in the pile remove white ridge
      //change the image of the pile
      //todo change images START AROUND HERE WORKING ON IMAGES after this do ridges
      if(intClick==1)
        c1=createCard(imgCard1);//todo MAKE THIS BLANK and w others check if there are red cards
      else if(intClick==2) {
        if(p2.size()==1&&rRidgeCount2>=1){
          //take a card from red
          rRidgeCount2-=1;
          setRRidgeImage(rRidgeCount2, rRidge2);
          c2= createCard(imgCard2);
        }
        else if(p2.size()==1) {//check if its size would be 1 or 2

        }//make blank
        else if(p2.size()>1){
          c2 = p2.get(p2.size()-2);//todo check for sure messed this up
          //remove one card from pile
          //remove one from white ridges
          p2.remove(p2.size()-1); //todo for real tho how are the piles organized
          wRidgeCount2-=1;
          setWRidgeImage(wRidgeCount2, wRidge2);
        }

      }
      else if(intClick==3){
        if(p3.size()==1 &&rRidgeCount3>=1){
          rRidgeCount3-=1;
          c3=createCard(imgCard3);
          setRRidgeImage(rRidgeCount3, rRidge3);
        }
        else if(p3.size()==1){
          //make blank
        }
        else if(p3.size()>1){
          c3= p3.get(p3.size()-2);
          p3.remove(p3.size()-1);
          wRidgeCount3-=1;
          setWRidgeImage(wRidgeCount3, wRidge3);
        }
      }

      else if(intClick==4){
        if(p4.size()==1 && rRidgeCount4>=1){
          rRidgeCount4-=1;
          c4= createCard(imgCard4);
          setRRidgeImage(rRidgeCount4, rRidge4);
        }
        else if(p4.size()==1){
          //make blank
        }
        else if(p4.size()>1){
          c4=p4.get(p4.size()-2);
          p4.remove(p4.size()-1);
          wRidgeCount4-=1;
          setWRidgeImage(wRidgeCount3, wRidge3);
        }
      }

      else if(intClick==5){
        if(p5.size()==1&&rRidgeCount5>=1){
          rRidgeCount5-=1;
          c5=createCard(imgCard5);
          setRRidgeImage(rRidgeCount5,rRidge5);
        }
        else if(p5.size()==1){
          // todo make blank
        }
        else if(p5.size()>1){
          c5= p5.get(p5.size()-2);
          p5.remove(p5.size()-1);
          wRidgeCount5-=1;
          setWRidgeImage(wRidgeCount5, wRidge5);
        }
      }
      else if(intClick==6){
        if(p6.size()==1&&rRidgeCount6>=1){
          rRidgeCount6-=1;
          c6=createCard(imgCard6);
          setRRidgeImage(rRidgeCount6,rRidge6);
        }
        else if(p6.size()==1){
          //blanks
        }
        else if(p6.size()>1){
          c6= p6.get(p6.size()-2);
          p6.remove(p6.size()-1);
          wRidgeCount6-=1;
          setWRidgeImage(wRidgeCount6, wRidge6);
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
          //blanks
        }
        else if(p7.size()>1){
          c7=p7.get(p7.size()-2);
          p7.remove(p7.size()-1);
          wRidgeCount7-=1;
          setWRidgeImage(wRidgeCount7,wRidge7);
        }
      }
    }

  }

  //method that takes in an imagebutton and a card and sets the iamge of the image button bassed on that
  public void setCardImage(ImageButton b, Card c){
    int rankCheck= c.getRank();
    if(c.getSuit().equals("Diamonds")){
      //todo be careful might be able to condense some of this
      //todo use a switch statement
      switch(rankCheck){
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
  //todo what do when ridge count zero
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


  //if the user has a king in each suit pile they win---if they win set something to win
  public void checkIfWin(){
    if(cDiamond.getRank()==13 && cClub.getRank()==13 && cHeart.getRank()==13 && cSpade.getRank()==13){
      btnRestart.setText("WINNER! TO RESTART CLICK HERE");
    }
  }
}
