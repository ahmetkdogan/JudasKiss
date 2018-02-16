package judaskiss;

import java.util.Stack;


public class Player {
    private String name;
    private int points;
    private Stack stack;
    private Card[] hand;
    
    public Player(String name){
        this.name=name;
        points=0;
        hand = new Card[4];
        stack=new Stack();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    
    
}
