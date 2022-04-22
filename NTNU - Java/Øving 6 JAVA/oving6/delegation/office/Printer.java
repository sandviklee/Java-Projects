package oving6.delegation.office;

import java.util.ArrayList;
import java.util.List;

public class Printer {  

    public void printDocument(String document, Employee employee) {
        System.out.println(document);
        employee.getDocumentList().add(document);

    };

    public List<String> getPrintHistory(Employee employee) {
        List<String> liste = new ArrayList<>(employee.getDocumentList());
        return liste;
        
    }

}
