package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "pga", "lgm", "same", "arr", "mrr", "oore", "rplm", "gsf");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        // итерация по всем словам
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            boolean found = false;
            // итерация по буквам в массиве
            for (int j = 0; j < crossword.length; j++) {
                for (int k = 0; k < crossword[j].length; k++) {
                    int idx = 0;
                    if (crossword[j][k] == cur.charAt(idx)) {
                        if (searchUp(crossword, j, k, cur, 0)) {
                            Word word = new Word(cur);
                            word.setStartPoint(k, j);
                            word.setEndPoint(k, j - (cur.length() - 1));
                            list.add(word);
                            found = true;
                            break;
                        } else if (searchDown(crossword, j, k, cur, 0)) {
                            Word word = new Word(cur);
                            word.setStartPoint(k, j);
                            word.setEndPoint(k, j + (cur.length() - 1));
                            list.add(word);
                            found = true;
                            break;
                        } else if (searchLeft(crossword, j, k, cur, 0)) {
                            Word word = new Word(cur);
                            word.setStartPoint(k, j);
                            word.setEndPoint(k - (cur.length() - 1), j);
                            list.add(word);
                            found = true;
                            break;
                        } else if (searchRight(crossword, j, k, cur, 0)) {
                            Word word = new Word(cur);
                            word.setStartPoint(k, j);
                            word.setEndPoint(k + (cur.length() - 1), j);
                            list.add(word);
                            found = true;
                            break;
                        } else if (searchUpLeft(crossword, j, k, cur, 0)) {
                            Word word = new Word(cur);
                            word.setStartPoint(k, j);
                            word.setEndPoint(k - (cur.length() - 1), j - (cur.length() - 1));
                            list.add(word);
                            found = true;
                            break;
                        } else if (searchDownLeft(crossword, j, k, cur, 0)) {
                            Word word = new Word(cur);
                            word.setStartPoint(k, j);
                            word.setEndPoint(k - (cur.length() - 1), j + (cur.length() - 1));
                            list.add(word);
                            found = true;
                            break;
                        } else if (searchUpRight(crossword, j, k, cur, 0)) {
                            Word word = new Word(cur);
                            word.setStartPoint(k, j);
                            word.setEndPoint(k + (cur.length() - 1), j - (cur.length() - 1));
                            list.add(word);
                            found = true;
                            break;
                        } else if (searchDownRight(crossword, j, k, cur, 0)) {
                            Word word = new Word(cur);
                            word.setStartPoint(k, j);
                            word.setEndPoint(k + (cur.length() - 1), j + (cur.length() - 1));
                            list.add(word);
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    break;
                }
            }
        }
        return list;
    }

    public static boolean searchUp(int[][] crossword, int idxX, int idxY, String cur, int idxToComp) {
        if (idxToComp >= cur.length()) {
            return true;
        } else if (idxX < 0) {
            return false;
        } else {
            if (crossword[idxX][idxY] == cur.charAt(idxToComp)) {
                return searchUp(crossword, idxX - 1, idxY, cur, idxToComp + 1);
            } else {
                return false;
            }
        }
    }

    public static boolean searchDown(int[][] crossword, int idxX, int idxY, String cur, int idxToComp) {
        if (idxToComp >= cur.length()) {
            return true;
        } else if (idxX >= crossword.length) {
            return false;
        } else {
            if (crossword[idxX][idxY] == cur.charAt(idxToComp)) {
                return searchDown(crossword, idxX + 1, idxY, cur, idxToComp + 1);
            } else {
                return false;
            }
        }
    }

    public static boolean searchLeft(int[][] crossword, int idxX, int idxY, String cur, int idxToComp) {
        if (idxToComp >= cur.length()) {
            return true;
        } else if (idxY < 0) {
            return false;
        } else {
            if (crossword[idxX][idxY] == cur.charAt(idxToComp)) {
                return searchLeft(crossword, idxX, idxY - 1, cur, idxToComp + 1);
            } else {
                return false;
            }
        }
    }

    public static boolean searchRight(int[][] crossword, int idxX, int idxY, String cur, int idxToComp) {
        if (idxToComp >= cur.length()) {
            return true;
        } else if (idxY >= crossword[idxX].length) {
            return false;
        } else {
            if (crossword[idxX][idxY] == cur.charAt(idxToComp)) {
                return searchRight(crossword, idxX, idxY + 1, cur, idxToComp + 1);
            } else {
                return false;
            }
        }
    }

    public static boolean searchUpLeft(int[][] crossword, int idxX, int idxY, String cur, int idxToComp) {
        if (idxToComp >= cur.length()) {
            return true;
        } else if (idxX < 0 || idxY < 0) {
            return false;
        } else {
            if (crossword[idxX][idxY] == cur.charAt(idxToComp)) {
                return searchUpLeft(crossword, idxX - 1, idxY - 1, cur, idxToComp + 1);
            } else {
                return false;
            }
        }
    }

    public static boolean searchDownLeft(int[][] crossword, int idxX, int idxY, String cur, int idxToComp) {
        if (idxToComp >= cur.length()) {
            return true;
        } else if (idxX >= crossword.length || idxY < 0) {
            return false;
        } else {
            if (crossword[idxX][idxY] == cur.charAt(idxToComp)) {
                return searchDownLeft(crossword, idxX + 1, idxY - 1, cur, idxToComp + 1);
            } else {
                return false;
            }
        }
    }

    public static boolean searchUpRight(int[][] crossword, int idxX, int idxY, String cur, int idxToComp) {
        if (idxToComp >= cur.length()) {
            return true;
        } else if (idxX < 0 || idxY >= crossword[idxX].length) {
            return false;
        } else {
            if (crossword[idxX][idxY] == cur.charAt(idxToComp)) {
                return searchUpRight(crossword, idxX - 1, idxY + 1, cur, idxToComp + 1);
            } else {
                return false;
            }
        }
    }

    public static boolean searchDownRight(int[][] crossword, int idxX, int idxY, String cur, int idxToComp) {
        if (idxToComp >= cur.length()) {
            return true;
        } else if (idxX >= crossword.length || idxY >= crossword[idxX].length ) {
            return false;
        } else {
            if (crossword[idxX][idxY] == cur.charAt(idxToComp)) {
                return searchDownRight(crossword, idxX + 1, idxY + 1, cur, idxToComp + 1);
            } else {
                return false;
            }
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
