package Lesson_7.components;
import javax.swing.*;
import java.awt.*;

public class Map extends JPanel{
    private AppWindow  appWindow;
    private char[][] room;
    private char[][] invisibleRoom;
    private int roomHeight;
    private int roomWidth;
    private int roomSizeMin = 3;
    private int roomSizeMax = 6;
    private char emptyCell = '_';
    private char visitedCell = '*';
    private int enemiesAmount;

    Map(AppWindow appWindow){
        this.appWindow = appWindow;
        setBackground(new Color(220, 237, 201));

    }

}
