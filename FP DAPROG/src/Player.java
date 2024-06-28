public class Player {
    private String name;
    private int position = 0;

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int rollDice() {
        return (int) (Math.random() * 6.0) + 1;
    }

    public void moveAround(int steps) {
        if (this.position + steps > 100) {
            this.position = 100 - (this.position + steps - 100);
        } else {
            this.position += steps;
        }
    }

    public void moveForward(int steps) {
        this.position += steps;
        if (this.position > 100) {
            this.position = 100;
        }
    }

    public void moveBackward(int steps) {
        this.position -= steps;
        if (this.position < 0) {
            this.position = 0;
        }
    }
}
