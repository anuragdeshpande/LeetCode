package easy;

/*
    You are playing the following Nim Game with your friend:
    There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
    The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

    Both of you are very clever and have optimal strategies for the game.
    Write a function to determine whether you can win the game given the number of stones in the heap.
 */
public class NimGame {
    public static void main(String[] args) {
        NimGame tester = new NimGame();
        System.out.println(tester.canWinNim(4));
    }

    /*
        Algorithm:
        1. The only way the player would win the game is if player can pick up the last remaining stones all at one.
        2. we need to make sure it is always 1,2,3
        3. to ensure that is the only option, if the number is not divisible by 4, the only remaining options are
            1,2,3
        4. Hence the only check we need to make is if the number is not divisible by 4, then we can win the game.
     */
    private boolean canWinNim(int n) {
        return n%4 != 0;
    }
}
