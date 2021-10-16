package Homework.Lesson_8.components;

import javax.swing.*;
import java.awt.*;


public class AppWindow extends JFrame {

    private int winWidth = 1024;
    private int winHeight = 768;
    private int winPositionX = 150;
    private int winPositionY = 50;

    private GameMap map;
    private GuiPanel mainPanel;

    public AppWindow() {
        setupWindow();

        mainPanel = new GuiPanel(this);
        map = new GameMap(this);

        add(mainPanel, BorderLayout.EAST);
        add(map);
        setVisible(true);
    }

    private void setupWindow() {
        setLocation(winPositionX, winPositionY);
        setSize(winWidth, winHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUI_GAME");
        setResizable(false);
    }

    void log(String msg) {
        mainPanel.recordLog(msg);
    }

    void refreshGuiInfo(GameMap map) {
        mainPanel.refresh(map);
    }

    void startSession() {
        map.startNewGame();
    }

    void changePositionPlayer(int key) {
        map.update(key);
    }

}
