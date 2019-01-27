package easy;

import java.util.Arrays;
import java.util.TreeMap;

/*
    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
    (Here, the distance between two points on a plane is the Euclidean distance.)
    You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

    Example 1:
    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]

    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

    Example 2:
    Input: points = [[3,3],[5,-1],[-2,4]], K = 2
    Output: [[3,3],[-2,4]]

    (The answer [[-2,4],[3,3]] would also be accepted.)
 */

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin tester = new KClosestPointsToOrigin();
        System.out.println(Arrays.deepToString(tester.kClosest(new int[][]{{3,3}, {5,-1}, {-2,4}}, 2)));
    }


    /*
        Algorithm: Using tree map to naturally sort the lengths on insert.
        1. init a tree map <Double, Integer> to store the length of a given point and the index of the point
            from the original array
        2. for each point in the original array
            2.a calculate the distance from origin = underRoot(y2 - x2)
            2.b store the distance and the index of the point in the treeMap
        3. init index at 0 for index < K
            3.a get the first entry from the map
            3.b get corresponding value from the original point array
            3.c store the new found point in the result array
            3.d increment index.
        4. return result Array.

     */
    private int[][] kClosest(int[][] points, int K) {
        TreeMap<Double, Integer> lengthMap =  new TreeMap<>();
        int[][] resultArray = new int[K][2];
        for (int i = 0; i < points.length; i++) {
            lengthMap.put(distanceToOrigin(points[i]), i);
        }

        int index = 0;
        while(index < K){
            resultArray[index] = points[lengthMap.pollFirstEntry().getValue()];
            index++;
        }

        return resultArray;
    }

    private double distanceToOrigin(int[] point){
        int y = point[1];
        int x = point[0];
        return Math.sqrt((y*y) + (x*x));
    }
}
