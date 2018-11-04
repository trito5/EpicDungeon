import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        //Player player = new Player(6, 17, '\u263a');
        Player player = new Player(71, 11, '\u263a');
        Dungeon dungeonOne = new Dungeon();
        List<Brick> walls = createDungeon();
        List<Bomb> bombs = createBombs();
        List<BlinkingBomb> blinkingBombs = createBlinknigBombs();
        List<RandomMob> randomMobs = createRandomMobs();
        List<MovingWallNode> movingWall1 = createMovingWall();
        List<Rain> rainList = createRain();

        createDoors(walls);

        dungeonOne.setWalls(walls);
        dungeonOne.setBombs(bombs);
        dungeonOne.setMovingWall(movingWall1);
        dungeonOne.setRandomMobs(randomMobs);
        dungeonOne.setBlinkingBombs(blinkingBombs);
        dungeonOne.setRainList(rainList);

        drawCharacters(terminal, player, dungeonOne);

        do {
            KeyStroke keyStroke = getUserKeyStroke(terminal);

            movePlayer(player, keyStroke, walls);
            moveObjects(dungeonOne);


            drawCharacters(terminal, player, dungeonOne);


        } while (!isPlayerDead(player, dungeonOne));
        drawGameOver(terminal);
    }

    private static List<BlinkingBomb> createBlinknigBombs() {
        List<BlinkingBomb> list = new ArrayList<>();
        list.add(new BlinkingBomb(65, 9));
        list.add(new BlinkingBomb(62, 11));
        list.add(new BlinkingBomb(65, 13));
        list.add(new BlinkingBomb(70, 11));
        list.add(new BlinkingBomb(69, 12));
        list.add(new BlinkingBomb(68, 12));
        list.add(new BlinkingBomb(68, 10));
        list.add(new BlinkingBomb(67, 11));
        list.add(new BlinkingBomb(70, 12));
        list.add(new BlinkingBomb(66, 12));
        list.add(new BlinkingBomb(68, 10));
        list.add(new BlinkingBomb(65, 13));
        list.add(new BlinkingBomb(68, 11));
        list.add(new BlinkingBomb(63, 11));
        list.add(new BlinkingBomb(70, 10));
        list.add(new BlinkingBomb(69, 11));
        list.add(new BlinkingBomb(69, 12));
        list.add(new BlinkingBomb(76, 12));
        list.add(new BlinkingBomb(73, 9));
        list.add(new BlinkingBomb(74, 13));
        list.add(new BlinkingBomb(76, 10));
        list.add(new BlinkingBomb(75, 12));
        list.add(new BlinkingBomb(75, 13));
        list.add(new BlinkingBomb(74, 11));
        list.add(new BlinkingBomb(75, 9));
        return list;
    }

    private static List<Bomb> createBombs() {
        List<Bomb> bombs = new ArrayList<>();
        bombs.add(new Bomb(13, 16));
        bombs.add(new Bomb(13, 17));
        bombs.add(new Bomb(13, 18));
        bombs.add(new Bomb(13, 19));

        //bombs.add(new Bomb(14,18));

        //bombs.add(new Bomb(14,18));
        // bombs.add(new Bomb(14,19));
        bombs.add(new Bomb(16, 18));
        bombs.add(new Bomb(16, 17));
        bombs.add(new Bomb(16, 16));
        bombs.add(new Bomb(16, 15));
        bombs.add(new Bomb(17, 18));
        bombs.add(new Bomb(18, 18));
        bombs.add(new Bomb(19, 18));
        bombs.add(new Bomb(20, 18));
        bombs.add(new Bomb(19, 16));
        bombs.add(new Bomb(20, 16));
        bombs.add(new Bomb(21, 16));
        bombs.add(new Bomb(22, 16));
        bombs.add(new Bomb(23, 19));
        bombs.add(new Bomb(23, 18));
        bombs.add(new Bomb(23, 17));
        bombs.add(new Bomb(23, 16));
        bombs.add(new Bomb(26, 15));
        bombs.add(new Bomb(26, 16));
        bombs.add(new Bomb(26, 17));
        bombs.add(new Bomb(26, 18)); 
        bombs.add(new Bomb(29, 18));

        return bombs;
    }

    private static List<RandomMob> createRandomMobs() {
        List<RandomMob> list = new ArrayList<>();
        list.add(new RandomMob(60, 17));
        list.add(new RandomMob(70, 19));
        list.add(new RandomMob(55, 16));
        list.add(new RandomMob(7,12));
        list.add(new RandomMob(25,12));
        return list;
    }

    private static List<MovingWallNode> createMovingWall() {
        List<MovingWallNode> list = new ArrayList<>();
        list.add(new MovingWallNode(31, 15));
        list.add(new MovingWallNode(31, 16));
        list.add(new MovingWallNode(31, 17));
        list.add(new MovingWallNode(31, 18));
        list.add(new MovingWallNode(31, 19));


        return list;
    }

    private static void createDoors(List<Brick> dungeon) {

        for (int i = 0; i < dungeon.size(); i++) {
            if (dungeon.get(i).getX() == 70 && dungeon.get(i).getY() == 14) {
                dungeon.remove(dungeon.get(i));
            }
            if (dungeon.get(i).getX() == 9 && dungeon.get(i).getY() == 8) {
                dungeon.remove(dungeon.get(i));
            }
        }
        /*doorList.add(new Door(70,8));
        for (int i = 0; i < dungeon.size(); i++) {
            if (dungeon.get(i).getX() == 70 && dungeon.get(i).getY() == 14)
                dungeon.remove(dungeon.get(i));
        }*/

    }

    private static List<Rain> createRain() {
        List<Rain> rainList = new ArrayList<>();
        rainList.add(new Rain(33, 9));
        rainList.add(new Rain( 36, 11));
        rainList.add(new Rain(39,12));
        rainList.add(new Rain(43, 9));
        rainList.add(new Rain(46, 10));
        rainList.add(new Rain(50,12));
        rainList.add(new Rain(53,11));
        rainList.add(new Rain(57,9));
        rainList.add(new Rain(59,12));


        return rainList;
    }

    private static List<Brick> createDungeon() {
        List<Brick> wallList = new ArrayList<>();

        for (int i = 2; i < 77; i++) {
            wallList.add(new Brick(i, 20));
            wallList.add(new Brick(i, 14));
            wallList.add(new Brick(i, 8));
            wallList.add(new Brick(i, 2));
        }

        for (int i = 2; i <= 20; i++) {
            wallList.add(new Brick(2, i));
            wallList.add(new Brick(76, i));
        }

        wallList.add(new Brick(10, 19));
        wallList.add(new Brick(10, 18));
        wallList.add(new Brick(10, 16));
        wallList.add(new Brick(10, 15));

        wallList.add(new Brick(30, 19));
        wallList.add(new Brick(30, 18));
        wallList.add(new Brick(30, 16));
        wallList.add(new Brick(30, 15));

        wallList.add(new Brick(50, 19));
        wallList.add(new Brick(50, 18));
        wallList.add(new Brick(50, 16));
        wallList.add(new Brick(50, 15));

        wallList.add(new Brick(60, 13));
        wallList.add(new Brick(60, 12));
        wallList.add(new Brick(60, 10));
        wallList.add(new Brick(60, 9));

        wallList.add(new Brick(30, 13));
        wallList.add(new Brick(30, 12));
        wallList.add(new Brick(30, 10));
        wallList.add(new Brick(30, 9));

        wallList.add(new Brick(20, 13));
        wallList.add(new Brick(20, 12));
        wallList.add(new Brick(20, 11));
        wallList.add(new Brick(20, 10));

        wallList.add(new Brick(10, 12));
        wallList.add(new Brick(10, 11));
        wallList.add(new Brick(10, 10));
        wallList.add(new Brick(10, 9));

        wallList.add(new Brick(14, 7));
        wallList.add(new Brick(14, 6));
        wallList.add(new Brick(14, 4));
        wallList.add(new Brick(14, 3));



        return wallList;

    }

    private static boolean isWallInTheWay(int x, int y, List<Brick> dungeon) {
        for (Brick brick : dungeon) {
            if (x == brick.getX() && y == brick.getY()) {
                return true;
            }
        }
        return false;
    }

    private static void moveObjects(Dungeon dungeon) {
        for (MovingWallNode mvn : dungeon.getMovingWall()) {
            mvn.moveRight();
        }
        for (RandomMob rm : dungeon.getRandomMobs()) {
            Random random = new Random();
            switch (random.nextInt(4) + 1) {
                case 1:
                    if (!isWallInTheWay(rm.getX() + 1, rm.getY(), dungeon.getWalls()))
                        rm.moveRight();
                    break;
                case 2:
                    if (!isWallInTheWay(rm.getX() - 1, rm.getY(), dungeon.getWalls()))
                        rm.moveLeft();
                    break;
                case 3:
                    if (!isWallInTheWay(rm.getX(), rm.getY() + 1, dungeon.getWalls()))
                        rm.moveDown();
                    break;
                case 4:
                    if (!isWallInTheWay(rm.getX(), rm.getY() - 1, dungeon.getWalls()))
                        rm.moveUp();
                    break;
            }
        }

        for (BlinkingBomb blinkingBomb : dungeon.getBlinkingBombs()) {
            blinkingBomb.blink();
        }

        for (Rain rain : dungeon.getRainList()) {
            rain.moveDown();

        }
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
                if (!isWallInTheWay(player.getX() - 1, player.getY(), dungeon)) {
                    player.moveLeft();
                }
                break;
            case ArrowRight:
                if (!isWallInTheWay(player.getX() + 1, player.getY(), dungeon)) {
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

    private static void drawCharacters(Terminal terminal, Player player, Dungeon dungeon) throws IOException {

        terminal.setCursorPosition(30,1);
        terminal.putCharacter('E');
        terminal.setCursorPosition(31,1);
        terminal.putCharacter('P');
        terminal.setCursorPosition(32,1);
        terminal.putCharacter('I');
        terminal.setCursorPosition(33,1);
        terminal.putCharacter('C');
        terminal.setCursorPosition(35,1);
        terminal.putCharacter('D');
        terminal.setCursorPosition(36,1);
        terminal.putCharacter('U');
        terminal.setCursorPosition(37,1);
        terminal.putCharacter('N');
        terminal.setCursorPosition(38,1);
        terminal.putCharacter('G');
        terminal.setCursorPosition(39,1);
        terminal.putCharacter('E');
        terminal.setCursorPosition(40,1);
        terminal.putCharacter('O');
        terminal.setCursorPosition(41,1);
        terminal.putCharacter('N');
        terminal.setCursorPosition(38,1);




        terminal.setCursorPosition(player.getPreviousX(), player.getPreviousY());
        terminal.putCharacter(' ');

        terminal.setCursorPosition(player.getX(), player.getY());
        terminal.putCharacter(player.getSymbol());

        for (BlinkingBomb blinkingBomb : dungeon.getBlinkingBombs()) {
            if (blinkingBomb.isVisible()) {
                terminal.setCursorPosition(blinkingBomb.getX(), blinkingBomb.getY());
                terminal.putCharacter(blinkingBomb.getSymbol());
            } else {
                terminal.setCursorPosition(blinkingBomb.getX(), blinkingBomb.getY());
                terminal.putCharacter(' ');
            }

        }

        for (Brick brick : dungeon.getWalls()) {
            terminal.setCursorPosition(brick.getX(), brick.getY());
            terminal.putCharacter(brick.getSymbol());
        }

        for (Bomb bomb : dungeon.getBombs()) {
            terminal.setCursorPosition(bomb.getX(), bomb.getY());
            terminal.putCharacter(bomb.getSymbol());
        }

        for (MovingWallNode mvn : dungeon.getMovingWall()) {
            terminal.setCursorPosition(mvn.getPreviousX(), mvn.getPreviousY());
            terminal.putCharacter(' ');

            terminal.setCursorPosition(mvn.getX(), mvn.getY());
            terminal.putCharacter(mvn.getSymbol());
        }

        for (RandomMob rm : dungeon.getRandomMobs()) {
            if (rm.getPreviousX() == player.getX() && rm.getPreviousY() == player.getY()) {

            } else {
                terminal.setCursorPosition(rm.getPreviousX(), rm.getPreviousY());
                terminal.putCharacter(' ');
            }

            terminal.setCursorPosition(rm.getX(), rm.getY());
            terminal.putCharacter(rm.getSymbol());
        }

        for (Rain rain : dungeon.getRainList()) {
            if (rain.getPreviousX() == player.getX() && rain.getPreviousY() == player.getY()) {

            } else {
                terminal.setCursorPosition(rain.getPreviousX(), rain.getPreviousY());
                terminal.putCharacter(' ');
            }

            terminal.setCursorPosition(rain.getX(), rain.getY());
            terminal.putCharacter(rain.getSymbol());
        }


        terminal.flush();
    }

    private static boolean isPlayerDead(Player player, Dungeon dungeon) {
        for (Bomb bomb : dungeon.getBombs()) {
            if (player.getX() == bomb.getX() && player.getY() == bomb.getY()) {
                return true;
            }
        }

        for (MovingWallNode mvn : dungeon.getMovingWall()) {
            if (player.getX() == mvn.getX() && player.getY() == mvn.getY()) {
                return true;
            }
        }

        for (RandomMob rm : dungeon.getRandomMobs()) {
            if (player.getX() == rm.getX() && player.getY() == rm.getY()) {
                return true;
            }
        }

        for (BlinkingBomb blinkingBomb : dungeon.getBlinkingBombs()) {
            if (player.getX() == blinkingBomb.getX() && player.getY() == blinkingBomb.getY() && blinkingBomb.isVisible()) {
                return true;
            }
        }


        for (Rain rain : dungeon.getRainList()){
            if (player.getX() == rain.getX() && player.getY() == rain.getY()) {
                return true;
            }
        }
        return false;
    }

    private static void drawGameOver(Terminal terminal) throws IOException {
        terminal.clearScreen();
        terminal.setCursorPosition(33, 10);
        terminal.putCharacter('G');
        terminal.setCursorPosition(34, 10);
        terminal.putCharacter('A');
        terminal.setCursorPosition(35, 10);
        terminal.putCharacter('M');
        terminal.setCursorPosition(36, 10);
        terminal.putCharacter('E');
        terminal.setCursorPosition(38, 10);
        terminal.putCharacter('O');
        terminal.setCursorPosition(39, 10);
        terminal.putCharacter('V');
        terminal.setCursorPosition(40, 10);
        terminal.putCharacter('E');
        terminal.setCursorPosition(41, 10);
        terminal.putCharacter('R');
        terminal.flush();

    }


}
