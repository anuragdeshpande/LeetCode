package easy;

public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones tester = new JewelsAndStones();
        System.out.println(tester.numJewelsInStones("aA", "aAAbbbbaA"));
    }

    private int numJewelsInStones(String J, String S) {
        int jewelsFound = 0;
        for(String jewel : J.split("")){
            for(String stone: S.split("")){
                if(jewel.equals(stone)){
                    jewelsFound++;
                }
            }
        }

        return jewelsFound;
    }
}
