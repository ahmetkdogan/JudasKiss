package judaskiss;

import java.util.Stack;


public class Player {
    private String name;
    private int points;
    private Stack<Card> stack;
    private Card[] hand;
    private int num;
    
    public Player(String name,int num){
        this.name=name;
        points=0;
        hand = new Card[4];
        stack=new Stack<>();
        this.num=num;
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

    public Stack<Card> getStack() {
        return stack;
    }

    public void setStack(Stack<Card> stack) {
        this.stack = stack;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }
    public int getPlayerNum(){
        return num;
    }
    public void setPlayerNum(int num){
        this.num = num;
    }
    
    
}
