package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class GameBattle {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static int levelGame = 0;

    public static char[][] room;
    public static char[][] invisibleRoom;
    public static int roomHeight;
    public static int roomWidth;
    public static int roomSizeMin = 3;
    public static int roomSizeMax = 6;
    public static char emptyCell = '_';
    public static char visitedCell = '*';

    public static int enemiesAmount;
    public static char enemy = 'E';
    public static int enemyHP = 40;
    public static int enemyForce;
    public static int enemyValueMin = 5;
    public static int enemyValueMax = 10;

    public static char player = '@';
    public static int playerHP = 200;
    public static int playerPower = 20;
    public static int playerPosX;
    public static int playerPosY;
    public static final int playerMoveUp = 8;
    public static final int playerMoveLeft = 4;

    public static final int playerMoveRight = 6;
    public static final int playerMoveDown = 2;

    public static void main(String[] args) {

        while (PlayerIsAlive()) {
            ++levelGame;
            System.out.println("WELCOME TO LEVEL " + levelGame);
            roomGameCycle();
        }
        System.out.println("GAME IS OVER! The Player has cleared the room at " + levelGame);
    }

    public static void roomGameCycle() {
        createRoom();
        spawnPlayer();
        spawnEnemies();

        while(true) {
            showRoom();
            playerMove();

            if (!PlayerIsAlive()) {
                System.out.println("The Player is dead");
                break;
            }


            if (!EnemiesExistence()) {
                System.out.println("Current room is clear. Go to LEVEL " + (levelGame + 1));
                break;
            }
        }
    }


    public static void createRoom() {
        roomWidth = randomValue(roomSizeMin, roomSizeMax);
        roomHeight = randomValue(roomSizeMin, roomSizeMax);
        room = new char[roomHeight][roomWidth];
        invisibleRoom = new char[roomHeight][roomWidth];

        for (int y = 0; y < roomHeight; y++) {
            for (int x = 0; x < roomWidth; x++) {
                room[y][x] = emptyCell;
                invisibleRoom[y][x] = emptyCell;
            }
        }

        System.out.println("Room " + roomWidth + "x" + roomHeight + " is created");
    }

    public static void showRoom() {
        System.out.println("===== ROOM =====");
        for (int y = 0; y < roomHeight; y++) {
            for (int x = 0; x < roomWidth; x++) {
                System.out.print(room[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("================");
    }

    public static void spawnPlayer() {
        playerPosX = randomValue(0, roomWidth - 1);
        playerPosY = randomValue(0, roomHeight - 1);
        room[playerPosY][playerPosX] = player;
        System.out.println("Player is created, in [" + (playerPosX + 1) + ":" + (playerPosY + 1) + "] His HP=" + playerHP + " and STR=" + playerPower);
    }

    public static void spawnEnemies(){
        enemyHP = randomValue(enemyValueMin, enemyValueMax);
        enemyForce = randomValue(enemyValueMin, enemyValueMax);

        enemiesAmount = (roomWidth + roomHeight) / 2;

        int enemyPosX;
        int enemyPosY;

        for (int i = 1; i <= enemiesAmount; i++) {

            do {
                enemyPosX = random.nextInt(roomWidth);
                enemyPosY = random.nextInt(roomHeight);
            } while (!IsCellEmpty(room, enemyPosX, enemyPosY) || !IsCellEmpty(invisibleRoom, enemyPosX, enemyPosY));

            invisibleRoom[enemyPosY][enemyPosX] = enemy;
        }
        System.out.println(enemiesAmount + " Enemies are created with HP=" + enemyHP + " and STR=" + enemyForce);

    }


    public static void playerMove() {
        int currentPlayerX = playerPosX;
        int currentPlayerY = playerPosY;

        int playerDestination;

        do {
            System.out.print("Enter direction to move (UP=" + playerMoveUp + ", LEFT=" + playerMoveLeft + ", DOWN=" + playerMoveDown + ", RIGHT=" + playerMoveRight + ") > ");
            playerDestination = scanner.nextInt();

            switch (playerDestination) {
                case playerMoveUp:
                    playerPosY -= 1;
                    break;
                case playerMoveLeft:
                    playerPosX -= 1;
                    break;
                case playerMoveDown:
                    playerPosY += 1;
                    break;
                case playerMoveRight:
                    playerPosX += 1;
                    break;
            }
        } while (!checkPlayerMove(currentPlayerX, currentPlayerY, playerPosX, playerPosY));
        //i++
        //+= value, -= value, *= value, /= value -> i = i + value;
        playerNextMoveAction(currentPlayerX, currentPlayerY, playerPosX, playerPosY);

    }

    public static void playerNextMoveAction(int lastPosX, int lastPosY, int nextPosX, int nextPosY) {
        if (invisibleRoom[nextPosY][nextPosX] == enemy) {
            playerHP -= enemyForce;
            System.out.println("ALERT! Enemy caused " + enemyForce + " points damage. Player HP now is " + playerHP);
            enemiesAmount--;
            invisibleRoom[nextPosY][nextPosX] = emptyCell;
        }
        room[playerPosY][playerPosX] = player;
        room[lastPosY][lastPosX] = visitedCell;
    }


    public static boolean checkPlayerMove(int currentX, int currentY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < roomWidth && nextY >= 0 && nextY < roomHeight) {
            System.out.println("Player moves to [" + (nextX + 1) + ":" + (nextY + 1) + "], success!");
            return true;
        } else {
            System.out.println(" FAIL! This movement is impossible. Please, try another direction!");
            playerPosX = currentX;
            playerPosY = currentY;
            return false;
        }
    }

    public static boolean IsCellEmpty(char[][] checkRoom, int x, int y) {
        return checkRoom[y][x] == emptyCell;
    }

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean EnemiesExistence() {
        return enemiesAmount > 0;
    }

    public static boolean PlayerIsAlive() {
        return playerHP > 0;
    }
}
