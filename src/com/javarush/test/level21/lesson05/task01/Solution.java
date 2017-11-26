package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (this == n)
            return true;
        if (n == null || getClass() != n.getClass())
            return false;
        Solution solution = (Solution) n;
        if (first != null ? !first.equals(solution.first) : solution.first != null)
            return false;
        if (last != null ? !last.equals(solution.last) : solution.last != null)
            return false;
        return true;
    }

    public int hashCode() {
        return 31 * (first == null ? 0 : first.hashCode()) + (last == null ? 0 : last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Solution tmp = new Solution("Donald", "Duck");
        Solution tmp1 = new Solution("Donald", "Duck");
        s.add(tmp);
        System.out.println(s.contains(tmp1));
    }
}
