package medium;

import java.util.TreeMap;

public class IntToRoman {
    public static void main(String[] args) {
        IntToRoman tester = new IntToRoman();
        for(int i = 1; i <= 3999; i++){
            String sol1 = tester.intToRoman1(i);
            String sol2 = tester.intToRoman2(i);
            if(!sol1.equals(sol2)){
                System.out.println(i + "("+sol1 +" - "+ sol2 +")");
            }
        }
    }


    // Solution 1
    private String intToRoman1(int num) {
        StringBuilder roman = new StringBuilder();
        while(num > 0){
            if(num >= 1000){
                roman.append("M");
                num = num - 1000;
                continue;
            }

            if(num >= 900){
                roman.append("CM");
                num = num - 900;
                continue;
            }

            if(num >= 500 ){
                roman.append("D");
                num = num - 500;
                continue;
            }

            if(num >= 400){
                roman.append("CD");
                num = num - 400;
                continue;
            }

            if(num >= 100){
                roman.append("C");
                num = num- 100;
                continue;
            }

            if(num >= 90){
                roman.append("XC");
                num = num - 90;
                continue;
            }

            if(num >= 50){
                roman.append("L");
                num = num - 50;
                continue;
            }

            if(num >= 40){
                roman.append("XL");
                num = num - 40;
                continue;
            }

            if(num >= 10){
                roman.append("X");
                num = num- 10;
                continue;
            }
            if(num >= 9){
                roman.append("IX");
                num = num -9;
                continue;
            }

            if(num >= 5){
                roman.append("V");
                num = num -5;
                continue;
            }

            if(num >= 4){
                roman.append("IV");
                num = num - 4;
                continue;
            }

            if(num >= 1){
                roman.append("I");
                num = num - 1;
            }

        }

        return roman.toString();
    }

    // Solution 2
    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    private String intToRoman2(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + intToRoman2(number-l);
    }

}
