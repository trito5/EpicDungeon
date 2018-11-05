public class Skull extends MovingNodeXY {

    public Skull (int x, int y){
        super(x, y);
        setSymbol('\u2620');
        this.setStartValueY(3);
        this.setStopValueY(7);
        this.setPreviousX(x);
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

    public void move(int i) {
        if (this.getY() == getStopValueY() || this.getY() == getStartValueY()) {
            i = i * -1;
        }
        setPreviousY(getY());
        setY(getY() + i);
    }
}
