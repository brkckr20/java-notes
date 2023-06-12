
public class Employee {

    private String name;
    public double salary;
    private int workHour, hireYear;

    Employee(int hireYear, int workHour, double salary, String name) {
        this.name = name;
        this.salary = salary;
        this.workHour = workHour;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (this.salary >= 1000) {
            return this.salary * 0.03;
        }
        return 0.0;
    }

    public double bonus() {
        int extraHours = this.workHour - 40;
        if (extraHours > 0) {
            return 30 * extraHours;
        }
        return 0.0;
    }

    public double increase() {
        int year = 2023 - this.hireYear;
        if (year < 10) {
            return salary * 0.5;
        } else if (year >= 10 && year < 20) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    public void toString(Employee emp) {
        System.out.println("Tax : " + emp.tax());
        System.out.println("Bonus : " + emp.bonus());
        System.out.println("Increase salary : " + emp.increase());
        double totalSalary = emp.salary - emp.tax() + emp.bonus();
        System.out.println("Total Salary : " + totalSalary);
        System.out.println("Raise of salary : " + (emp.salary + emp.increase()));
    }

}
