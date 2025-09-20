package ru.mpei.lec3;

public class PalindromeChecker {


    public boolean check(int number){
        if (number < 0 ){
            throw new PalindromeException("number is negative");
        }

        String s = String.valueOf(number);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
