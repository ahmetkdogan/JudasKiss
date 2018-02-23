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
        System.out.println("Pick a card");
        temp = scan.nextLine(); //Gets picked card's name
        for(Card x : player.getHand()){
            if(x.getName().equals(temp)) pickedCard = x; 
        }
        System.out.println("Choose target stack");
        temp = scan.nextLine();
        targetStack = game.findStack(temp);
        System.out.println("Choose victim stack");
        temp = scan.nextLine();
        victimStack = game.findStack(temp);
        game.putCard(pickedCard, targetStack,victimStack );
        
    }
    public String printArray(Card[] card){
        String temp = "";
        for(int i = 0 ; i<card.length;i++){
            temp += card[i].getName()+" ,";
        }
        return temp;
    }
    
}
