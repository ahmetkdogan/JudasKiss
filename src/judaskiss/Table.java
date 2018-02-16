package judaskiss;

import java.util.Stack;

public class Table {
    private Stack stack;
    private Card[] cardSlot;
    
    public Table(){
        stack = new Stack();
        cardSlot = new Card[4];
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public Card[] getCardSlot() {
        return cardSlot;
    }

    public void setCardSlot(Card[] cardSlot) {
        this.cardSlot = cardSlot;
    }
    
    
}
