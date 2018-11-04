public class MovingWallHole extends MovingNodeXY {

    public MovingWallHole(int x, int y){
        super(x, y);
        setSymbol('\u2620');
        setStartValueX(13);
        setStopValueX(39);
        setPreviousY(getY());
    }

    @Override
    public void moveLeft() {

        if (this.getX() == getStopValueX()){
            setX(getStartValueX());
            setPreviousX(getStopValueX());
        } else {
            setPreviousX(getX());
            setX(getX() + 1);
        }
    }
}
