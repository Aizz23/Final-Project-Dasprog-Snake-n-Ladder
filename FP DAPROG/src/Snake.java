

public class Snake {
    private int head;
    private int tail;

    Snake(int var1, int var2) {
        this.head = var1;
        this.tail = var2;
    }

    void setTail(int var1) {
        this.tail = var1;
    }

    void setHead(int var1) {
        this.head = var1;
    }

    int getTail() {
        return this.tail;
    }

    int getHead() {
        return this.head;
    }
}
