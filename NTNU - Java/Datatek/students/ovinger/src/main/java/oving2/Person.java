package oving2;

import java.util.Arrays;
import java.util.Date;

public class Person {
    private String name;
    private String Fname;
    private String Lname;
    private String email;
    private Date date;
    private char gender;

    public void setName(String name) throws IllegalArgumentException {
        try {
            String[] arrOfString = name.split(" ");
            if ((arrOfString[0].length() >= 2 && arrOfString[1].length() >= 2) && (arrOfString.length == 2) && ((arrOfString[0].matches("[a-zA-Z]+") && (arrOfString[1].matches("[a-zA-Z]+"))))) {
                this.Fname = arrOfString[0];
                this.Lname = arrOfString[1];
                this.name = Fname + " " + Lname;
            }
            else throw new IllegalArgumentException("Not a usable name.");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Missing space in: " + name);
        }
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        try {
            //"Liste" med alle landskodene.
            String[] strArray = {"ad", "ae", "af", "ag", "ai", "al", 
            "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", 
            "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", 
            "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", 
            "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", 
            "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", 
            "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", 
            "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", 
            "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", 
            "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", 
            "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", 
            "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", 
            "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", 
            "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", 
            "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", 
            "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", 
            "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", 
            "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", 
            "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", 
            "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", 
            "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", 
            "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", 
            "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", 
            "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", 
            "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", 
            "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", 
            "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", 
            "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};

            if (email != null) {
                //Danner lister som "splitter" opp teksten.
                String[] arrOfStrings = email.split("@");
                String[] arrOfStr1 = arrOfStrings[0].split("[.]");
                String[] arrOfStr2 = arrOfStrings[1].split("[.]");
                String fname = arrOfStr1[0].toLowerCase();
                String lname = arrOfStr1[1].toLowerCase();
        
                //Sjekker om fornavn og etternavn er likt som det som ble oppgitt. 
                if (fname.equals(Fname.toLowerCase()) && lname.equals(Lname.toLowerCase())) {
                    /*Hvis navnene er like, vil det gå videre til en sjekk av at 
                    landskoden oppgitt på slutten er brukbar. */

                    //System.out.println(arrOfStr2[0].length());
                    if (arrOfStr2[0].length() >= 1) {
                        if (Arrays.stream(strArray).anyMatch(arrOfStr2[1]::equals)) {
                            this.email = email;
                        }
                        else throw new IllegalArgumentException("This Email does not have a valid countrycode.");
                    }
                    else throw new IllegalArgumentException("Not usable Email.");
                }
                else throw new IllegalArgumentException("This Email is not corresponding with the name.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Not usable Email.");
            }
        }

    public String getEmail() {
        return email;
    }
    
    public void setBirthday(Date date) {
        Date date1 = new Date();
        if (!date.after(date1)) {
            this.date = date;
        }
        else throw new IllegalArgumentException("This date is a future date.");
    }

    public Date getBirthday() {
        return date;
    }

    public void setGender(char gender) {
        if (gender == 'M' || gender == 'F' || gender == '\0') {
            this.gender = gender;
        }
        else throw new IllegalArgumentException("Not a gender.");
    }

    public char getGender() {
        return gender;
    }

    public static void main(String[] args) {
        Person Per = new Person();
        Per.setName("Per Olav");
        System.out.println(Per.getName());
        Per.setEmail("Per.Olav@gmail.no");
        System.out.println(Per.getEmail());

    }
}

