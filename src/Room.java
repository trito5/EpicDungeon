public class Room {
    private RoomType roomType;
    private int x;
    private int y;
    private char symbol = 'X';
    private int previousX;
    private int previousY;
    private final int width = 19;
    private final int height = 8;


    public Room(){
        roomType = RoomType.FOURWAY;
    }

    public Room(RoomType roomType, int x, int y) {
        this.roomType = roomType;
        this.x = x;
        this.y = y;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
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

    public Room(RoomType roomType) {
        this.roomType = roomType;
    }

   /* public String drawRoom(){

    }*/
}
