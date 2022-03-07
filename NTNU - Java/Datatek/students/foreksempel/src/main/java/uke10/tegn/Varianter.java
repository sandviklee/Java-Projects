package uke10.tegn;

import java.util.ArrayList;
import java.util.List;

public class Varianter {
    public static void main(String[] args) {
        
        List<Character> charList = new ArrayList<>();
        charList.add('a');
        charList.add('b');
        charList.add('c');
        for (int i = 0; i < charList.size(); i++) {
            Character c = charList.get(i);
        System.out.println(c);
        }

        String s = "def";
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            System.out.println(c);
        }

        char[] charArray = "ghi".toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            Character c = charArray[i];
            System.out.println(c);
        }
    }
}
