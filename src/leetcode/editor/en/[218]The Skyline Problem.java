//A city's skyline is the outer contour of the silhouette formed by all the buil
//dings in that city when viewed from a distance. Now suppose you are given the lo
//cations and height of all the buildings as shown on a cityscape photo (Figure A)
//, write a program to output the skyline formed by these buildings collectively (
//Figure B). 
// 
//
// The geometric information of each building is represented by a triplet of int
//egers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right 
//edge of the ith building, respectively, and Hi is its height. It is guaranteed t
//hat 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all 
//buildings are perfect rectangles grounded on an absolutely flat surface at heigh
//t 0. 
//
// For instance, the dimensions of all buildings in Figure A are recorded as: [ 
//[2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] . 
//
// The output is a list of "key points" (red dots in Figure B) in the format of 
//[ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key poin
//t is the left endpoint of a horizontal line segment. Note that the last key poin
//t, where the rightmost building ends, is merely used to mark the termination of 
//the skyline, and always has zero height. Also, the ground in between any two adj
//acent buildings should be considered part of the skyline contour. 
//
// For instance, the skyline in Figure B should be represented as:[ [2 10], [3 1
//5], [7 12], [12 0], [15 10], [20 8], [24, 0] ]. 
//
// Notes: 
//
// 
// The number of buildings in any input list is guaranteed to be in the range [0
//, 10000]. 
// The input list is already sorted in ascending order by the left x position Li
//. 
// The output list must be sorted by the x position. 
// There must be no consecutive horizontal lines of equal height in the output s
//kyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not accepta
//ble; the three lines of height 5 should be merged into one in the final output a
//s such: [...[2 3], [4 5], [12 7], ...] 
// 
// Related Topics Divide and Conquer Heap Binary Indexed Tree Segment Tree Line 
//Sweep


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        PriorityQueue<Event> queue = new PriorityQueue<>(new Comparator<Event>(){
            public int compare(Event e1, Event e2) {
                if (e1.x != e2.x) {
                    return e1.x - e2.x;
                } else {
                    if (e1.typ != e2.typ) {
                        return e1.typ == 0 ? -1 : 1;

                    } else {
                        if (e1.typ == 0) {
                            // entering
                            return e2.h - e1.h;
                        } else {
                            return e1.h - e2.h;
                        }
                    }
                }
            }
        });
        int id = 0;
        for (int[] building : buildings) {
            Event entering = new Event(building[0], building[2], 0, id);
            Event leaving = new Event(building[1], building[2], 1, id);
            id++;
            queue.offer(entering);
            queue.offer(leaving);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(0, 1);
        while (!queue.isEmpty()) {
            Event cur = queue.poll();
            if (cur.typ == 0) {
                // entering
                if (map.firstKey() < cur.h) {
                    List<Integer> node = new LinkedList<>();
                    node.add(cur.x);
                    node.add(cur.h);
                    ret.add(node);
                }
                map.put(cur.h, map.getOrDefault(cur.h, 0) + 1);
            } else {
                map.put(cur.h, map.get(cur.h) - 1);
                if (map.get(cur.h) == 0)
                    map.remove(cur.h);

                if (cur.h > map.firstKey()) {
                    List<Integer> node = new LinkedList<>();
                    node.add(cur.x);
                    node.add(map.firstKey());
                    ret.add(node);
                }
            }
        }
        return ret;
    }
    class Event {
        int x;
        int h;
        int typ;
        int id;

        public Event(int x, int h, int typ, int id) {
            this.x = x;
            this.h = h;
            this.typ = typ;
            this.id = id;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
