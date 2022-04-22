package oving6.delegation.office;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Clerk implements Employee {
    private Printer printer;
    public List<String> documentList = new ArrayList<>();
    public int calculations;
    
    public Clerk() {};

    public Clerk(Printer printer) {
        this.printer = printer;
    };

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        calculations++;
        return operation.apply(value1, value2);
    }

    @Override
    public void printDocument(String document) {
        printer.printDocument(document, this);
    }

    @Override
    public int getTaskCount() {
        return calculations + getDocumentList().size();
    }

    @Override
    public int getResourceCount() {
        return 1;
    }

    @Override
    public List<String> getDocumentList() {
        return documentList;
    }
    
    public static void main(String[] args) {
        Clerk c = new Clerk(new Printer());

        c.printDocument("Hei Simon");
        System.out.println(c.getDocumentList());
    }
}
