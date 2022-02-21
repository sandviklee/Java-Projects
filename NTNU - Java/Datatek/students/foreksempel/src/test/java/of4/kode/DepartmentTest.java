package of4.kode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class DepartmentTest {
    
    @Test
    public void testConstructor() {
        Department oopNorge = new Department();
        Department oopMini = new Department(oopNorge);

        assertEquals(oopNorge, oopMini.getParentDepartment(), "OOP mini should be a subunit of OOP Norge");
        assertNotNull(oopNorge.getParentDepartment(), "OOP Norge should not have a parentDepartment");
    }

}   
