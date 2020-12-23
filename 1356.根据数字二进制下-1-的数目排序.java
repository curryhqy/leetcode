import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1356 lang=java
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

// @lc code=start
class Solution {
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        //将重排的结果放在list中
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
            bit[x] = getNum(x);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                }else{
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    //统计二进制下1出现的次数
    public int getNum(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x = x / 2;
        }
        return res;
    }

}
// @lc code=end

