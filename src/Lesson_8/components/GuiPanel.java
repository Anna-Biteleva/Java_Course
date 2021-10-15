package Lesson_8.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPanel extends JPanel { //Ctrl + click

    private AppWindow appWindow;

    private JPanel appControlArea;
    private JButton btnStart;
    private JButton btnExit;

    private JPanel gameInfoArea;
    private JLabel generalHeading;
    private JLabel levelInfo;
    private JLabel sizeMapInfo;

    //private JPanel enemyInfoArea;
    private JLabel enemyCountInfo;
    private JLabel enemyHpInfo;
    private JLabel enemyStrInfo;

    private JPanel playerInfoArea;
    private JLabel playerHpInfo;
    private JLabel playerStrInfo;
    private JLabel playerPositionInfo;

    private JPanel playerControlArea;
    private JButton playerMoveUp;
    private JButton playerMoveDown;
    private JButton playerMoveLeft;
    private JButton playerMoveRight;

    private JLabel blank = new JLabel("");


    private JTextArea gameLog;
    private JScrollPane scrollLogPanel;


    GuiPanel(AppWindow appWindow) {
        this.appWindow = appWindow;

        setLayout(new GridLayout(5, 1));

        setupAppControlArea();
        setupPlayerControlArea();
        setupGameInfoArea();
      //  setupEnemyInfoArea();
        setupPlayerInfoArea();
        setupGameLog();

        constructMainPanel();

    }

    private void constructMainPanel() {

        add(appControlArea);
        add(playerControlArea);
        add(gameInfoArea);
      //  add(enemyInfoArea);
        add(playerInfoArea);
        add(scrollLogPanel);

    }

    private void setupAppControlArea() {
        appControlArea = new JPanel();
        appControlArea.setLayout(new GridLayout(2, 1));
        btnStart = new JButton("<html><font size = 10 color = green>  Start game </font> </html>");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appWindow.startSession();
            }
        });

        btnExit = new JButton("<html><font size =10 color = #800000 >  Stop game </font> </html>");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        appControlArea.add(btnStart);
        appControlArea.add(btnExit);
    }

    private void setupPlayerControlArea() {
        playerControlArea = new JPanel();
        playerControlArea.setLayout(new GridLayout(1, 4));
        playerMoveUp = new JButton("\uD83E\uDC81");
        playerMoveUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appWindow.changePositionPlayer(GameMap.DIRECTION_UP);
            }
        });

        playerMoveDown = new JButton("\uD83E\uDC83");
        playerMoveDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appWindow.changePositionPlayer(GameMap.DIRECTION_DOWN);
            }
        });

        playerMoveLeft = new JButton("\uD83E\uDC80");
        playerMoveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appWindow.changePositionPlayer(GameMap.DIRECTION_LEFT);
            }
        });

        playerMoveRight = new JButton("\uD83E\uDC82");
        playerMoveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appWindow.changePositionPlayer(GameMap.DIRECTION_RIGHT);
            }
        });

        playerControlArea.add(playerMoveLeft);
        playerControlArea.add(playerMoveUp);
        playerControlArea.add(playerMoveDown);
        playerControlArea.add(playerMoveRight);
    }

       private void setupGameInfoArea() {
        gameInfoArea = new JPanel();
        gameInfoArea.setLayout(new GridLayout(7, 1));
        generalHeading= new JLabel("<html> <font color= #964b00> &nbsp GENERAL INFO </font> </html>");
        levelInfo = new JLabel("<html> &nbsp Game Level: -</html>");
        sizeMapInfo = new JLabel("<html> &nbsp Map Size: - | - </html>");
        gameInfoArea.add(generalHeading);
        gameInfoArea.add(levelInfo);
        gameInfoArea.add(sizeMapInfo);

        JLabel enemyHeading = new JLabel("<html> <font color= #964b00> &nbsp ENEMIES </font> </html>");
        enemyCountInfo = new JLabel("<html> &nbsp Number of Enemies: - </html>");
        enemyHpInfo = new JLabel("<html> &nbsp Enemy's HealthPower: - </html>");
        enemyStrInfo = new JLabel("<html> &nbsp Enemy's Strength: - </html>");
        gameInfoArea.add(enemyHeading);
        gameInfoArea.add(enemyCountInfo);
        gameInfoArea.add(enemyHpInfo);
        gameInfoArea.add(enemyStrInfo);
    }


      /*  enemyCountInfo = new JLabel("Enemies: -");
        enemyHpInfo = new JLabel("Enemies HP: -");
        enemyStrInfo = new JLabel("Enemies STR: -");


        gameInfoArea.add(enemyCountInfo);
        gameInfoArea.add(enemyHpInfo);
        gameInfoArea.add(enemyStrInfo); */


    private void setupPlayerInfoArea() {
        playerInfoArea = new JPanel();
        playerInfoArea.setLayout( new GridLayout(7,1));
        playerPositionInfo =new JLabel("<html> &nbsp Player's Position: - | - </html>");
        playerHpInfo = new JLabel("<html> &nbsp Player's HealthPower: - </html>");
        playerStrInfo = new JLabel("<html> &nbsp Player's Strength: - </html>");

       // playerInfoArea.add(blank);
        playerInfoArea.add(new JLabel("<html> <font color= #964b00> &nbsp PLAYER </font> </html>"));
        playerInfoArea.add(playerHpInfo);
        playerInfoArea.add(playerStrInfo);
        playerInfoArea.add(playerPositionInfo);
    }



    private void setupGameLog() {
        gameLog = new JTextArea();
        scrollLogPanel = new JScrollPane(gameLog);
        gameLog.setLineWrap(true);
        gameLog.setEditable(false);
    }

    void recordLog(String msg) {
        gameLog.append(msg + "\n");
    }

    void refresh(GameMap map) {
        levelInfo.setText(map.getInfoLevel());
        sizeMapInfo.setText(map.getInfoMap());
        enemyCountInfo.setText(" Number of Enemies: " + map.getInfoEnemy().getCountEnemies());
        enemyHpInfo.setText(" Enemy's HealthPower: " + map.getInfoEnemy().getHealth());
        enemyStrInfo.setText(" Enemy's Strength: " + map.getInfoEnemy().getPower());
        playerHpInfo.setText(" Player's HealthPower: " + map.getInfoPlayer().getHealth());
        playerStrInfo.setText(" Player's Strength: " + map.getInfoPlayer().getPower());
        playerPositionInfo.setText(map.getInfoPlayer().getPosition());

    }


}
