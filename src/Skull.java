public class Skull extends MovingNodeXY {

    private int direction;

    public Skull (int x, int y){
        super(x, y);
        setSymbol('\u2620');
        this.setStartValueY(3);
        this.setStopValueY(7);
        this.setPreviousX(x);
        this.direction = 1;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void moveDown() {

        if (this.getY() == getStopValueY()){
            setPreviousY(getY());
            setY(getY() - 1);
        } else {
            setPreviousY(getY());
            setY(getY() + 1);
        }
    }

    @Override
    public void moveUp() {

        if (this.getY() == getStartValueY()){
            setPreviousY(getY());
            moveDown();
        } else {
            setPreviousY(getY());
            setY(getY() - 1);
        }
    }

    public void move() {

        if (this.getY() == getStopValueY()) {
            direction = -1;
        }
        if (this.getY() == getStartValueY()) {
            direction = 1;
        }
        setPreviousY(getY());
        setY(getY() + direction);



    }
}
