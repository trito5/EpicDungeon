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
        Player player = new Player(10, 10, '\u263a');
        List<Room> dungeon = createDungeon();

        drawCharacters(terminal, player, dungeon);

        do {
            KeyStroke keyStroke = getUserKeyStroke(terminal);

            movePlayer(player, keyStroke);


            drawCharacters(terminal, player, dungeon);
            //drawRoom();

        } while (true);

    }

    private static List<Room> createDungeon() {
        List<Room> roomList = new ArrayList<>();
        Room room = new Room(RoomType.FOURWAY, 1, 20);
        roomList.add(room);
        return roomList;
    }

    private static void movePlayer(Player player, KeyStroke keyStroke) {
        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                player.moveUp();
                break;
            case ArrowDown:
                player.moveDown();
                break;
            case ArrowLeft:
                player.moveLeft();
                break;
            case ArrowRight:
                player.moveRight();
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

    private static void drawCharacters(Terminal terminal, Player player, List<Room> roomList) throws IOException {

        terminal.setCursorPosition(player.getPreviousX(), player.getPreviousY());
        terminal.putCharacter(' ');

        terminal.setCursorPosition(player.getX(), player.getY());
        terminal.putCharacter(player.getSymbol());

        for (Room room : roomList) {

            for (int i = 0; i < room.getWidth(); i++) {
                room.setX(room.getX() + 1);
                if (room.getRoomType() == RoomType.VERTICAL_CORRIDOR || room.getRoomType() == RoomType.FOURWAY)
                    if (i == 9)
                        continue;
                terminal.setCursorPosition(room.getX(), room.getY());
                terminal.putCharacter(room.getSymbol());
            }
            for (int i = 0; i < room.getHeight(); i++) {

                room.setY(room.getY() - 1);
                if (room.getRoomType() == RoomType.HORISONTAL_CORRIDOR || room.getRoomType() == RoomType.START ||
                                         room.getRoomType() == RoomType.FOURWAY)
                    if (i == 3)
                        continue;
                terminal.setCursorPosition(room.getX(), room.getY());
                terminal.putCharacter(room.getSymbol());
            }

            for (int i = 0; i < room.getWidth() - 1; i++) {
                room.setX(room.getX() - 1);
                if (room.getRoomType() == RoomType.VERTICAL_CORRIDOR || room.getRoomType() == RoomType.FOURWAY)
                    if (i == 8)
                        continue;
                terminal.setCursorPosition(room.getX(), room.getY());
                terminal.putCharacter(room.getSymbol());
            }

            for (int i = 0; i < room.getHeight() - 1; i++) {
                room.setY(room.getY() + 1);
                if (room.getRoomType() == RoomType.HORISONTAL_CORRIDOR || room.getRoomType() == RoomType.START ||
                        room.getRoomType() == RoomType.FOURWAY)
                    if (i == 3)
                        continue;
                terminal.setCursorPosition(room.getX(), room.getY());
                terminal.putCharacter(room.getSymbol());
            }


        }
        terminal.flush();
    }


}
