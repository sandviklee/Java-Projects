package stateandbehavior;

public class Digit {
    int Base;
    int Value = 0;

    public Digit(int Base) {
        this.Base = Base;
        this.Value = 0;
    }

    public static String getCharForNumber(int i, int Base) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUWXYZ".toCharArray();
        if (i <= 10) {
            if (Base > 10) {
                if (i == 10) {
                    return Character.toString(alphabet[i-10]);
                }
                return String.valueOf(i);
            }
            return String.valueOf(i);
        }
        
        return Character.toString(alphabet[i-10]);
    }

    public int getValue() {
        return Value;
    }

    public boolean increment() {
        this.Value += 1;
        if (this.Value >= this.Base) {
            this.Value = 0;
            return true;
        }
        else {
            return false;
        }
        
    }

    public int getBase() {
        return this.Base;
    }

	public String getDigit() {
        return String.valueOf(getCharForNumber(this.Value, this.Base));
      
    }
    @Override
    public String toString() {
        return getDigit();
    }
        
    public static void main(String[] args) {
        System.out.println(getCharForNumber(11, 12));
    }

}
