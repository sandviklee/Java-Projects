package oving5;

public interface StringGrid {
    public int getRowCount();

    public int getColumnCount();

    public String getElement(int row, int column);

    public void setElement(int row, int column, String element);

}
