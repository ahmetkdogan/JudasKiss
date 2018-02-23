package judaskiss;

public class JudasKiss {

    
    public static void main(String[] args) {
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
