import org.w3c.dom.Node;

public class Brick extends NodeXY{


    public Brick(int x, int y){
        super(x,y);
        this.setSymbol('\u25AE');
    }

}

/*public class Brick {
    private int x;
    private int y;
    private char symbol = 'X';

    public Brick(int x, int y){
        this.y = y;
        this.x = x;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}*/
