package Lesson_5;

public class EmplList {

    public static void main(String[] args) {

        //4 Создание массива из 5 сотрудников.

        Employee chief = new Employee("И.И.Иванов", "Директор", "ivanov@company.ru", "+7 777-777-77-77", "120 000 руб", 49);
        Employee engineer = new Employee("П.П.Петров", "инженер", "petrov@company.ru", "+7 777-777-77-76", "65000 руб", 37);
        Employee developer = new Employee("Н.Н.Николаев", " программист", "nickolajev@company.ru", "+7-777-777-77-78", "100 000 руб", 28);
        Employee janitor = new Employee("С.С.Сидоров", "вахтер", "checkpoint@company.ru", "+7-777-777-77-73", "15000 руб", 85);
        Employee accountant = new Employee("М.М.Михайлова", "бухгалтер", "mihajlova@company.ru", "+7-777-777-77-79", "500000 руб", 32);

        Employee[] staff = {chief, engineer, developer, janitor, accountant};

        // 3. Вывод информации об объектах на консоль.

        System.out.println(chief.getData());
        System.out.println(engineer.getData());
        System.out.println(developer.getData());
        System.out.println(janitor.getData());
        System.out.println(accountant.getData());
        System.out.println("******************");



        // Вывод информации об объектах как элементах массива.

        System.out.println (staff[0].getData());
        System.out.println (staff[1].getData());
        System.out.println (staff[2].getData());
        System.out.println (staff[3].getData());
        System.out.println (staff[4].getData());
        System.out.println("******************");

        //5  Вывод информации о сотрудниках страше 40 лет

        ageEvaluation( staff);

    }

    public static void ageEvaluation(Employee[] arr) {
        for (int i = 0; i < 5; i++) {
            if (arr[i].getAge() > 40)
                System.out.println(arr[i].getData());
        }

    }
}