import com.googlecode.lanterna.TextColor;
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
        Player player = new Player(6, 17, '\u263a');
        //Player player = new Player(40, 5, '\u263a');
        Dungeon dungeonOne = new Dungeon();
        List<Brick> walls = createDungeon();
        List<Bomb> bombs = createBombs();
        List<BlinkingBomb> blinkingBombs = createBlinknigBombs();
        List<RandomMob> randomMobs = createRandomMobs();
        List<MovingWallNode> movingWall1 = createMovingWall();
        List<Rain> rainList = createRain();
        List<MovingWallHole> wallHoles = createWallHole();
        List<Fire> fires = createFire();
        List<Skull> skulls = createSkulls();
        Finish finish = new Finish(72, 5);

        createDoors(walls);

        dungeonOne.setWalls(walls);
        dungeonOne.setBombs(bombs);
        dungeonOne.setMovingWall(movingWall1);
        dungeonOne.setRandomMobs(randomMobs);
        dungeonOne.setBlinkingBombs(blinkingBombs);
        dungeonOne.setRainList(rainList);
        dungeonOne.setMovingWallHole(wallHoles);
        dungeonOne.setFinish(finish);
        dungeonOne.setFires(fires);
        dungeonOne.setSkulls(skulls);

        drawCharacters(terminal, player, dungeonOne);

        do {
            KeyStroke keyStroke = getUserKeyStroke(terminal);

            movePlayer(player, keyStroke, walls);
            moveObjects(dungeonOne);
            drawCharacters(terminal, player, dungeonOne);
            if (isPlayerAtFinish(player, dungeonOne)){
                break;
            }

        } while (!isPlayerDead(player, dungeonOne));
        if (isPlayerAtFinish(player, dungeonOne)){
            drawFinish(terminal);
        } else {
            drawGameOver(terminal);
        }
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

        list.add(new BlinkingBomb(10, 5));
        list.add(new BlinkingBomb(8, 5));
        list.add(new BlinkingBomb(6, 3));
        list.add(new BlinkingBomb(8, 3));
        list.add(new BlinkingBomb(10, 3));
        list.add(new BlinkingBomb(12, 3));

        return list;
    }

    private static List<Fire> createFire(){
        List<Fire> fires = new ArrayList<>();
        fires.add(new Fire(42,4));
        fires.add(new Fire(42,5));
        fires.add(new Fire(42,6));
        fires.add(new Fire(44,3));
        fires.add(new Fire(44,4));
        fires.add(new Fire(44,6));
        fires.add(new Fire(44,7));
        fires.add(new Fire(46,4));
        fires.add(new Fire(46,5));
        fires.add(new Fire(46,6));
        fires.add(new Fire(46,7));
        fires.add(new Fire(48,3));
        fires.add(new Fire(48,4));
        fires.add(new Fire(48,5));
        fires.add(new Fire(48,6));

        return  fires;
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

        //bombs.add(new Bomb(12,6));
        bombs.add(new Bomb(11, 6));
        bombs.add(new Bomb(10, 6));
        bombs.add(new Bomb(9, 6));
        bombs.add(new Bomb(8, 6));
        bombs.add(new Bomb(8, 7));

        // bombs.add(new Bomb(6,6));
        bombs.add(new Bomb(5, 6));
        bombs.add(new Bomb(5, 5));
        bombs.add(new Bomb(5, 4));

        bombs.add(new Bomb(6, 4));
        bombs.add(new Bomb(7, 4));
        bombs.add(new Bomb(8, 4));
        bombs.add(new Bomb(9, 4));
        bombs.add(new Bomb(10, 4));
        bombs.add(new Bomb(11, 4));
        bombs.add(new Bomb(12, 4));
        bombs.add(new Bomb(13, 4));



        return bombs;
    }

    private static List<RandomMob> createRandomMobs() {
        List<RandomMob> list = new ArrayList<>();
        list.add(new RandomMob(60, 17));
        list.add(new RandomMob(70, 19));
        list.add(new RandomMob(55, 16));
        list.add(new RandomMob(7, 12));
        list.add(new RandomMob(25, 12));
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
        rainList.add(new Rain(36, 11));
        rainList.add(new Rain(39, 12));
        rainList.add(new Rain(43, 9));
        rainList.add(new Rain(46, 10));
        rainList.add(new Rain(50, 12));
        rainList.add(new Rain(53, 11));
        rainList.add(new Rain(57, 9));
        rainList.add(new Rain(59, 12));


        return rainList;
    }

    private static List<Skull> createSkulls(){
        List<Skull> skulls = new ArrayList<>();
        skulls.add(new Skull(52,3));
        skulls.add(new Skull(56,6));
        skulls.add(new Skull(58,3));
        skulls.add(new Skull(62,7));
        skulls.add(new Skull(64,5));
        return skulls;
    }

    private static List<MovingWallHole> createWallHole() {
        List<MovingWallHole> wallHoles = new ArrayList<>();
        wallHoles.add(new MovingWallHole(39, 3));
        wallHoles.add(new MovingWallHole(39, 4));
        wallHoles.add(new MovingWallHole(39, 6));
        wallHoles.add(new MovingWallHole(39, 7));

        wallHoles.add(new MovingWallHole(35, 4));
        wallHoles.add(new MovingWallHole(35, 5));
        wallHoles.add(new MovingWallHole(35, 6));
        wallHoles.add(new MovingWallHole(35, 7));

        wallHoles.add(new MovingWallHole(30, 3));
        wallHoles.add(new MovingWallHole(30, 5));
        wallHoles.add(new MovingWallHole(30, 6));
        wallHoles.add(new MovingWallHole(30, 7));

        wallHoles.add(new MovingWallHole(25, 3));
        wallHoles.add(new MovingWallHole(25, 4));
        wallHoles.add(new MovingWallHole(25, 5));
        wallHoles.add(new MovingWallHole(25, 6));

        wallHoles.add(new MovingWallHole(19, 3));
        wallHoles.add(new MovingWallHole(19, 5));
        wallHoles.add(new MovingWallHole(19, 6));
        wallHoles.add(new MovingWallHole(19, 7));
        return wallHoles;
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

        wallList.add(new Brick(14, 4));
        wallList.add(new Brick(14, 5));
        wallList.add(new Brick(14, 6));
        wallList.add(new Brick(14, 7));

        wallList.add(new Brick(40, 3));
        wallList.add(new Brick(40, 4));
        wallList.add(new Brick(40, 6));
        wallList.add(new Brick(40, 7));

        wallList.add(new Brick(50,3));
        wallList.add(new Brick(50,4));
        wallList.add(new Brick(50,6));
        wallList.add(new Brick(50,7));

        wallList.add(new Brick(68,3));
        wallList.add(new Brick(68,4));
        wallList.add(new Brick(68,6));
        wallList.add(new Brick(68,7));


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

        for (Skull skull : dungeon.getSkulls()) {
            skull.move();
        }

        for (MovingWallHole mvh : dungeon.getMovingWallHole()) {
            mvh.moveLeft();
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
        terminal.setForegroundColor(TextColor.ANSI.WHITE);
        terminal.setCursorPosition(30, 1);
        terminal.putCharacter('E');
        terminal.setCursorPosition(31, 1);
        terminal.putCharacter('P');
        terminal.setCursorPosition(32, 1);
        terminal.putCharacter('I');
        terminal.setCursorPosition(33, 1);
        terminal.putCharacter('C');
        terminal.setCursorPosition(35, 1);
        terminal.putCharacter('D');
        terminal.setCursorPosition(36, 1);
        terminal.putCharacter('U');
        terminal.setCursorPosition(37, 1);
        terminal.putCharacter('N');
        terminal.setCursorPosition(38, 1);
        terminal.putCharacter('G');
        terminal.setCursorPosition(39, 1);
        terminal.putCharacter('E');
        terminal.setCursorPosition(40, 1);
        terminal.putCharacter('O');
        terminal.setCursorPosition(41, 1);
        terminal.putCharacter('N');
        terminal.setCursorPosition(38, 1);


        terminal.setForegroundColor(TextColor.ANSI.WHITE);
        terminal.setCursorPosition(player.getPreviousX(), player.getPreviousY());
        terminal.putCharacter(' ');

        terminal.setCursorPosition(player.getX(), player.getY());
        terminal.putCharacter(player.getSymbol());
        terminal.setForegroundColor(TextColor.ANSI.GREEN);
        for (BlinkingBomb blinkingBomb : dungeon.getBlinkingBombs()) {
            if (blinkingBomb.isVisible()) {
                terminal.setCursorPosition(blinkingBomb.getX(), blinkingBomb.getY());
                terminal.putCharacter(blinkingBomb.getSymbol());
            } else {
                terminal.setCursorPosition(blinkingBomb.getX(), blinkingBomb.getY());
                terminal.putCharacter(' ');
            }

        }

        terminal.setForegroundColor(TextColor.ANSI.BLUE);
        for (Brick brick : dungeon.getWalls()) {
            terminal.setCursorPosition(brick.getX(), brick.getY());
            terminal.putCharacter(brick.getSymbol());
        }

        terminal.setForegroundColor(TextColor.ANSI.GREEN);
        for (Bomb bomb : dungeon.getBombs()) {
            terminal.setCursorPosition(bomb.getX(), bomb.getY());
            terminal.putCharacter(bomb.getSymbol());
        }

        terminal.setForegroundColor(TextColor.ANSI.CYAN);
        for (MovingWallNode mvn : dungeon.getMovingWall()) {
            terminal.setCursorPosition(mvn.getPreviousX(), mvn.getPreviousY());
            terminal.putCharacter(' ');

            terminal.setCursorPosition(mvn.getX(), mvn.getY());
            terminal.putCharacter(mvn.getSymbol());
        }
        terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
        for (RandomMob rm : dungeon.getRandomMobs()) {
            if (rm.getPreviousX() == player.getX() && rm.getPreviousY() == player.getY()) {

            } else {
                terminal.setCursorPosition(rm.getPreviousX(), rm.getPreviousY());
                terminal.putCharacter(' ');
            }

            terminal.setCursorPosition(rm.getX(), rm.getY());
            terminal.putCharacter(rm.getSymbol());
        }


        terminal.setForegroundColor(TextColor.ANSI.YELLOW);
        for (Rain rain : dungeon.getRainList()) {
            if (rain.getPreviousX() == player.getX() && rain.getPreviousY() == player.getY()) {

            } else {
                terminal.setCursorPosition(rain.getPreviousX(), rain.getPreviousY());
                terminal.putCharacter(' ');
            }

            terminal.setCursorPosition(rain.getX(), rain.getY());
            terminal.putCharacter(rain.getSymbol());
        }

        terminal.setForegroundColor(TextColor.ANSI.CYAN);
        for (MovingWallHole mvh : dungeon.getMovingWallHole()) {
            if (mvh.getPreviousX() == player.getX() && mvh.getPreviousY() == player.getY()) {

            } else {
                terminal.setCursorPosition(mvh.getPreviousX(), mvh.getPreviousY());
                terminal.putCharacter(' ');
            }

            terminal.setCursorPosition(mvh.getX(), mvh.getY());
            terminal.putCharacter(mvh.getSymbol());
        }

        terminal.setForegroundColor(TextColor.ANSI.RED);
        for (Fire fire : dungeon.getFires()) {
            terminal.setCursorPosition(fire.getX(), fire.getY());
            terminal.putCharacter(fire.getSymbol());
        }

        terminal.setForegroundColor(TextColor.ANSI.YELLOW);
        terminal.setCursorPosition(dungeon.getFinish().getX(), dungeon.getFinish().getY());
        terminal.putCharacter(dungeon.getFinish().getSymbol());

        for (Skull skull : dungeon.getSkulls()){
            if (skull.getPreviousX() == player.getX() && skull.getPreviousY() == player.getY()) {
            } else {
                terminal.setCursorPosition(skull.getPreviousX(), skull.getPreviousY());
                terminal.putCharacter(' ');
            }

            terminal.setCursorPosition(skull.getX(), skull.getY());
            terminal.putCharacter(skull.getSymbol());
        }


        terminal.flush();
    }

    private static boolean isPlayerAtFinish(Player player, Dungeon dungeon) {
        if (player.getX() == dungeon.getFinish().getX() && player.getY() == dungeon.getFinish().getY()) {
            return true;
        }
        return false;
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

        for (Rain rain : dungeon.getRainList()) {
            if (player.getX() == rain.getX() && player.getY() == rain.getY()) {
                return true;
            }
        }

        for (MovingWallHole mvh : dungeon.getMovingWallHole()) {
            if (player.getX() == mvh.getX() && player.getY() == mvh.getY()) {
                return true;
            }
        }

        for (Fire fire : dungeon.getFires()){
            if (player.getX() == fire.getX() && player.getY() == fire.getY()){
                return true;
            }
        }

        for (Skull skull : dungeon.getSkulls()) {
            if (player.getX() == skull.getX() && player.getY() == skull.getY()){
                return true;
            }
        }
        return false;
    }

    private static void drawFinish(Terminal terminal) throws  IOException {
        terminal.clearScreen();

        terminal.setForegroundColor(TextColor.ANSI.YELLOW);
        terminal.setCursorPosition(33, 10);
        terminal.putCharacter('S');
        terminal.setForegroundColor(TextColor.ANSI.RED);
        terminal.setCursorPosition(34, 10);
        terminal.putCharacter('T');
        terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
        terminal.setCursorPosition(35, 10);
        terminal.putCharacter('A');
        terminal.setForegroundColor(TextColor.ANSI.BLUE);
        terminal.setCursorPosition(36, 10);
        terminal.putCharacter('G');
        terminal.setForegroundColor(TextColor.ANSI.CYAN);

        terminal.setCursorPosition(37, 10);
        terminal.putCharacter('E');

        terminal.setForegroundColor(TextColor.ANSI.GREEN);
        terminal.setCursorPosition(39, 10);
        terminal.putCharacter('C');
        terminal.setForegroundColor(TextColor.ANSI.YELLOW);
        terminal.setCursorPosition(40, 10);
        terminal.putCharacter('L');
        terminal.setForegroundColor(TextColor.ANSI.RED);
        terminal.setCursorPosition(41, 10);
        terminal.putCharacter('E');
        terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
        terminal.setCursorPosition(42, 10);
        terminal.putCharacter('A');
        terminal.setForegroundColor(TextColor.ANSI.BLUE);
        terminal.setCursorPosition(43, 10);
        terminal.putCharacter('R');
        terminal.flush();
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
