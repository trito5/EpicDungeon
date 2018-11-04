import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<Brick> walls = new ArrayList<>();
    private List<Bomb> bombs = new ArrayList<>();
    private List<MovingWallNode> movingWall = new ArrayList<>();
    private List<RandomMob> randomMobs = new ArrayList<>();
    private List<BlinkingBomb> blinkingBombs = new ArrayList<>();
    private List<Rain> rainList = new ArrayList<>();
    private String name;

    public List<Rain> getRainList() {
        return rainList;
    }

    public void setRainList(List<Rain> rainList) {
        this.rainList = rainList;
    }

    public List<BlinkingBomb> getBlinkingBombs() {
        return blinkingBombs;
    }

    public void setBlinkingBombs(List<BlinkingBomb> blinkingBombs) {
        this.blinkingBombs = blinkingBombs;
    }

    public List<MovingWallNode> getMovingWall() {
        return movingWall;
    }

    public List<RandomMob> getRandomMobs() {
        return randomMobs;
    }

    public void setRandomMobs(List<RandomMob> randomMobs) {
        this.randomMobs = randomMobs;
    }

    public void setMovingWall(List<MovingWallNode> movingWall) {
        this.movingWall = movingWall;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public List<Brick> getWalls() {
        return walls;
    }

    public void setWalls(List<Brick> walls) {
        this.walls = walls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
