package Lesson_6;

public class Cat extends Animal {

    public static int catNum = 0;

    public Cat( int runLength, int swimLength, String name) {
        super( runLength, swimLength,name);

        catNum++ ;
    }

    @Override
    public void swim (String name, int dist ){
       System.out.println (name +", как и все коты, вообще не умеет плавать.");

    }


}
