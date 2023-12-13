package stream.practice;

import lamba.excercises.StringEmpty;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        // TODO
        // QnA
        listAllDistinctProjectInNonAscendingOrder();
        printEmployeeNameStartsWithA();
        listEmployeesJoinedInYear2023();
        printMinSalary();
        listPeopleWorkingOn2Projects();
        countTotalLaptops();
    }

    private static void listAllDistinctProjectInNonAscendingOrder() {
        System.out.println("==== listAllDistinctProjectInNonAscendingOrder =====");
        App.employeeList.stream()
                .flatMap(p -> p.getProjects().stream())
                .sorted(Comparator.comparing(Project::getName, Comparator.reverseOrder()))
                .distinct()
                .forEach(App::convertToString);
    }

    private static void printEmployeeNameStartsWithA() {
        System.out.println("=== printEmployeeNameStartsWithA ======= ");
        App.employeeList.stream()
                .filter(employee -> employee.getFirstName().startsWith("A"))
                .forEach(App::convertToString);

    }

    private static void listEmployeesJoinedInYear2023() {
        System.out.println("=== listEmployeesJoinedInYear2023 ======= ");
        App.employeeList.stream()
                .filter(employee -> employee.getId().startsWith("2023"))
                .forEach(App::convertToString);
    }

    private static void printMinSalary() {
        System.out.println("=== printMinSalary ======= ");
        Employee employee = App.employeeList.stream()
                .min(Comparator.comparing(Employee::getSalary)).orElseThrow();
        convertToString(employee);
    }

    private static void listPeopleWorkingOn2Projects() {
        System.out.println("=== listPeopleWorkingOn2Projects ======= ");
        List<Employee> employees = App.employeeList.stream()
                .filter(e -> e.getProjects().size() > 2).toList();
        employees.forEach(App::convertToString);
    }

    private static void countTotalLaptops() {
        System.out.println("=== countTotalLaptops ======= ");
        int total = App.employeeList.stream()
                .mapToInt(Employee::getTotalLaptopsAssigned)
                .sum();
        System.out.println(total);


    }

    private static void convertToString(Project project) {
        System.out.printf("%-12s PM: %20s Team:%s%n", project.getName(), project.getProjectManager(), project.getTeam());
    }
    private static void convertToString(Employee employee) {
        System.out.printf("id: %-12s sal:%8d fn:%-8s ln:%-10s%n", employee.getId(), employee.getSalary(), employee.getFirstName(), employee.getLastName());
    }
}
