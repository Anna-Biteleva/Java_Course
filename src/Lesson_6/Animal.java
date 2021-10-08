package Lesson_6;


import java.util.Random;

public class Animal {
    protected int runLength;
    protected int swimLength;
    protected String name;
    public static int anNum = 0;



    public Animal( int runLength, int swimLength, String name) {
        this.runLength = runLength;
        this.swimLength = swimLength;
        this.name = name;
        anNum ++;

    }


    public void run(String name, int dist) {

        if (dist > runLength)
            System.out.println( name + " смог пробежать только " + runLength + " из " + dist + " метров.");
        else {
            System.out.println( name + " успешо пробежал дистанцию в " + dist + " метров.");


        }

    }
    public void swim (String name, int dist){

        if (dist > swimLength)
            System.out.println( name + " смог проплыть только "  + swimLength+" из " + dist + " метров.");
        else {
            System.out.println(name + " успешно проплыл " + dist + " метров.");
        }

        }


    }

