package Task2;

public class Employee implements Comparable<Employee> {

    int employeeId;
    String name;
    String department;
    public Employee(int employeeId, String name, String department) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    @Override
    public int compareTo(Employee other) {

        if (this.employeeId < other.employeeId) {
            return -1;
        }

        else if (this.employeeId > other.employeeId) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {

        return "ID      : " + employeeId +
                "\nName    : " + name +
                "\nDept    : " + department;
    }
}