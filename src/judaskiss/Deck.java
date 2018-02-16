package judaskiss;

import java.util.Random;


public class Deck {
    private Card[] cards;
    private int cardsInDeck;
    public Deck(){
        cards = new Card[52];
        cardsInDeck = cards.length;
    }
    public void shuffle(){
        int newI;
    Card temp;
    Random randIndex = new Random();

    for (int i = 0; i < cards.length; i++) {

        // pick a random index between 0 and cardsInDeck - 1
        newI = randIndex.nextInt(cardsInDeck);

        // swap cards[i] and cards[newI]
        temp = cards[i];
        cards[i] = cards[newI];
        cards[newI] = temp;
    }
    }
    
    public void deal(Player player1,Player playar2,Player player3, Player player4){
        
        
    }
    
    
    
}
