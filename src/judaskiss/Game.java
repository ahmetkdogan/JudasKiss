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
    
    public void putCard(Card card, Player targetPlayer, Player victimPlayer){                                 //USER PLAYS A CARD TO ANOTHER PLAYER'S STACK
        if(card.getStatus().equals(targetPlayer.getStack().peek().getStatus())) {           //WE PUT OUR CARD TO TARGETPLAYER AND MOVE TO VICTIMPLAYER
            targetPlayer.getStack().push(card);
            card = null;
            move(targetPlayer, victimPlayer);
        }
        else putCard(card,table,victimPlayer);
    }
    
    public void putCard(Card card, Table table,Player victimPlayer){
        boolean temp = card.getStatus().equals(table.getMainStack().peek().getStatus()); // TRUE IF PLAYED CARD'S STATUS IS SAME WITH THE TOP OF THE MAIN STACK'S CARD'S STATUS
        table.getMainStack().push(card);
        card=null;
        if(temp){
            move(table,victimPlayer);
        }
    }
    
    public boolean isPlayable(Card card,Stack stack){                          // CHECK IF THE CHOOSEN CARD CAN PLAYABLE WITH THE STACKS
        if(card.getStatus().equals(stack.peek())) return true;
        else return false;
    }

    public void move(Player currentPlayer , Player targetPlayer) {     //TAKE AND MOVE THE CARDS TO ANOTHER PLAYER'S STACK
        Card temp = currentPlayer.getStack().peek();
        while(temp.getStatus().equals(currentPlayer.getStack().peek().getStatus())){
            targetPlayer.getStack().push(currentPlayer.getStack().pop()) ;
        }
    }
    public void move(Table table,Player victimPlayer){
        Card temp = table.getMainStack().peek();
        while(temp.getStatus().equals(table.getMainStack().peek().getStatus())){
            victimPlayer.getStack().push(table.getMainStack().pop());
        }
    }
        
    }
