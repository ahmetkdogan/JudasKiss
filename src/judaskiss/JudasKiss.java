package judaskiss;

public class JudasKiss {

    
    public static void main(String[] args) {
        Table table = new Table();
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Deck deck = new Deck();
        Game game = new Game(table,player1,player2,player3,player4,deck);
    }
    
}
