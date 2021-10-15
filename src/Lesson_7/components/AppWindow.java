package Lesson_7.components;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {

    private int winWidth  = 1024;
    private int winHeight = 768;
    private int winPositionX = 150;
    private int winPositionY =50;
    private Map map;
    private GuiPanel controlPanel;

    AppWindow(){

        setupWindow();
        controlPanel = new GuiPanel();
        map = new Map(this);
        add(controlPanel, BorderLayout.EAST);
         add (map);

    }

    private void setupWindow() {
        setLocation(winPositionX,winPositionY);
        setSize(winWidth,winHeight);
        setVisible(true);
        setTitle("GUI_Interface");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void log(String msg){
        controlPanel.recordLog(msg);
    }

}

