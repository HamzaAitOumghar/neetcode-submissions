class Solution {
    class Point {
        public int x;
        public int y;
        public double distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(x * x + y * y);
        }

        @Override
        public String toString() {
            return "Point{x=" + x + ", y=" + y + ", distance=" + distance + "}";
        }


    }

    public int[][] kClosest(int[][] points, int k) {
        List<Point> pts = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            pts.add(new Point(points[i][0], points[i][1]));
        }

        pts.sort((a, b) -> Double.compare(a.distance, b.distance));
        System.out.println(pts);

        int[][] result = new int[k][2];

        for(int i=0;i<k;i++){

            Point p = pts.get(i);

            result[i][0]=p.x;
            result[i][1]=p.y;
        }

        return result;
    }
}
