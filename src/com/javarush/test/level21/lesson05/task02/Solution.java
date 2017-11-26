package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        if (first != null ? !(first.equals(n.first)) : n.first != null) {
            return false;
        }
        if (last != null ? !(last.equals(n.last)) : n.last != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.length()) + (last == null ? 0 : last.length());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution(null, null)));
    }
}
