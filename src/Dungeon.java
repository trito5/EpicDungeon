import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<Brick> walls = new ArrayList<>();
    private String name;

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
