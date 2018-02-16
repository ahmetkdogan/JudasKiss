package judaskiss;

import java.util.Stack;


public class Game {
    private Table table;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Deck deck;
    
    public Game(Table table,Player player1,Player player2,Player player3,Player player4,Deck deck){
        this.table=table;
        this.player1=player1;
        this.player2=player2;
        this.player3=player3;
        this.player4=player4;
        this.deck=deck;
    }
    
    
    
    public boolean isPlayable(Card card,Stack stack){                          // CHECK IF THE CHOOSEN CARD CAN PLAYABLE WITH THE STACKS
        if(card.getStatus().equals(stack.peek())) return true;
        else return false;
    }
}
