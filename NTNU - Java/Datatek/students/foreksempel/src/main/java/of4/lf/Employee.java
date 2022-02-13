package of4.lf;

public class Employee {

    private Department employer;

    public Employee(Department employer) {
        this.employer = employer;
        this.employer.addEmployee(this);
    }

    public void promote() {
        if (employer == null) {
            throw new IllegalStateException("No department to promote employee from!");
        }
        if (employer.getParentDepartment() == null) {
            throw new IllegalStateException("No department to promote employee to!");
        }
        employer.removeEmployee(this);
        employer = employer.getParentDepartment();
        employer.addEmployee(this);
    }

    public void quit() {
        if (employer == null) {
            throw new IllegalStateException("No department to quit!");
        }
        employer.removeEmployee(this);
        employer = null;
    }

    public Department getDepartment() {
        return employer;
    }

}
