package Lesson_8.components;

import Lesson_8.Tools;
import Lesson_8.models.Enemy;
import Lesson_8.models.Player;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    private AppWindow appWindow;

    public static final int DIRECTION_UP = 8;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_RIGHT = 6;
    public static final int DIRECTION_DOWN = 2;

    private final int CELL_PLAYER = 1;
    private final int CELL_ENEMY = 2;
    private final int CELL_EMPTY = 0;
    private final int CELL_READY = 99;

    private int[][] room;
    private int[][] invisibleRoom;
    private int roomHeight;
    private int roomWidth;
    private int roomSizeMin = 3;
    private int roomSizeMax = 6;

    private int levelGame;

    private int cellWidth;
    private int cellHeight;

    private Player player;
    private Enemy enemy;

    private boolean isExist;
    private boolean isGameStart;

    GameMap(AppWindow appWindow) {
        this.appWindow = appWindow;
        isExist = false;
        isGameStart = false;
        setBackground(Color.BLACK);

    }

    void startNewGame() {
        levelGame = 1;
        player = new Player();
        generateNewLevel();
        isExist = true;
        isGameStart = true;
    }

    void update(int key) {
        if (!isExist) {
            return;
        }

        if (!isGameStart) {
            return;
        }

        int currentPlayerX = player.getX();
        int currentPlayerY = player.getY();

        switch (key) {
            case DIRECTION_UP:
                player.moveUp();
                break;
            case DIRECTION_LEFT:
                player.moveLeft();
                break;
            case DIRECTION_RIGHT:
                player.moveRight();
                break;
            case DIRECTION_DOWN:
                player.moveDown();
                break;
        }

        if (!checkPlayerMove(currentPlayerX, currentPlayerY, player.getX(), player.getY())) {
            return;
        }

        playerNextMoveAction(currentPlayerX, currentPlayerY, player.getX(), player.getY());
        appWindow.refreshGuiInfo(this);
        repaint();

        if (!player.isAlive()) {
            isGameStart = false;
            JOptionPane.showMessageDialog(this, "Player is dead! Game is Over!");
        }

        if (!enemy.isExistEnemies()) {
            ++levelGame;
            generateNewLevel();
        }
    }

    private void render(Graphics g) {
        if (!isExist) {
            return;
        }

        paintMap(g);

        for (int y = 0; y < roomHeight; y++) {
            for (int x = 0; x < roomWidth; x++) {

                if (room[y][x] == CELL_EMPTY) {
                    continue;
                }

                if (room[y][x] == CELL_PLAYER) {
                    g.setColor(Color.CYAN );
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }

                if (room[y][x] == CELL_READY) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }

    }

    private void paintMap(Graphics g) {
        int widthMap = getWidth();
        int heightMap = getHeight();

        cellWidth = widthMap / roomWidth;
        cellHeight = heightMap / roomHeight;

        g.setColor(Color.WHITE);

        for (int i = 0; i <= roomHeight ; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, widthMap, y);
        }

        for (int i = 0; i <= roomWidth ; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, heightMap);
        }

    }

    private void generateNewLevel() {
        createRoom();
        spawnPlayer();
        spawnEnemies();
        appWindow.log("Start Level " + levelGame);
        appWindow.refreshGuiInfo(this);
        repaint();
    }

    private void createRoom() {
        roomWidth = Tools.randomValue(roomSizeMin, roomSizeMax);
        roomHeight = Tools.randomValue(roomSizeMin, roomSizeMax);
        room = new int[roomHeight][roomWidth];
        invisibleRoom = new int[roomHeight][roomWidth];

        for (int y = 0; y < roomHeight; y++) {
            for (int x = 0; x < roomWidth; x++) {
                room[y][x] = CELL_EMPTY;
                invisibleRoom[y][x] = CELL_EMPTY;
            }
        }
    }

    private void spawnPlayer() {
        player.setPosition(Tools.randomValue(0, roomWidth - 1), Tools.randomValue(0, roomHeight - 1));
        room[player.getY()][player.getX()] = CELL_PLAYER;
    }

    private void spawnEnemies(){
        enemy = new Enemy((roomWidth + roomHeight) / 2);

        int enemyPosX;
        int enemyPosY;

        for (int i = 1; i <= enemy.getCountEnemies(); i++) {

            do {
                enemyPosX = Tools.random.nextInt(roomWidth);
                enemyPosY = Tools.random.nextInt(roomHeight);
            } while (!isEmptyCell(room, enemyPosX, enemyPosY) || !isEmptyCell(invisibleRoom, enemyPosX, enemyPosY));

            invisibleRoom[enemyPosY][enemyPosX] = CELL_ENEMY;
        }
    }

    private void playerNextMoveAction(int lastPosX, int lastPosY, int nextPosX, int nextPosY) {
        if (invisibleRoom[nextPosY][nextPosX] == CELL_ENEMY) {
            appWindow.log("ALERT! Player has been attacked");
            player.decreaseHealth(enemy.getPower());
            enemy.killEnemy();
            invisibleRoom[nextPosY][nextPosX] = CELL_EMPTY;
        }

        room[player.getY()][player.getX()] = CELL_PLAYER;
        room[lastPosY][lastPosX] = CELL_READY;
    }

    private boolean checkPlayerMove(int currentX, int currentY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < roomWidth && nextY >= 0 && nextY < roomHeight) {
            return true;
        } else {
            appWindow.log("Invalid move! Please try again!");
            player.setPosition(currentX, currentY);
            return false;
        }
    }

    private boolean isEmptyCell(int[][] checkRoom, int x, int y) {
        return checkRoom[y][x] == CELL_EMPTY;
    }

    String getInfoLevel() {
        return "Level: " + levelGame;
    }

    String getInfoMap() {
        return "Size map: " + roomWidth + ":" + roomHeight;
    }

    Enemy getInfoEnemy() {
        return enemy;
    }

    Player getInfoPlayer() {
        return player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
}
