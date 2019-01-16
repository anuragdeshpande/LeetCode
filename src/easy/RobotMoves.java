package easy;


/*
    There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves,
    judge if this robot ends up at (0, 0) after it completes its moves.

    The move sequence is represented by a string, and the character moves[i] represents its ith move.
    Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.

    Note: The way that the robot is "facing" is irrelevant.
    "R" will always make the robot move to the right once,
    "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.

    Example 1:
    Input: "UD"
    Output: true

    Explanation: The robot moves up once, and then down once. All moves have the same magnitude,
    so it ended up at the origin where it started. Therefore, we return true.


    Example 2:
    Input: "LL"
    Output: false

    Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin.
    We return false because it is not at the origin at the end of its moves.
 */
public class RobotMoves {
    public static void main(String[] args) {
        RobotMoves tester = new RobotMoves();
        System.out.println(tester.judgeCircle("UD"));
        System.out.println(tester.judgeCircle("LL"));
    }

    /*
        My Solution - Algorithm:
        to replicate co-ordinates in a 2D plane,
        1. Initiate an int array with 0,0
        2. for each letter in the string
            2.a in switch
                2.a.1 Up: arr[1]++
                2.a.2 Down: arr[1]--
                2.a.3 Right: arr[0]++
                2.a.4 Left: arr[0]--
        3. if arr[0] and arr[1] are 0,0 respectively return true.
     */
    private boolean judgeCircle(String moves) {
        int[] position = new int[]{0,0};
        for(String move: moves.split("")){
            switch (move.toUpperCase()){
                case "U":
                    position[1]++;
                    break;
                case "D":
                    position[1]--;
                    break;
                case "L":
                    position[0]--;
                    break;
                case "R":
                    position[0]++;
                    break;
            }
        }

        return position[0] == 0 && position[1] == 0;
    }
}
