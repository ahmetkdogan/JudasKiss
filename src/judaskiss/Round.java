package judaskiss;

public class Round {
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Game game;
    
    public Round(Player player1,Player player2 , Player player3 , Player player4,Game game){
     this.player1=player1;
     this.player2=player2;
     this.player3=player3;
     this.player4=player4;
     this.game=game;
    }
    public void start(){
        Turn turn1 = new Turn(player1,game);
        Turn turn2=new Turn(player2,game);
        Turn turn3=new Turn(player3,game);
        Turn turn4=new Turn(player4,game);
        for(int i = 0 ; i<4;i++){
        turn1.start();
        turn2.start();
        turn3.start();
        turn4.start();
        }
        player1.setHand(new Card[4]);
        player2.setHand(new Card[4]);
        player3.setHand(new Card[4]);
        player4.setHand(new Card[4]);
    }
    
}
