type Point = [number, number];

function distanceFromZero(point: Point) {
    return Math.sqrt(point[0] ** 2 + point[1] ** 2);
}

class Solution {
    kClosest(points: Point[], k: number): Point[] {
        return points
            .sort((a, b) => distanceFromZero(a) - distanceFromZero(b))
            .slice(0, k);
    }
}
