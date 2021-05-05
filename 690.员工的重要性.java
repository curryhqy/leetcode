import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=690 lang=java
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {

    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id);
    }

    public int dfs (int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> list = employee.subordinates;
        for (int ids : list) {
            total += dfs(ids);
        }
        return total;
    }
}
// @lc code=end

