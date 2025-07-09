import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Step 1: Pair position and speed
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Step 2: Sort cars by starting position descending (from target)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // Step 3: Stack to hold fleets (each as [pos, speed])
        Stack<double[]> stack = new Stack<>();
        stack.push(cars[0]);

        for (int i = 1; i < n; i++) {
            double[] back = cars[i];       // current car
            double[] front = stack.peek(); // fleet ahead

            double posBack = back[0], spdBack = back[1];
            double posFront = front[0], spdFront = front[1];

            if (spdBack <= spdFront) {
                // Slower or same speed → can't catch → new fleet
                stack.push(back);
            } else {
                // Faster → calculate time to collision
                double t = (posFront - posBack) / (spdBack - spdFront);
                double collidePoint = posBack + spdBack * t;

                if (collidePoint > target) {
                    // Won't catch before target → new fleet
                    stack.push(back);
                }
                // Else: it merges → do nothing
            }
        }

        return stack.size(); // Each element in stack is one fleet
    }
}
