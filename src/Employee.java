import java.util.Objects;

public class Employee {
    private final String surName;
    private final String name;
    private final String patronymic;
    private int department;
    private int salary;
    private static int counter = 0;
    private final int id;

    public Employee(String surName, String name, String patronymic, int department, int salary) {
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        id = ++counter;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return  Objects.equals(salary, employee.salary);
    }
    @Override
    public String toString() {
        return "Сотрудник " + id + ": "+surName + " " + name + " " + patronymic + ". Отдел: " +department + ". Зарплата: " + salary+" рублей в месяц.";
    }
    public void printShortInfo() {
        System.out.println("Сотрудник: " +surName + " " + name + " " + patronymic + " получает в месяц = " + salary +" рублей.");
    }

}