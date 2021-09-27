package Lesson_3;

public class Homework {
    public static void main (String [] args) {
        /*1*/System.out.println ("Task 1");
        InvertNum();
        System.out.println();
        System.out.println();
        /*2*/ System.out.println("Task 2");
        FillNum();
        System.out.println();
        System.out.println();

        /*3*/ System.out.println("Task 3");
        Mult ();
        System.out.println();
        System.out.println();

        /*4*/ System.out.println("Task 4");
        Diag(7,7);
        System.out.println();

        /*5*/ System.out.println("Task 5");
        int[]arr = arrFive (5, 12);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
        /*6 */  System.out.println("Task 6");
        MaxMin( new int[] {0, -2, 12, 13});
        System.out.println();

        /*7*/ System.out.println("Task 7");
        System.out.println (Balance(new int[] {2, -1, 9, 10}));

    }

    //   1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    //  С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void InvertNum () {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr.length; i++) {
            System.out.print (arr[i]+ " ");}
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print((Math.abs(arr[i] - 1) + " "));
        }
    }

// 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;

    public static void FillNum() {
        int [] arr_fill = new int[100];
        for (int i = 0; i < arr_fill.length-1; i++)
            System.out.print((arr_fill[i] = i+1)+ " ");

    }
    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

    public static void Mult() {
        int[] arrMult = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int i = 0;
        for (i = 0; i < arrMult.length; i++) {
            System.out.print(arrMult[i] + "\t");
        }
        System.out.println();
        for (i = 0; i < arrMult.length; i++) {
            if (arrMult[i] < 6) {
                arrMult[i] = (arrMult[i] * 2);}
            System.out.print(arrMult[i] + "\t");
        }

    }
// 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
//    Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];

    public static void Diag (int x, int y ){
        int [][] arrDiag = new int[x][y];
        if (x != y) {
            System.out.println("Error! X and Y dimensions should be equal");
        }
        else {
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if ((i == j) || (i+j) == (x-1))
                    {arrDiag [i][j] = 1; }
                    System.out.print (arrDiag[i][j]+ "\t");
                }
                System.out.println();
            }

        }
    }

//5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
//  типа int  длиной len, каждая ячейка которого равна initialValue;

    public static int[] arrFive ( int len, int initialValue) {
        int[] arr_5 = new int[len];
        for (int i = 0; i < len; i ++) {
            arr_5[i] = initialValue;
        }
        return arr_5;
    }



//6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

    public static void MaxMin (int[] arr){
        int i =0;
        int max = Math.max (arr[i], arr[i+1]);
        int min= Math.min (arr[i], arr[i+1]);
        for (i = 2; i < arr.length; i++){
            max = Math.max (max, arr[i]);
            min = Math.min (min, arr[i]);
        }
        System.out.println("min: " + min );
        System.out.println ("max: " + max );

    }


    //7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.


    public static boolean Balance (int[] arrBal){

        int sumFull = 0;
        for (int i = 0; i < arrBal.length; i++){
            sumFull = sumFull + arrBal[i];}
        int i =0;
        int summ = 0;
        while ((summ != sumFull-summ) && (i < arrBal.length)) {
            summ = summ + arrBal[i];
            i++;
        }
        return (summ != sumFull || sumFull == 0);}


}
