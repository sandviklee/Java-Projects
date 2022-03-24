package oving5;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {
    private StringGrid stringGrid;
    private boolean rowMajor;
    private int rowCounter;
    private int columnCounter;
    private int currentCounter;
    private int currentCounter2;
    private int currentRow;
    private int currentColumn;

    public StringGridIterator(StringGrid stringGrid, boolean rowMajor) {
        this.stringGrid = stringGrid;
        this.rowMajor = rowMajor;
    }

    public void remove() {
        throw new UnsupportedOperationException("Du kan ikke fjerne et string-objekt fra rutenettet.");
    }

    @Override
    public boolean hasNext() {
        if (stringGrid.getElement(currentRow, currentColumn).equals(stringGrid.getElement(stringGrid.getRowCount()-1, stringGrid.getColumnCount()-1))) {
            return false;      
        } return true;
    }

    @Override
    public String next() {
        if (!(rowMajor)) {
            this.currentRow = currentCounter;
            this.currentColumn = columnCounter;
            if (rowCounter < stringGrid.getRowCount()) {
                this.currentCounter = rowCounter;
                rowCounter++;
                return stringGrid.getElement(currentCounter, columnCounter);
            } else {
                columnCounter++;
                rowCounter = 0;
                this.currentCounter2 = rowCounter;
                rowCounter++;
                return stringGrid.getElement(currentCounter2, columnCounter);
            }
            
        } else {
            this.currentRow = rowCounter;
            

            if (columnCounter < stringGrid.getColumnCount()) {
                this.currentCounter = columnCounter;
                columnCounter++;
                this.currentColumn = currentCounter;
                return stringGrid.getElement(rowCounter, currentCounter);
            } else {
                rowCounter++;
                columnCounter = 0;
                this.currentCounter2 = columnCounter;
                columnCounter++;
                return stringGrid.getElement(rowCounter, currentCounter2);
            }
        }
    }

    public static void main(String[] args) {
        StringGridImpl stringGrid = new StringGridImpl(2, 3);
		stringGrid.setElement(0, 0, "0, 0");
		stringGrid.setElement(0, 1, "0, 1");
		stringGrid.setElement(0, 2, "0, 2");
		stringGrid.setElement(1, 0, "1, 0");
		stringGrid.setElement(1, 1, "1, 1");
		stringGrid.setElement(1, 2, "1, 2");

 
        StringGridIterator iterator = new StringGridIterator(stringGrid, false);
        System.out.println(stringGrid.getElement(1, 2));
        System.out.println(stringGrid.getstringGrid());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        
        
        

        
    }
    
}
