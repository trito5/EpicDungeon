import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            startGame();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println("Game over!");
        }
    }

    private static void startGame() throws IOException, InterruptedException {
        Terminal terminal = createTerminal();
        Player player = new Player(10, 17, '\u263a');
        List<Brick> dungeon = createDungeon();
        dungeon = createDoors(dungeon);
        //List<Door> doors = createDoors(dungeon);

        drawCharacters(terminal, player, dungeon);

        do {
            KeyStroke keyStroke = getUserKeyStroke(terminal);

            movePlayer(player, keyStroke, dungeon);


            drawCharacters(terminal, player, dungeon);
            //drawRoom();

        } while (true);

    }
    private static List<Brick> createDoors(List<Brick> dungeon){

        for (int i = 0; i < dungeon.size(); i++) {
            if (dungeon.get(i).getX() == 70 && dungeon.get(i).getY() == 14){
                dungeon.remove(dungeon.get(i));
            }
            if (dungeon.get(i).getX() == 9 && dungeon.get(i).getY() == 8){
                dungeon.remove(dungeon.get(i));
            }
        }
        /*doorList.add(new Door(70,8));
        for (int i = 0; i < dungeon.size(); i++) {
            if (dungeon.get(i).getX() == 70 && dungeon.get(i).getY() == 14)
                dungeon.remove(dungeon.get(i));
        }*/
        return dungeon;
    }

    private static List<Brick> createDungeon() {
        List<Brick> wallList = new ArrayList<>();
       // Room room = new Room(RoomType.FOURWAY, 1, 20);
        //roomList.add(room);
        for (int i = 2; i < 77; i++) {
            wallList.add(new Brick(i,20));
            wallList.add(new Brick(i, 14));
            wallList.add(new Brick(i,8));
            wallList.add(new Brick(i,2));
        }

        for (int i = 2; i <= 20; i++){
            wallList.add(new Brick(2, i));
            wallList.add(new Brick(76, i));
        }


        return wallList;

    }

    private static boolean isWallInTheWay(int x, int y, List<Brick> dungeon) {
        for (Brick brick : dungeon) {
            if (x == brick.getX() && y == brick.getY()){
                return true;
            }
        }
        return false;
    }

    private static void movePlayer(Player player, KeyStroke keyStroke, List<Brick> dungeon) {
        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                if (!isWallInTheWay(player.getX(), player.getY() - 1, dungeon)) {
                    player.moveUp();
                }
                break;
            case ArrowDown:
                if (!isWallInTheWay(player.getX(), player.getY() + 1, dungeon)) {
                    player.moveDown();
                }
                break;
            case ArrowLeft:
                if (!isWallInTheWay(player.getX()-1, player.getY(), dungeon)) {
                    player.moveLeft();
                }
                break;
            case ArrowRight:
                if (!isWallInTheWay(player.getX()+1, player.getY(), dungeon)) {
                    player.moveRight();
                }
                break;
        }
    }

    private static KeyStroke getUserKeyStroke(Terminal terminal) throws InterruptedException, IOException {
        KeyStroke keyStroke;
        do {
            Thread.sleep(5);
            keyStroke = terminal.pollInput();
        } while (keyStroke == null);
        return keyStroke;
    }

    private static Terminal createTerminal() throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        return terminal;
    }

    private static void drawCharacters(Terminal terminal, Player player, List<Brick> walls) throws IOException {

        terminal.setCursorPosition(player.getPreviousX(), player.getPreviousY());
        terminal.putCharacter(' ');

        terminal.setCursorPosition(player.getX(), player.getY());
        terminal.putCharacter(player.getSymbol());

        for (Brick brick : walls) {
            terminal.setCursorPosition(brick.getX(),brick.getY());
            terminal.putCharacter(brick.getSymbol());
        }

        terminal.flush();
    }


}
