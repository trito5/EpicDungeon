public class MovingNodeXY extends NodeXY{
    private int previousX;
    private int previousY;
    private final int startValueX;
    private final int startValueY;
    private int counter = 0;
    private int stopValueX;
    private int stopValueY;

    public MovingNodeXY(int x, int y){
        super(x,y);
        startValueX = x;
        startValueY = y;

    }
    public MovingNodeXY(int x, int y, int startX, int startY, int stopValueX, int stopValueY){
        super(x, y);
        startValueX = startX;
        startValueY = startY;
        this.stopValueX = stopValueX;
        this.stopValueY = stopValueY;
    }

    public int getStopValueX() {
        return stopValueX;
    }

    public void setStopValueX(int stopValueX) {
        this.stopValueX = stopValueX;
    }

    public int getStopValueY() {
        return stopValueY;
    }

    public void setStopValueY(int stopValueY) {
        this.stopValueY = stopValueY;
    }

    public int getStartValueX() {
        return startValueX;
    }

    public int getStartValueY() {
        return startValueY;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getPreviousX() {
        return previousX;
    }

    public void setPreviousX(int previousX) {
        this.previousX = previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public void setPreviousY(int previousY) {
        this.previousY = previousY;
    }

    public void moveLeft(){
        previousX = getX();
        previousY = getY();
        setX(getX() -1);
    }

    public void moveRight(){
        previousX = getX();
        previousY = getY();
        setX(getX()+1);
    }

    public void moveUp(){
        previousX = getX();
        previousY = getY();
        setY(getY()-1);
    }

    public void moveDown(){
        previousX = getX();
        previousY = getY();
        setY(getY()+1);
    }

}
