package oving5;

public class Person2 implements Named{
    private String fullName;
    public Person1 p;

    public Person2(String fullName) {
        this.fullName = fullName;
        String str[] = fullName.split(" ");
        p = new Person1(str[0],str[1]);
    }

    @Override
    public void setGivenName(String givenName) {
        String str[] = fullName.split(" ");
        this.fullName = givenName + " " + str[1];

        this.fullName = p.getFullName();
    }

    @Override
    public String getGivenName() {
        String str[] = fullName.split(" ");

        return p.getGivenName();
    }

    @Override
    public void setFamilyName(String familyName) {
        String str[] = fullName.split(" ");
        this.fullName = str[0] + " " + familyName;
    }

    @Override
    public String getFamilyName() {
        String str[] = fullName.split(" ");
        return str[1];
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
        
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return this.getFullName();
    }

}
