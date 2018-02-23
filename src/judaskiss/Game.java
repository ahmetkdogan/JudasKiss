package judaskiss;

import java.util.Stack;


public class Game {
    private Table table; // STATIC
    private Player player1;  //STATIC
    private Player player2;   //STATIC
    private Player player3;      //STATIC
    private Player player4;    //STATIC
    private Deck deck;          //STATIC
    
    public Game(Table table,Player player1,Player player2,Player player3,Player player4,Deck deck){
        this.table=table;
        this.player1=player1;
        this.player2=player2;
        this.player3=player3;
        this.player4=player4;
        this.deck=deck;
        
    }
    
    public void putCard(Card card, Stack<Card> targetStack, Stack<Card> victimStack){                                 //USER PLAYS A CARD TO ANOTHER PLAYER'S STACK
        if(!targetStack.isEmpty() && card.getStatus().equals(targetStack.peek().getStatus())) {           //WE PUT OUR CARD TO TARGETPLAYER AND MOVE TO VICTIMPLAYER
            targetStack.push(card);
            card = null; //--------------------------------//
            move(targetStack, victimStack);
        }
        else putCard(card,table,victimStack);
    }
    
    public void putCard(Card card, Table table,Stack<Card> victimStack){
        boolean temp = false;
        if(!table.getMainStack().isEmpty())
        temp = card.getStatus().equals(table.getMainStack().peek().getStatus()); // TRUE IF PLAYED CARD'S STATUS IS SAME WITH THE TOP OF THE MAIN STACK'S CARD'S STATUS
        table.getMainStack().push(card);
        card=null;
        if(temp){
            move(table,victimStack);
        }
    }
    
    public boolean isPlayable(Card card,Stack stack){                          // CHECK IF THE CHOOSEN CARD CAN PLAYABLE WITH THE STACKS
        if(!stack.isEmpty() && card.getStatus().equals(stack.peek())) return true;
        else return false;
    }

    public void move(Stack<Card> currentStack , Stack<Card> targetStack) {     //TAKE AND MOVE THE CARDS TO ANOTHER PLAYER'S STACK
        Card temp = currentStack.peek();
        while(temp.getStatus().equals(currentStack.peek().getStatus())){
            targetStack.push(currentStack.pop()) ;
        }
    }
    public void move(Table table,Stack<Card> victimStack){
        Card temp = table.getMainStack().peek();
        while(temp.getStatus().equals(table.getMainStack().peek().getStatus())){
            victimStack.push(table.getMainStack().pop());
        }
    }
    
    public Stack<Card> findStack(String stackName){
        if(stackName.equals("Player1 Stack")) return player1.getStack();
        else if(stackName.equals("Player2 Stack")) return player2.getStack();
        else if(stackName.equals("Player3 Stack")) return player3.getStack();
        else if(stackName.equals("Player4 Stack")) return player4.getStack();
        else if(stackName.equals("Main Stack")) return table.getMainStack();
        else if(stackName.equals("Stackslot 1")) return table.getStackSlot1();
        else if(stackName.equals("Stackslot 2")) return table.getStackSlot2();
        else if(stackName.equals("Stackslot 3")) return table.getStackSlot3();
        else if(stackName.equals("Stackslot 4")) return table.getStackSlot4();
        else return table.getMainStack();
    }
    
    public String printInfo(){
        String temp = "";
        if(!player1.getStack().isEmpty())
        temp += "Player1 Stack : " + player1.getStack().peek() + "\n";
        if(!player2.getStack().isEmpty())
        temp += "Player2 Stack : " + player2.getStack().peek() + "\n";
        if(!player3.getStack().isEmpty())
        temp += "Player3 Stack : " + player3.getStack().peek() + "\n";
        if(!player4.getStack().isEmpty())
        temp += "Player4 Stack : " + player4.getStack().peek() + "\n";
        if(!table.getMainStack().isEmpty())
        temp += "Main Stack : " + table.getMainStack() + "\n";
        if(!table.getStackSlot1().isEmpty())
        temp += "Stack Slot1 : " + table.getStackSlot1()+ "\n";
        if(!table.getStackSlot2().isEmpty())
        temp += "Stack Slot2 : " + table.getStackSlot2() + "\n";
        if(!table.getStackSlot3().isEmpty())
        temp += "Stack Slot3 : " + table.getStackSlot3() + "\n";
        if(!table.getStackSlot4().isEmpty())
        temp += "Stack Slot4 : " + table.getStackSlot4() + "\n";
        
        return temp;
    }
        
}
