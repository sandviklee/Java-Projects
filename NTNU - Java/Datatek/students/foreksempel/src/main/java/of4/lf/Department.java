package of4.lf;

import java.util.ArrayList;
import java.util.Collection;

public class Department {

    private Department parentDepartment;
    private Collection<Department> subDepartments = new ArrayList<>();
    private Collection<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(Department parentDepartment) {
        this.parentDepartment = parentDepartment;
        this.parentDepartment.addSubDepartment(this);
    }

    public Department getParentDepartment() {
        return parentDepartment;
    }

    private void addSubDepartment(Department subDepartment) {
        if (subDepartments.contains(subDepartment)) {
            throw new IllegalArgumentException("Sub-department can't be added twice!");
        }
        subDepartments.add(subDepartment);
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
        if (employees.contains(employee)) {
            throw new IllegalArgumentException("Employee can't be added twice!");
        }
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new IllegalArgumentException("This is not an employee of this department!");
        }
        this.employees.remove(employee);
    }

    // Oppgave 10 (ekstraoppgave)
    // Her er cluet å sørge for at det er konsistent og gyldig tilstand.
    // Skriv tester og prøv forskjellige edge-cases for å se at ting blir riktig.
    public void moveToDepartment(Department newDepartment) {
        if (newDepartment == this) {
            throw new IllegalArgumentException("Department cannot be a subunit of itself");
        }
        if (newDepartment == this.parentDepartment) {
            throw new IllegalArgumentException("Department is already a subunit of the the provided department");
        }
        if (this.parentDepartment != null && this.parentDepartment.contains(this)) {
            this.parentDepartment.removeChildDepartment(this);
        }
        this.parentDepartment = newDepartment;
        if (newDepartment != null && !newDepartment.contains(this)) {
            newDepartment.addSubDepartment(this);
        }
    }

    public void removeChildDepartment(Department department) {
        if (!subDepartments.contains(department)) {
            throw new IllegalArgumentException("The provided department is not a subunit of this department");
        }
        subDepartments.remove(department);
        if (department.getParentDepartment() == this) {
            department.moveToDepartment(null);
        }
    }

}
