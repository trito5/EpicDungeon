public class Rain extends MovingNodeXY {



    public Rain(int x, int y) {
        super(x, y);
        this.setStopValueY(13);
        this.setStartValueY(9);
        setSymbol('\u26A1');
        setPreviousX(x);

    }

    public Rain(int x, int y, int startX, int startY, int stopX, int stopY) {
        super(x, y, startX, startY, stopX, stopY);

    }

    @Override
    public void moveDown() {
       /* if (getCounter() < this.getStopValueY()) {
            setPreviousX(getX());
            setPreviousY(getY());
            setY(getY() + 1);
            setCounter(getCounter() + 1);
        } else {
            setCounter(0);
            setPreviousY(getY());
            setY(getStartValueY());

        }*/
       if (this.getY() == getStopValueY()){
           setY(getStartValueY());
           setPreviousY(getStopValueY());
       } else {
           setPreviousY(getY());
           setY(getY() + 1);
       }
    }

  /*  public void moveToStartPosition(){
        setPreviousY(getStartValueY();
        setY(getStartValueY());
    }*/

}
