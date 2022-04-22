package oving6.delegation.office;

import java.util.List;
import java.util.function.BinaryOperator;

public interface Employee {

    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2);

    public void printDocument(String document);

    public int getTaskCount();

    public int getResourceCount();

    public List<String> getDocumentList();

}
