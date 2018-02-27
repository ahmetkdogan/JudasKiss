package judaskiss;
import java.util.Scanner;
import java.util.Stack;


public class Turn {
    Scanner scan = new Scanner(System.in);
    String temp;
    Player player;
    Card pickedCard;
    Game game;
    Stack<Card> targetStack;
    Stack<Card> victimStack;
    
    public Turn(Player player,Game game){
        this.player = player;
        this.game=game;
    }
    
    public void start(){
        System.out.println(player.getName() + "'s Turn\t: " + printArray(player.getHand()) + "\n");
        System.out.println(game.printInfo());
        
        //  CARD PICKING STARTS HERE //
        
        
        boolean cardFound = false;
        int temp2 = 0;
        int temp3 = 0;
        do{
        System.out.println("Pick a card");
        temp = scan.nextLine(); //Gets picked card's name
        temp2 = 0;
        temp3 = 0;
        for(Card x : player.getHand()){
            if(x.getName().equals(temp)) {
                pickedCard = x;
                player.getHand()[temp2]= new Card();
                cardFound = true;
                break;
            }
            temp2++;
        }
        }while(!cardFound);
        Card[] tempCard = new Card[player.getHand().length-1];
        for(int i = 0 ; i<player.getHand().length;i++){
            if(i != temp2) tempCard[temp3++] = player.getHand()[i];
        }
        
        player.setHand(tempCard);
        //  ENDS HERE //
       
        // CHOOSING TARGET STACK STARTS HERE //
        boolean stackFound = false;
        do{
            System.out.println("Choose target stack");
            temp = scan.nextLine();
            targetStack = game.findStack(temp);
            stackFound = true;
            if(targetStack==game.findStack("Dummy Stack")) stackFound = false;
        }while(!stackFound);
        // ENDS HERE //
        
        // CHOOSING VICTIM STACK STARTS HERE //
        if( (!game.findStack("Stack Slot1").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Stack Slot1").peek().getStatus()) ) || (!game.findStack("Stack Slot2").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Stack Slot2").peek().getStatus()) )||(!game.findStack("Stack Slot3").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Stack Slot3").peek().getStatus()) )||(!game.findStack("Stack Slot4").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Stack Slot4").peek().getStatus()) )||(!game.findStack("Player1 Stack").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Player1 Stack").peek().getStatus()) )||(!game.findStack("Player2 Stack").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Player2 Stack").peek().getStatus()) )||(!game.findStack("Player3 Stack").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Player3 Stack").peek().getStatus()) )||(!game.findStack("Player4 Stack").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Player4 Stack").peek().getStatus()) ) || (!game.findStack("Main Stack").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Main Stack").peek().getStatus()) ) ){
            boolean victimStackFound = false;
            do{
                victimStackFound = true;
            System.out.println("Choose victim stack");
            temp = scan.nextLine();
            victimStack = game.findStack(temp);
            if(victimStack==game.findStack("Dummy Stack")) victimStackFound = false;
            }while(!victimStackFound);
        
        }
        else victimStack = game.findStack("Player1 Stack");
        //ENDS HERE//
        game.putCard(pickedCard, targetStack,victimStack );
        
    }
    public String printArray(Card[] card){
        String temp = "";
        for(int i = 0 ; i<card.length;i++){
            if(card[i]!=null)
            temp += card[i].getName()+" ,";
        }
        return temp;
    }
    
    public void botStart(){
        //CARD PICKING//
        boolean cardPicked = false;
        boolean isMatchable = false;
        for(int i = 0 ; i<player.getHand().length;i++){
            if((!game.findStack("Stack Slot1").isEmpty()  && player.getHand()[i].getStatus().equals(game.findStack("Stack Slot1").peek().getStatus()) ) || (!game.findStack("Stack Slot2").isEmpty()  && player.getHand()[i].getStatus().equals(game.findStack("Stack Slot2").peek().getStatus()) )||(!game.findStack("Stack Slot3").isEmpty()  && player.getHand()[i].getStatus().equals(game.findStack("Stack Slot3").peek().getStatus()) )||(!game.findStack("Stack Slot4").isEmpty()  && player.getHand()[i].getStatus().equals(game.findStack("Stack Slot4").peek().getStatus()) )||(!game.findStack("Player1 Stack").isEmpty()  && player.getHand()[i].getStatus().equals(game.findStack("Player1 Stack").peek().getStatus()) )||(!game.findStack("Player2 Stack").isEmpty()  && player.getHand()[i].getStatus().equals(game.findStack("Player2 Stack").peek().getStatus()) )||(!game.findStack("Player3 Stack").isEmpty()  && player.getHand()[i].getStatus().equals(game.findStack("Player3 Stack").peek().getStatus()) )||(!game.findStack("Player4 Stack").isEmpty()  && player.getHand()[i].getStatus().equals(game.findStack("Player4 Stack").peek().getStatus()) ) || (!game.findStack("Main Stack").isEmpty()  && player.getHand()[i].getStatus().equals(game.findStack("Main Stack").peek().getStatus()) ) ){
            cardPicked = true;
            isMatchable = true;
            pickedCard = player.getHand()[i];
            break;
            }
        }
        if(!cardPicked){
                int temp = (int)(Math.random()*player.getHand().length);
                pickedCard = player.getHand()[temp];
            }
        //ENDS HERE//
        
        //CHOOSING TARGET STACK//
        if(isMatchable){
            if((!game.findStack("Stack Slot1").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Stack Slot1").peek().getStatus()) )) targetStack = game.findStack("Stack Slot1");
            else if((!game.findStack("Stack Slot2").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Stack Slot2").peek().getStatus()) )) targetStack = game.findStack("Stack Slot2");
            else if((!game.findStack("Stack Slot3").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Stack Slot3").peek().getStatus()) )) targetStack = game.findStack("Stack Slot3");
            else if((!game.findStack("Stack Slot4").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Stack Slot4").peek().getStatus()) )) targetStack = game.findStack("Stack Slot4");
            else if((!game.findStack("Player1 Stack").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Player1 Stack").peek().getStatus()) )) targetStack = game.findStack("Player1 Stack");
            else if((!game.findStack("Player2 Stack").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Player2 Stack").peek().getStatus()) )) targetStack = game.findStack("Player2 Stack");
            else if((!game.findStack("Player3 Stack").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Player3 Stack").peek().getStatus()) )) targetStack = game.findStack("Player3 Stack");
            else if((!game.findStack("Player4 Stack").isEmpty()  && pickedCard.getStatus().equals(game.findStack("Player4 Stack").peek().getStatus()) )) targetStack = game.findStack("Player4 Stack");
            else targetStack = game.findStack("Main Stack");
        }
        else targetStack = game.findStack("Main Stack");
        //ENDS HERE//
        
        //CHOOSING VICTIM STACK//
        boolean selfVictim = false;
        do{
        int temp2 = (int)(Math.random()*4);
            switch (temp2) {
                case 0:
                    victimStack = game.findStack("Player1 Stack");
                    break;
                case 1:
                    victimStack = game.findStack("Player2 Stack");
                    break;
                case 2:
                    victimStack = game.findStack("Player3 Stack");
                    break;
                default:
                    victimStack = game.findStack("Player4 Stack");
                    break;
            }
        if(victimStack == player.getStack()) selfVictim = true;
        else selfVictim = false;
            }while(selfVictim);
        //ENDS HERE//
        game.putCard(pickedCard, targetStack,victimStack);
        
    }
    
}
