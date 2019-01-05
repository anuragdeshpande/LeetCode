package easy;

public class AddDigits {
    public static void main(String[] args) {
        AddDigits tester = new AddDigits();
        System.out.println(tester.addDigits(38));
        System.out.println(tester.digitalRoot(38));
    }

    // My solution
    private int addDigits(int num) {
        int result = 0;
        while(num > 0){
            result += num%10;
            num = num/10;
            if(num == 0 && result > 9){
                num = result;
                result = 0;
            }
        }

        return result;
    }

    // Digital Root (No Loop Solution) - wikipedia article - https://en.wikipedia.org/wiki/Digital_root
    private int digitalRoot(int num){
        return num - 9*((int)Math.floor((int)((num-1)/9)));
    }
}
