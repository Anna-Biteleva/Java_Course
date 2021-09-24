package Lesson_2;

public class HW_2 {

    public static void main(String[] args) {

        /*1*/   System.out.println(Checksum(6, 5));
        /*2*/   plus_minos(-10);
        /*3*/   System.out.println (plus_minos_log(5));
        /*4*/   printWord(5, "моя строка");
        /*5*/   System.out.println (leap_year(2100));
    }


    // 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
    // (включительно), если да – вернуть true, в противном случае – false.

    public static boolean Checksum(int a, int b) {

        return ((a + b) >= 10 && (a + b) <= 20);
    }


//2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    //      положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.

    public static void plus_minos(int a) {
        if (a >= 0)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }
    //3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное, и вернуть false если положительное.

    public static boolean plus_minos_log (int a) {
        return (a < 0);
    }

    //4. Написать метод, которому в качестве аргументов передается строка и число, метод должен
    // отпечатать в консоль указанную строку, указанное количество раз;

    public static void printWord(int value, String line) {
        int i = 0;
        while (i < value) {
            System.out.println (line);
            i++;
        }

    }
    // 5  Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static boolean leap_year(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));}

}

