public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        for (int i = 0; i < 11; i++) {
            EmployeeBook.contentEmployeeBook();
        }
        EmployeeBook.listAllEmployees();
        EmployeeBook.calculateAverageSalary();
        EmployeeBook.findTaxValues("PROGRESSIVE");
        EmployeeBook.indexTheSalary(2);
        EmployeeBook.compareSalary(3, 100000);
        EmployeeBook.compareSalary2(100000, 2);
        EmployeeBook.compareDepartment(2);
        EmployeeBook.searchByID(10);
    }
}