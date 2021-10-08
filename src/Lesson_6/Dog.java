package Lesson_6;

import java.util.Random;

public class Dog extends Animal {

    public static int dogNum = 0;


    public Dog (int runLength, int swimLength, String name ) {
        super(runLength, swimLength, name);


        dogNum++ ;

        }


    }
