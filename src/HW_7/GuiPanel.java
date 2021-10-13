package HW_7;

import javax.swing.*;
import java.awt.*;

public class GuiPanel extends JPanel {

    private JPanel appControlArea;
    private JButton btnStart = new JButton("Start game");
    private JButton btnStop = new JButton("Stop game");

    private JPanel gameInfoArea;
    private JLabel generalHeading;
    private JLabel levelInfo;
    private JLabel sizeMapInfo;


    private JPanel enemyInfoArea;
    private JLabel enemyHeading;
    private JLabel enemyCountInfo;
    private JLabel enemyHPInfo;
    private JLabel enemySTRInfo;

    private JPanel playerInfoArea;
    private JLabel playerHeading;
    private JLabel playerPositionInfo;
    private JLabel playerHPInfo;
    private JLabel playerSTRInfo;

    private JPanel playerControlArea;
    private JButton playerMoveUP;
    private JButton playerMoveDown;
    private JButton playerMoveLeft;
    private JButton playerMoveRight;


    private JLabel blank = new JLabel("");


    private JTextArea gameLog;
    private JScrollPane scrollLogPanel;

    private JSeparator divisionArea;

    GuiPanel() {
        setBackground(new Color(230, 219, 203));
        setLayout(new GridLayout(6, 1));


        setupAppControlArea();
        setupPlayerControlArea();
        setupGameInfoArea();
        setupEnemyInfoArea();
        setupPlayerInfoArea();
        setupGameLog();

        formPanel();

    }


    private void formPanel() {
        add(appControlArea);
        add(playerControlArea);
        add(gameInfoArea);
        add(enemyInfoArea);
        add(playerInfoArea);
        add(scrollLogPanel);


    }

    private void setupAppControlArea() {
        appControlArea = new JPanel();
        appControlArea.setLayout(new GridLayout(2, 1));
        // ImageIcon iconStart = new ImageIcon("start_icons.png");
        JButton btnStart = new JButton("<html><font size = 10 color = green>  Start game </font> </html>");
        JButton btnStop = new JButton("<html><font size =10 color = #800000 >  Stop game </font> </html>");
        appControlArea.add(btnStart);
        appControlArea.add(btnStop);

    }

    private void setupPlayerControlArea() {

        playerControlArea = new JPanel();
        playerControlArea.setLayout( new GridLayout(1,4));
        playerMoveUP = new JButton(" \uD83E\uDC81 ");
        playerMoveDown = new JButton("\uD83E\uDC83" );
        playerMoveLeft = new JButton("\uD83E\uDC80");
        playerMoveRight = new JButton("\uD83E\uDC82");
        playerControlArea.add(playerMoveLeft);
        playerControlArea.add(playerMoveUP);
        playerControlArea.add(playerMoveDown);
        playerControlArea.add(playerMoveRight);


    }

    private void setupGameInfoArea() {
        gameInfoArea = new JPanel();
        gameInfoArea.setLayout(new GridLayout(4, 1));
        generalHeading= new JLabel("<html> <font color= #964b00> &nbsp GENERAL INFO </font> </html>");
        levelInfo = new JLabel("<html> &nbsp Game Level: -</html>");
        sizeMapInfo = new JLabel("<html> &nbsp Map Size: - | - </html>");
        // divisionArea = new JSeparator(SwingConstants.HORIZONTAL);
        gameInfoArea.add(generalHeading);
        gameInfoArea.add(levelInfo);
        gameInfoArea.add(sizeMapInfo);
        // gameInfoArea.add(divisionArea);

    }

    private void setupEnemyInfoArea() {
        enemyInfoArea = new JPanel();
        enemyInfoArea.setLayout( new GridLayout(5,1));
        enemyHeading = new JLabel("<html> <font color= #964b00> &nbsp ENEMIES </font> </html>");
        enemyCountInfo = new JLabel("<html> &nbsp Number of Enemies: - </html>");
        enemyHPInfo = new JLabel("<html> &nbsp Enemy's HealthPower: - </html>");
        enemySTRInfo= new JLabel("<html> &nbsp Enemy's Strength: - </html>");
        enemyInfoArea.add(blank);
        enemyInfoArea.add(enemyHeading);
        enemyInfoArea.add(enemyCountInfo);
        enemyInfoArea.add(enemyHPInfo);
        enemyInfoArea.add(enemySTRInfo);
    }

    private void setupPlayerInfoArea() {
        playerInfoArea = new JPanel();
        playerInfoArea.setLayout( new GridLayout(6,1));
        playerHeading = new JLabel("<html> <font color= #964b00> &nbsp PLAYER </font> </html>");
        playerPositionInfo =new JLabel("<html> &nbsp Player's Position: - | - </html>");
        playerHPInfo =new JLabel("<html> &nbsp Player's HealthPower: - </html>");
        playerSTRInfo =new JLabel("<html> &nbsp Player's Strength: - </html>");
        playerInfoArea.add(blank);
        playerInfoArea.add(playerHeading);
        playerInfoArea.add(playerPositionInfo);
        playerInfoArea.add(playerHPInfo);
        playerInfoArea.add(playerSTRInfo);



    }





    private void setupGameLog() {

        gameLog = new JTextArea(" Window for logs");
        scrollLogPanel = new JScrollPane(gameLog);
        gameLog.setLineWrap(true);

    }

   }

