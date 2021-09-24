package Lesson_1;

public class HW_1 {


    public static void main(String[] args) {
        printThreeWords("Orange");
        printThreeWords("Banana");
        printThreeWords("Apple");
        checkSumSign();
        if (checkSum1(-10, 20))
            System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
        printColor();
        compareNumbers();
        printThreeWords1 ();

    }

    // 2. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.

    public static void printThreeWords(String fruit) {

        System.out.println(fruit);
    }

    public static void printThreeWords1 ( ){
        System.out.println ("Orange");
        System.out.println ("Banana");
        System.out.println ("Apple");}


    // 3. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями,
    // которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль
    // сообщение “Сумма положительная”, в противном случае "Сумма положительная"

    public static void checkSumSign() {
        int a = 10;
        int b = -35;

        if ( a+b  >= 0)
            System.out.println("Сумма положительная");

        else System.out.println("Сумма отрицательная");
    }
    //  Второй вариант третьего метода

    public static boolean checkSum1( int a, int b) {
        return a + b >= 0;
    }


    // 4. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
// Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах от 0 (0 исключительно)
// до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;

    public static void printColor() {
        int value = 155;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }


    }
    // 5. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями,
    // которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;

    public static void compareNumbers() {
        int  a = 20;
        int b = 20;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else System.out.println("a < b");

    }
// другой вариант метода compareNumbers

    public static String compareNum (int a, int b) {
        if (a < b)
            return ("a < b");
        else
            return ("a >= b");
    }
}

