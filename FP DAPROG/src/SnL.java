import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class SnL {
    private int boardSize;
    private ArrayList<Player> players;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;
    private ArrayList<Jackpot> jackies; //new features (jackpot)
    private ArrayList<Challange> challanges; //new features (challange)
    private ArrayList<SpringTrap> springTraps; //new features (springTraps)
    private int gameStatus;
    private int currentTurn;


    public SnL(int var1) {
        this.boardSize = var1;
        this.snakes = new ArrayList();
        this.ladders = new ArrayList();
        this.players = new ArrayList();
        this.jackies = new ArrayList();
        this.challanges = new ArrayList();
        this.springTraps = new ArrayList();
        this.gameStatus = 0;
        this.currentTurn = 0;

    }

    public void initiateGame() {
        int[][] var1 = new int[][]{{2, 23}, {20, 77}, {32, 68}, {41, 78}, {74, 88}, {82, 100}, {85, 95}};
        this.setLadders(var1);
        int[][] var2 = new int[][]{{47, 5}, {29, 9}, {38, 15}, {97, 25}, {53, 33}, {92, 70}, {86, 54}, {97, 25}};
        this.setSnakes(var2);
        int[] jack = new int[]{50, 100};
        this.setJackies(jack);
        Challange[] challanges = new Challange[]{
                new Challange(10, "What is the country with the most population?", "India"),
                new Challange(30, "What is the capital of Indonesia?", "Jakarta"),
                new Challange(60, "How many children does the IUP class information system department have?", "32")
        };
        this.setChallanges(challanges);
        int[] springTrapPositions = new int[]{14, 36, 58};
        this.setSpringTraps(springTrapPositions);
    }

    public Player getTurn() {
        if (this.gameStatus == 0) {
            double var1 = Math.random();
            if (var1 < 0.5) {
                this.currentTurn = 0;
                return (Player)this.players.get(0);
            } else {
                this.currentTurn = 1;
                return (Player)this.players.get(1);
            }
        } else if (this.currentTurn == 0) {
            this.currentTurn = 1;
            return (Player)this.players.get(1);
        } else {
            this.currentTurn = 0;
            return (Player)this.players.get(0);
        }
    }

    public void setSizeBoard(int var1) {
        this.boardSize = var1;
    }

    public void addPlayer(Player var1) {
        this.players.add(var1);
    }

    public void setLadders(int[][] var1) {
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            this.ladders.add(new Ladder(var1[var3][0], var1[var3][1]));
        }
    }

    public void setSnakes(int[][] var1) {
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            this.snakes.add(new Snake(var1[var3][0], var1[var3][1]));
        }
    }

    public void setJackies(int[] jack) {
        int var2 = jack.length;

        for(int var3 = 0; var3 < var2; var3 += 2) {
            this.jackies.add(new Jackpot(jack[var3], jack[var3 + 1]));
        }
    }

    public void setChallanges(Challange[] challanges) {
        for (Challange challange : challanges) {
            this.challanges.add(challange);
        }
    }

    public void setSpringTraps(int[] positions) {
        for (int position : positions) {
            this.springTraps.add(new SpringTrap(position));
        }
    }



    public String getWinner() {
        if (this.gameStatus == 0) {
            return "The game is not over yet";
        } else {
            return ((Player)this.players.get(0)).getPosition() == 100 ? ((Player)this.players.get(0)).getName() : ((Player)this.players.get(1)).getName();
        }
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public ArrayList<Snake> getSnakes() {
        return this.snakes;
    }

    public ArrayList<Ladder> getLadders() {
        return this.ladders;
    }

    public ArrayList<Jackpot> getJackpot() {
        return this.jackies;
    }

    public ArrayList<Challange> getChallanges() {
        return this.challanges;
    }

    public ArrayList<SpringTrap> getSpringTraps() {
        return this.springTraps;
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public int getGameStatus() {
        return this.gameStatus;
    }

    public void movePlayer(Player var1, int var2) {
        this.gameStatus = 1;
        var1.moveAround(var2);
        Iterator var3 = this.ladders.iterator();

        PrintStream var10000;
        String var10001;
        while(var3.hasNext()) {
            Ladder var4 = (Ladder)var3.next();
            if (var4.getFromPosition() == var1.getPosition()) {
                var1.setPosition(var4.getToPosition());
                var10000 = System.out;
                var10001 = var1.getName();
                var10000.println(var10001 + " got ladder so jumps to " + var1.getPosition());
            }
        }

        var3 = this.snakes.iterator();

        while(var3.hasNext()) {
            Snake var5 = (Snake)var3.next();
            if (var5.getHead() == var1.getPosition()) {
                var1.setPosition(var5.getTail());
                var10000 = System.out;
                var10001 = var1.getName();
                var10000.println(var10001 + " got snake so slides to " + var1.getPosition());
            }
        }

        var3 = this.jackies.iterator();
        while(var3.hasNext()) {
            Jackpot var6 = (Jackpot)var3.next();
            if (var6.getFromPosition() == var1.getPosition()) {
                var1.setPosition(var6.getToPosition());
                var10000 = System.out;
                var10001 = var1.getName();
                var10000.println(var10001 + " got jackpot so jumps to " + var1.getPosition());
            }
        }

        var3 = this.challanges.iterator();
        while(var3.hasNext()) {
            Challange var7 = (Challange)var3.next();
            if (var7.getFromPosition() == var1.getPosition()) {
                boolean correctAnswer = var7.askQuestion();
                if (correctAnswer) {
                    var1.setPosition(var7.getToPosition());
                    var10000 = System.out;
                    var10001 = var1.getName();
                    var10000.println(var10001 + " answered correctly so jumps to " + var1.getPosition());
                } else {
                    var10000 = System.out;
                    var10001 = var1.getName();
                    var10000.println(var10001 + " answered incorrectly and stays at " + var1.getPosition());
                }
            }
        }

        var3 = this.springTraps.iterator();
        while(var3.hasNext()) {
            SpringTrap springTrap = (SpringTrap)var3.next();
            if (springTrap.getPosition() == var1.getPosition()) {
                var1.setPosition(var1.getPosition() - 5);
                var10000 = System.out;
                var10001 = var1.getName();
                var10000.println(var10001 + " landed on a SpringTrap and goes back to " + var1.getPosition());
            }
        }


        if (var1.getPosition() == this.boardSize) {
            this.gameStatus = 2;
        }
    }

}
