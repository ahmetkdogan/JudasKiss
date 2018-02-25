package judaskiss;

import java.util.Random;
import java.util.Stack;


public class Deck {
    private Card[] cards;          //STATIC
    private int cardsInDeck;        //STATIC
    private Stack<Card> stack;          //STATIC
    public Deck(){
        cards = new Card[52];
        cardsInDeck = cards.length;
        stack = new Stack<>();
        cards[0] = new Card("Karo King", "Karo", "K", 13);
        cards[1] = new Card("Karo Queen", "Karo", "Q", 12);
        cards[2] = new Card("Karo Joker", "Karo", "J", 11);
        cards[3] = new Card("Karo 10", "Karo", "10", 10);
        cards[4] = new Card("Karo 9", "Karo", "9", 9);
        cards[5] = new Card("Karo 8", "Karo", "8", 8);
        cards[6] = new Card("Karo 7", "Karo", "7", 7);
        cards[7] = new Card("Karo 6", "Karo", "6", 6);
        cards[8] = new Card("Karo 5", "Karo", "5", 5);
        cards[9] = new Card("Karo 4", "Karo", "4", 4);
        cards[10] = new Card("Karo 3", "Karo", "3", 3);
        cards[11] = new Card("Karo 2", "Karo", "2", 2);
        cards[12] = new Card("Karo A", "Karo", "A", 1);
        cards[13] = new Card("Sinek King", "Sinek", "K", 13);
        cards[14] = new Card("Sinek Queen", "Sinek", "Q", 12);
        cards[15] = new Card("Sinek Joker", "Sinek", "J", 11);
        cards[16] = new Card("Sinek 10", "Sinek", "10", 10);
        cards[17] = new Card("Sinek 9", "Sinek", "9", 9);
        cards[18] = new Card("Sinek 8", "Sinek", "8", 8);
        cards[19] = new Card("Sinek 7", "Sinek", "7", 7);
        cards[20] = new Card("Sinek 6", "Sinek", "6", 6);
        cards[21] = new Card("Sinek 5", "Sinek", "5", 5);
        cards[22] = new Card("Sinek 4", "Sinek", "4", 4);
        cards[23] = new Card("Sinek 3", "Sinek", "3", 3);
        cards[24] = new Card("Sinek 2", "Sinek", "2", 2);
        cards[25] = new Card("Sinek A", "Sinek", "A", 1);
        cards[26] = new Card("Maca King", "Maca", "K", 13);
        cards[27] = new Card("Maca Queen", "Maca", "Q", 12);
        cards[28] = new Card("Maca Joker", "Maca", "J", 11);
        cards[29] = new Card("Maca 10", "Maca", "10", 10);
        cards[30] = new Card("Maca 9", "Maca", "9", 9);
        cards[31] = new Card("Maca 8", "Maca", "8", 8);
        cards[32] = new Card("Maca 7", "Maca", "7", 7);
        cards[33] = new Card("Maca 6", "Maca", "6", 6);
        cards[34]= new Card("Maca 5", "Maca", "5", 5);
        cards[35] = new Card("Maca 4", "Maca", "4", 4);
        cards[36] = new Card("Maca 3", "Maca", "3", 3);
        cards[37] = new Card("Maca 2", "Maca", "2", 2);
        cards[38] = new Card("Maca A", "Maca", "A", 1);
        cards[39] = new Card("Kupa King", "Kupa", "K", 13);
        cards[40] = new Card("Kupa Queen", "Kupa", "Q", 12);
        cards[41] = new Card("Kupa Joker", "Kupa", "J", 11);
        cards[42] = new Card("Kupa 10", "Kupa", "10", 10);
        cards[43] = new Card("Kupa 9" , "Kupa", "9", 9);
        cards[44] = new Card("Kupa 8", "Kupa", "8", 8);
        cards[45] = new Card("Kupa 7", "Kupa", "7", 7);
        cards[46] = new Card("Kupa 6", "Kupa", "6", 6);
        cards[47] = new Card("Kupa 5", "Kupa", "5", 5);
        cards[48] = new Card("Kupa 4", "Kupa", "4", 4);
        cards[49] = new Card("Kupa 3", "Kupa", "3", 3);
        cards[50] = new Card("Kupa 2", "Kupa", "2", 2);
        cards[51] = new Card("Kupa 1", "Kupa", "A", 1);
        
        
    }
    
    public void shuffle(){
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
            stack.push(cards[i]);
        }
        
    }
    
    public void deal(Player player1,Player player2,Player player3, Player player4){
        for(int i = 0 ; i<player1.getHand().length;i++){
            player1.getHand()[i] = stack.pop();
        }
        for(int i = 0 ; i<player2.getHand().length;i++){
            player2.getHand()[i] = stack.pop();
        }
        for(int i = 0 ; i<player3.getHand().length;i++){
            player3.getHand()[i] = stack.pop();
        }
        for(int i = 0 ; i<player4.getHand().length;i++){
            player4.getHand()[i] = stack.pop();
        }
    }
    
    public void tableDeal(Table table){      // DEALS 4 CARDS TO THE TABLE FOR THE FIRST ROUND --------------------------------
        int temp = 1;
        table.getStackSlot1().push(stack.pop());
        while(temp<4 && table.getStackSlot1().peek().getStatus().equals(stack.peek().getStatus())){table.getStackSlot1().push(stack.pop()); temp++;}
        if(temp<4){table.getStackSlot2().push(stack.pop()); temp++;}
        while(temp<4 && table.getStackSlot2().peek().getStatus().equals(stack.peek().getStatus())){table.getStackSlot2().push(stack.pop()); temp++;}
        if(temp<4){table.getStackSlot3().push(stack.pop()); temp++;}
        while(temp<4 && table.getStackSlot3().peek().getStatus().equals(stack.peek().getStatus())){table.getStackSlot3().push(stack.pop()); temp++;}
        if(temp<4){table.getStackSlot4().push(stack.pop()); temp++;}
        while(temp<4 && table.getStackSlot4().peek().getStatus().equals(stack.peek().getStatus())){table.getStackSlot4().push(stack.pop()); temp++;}
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
    
    
    
}
