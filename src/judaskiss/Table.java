package judaskiss;

import java.util.Stack;

public class Table {
    private Stack mainStack;
    private Stack stackSlot1;
    private Stack stackSlot2;
    private Stack stackSlot3;
    private Stack stackSlot4;
    
    
    public Table(){
        mainStack = new Stack();
        stackSlot1 = new Stack();
        stackSlot2 = new Stack();
        stackSlot3 = new Stack();
        stackSlot4 = new Stack();
    }

    public Stack getMainStack() {
        return mainStack;
    }

    public Stack getStackSlot1() {
        return stackSlot1;
    }

    public void setStackSlot1(Stack stackSlot1) {
        this.stackSlot1 = stackSlot1;
    }

    public Stack getStackSlot2() {
        return stackSlot2;
    }

    public void setStackSlot2(Stack stackSlot2) {
        this.stackSlot2 = stackSlot2;
    }

    public Stack getStackSlot3() {
        return stackSlot3;
    }

    public void setStackSlot3(Stack stackSlot3) {
        this.stackSlot3 = stackSlot3;
    }

    public Stack getStackSlot4() {
        return stackSlot4;
    }

    public void setStackSlot4(Stack stackSlot4) {
        this.stackSlot4 = stackSlot4;
    }

    public void setMainStack(Stack mainStack) {
        this.mainStack = mainStack;
    }
    
    
}
