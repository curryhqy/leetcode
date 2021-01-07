import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();
        
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        int[] f = new int[nvars];
        for (int i = 0; i < nvars; i++) {
            f[i] = i;
        }

        double[] w = new double[nvars];
        Arrays.fill(w, 1.0);

        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            merge(f, w, va, vb, values[i]);
        }

        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0));
                int ib = variables.get(query.get(1));
                int fa = find(f, w, ia);
                int fb = find(f, w, ib);
                if (fa == fb) {
                    result =  w[ia] / w[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }

    public void merge(int[] f, double[] w, int x, int y, double val) {
        int fx = find(f, w, x);
        int fy = find(f, w, y);
        f[fx] = fy;
        w[fx] = val * w[y] / w[x];
    }

    public int find(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int father = find(f, w, f[x]);
            w[x] *= w[f[x]];
            f[x] = father;
        }
        return f[x];
    }
}
// @lc code=end

