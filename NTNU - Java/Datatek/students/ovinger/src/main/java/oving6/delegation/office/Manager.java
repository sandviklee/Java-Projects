package oving6.delegation.office;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
    private Collection<Employee> employees = new ArrayList<>();
    private int tasksDone;
    
    public Manager(Collection<Employee> employees) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException();
        } 
        this.employees = employees;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        Employee employee = employees.stream().findAny().get();
        tasksDone++;
        return employee.doCalculations(operation, value1, value2);
    
    }

    @Override
    public void printDocument(String document) {
        Employee employee = employees.stream().findAny().get();
        tasksDone++;
        employee.printDocument(document);
    }

    @Override
    public int getTaskCount() {
        return tasksDone;
    }

    @Override
    public int getResourceCount() {
        int n = 0;
        for (Employee employee : employees) {
            n += employee.getResourceCount();
        } 
        return n + 1;
    }

    @Override
    public List<String> getDocumentList() {
        return null;
    }
    public static void main(String[] args) {
        Printer p = new Printer();
        Manager m = new Manager(Arrays.asList(new Manager(Arrays.asList(new Clerk(), new Clerk())),
            new Clerk(p), new Clerk(), new Clerk()));

        System.out.println(m.getResourceCount());
    
    }

}
