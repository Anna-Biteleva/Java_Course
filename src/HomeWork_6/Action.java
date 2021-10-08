package HomeWork_6;

import java.util.Random;


public class Action {
    public static int dogMaxRunDist = 700;
    public static int dogMinRunDist = 300;
    public static int dogMaxSwimDist = 15;
    public static int dogMinSwimDist = 5;
    public static int catMaxRunDist = 400;
    public static int catMinRunDist = 200;
    public static Random runDist = new Random();



    public static void main(String[] args) {

        System.out.println("***********************");

        Dog dog1  = new Dog(500, 10, "Пес Фунтик");

       System.out.println("Первый участник:");


        dog1.run(dog1.name, distCalc( dogMinRunDist,dogMaxRunDist));
        dog1.swim (dog1.name, distCalc(dogMinSwimDist,dogMaxSwimDist ));

        System.out.println("Второй  участник:");

        Dog dog2 = new Dog(500, 10, "Пес Рекс");

        dog2.run (dog2.name, distCalc( dogMinRunDist,dogMaxRunDist));

        dog2.swim (dog2.name, distCalc (dogMinSwimDist,dogMaxSwimDist ));

       Cat cat1 = new Cat(300,0, "Кот Вася"  );

        System.out.println("Третий  участник:");

        cat1.run(cat1.name, distCalc( catMinRunDist,catMaxRunDist));
        cat1.swim(cat1.name, 10);

        System.out.println("Четвертый участник:");

        Cat cat2 = new Cat(300,0, "Кот Кузя"  );

        cat2.run(cat2.name, distCalc( catMinRunDist,catMaxRunDist));
        cat2.swim(cat2.name, 10);

System.out.println("***********************");

  System.out.println( "В выступлениях участвовало " + Animal.anNum + " животных. В том числе, " +  Dog.dogNum +" собаки и " + Cat.catNum + " кота." );


    }

    public static int distCalc ( int minDist, int maxDist) {
            int tmp = maxDist - minDist;
            return  (minDist + runDist.nextInt(tmp + 1));
        }
    }




