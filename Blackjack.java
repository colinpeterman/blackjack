import java.util.ArrayList;
// Utilizes the Card and PokerDeack packages in order to create 
// a black jack hanf which calculates the total value of the 
// 4 cards as well as runs a experiment to see how many 
// hands bust out of 1 million hands. 

public class Blackjack {
 public static void main(String[] args) {
  experiment();
  
  

 }
 
 // This method is the one that creates the blackjack hand
 // and adds it to the array list.
 public static ArrayList<Card> blackjackHand(int n) {
  PokerDeck pd = new PokerDeck();
  pd.shuffle();
  ArrayList<Card> hand = new ArrayList<Card>();
  for(int i = 0; i < n;++i){
     hand.add(pd.deal());
  }
  return hand;
 }
 
 // hardTotal calculates the total that the number of cards in
 // the hand adds up to which is later used in the experiement method.
 public static int hardTotal(ArrayList<Card> cards) {
    int total = 0;
    for(Card card : cards){
       total += card.getValue();
    }
  return total;
 }
 
 // Experiment method uses the blackjackHand as well as hardTotal
 // to run a calculation of the percent of hands that but out of 
 // 1 million tested hands. In order to bust the total must add up to
 // over 21. 
 public static void experiment() {
    int bust = 0;
    for(int i = 0; i < 1000000; i++){
       ArrayList<Card> blackjackHand = blackjackHand(4);
       if(hardTotal(blackjackHand) > 21){
          bust++;
       }
    }
    Double percent = ((double) bust / 1000000) * 10;
    System.out.println(percent + "% of the 5-card hands busted");
 }

}
