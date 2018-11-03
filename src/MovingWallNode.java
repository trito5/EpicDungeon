public class MovingWallNode extends MovingNodeXY{

    public MovingWallNode(int x, int y){
        super(x,y);
        this.setStopValueX(18);
        setSymbol('\u2702');
    }

    public MovingWallNode(int x, int y, int startX, int startY, int stopX, int stopY){
        super(x,y,startX,startY, stopX, stopY);
        setSymbol('\u2702');
    }

    @Override
    public void moveLeft(){

        setPreviousX(getX());
        setPreviousY(getY());
        setX(getX() -1);
    }

    @Override
    public void moveRight(){
        if (getCounter() < this.getStopValueX()){
            setPreviousX(getX());
            setPreviousY(getY());
            setX(getX()+1);
            setCounter(getCounter() + 1);
        } else {
            setCounter(0);
            setPreviousX(getX());
            setX(getStartValueX());

        }


    }

}
