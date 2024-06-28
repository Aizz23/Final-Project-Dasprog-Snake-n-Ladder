public class Main {
    public static void main(String[] args) {
        SnL g1 = new SnL(100);
        g1.initiateGame();
        Player p1 = new Player("Sipli");
        Player p2 = new Player("Adel");

        g1.addPlayer(p1);
        g1.addPlayer(p2);

        do {
            System.out.println("====================================================================");

            Player nowPlaying = g1.getTurn();
            System.out.println("Now Playing: " + nowPlaying.getName() + " the current position is " + nowPlaying.getPosition());

            int x = nowPlaying.rollDice();
            System.out.println(nowPlaying.getName() + " is rolling dice and gets number: " + x);
            g1.movePlayer(nowPlaying, x);
            System.out.println(nowPlaying.getName() + " the current position is " + nowPlaying.getPosition());
        } while (g1.getGameStatus() != 2);

        if (g1.getPlayers().get(0).getPosition() == 100) {
            System.out.println("The game is over, the winner is: " + g1.getPlayers().get(0).getName());
        } else if (g1.getPlayers().get(1).getPosition() == 100) {
            System.out.println("The game is over, the winner is: " + g1.getPlayers().get(1).getName());
        } else {
            Player loser = g1.getPlayers().get(g1.getTurn() == g1.getPlayers().get(0) ? 1 : 0);
            System.out.println("The game is over, the winner is: " + loser.getName());
        }
    }
}
