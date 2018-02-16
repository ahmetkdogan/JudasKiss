package judaskiss;

import java.util.Stack;

public class Table {
    private Stack<Card> mainStack;
    private Stack<Card> stackSlot1;
    private Stack<Card> stackSlot2;
    private Stack<Card> stackSlot3;
    private Stack<Card> stackSlot4;
    
    
    public Table(){
        mainStack = new Stack();
        stackSlot1 = new Stack();
        stackSlot2 = new Stack();
        stackSlot3 = new Stack();
        stackSlot4 = new Stack();
    }

    public Stack<Card> getMainStack() {
        return mainStack;
    }

    public Stack<Card> getStackSlot1() {
        return stackSlot1;
    }

    public void setStackSlot1(Stack<Card> stackSlot1) {
        this.stackSlot1 = stackSlot1;
    }

    public Stack<Card> getStackSlot2() {
        return stackSlot2;
    }

    public void setStackSlot2(Stack<Card> stackSlot2) {
        this.stackSlot2 = stackSlot2;
    }

    public Stack<Card> getStackSlot3() {
        return stackSlot3;
    }

    public void setStackSlot3(Stack<Card> stackSlot3) {
        this.stackSlot3 = stackSlot3;
    }

    public Stack<Card> getStackSlot4() {
        return stackSlot4;
    }

    public void setStackSlot4(Stack<Card> stackSlot4) {
        this.stackSlot4 = stackSlot4;
    }

    public void setMainStack(Stack<Card> mainStack) {
        this.mainStack = mainStack;
    }
    
    
}
