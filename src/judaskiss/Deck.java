package judaskiss;

import java.util.Random;
import java.util.Stack;


public class Deck {
    private Card[] cards;
    private int cardsInDeck;
    private Stack<Card> stack;
    public Deck(){
        cards = new Card[52];
        cardsInDeck = cards.length;
        stack = new Stack<>();
    }
    
    public void shuffle(Deck deck,Card[] cards){
        int newI;                                                     // SHUFFLE CARDS//
        Card temp;
        Random randIndex = new Random();

        for (int i = 0; i < cards.length; i++) {

        // pick a random index between 0 and cardsInDeck - 1
        newI = randIndex.nextInt(cardsInDeck);

        // swap cards[i] and cards[newI]
        temp = cards[i];
        cards[i] = cards[newI];
        cards[newI] = temp;
        }                                                              // ADD SHUFFLED CARDS TO DECK STACK
        for(int i = 0 ; i<cards.length;i++){
            deck.stack.push(cards[i]);
        }
        
    }
    
    public void deal(Deck deck,Player player1,Player player2,Player player3, Player player4){
        for(int i = 0 ; i<player1.getHand().length;i++){
            player1.getHand()[i] = deck.stack.pop();
        }
        for(int i = 0 ; i<player2.getHand().length;i++){
            player2.getHand()[i] = deck.stack.pop();
        }
        for(int i = 0 ; i<player3.getHand().length;i++){
            player3.getHand()[i] = deck.stack.pop();
        }
        for(int i = 0 ; i<player4.getHand().length;i++){
            player4.getHand()[i] = deck.stack.pop();
        }
    }
    
    public void tableDeal(Deck deck,Table table,Stack stackSlot1,Stack stackSlot2,Stack stackSlot3,Stack stackSlot4){      // DEALS 4 CARDS TO THE TABLE FOR THE FIRST ROUND
        for(int i = 0 ; i<3;i++){
            table.getStackSlot1().push(deck.stack.pop());
        }
    }
    
    
    
}
