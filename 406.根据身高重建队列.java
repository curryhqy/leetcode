import java.util.*;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */
/**
 * 先排序，后插入
 * 1:按照H高度降序、K个数升序
 * 2:根据k插到k的位置上
 * 
 * 高个子先站位，矮个子再插入时不会影响高个子前面比他高的个数
 */
// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people){
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
// @lc code=end

