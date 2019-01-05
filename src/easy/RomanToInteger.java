package easy;

import medium.IntToRoman;
import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        IntToRoman intToRoman = new IntToRoman();
//        System.out.println(romanToInteger.romanToInt("XIV"));
//
//
        for (int i = 1; i <= 3999; i++) {
            if(romanToInteger.romanToInt(intToRoman.intToRoman1(i)) != i){
                System.out.println(i);
            }
        }
    }

    // non brute force - less efficient in this case but extensible
    private int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        String[] split = s.split("");
        int resultVal = 0;
        for (int i = 0; i < split.length; i++) {
            String currentChar = split[i];
            String previousChar = "";
            if(i > 0){
                previousChar = split[i-1];
            }

            int currentVal = map.get(currentChar);
            Integer previousVal = map.get(previousChar);
            if(!(null == previousVal)){
                resultVal = currentVal > previousVal ? Math.abs((resultVal + (currentVal - previousVal))-previousVal) : resultVal + currentVal;
            } else {
                resultVal += currentVal;
            }
        }

        return resultVal;
    }

    // Brute Force - non extensible
    private int romanToIntBruteForce(String s){
        int sum=0;
        if(s.contains("IV")){sum-=2;}
        if(s.contains("IX")){sum-=2;}
        if(s.contains("XL")){sum-=20;}
        if(s.contains("XC")){sum-=20;}
        if(s.contains("CD")){sum-=200;}
        if(s.contains("CM")){sum-=200;}

        char[] c = s.toCharArray();
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(c[i]=='M') sum+=1000;
            if(c[i]=='D') sum+=500;
            if(c[i]=='C') sum+=100;
            if(c[i]=='L') sum+=50;
            if(c[i]=='X') sum+=10;
            if(c[i]=='V') sum+=5;
            if(c[i]=='I') sum+=1;
        }

        return sum;
    }
}
