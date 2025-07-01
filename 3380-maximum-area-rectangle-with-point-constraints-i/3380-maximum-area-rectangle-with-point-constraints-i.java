class Solution {
    public int maxRectangleArea(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        Set<Integer> Xs = new HashSet<>();
        Set<Integer> Ys = new HashSet<>();

        for (int[] p : points) {
            pointSet.add(p[0] + "," + p[1]);
            Xs.add(p[0]);
            Ys.add(p[1]);
        }

        List<Integer> xList = new ArrayList<>(Xs);
        List<Integer> yList = new ArrayList<>(Ys);
        int maxArea = 0;

        for (int i = 0; i < xList.size(); i++) {
            for (int j = i + 1; j < xList.size(); j++) {
                for (int a = 0; a < yList.size(); a++) {
                    for (int b = a + 1; b < yList.size(); b++) {
                        int x1 = xList.get(i), x2 = xList.get(j);
                        int y1 = yList.get(a), y2 = yList.get(b);

                        int left = Math.min(x1, x2), right = Math.max(x1, x2);
                        int bottom = Math.min(y1, y2), top = Math.max(y1, y2);

                        // Check corners
                        if (pointSet.contains(left + "," + bottom) &&
                                pointSet.contains(left + "," + top) &&
                                pointSet.contains(right + "," + bottom) &&
                                pointSet.contains(right + "," + top)

                        ) {
                            // Ensure no internal points
                            boolean hasInside = false;
                            for (int[] p : points) {
                                int px = p[0], py = p[1];
                                String pStr = px + "," + py;

                                // Skip the points on border
                                if (pStr.equals(left + "," + bottom) ||
                                        pStr.equals(left + "," + top) ||
                                        pStr.equals(right + "," + bottom) ||
                                        pStr.equals(right + "," + top)) {
                                    continue;
                                }

                                // If any point lies inside or on the border, disqualify
                                if (px >= left && px <= right && py >= bottom && py <= top) {
                                    hasInside = true;
                                    break;
                                }
                            }

                            if (!hasInside) {
                                int area = (right - left) * (top - bottom);
                                maxArea = Math.max(maxArea, area);
                            }
                        }
                    }
                }
            }
        }

        return maxArea!=0?maxArea:-1;
    }
}
