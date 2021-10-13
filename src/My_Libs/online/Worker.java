package My_Libs.online;

import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 06.10.2021
 */

/*public class Worker extends Object{

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        int[] abc = {1};
//        System.out.println(abc);
//
//        String string1 = "Sweet home!";
//        String string2 = "Sweet ";
//        string2 += "home!";
//
//        String string3 = scanner.nextLine();
//        String string4 = "Sweet home!";
//
//        System.out.println("string1 > " + string1);
//        System.out.println("string2 > " + string2);
//        System.out.println("string3 > " + string3);
//        System.out.println("string4 > " + string4);
//        System.out.println("**********");
//
//        System.out.println("string1 == string2 > " + (string1 == string2));
//        System.out.println("string1 == string3 > " + (string1 == string3));
//        System.out.println("string1 == string4 > " + (string1 == string4));
//        System.out.println("**********");
//
//        System.out.println("string1 == string2 > " + (string1.equals(string2)));
//        System.out.println("string1 == string3 > " + (string1.equals(string3)));
//        System.out.println("string1 == string4 > " + (string1.equals(string4)));
        String testString = "Test"; //String testString = new String("Test");
        StringBuilder stringBuilder = new StringBuilder("Test");

        long timeStart = System.nanoTime();//UNIX-time

        for (int i = 0; i < 80000; i++) {
            testString += i; //Test0123456789...79999
        }

        float deltaTime = System.nanoTime() - timeStart;
        System.out.println(testString);
        System.out.println("Time test string: " + deltaTime * 0.000001f + " millisec");

        timeStart = System.nanoTime();

        for (int i = 0; i < 80000; i++) {
           stringBuilder.append(i); //Test0123456789...79999
        }

        deltaTime = System.nanoTime() - timeStart;
        System.out.println(stringBuilder.toString());
        System.out.println("Time test stringBuilder: " + deltaTime * 0.000001f + " millisec");
        System.out.println(testString.equals(stringBuilder.toString()));



    }

}
*/