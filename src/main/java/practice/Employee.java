package practice;

import java.util.List;

public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private int salary;
    private int totalLaptopsAssigned;
    // OneToMany
    private List<Project> projects;
    private String department;

    Employee(){
    }

    public Employee(String id, String firstName, String lastName, int salary, int totalLaptopsAssigned,
                    List<Project> projects, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.totalLaptopsAssigned = totalLaptopsAssigned;
        this.projects = projects;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", projects="
                + projects + "]";
    }
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public int getSalary() {
        return salary;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public int getTotalLaptopsAssigned() {
        return totalLaptopsAssigned;
    }

    public String getDepartment() {
        return department;
    }
}
