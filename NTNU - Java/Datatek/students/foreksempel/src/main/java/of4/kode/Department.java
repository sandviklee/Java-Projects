package of4.kode;

public class Department {
    private Department parentDeptartment;

    public Department(Department parentDepartment) {
        this.parentDeptartment = parentDepartment;
    }

    public Department(){

    }

    public Department getParentDepartment() {
        return parentDeptartment;
    }

    public static void main(String[] args) {
        
    }
}
