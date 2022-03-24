package oving5;

public class Person1 implements Named{
    private String givenName;
    private String familyName;

    public Person1(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    @Override
    public void setGivenName(String givenName) {
        this.givenName = givenName;
        
    }
    @Override
    public String getGivenName() {
        return givenName;
    }
    @Override
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
        
    }
    @Override
    public String getFamilyName() {
        return familyName;
    }
    @Override
    public void setFullName(String fullName) {        
        String str[] = fullName.split(" ");
        this.givenName = str[0];
        this.familyName = str[1];
    }

    @Override
    public String getFullName() {
        return "" + givenName + " " + familyName + "";
    }

    @Override
    public String toString() {
        return this.getFullName();
    }

    
}


