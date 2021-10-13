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

        // Icon iconStart = new ImageIcon ("<a href='https://dryicons.com/free-icons/start'> Icon by Dryicons </a>");

        // ImageIcon iconStart = new ImageIcon("start_icons.png");

       /* JButton btnStart =new JButton( iconStart );
        JButton btnStop =new JButton ("Stop game");
        add(btnStart,BorderLayout.EAST);
        add(btnStop, BorderLayout.WEST); */

        map = new Map();
        controlPanel = new GuiPanel();
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
}
