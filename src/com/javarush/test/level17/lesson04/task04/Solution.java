package com.javarush.test.level17.lesson04.task04;

/* Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.
*/

public class Solution {
    public static class OurPresident {

//        static {
//            synchronized (OurPresident.class) {
//                if (OurPresident.president == null) {
//                    OurPresident.president = new OurPresident();
//                }
//            }
//
//        }

        private static OurPresident president;

        static {
            synchronized (president) {
                if (president == null) {
                    president = new OurPresident();
                }
            }
        }

        private OurPresident() {
        }

        public static OurPresident getOurPresident() {
            return president;
        }
    }
}
