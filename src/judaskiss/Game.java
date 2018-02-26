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
    public Game(){
        
    }
    
    public void putCard(Card card, Stack<Card> targetStack, Stack<Card> victimStack){                                 //USER PLAYS A CARD TO ANOTHER PLAYER'S STACK
        if(!targetStack.isEmpty() && card.getStatus().equals(targetStack.peek().getStatus())) {           //WE PUT OUR CARD TO TARGETPLAYER AND MOVE TO VICTIMPLAYER
            targetStack.push(card);
            //card = null; //--------------------------------//
            move(targetStack, victimStack);
        }
        else putCard(card,table,victimStack);
    }
    
    public void putCard(Card card, Table table,Stack<Card> victimStack){
        boolean temp = false;
        if(!table.getMainStack().isEmpty())
        temp = card.getStatus().equals(table.getMainStack().peek().getStatus()); // TRUE IF PLAYED CARD'S STATUS IS SAME WITH THE TOP OF THE MAIN STACK'S CARD'S STATUS
        table.getMainStack().push(card);
        //card=null;
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
        while(!currentStack.isEmpty() && temp.getStatus().equals(currentStack.peek().getStatus())){
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
        else if(stackName.equals("Stack Slot1")) return table.getStackSlot1();
        else if(stackName.equals("Stack Slot2")) return table.getStackSlot2();
        else if(stackName.equals("Stack Slot3")) return table.getStackSlot3();
        else if(stackName.equals("Stack Slot4")) return table.getStackSlot4();
        else if(stackName.equals("Main Stack")) return table.getMainStack();
        else if(stackName.equals("Dummy Stack")) return table.getDummyStack();
        else return table.getDummyStack();
    }
    
    public String printInfo(){
        String temp = "";
        if(!player1.getStack().isEmpty()){
            player1.setPoints(getPoint(player1.getStack()));
            temp += "Player1 Stack : " + player1.getStack() +" Points: "+ player1.getPoints() +"\n";
            }
        
        if(!player2.getStack().isEmpty()){
            player2.setPoints(getPoint(player2.getStack()));
            temp += "Player2 Stack : " + player2.getStack() +" Points: "+ player2.getPoints()+ "\n";
            }
        
        if(!player3.getStack().isEmpty()){
            player3.setPoints(getPoint(player3.getStack()));
            temp += "Player3 Stack : " + player3.getStack() +" Points: "+ player3.getPoints() + "\n";
        }
        
        if(!player4.getStack().isEmpty()){
            player4.setPoints(getPoint(player4.getStack()));
            temp += "Player4 Stack : " + player4.getStack() +" Points: "+ player4.getPoints() + "\n";
        }
        
        if(!table.getMainStack().isEmpty())
            temp += "Main Stack : " + table.getMainStack() +" Points: "+getPoint(table.getMainStack()) +"\n";
        if(!table.getStackSlot1().isEmpty())
            temp += "Stack Slot1 : " + table.getStackSlot1()+ " Points: "+getPoint(table.getStackSlot1()) +"\n";
        if(!table.getStackSlot2().isEmpty())
            temp += "Stack Slot2 : " + table.getStackSlot2() +" Points: "+getPoint(table.getStackSlot2()) + "\n";
        if(!table.getStackSlot3().isEmpty())
            temp += "Stack Slot3 : " + table.getStackSlot3() +" Points: "+getPoint(table.getStackSlot3()) + "\n";
        if(!table.getStackSlot4().isEmpty())
            temp += "Stack Slot4 : " + table.getStackSlot4() +" Points: "+getPoint(table.getStackSlot4()) + "\n";
        
        return temp;
    }
    public int getPoint(Stack<Card> stack){
        Stack<Card> tempStack = new Stack();
        int points = 0;
        while(!stack.isEmpty()){
            points += stack.peek().getPoint();
            tempStack.push(stack.pop());
        }
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return points;
    }
    public void start(){
        Table table = new Table();
        Player player1 = new Player("Player1",1);
        Player player2 = new Player("Player2",2);
        Player player3 = new Player("Player3",3);
        Player player4 = new Player("Player4",4);
        
        Deck deck = new Deck();
        Game game = new Game(table,player1,player2,player3,player4,deck);
        Round round = new Round(player1, player2, player3, player4,game);
        
        deck.shuffle();
        deck.tableDeal(table);
        
        
        for(int i = 0 ; i<4;i++){
            deck.deal(player1, player2, player3, player4);
            round.start();
        }
    }
        
}
