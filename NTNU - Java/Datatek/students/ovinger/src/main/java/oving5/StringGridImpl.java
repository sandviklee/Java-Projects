package oving5;


import java.util.ArrayList;

public class StringGridImpl implements StringGrid{
    private ArrayList<ArrayList<String>> stringGrid = new ArrayList<>();
    private int rows;
    private int columnCount;

    public StringGridImpl(int rows, int columnCount) {
        this.rows = rows;
        this.columnCount = columnCount;
        stringGrid = new ArrayList<>();
        ArrayList<String> innerStringGrid = new ArrayList<>();
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < rows; j++) {
                innerStringGrid.add("");
            }
            stringGrid.add(innerStringGrid);
            innerStringGrid = new ArrayList<>();
        }
    }

    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getElement(int row, int column) {
        if (row <= rows && column <= columnCount) {
            return stringGrid.get(column).get(row);
        } else throw new IllegalArgumentException("Not available in range to get.");
    }

    @Override
    public void setElement(int row, int column, String element) {
        if (row <= rows && column <= columnCount) {
            stringGrid.get(column).remove("");
            stringGrid.get(column).add(row, element);
        } else {
            System.out.println("Not available in range to set.");
        }
    }

    public ArrayList<ArrayList<String>> getstringGrid() {
        return stringGrid;
    }
    public static void main(String[] args) {
        StringGridImpl stringGrid = new StringGridImpl(2, 3);
        stringGrid.setElement(0, 0, "0, 0");
		stringGrid.setElement(0, 1, "0, 1");
		stringGrid.setElement(0, 2, "0, 2");
		stringGrid.setElement(1, 0, "1, 0");
		stringGrid.setElement(1, 1, "1, 1");
		stringGrid.setElement(1, 2, "1, 2");
        System.out.println(stringGrid.getstringGrid());

        System.out.println(stringGrid.getColumnCount());
        System.out.println(stringGrid.getElement(1, 2));
        
    }
}

