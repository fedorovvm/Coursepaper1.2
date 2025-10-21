import java.util.Random;

public class EmployeeBook {
    private final static Random RANDOM = new Random();
    private final static String[] surName = {"Андреев", "Сергеев", "Михайлов", "Павлов", "Олегов", "Орлов", "Кукушкин", "Иванов"};
    private final static String[] name = {"Андрей", "Сергей", "Виктор", "Михаил", "Павел", "Олег", "Фёдор", "Геннадий"};
    private final static String[] patronymic = {"Андреевич", "Сергеевич", "Викторович", "Михайлович", "Павлович", "Олегович", "Фёдорович", "Геннадьевич"};

    private static Employee[] employees = new Employee[10];

    public static void contentEmployeeBook() {
        int e = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                e++;
            } else if (employee == null) {
                employees[e] = new Employee (surName[RANDOM.nextInt(0, surName.length)],   name[RANDOM.nextInt(0, name.length)],  patronymic[RANDOM.nextInt(0, patronymic.length)], RANDOM.nextInt(1,6), RANDOM.nextInt(50000, 450000));
                System.out.println("Новый сотрудник успешно добавлен: "+employees[e]);
                break;
            }
            if (e == employees.length) {
                System.out.println(false);
            }
        }
    }

    public static void listAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }
    public static void calculateAverageSalary() {
        int sumSalary = 0;
        int numberOfPeople = 0;
        double AverageSalary = 0;
        for (Employee employee : EmployeeBook.employees) {
            if (employee != null) {
                sumSalary += employee.getSalary();
                numberOfPeople++;
            } else break;
        }
        AverageSalary = (double) sumSalary / numberOfPeople;
        System.out.println("Средняя зарплата = " + AverageSalary + " рублей в месяц.");
    }
    public static void findTaxValues(String typeOfTaxation) {
        switch (typeOfTaxation) {
            case "PROPORTIONAL":
                for (Employee employee : employees) {
                    if (employee != null) {
                        System.out.println(employee.getSalary() * 0.13d);
                    }
                }
                break;
            case "PROGRESSIVE":
                for (Employee employee : employees) {
                    if (employee != null) {
                        double percent=0;
                        if (employee.getSalary() <= 150000) {
                            percent = 0.13d;
                        } else if (employee.getSalary() > 150000 && employee.getSalary() <= 350000) {
                            percent = 0.17d;
                        } else if (employee.getSalary() > 350000) {
                            percent = 0.21d;
                        }
                        double taxValues = employee.getSalary() * percent;
                        System.out.println(taxValues);
                    }
                }
                break;
        }
    }
    public static void indexTheSalary(int numberDepartment) {
        for (Employee employee : employees)
            if (employee != null) {
                if (employee.getDepartment() == numberDepartment) {
                    employee.setSalary((int) ((1 + numberDepartment/100) * employee.getSalary()));
                    System.out.println("Зарплата сотрудника № " + employee.getId() + " из отдела № " + employee.getDepartment() + " после индексации равна " + employee.getSalary());
                } else { continue;}

            }
    }
    public static void compareSalary(int numberDepartment, int salaryAmount) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == numberDepartment && employee.getSalary() > salaryAmount) {
                    employee.printShortInfo();
                    break;
                }
            }
        }
    }
    public static void compareSalary2(int wage, int employeeNumber) {
        int i = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                while (i < employeeNumber && employee.getSalary() < wage) {
                    System.out.println(employee);
                    i ++;
                    break;
                }
            }
        }
    }
    public static void compareDepartment(int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == departmentNumber) {
                    System.out.println(employee.equals(employee));
                }
            }
        }
    }
    public static void searchByID(int ID) {
        for (Employee employee : employees)
            if (employee != null) {
                if (employee.getId() == ID) {
                    System.out.println(employee);
                    break;
                }
                else {
                    continue;
                }
            }
            else {
                System.out.println("Сотрудник под №" + ID + " не найден.");
            }

    }
}