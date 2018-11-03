public class BlinkingBomb extends Bomb {
    private boolean isVisible = true;

    public BlinkingBomb(int x, int y){
        super(x, y);
        this.setSymbol('\u2622');
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void blink(){
        isVisible = !isVisible;
    }
}
