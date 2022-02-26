package of4.kode;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
    private Department parentDepartment;
    private Collection<Department> subDepartments = new ArrayList<>();
    private Collection<Employee> employees = new ArrayList<>();


    public Department(Department parentDepartment) {
        this.parentDepartment = parentDepartment;
        this.parentDepartment.addSubDepartment(this);
    }

    public Department(){

    }

    public Department getParentDepartment() {
        return parentDepartment;
    }

    private void addSubDepartment(Department subDepartment) {
        if (this.subDepartments.contains(subDepartment)) {
            throw new IllegalArgumentException("Cannot add the same subdepartment twice.");
        }
        this.subDepartments.add(subDepartment);
    }

    public boolean contains(Department other) {
        for (Department department : subDepartments) {
            if (department == other || department.contains(other)) {
                return true;
            }
        }
        return false;
    }

    public void addEmployee(Employee employee) {
        if (this.subDepartments.contains(employee)) {
            throw new IllegalArgumentException("Cannot add the same employee twice.");
        }
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        if (!this.subDepartments.contains(employee)) {
            throw new IllegalArgumentException("Cannot remove unavailable employee.");
        }
        this.employees.add(employee);
    }


    public static void main(String[] args) {
        
    }
}
