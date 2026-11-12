class CountSquares {

    Map<Integer, Map<Integer, Integer>> pointsCount;

    public CountSquares() {
        pointsCount = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];

        pointsCount.putIfAbsent(x, new HashMap<>());
        pointsCount.get(x).put(y, pointsCount.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x1 = point[0], y1 = point[1];
        int totalSquares = 0;

        if (!pointsCount.containsKey(x1)) {
            return 0;
        }

        for (Map.Entry<Integer, Integer> entry : pointsCount.get(x1).entrySet()) {
            int y2 = entry.getKey();
            int countY2 = entry.getValue();

            if (y2 == y1) {
                continue;
            }

            int sideLength = Math.abs(y2 - y1);

            for (int x2 : new int[]{x1 + sideLength, x1 - sideLength}) {
                if (pointsCount.containsKey(x2)) {
                    int count1 = pointsCount.get(x2).getOrDefault(y1, 0);
                    int count2 = pointsCount.get(x2).getOrDefault(y2, 0);

                    totalSquares += countY2 * count1 * count2;
                }
            }
        }

        return totalSquares;
    }
}