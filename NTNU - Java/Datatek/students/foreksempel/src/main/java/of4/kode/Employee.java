package of4.kode;

public class Employee {

    private Department employer;

    public Employee(Department department) {
        this.employer = department;
        this.employer.addEmployee(this); 
    }
    
    public void promote() {
        if (employer == null || this.employer == this.employer.getParentDepartment()) {
            throw new IllegalArgumentException("No way to promote.");
        }
        this.employer.removeEmployee(this);
        this.employer = this.employer.getParentDepartment();
        this.employer.addEmployee(this);
    }

    public void quit() {
        if (employer == null) {
            throw new IllegalArgumentException("No new department to leave!");
        }
        this.employer.removeEmployee(this);
        this.employer = null;
    }
}
