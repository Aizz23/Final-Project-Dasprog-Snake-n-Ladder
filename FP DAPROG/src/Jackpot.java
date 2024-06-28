class Jackpot{
    private int fromPosition;
    private int toPosition;

    public Jackpot(int po1, int po2){
        this.fromPosition = po1;
        this.toPosition = po2;
    }

    void setFromPosition(int po1){
        this.fromPosition = po1;
    }

    void setToPosition(int po2){
        this.toPosition = po2;
    }
    int getFromPosition(){
        return this.fromPosition;
    }

    int getToPosition(){
        return this.toPosition;
    }





}