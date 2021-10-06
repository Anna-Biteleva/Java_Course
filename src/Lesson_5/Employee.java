package Lesson_5;

//1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private String salary;
    private int age;


    //  2. Конструктор класса должен заполнять эти поля при создании объекта.

    public Employee(String fullName, String position, String email, String phone, String salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.


    public String getData() {
        return ("ФИО: " + this.fullName + ", Должность: " + this.position + ", email: " + this.email + ", Телефон: " + this.phone + ", Зарплата: " +
                this.salary + ", Возраст:" + this.age);
    }
}






