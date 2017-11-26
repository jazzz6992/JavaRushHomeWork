package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }

        @Override
        public String getCompanyName() {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName() {
            String name = incomeData.getCountryCode();
            name = countries.get(name);
            return name;
        }

        @Override
        public String getName() {
            String firstName = incomeData.getContactFirstName();
            String lastName = incomeData.getContactLastName();
            String result = lastName + ", " + firstName;
            return result;
        }

        @Override
        public String getPhoneNumber() {
            String code = ((Integer) incomeData.getCountryPhoneCode()).toString();
            String number = ((Integer) incomeData.getPhoneNumber()).toString();
            StringBuilder sb = new StringBuilder();
            sb.append("+" + code + "(");
            int shortage = 10 - number.length();
            for (int i = 0; i < shortage; i++) {
                sb.append("0");
            }
            sb.append(number);
            sb.insert(sb.indexOf("(") + 4, ")");
            sb.insert(sb.indexOf(")") + 4, "-");
            sb.insert(sb.indexOf("-") + 3, "-");
            String result = sb.toString();
            return result;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static class IncomeDataImpl implements IncomeData {

        @Override
        public String getCountryCode() {
            return "UA";
        }

        @Override
        public String getCompany() {
            return "JavaRush Ltd.";
        }

        @Override
        public String getContactFirstName() {
            return "Ivan";
        }

        @Override
        public String getContactLastName() {
            return "Ivanov";
        }

        @Override
        public int getCountryPhoneCode() {
            return 38;
        }

        @Override
        public int getPhoneNumber() {
            return 501234567;
        }
    }

//    public static void main(String[] args) {
//        IncomeData incomeData = new IncomeDataImpl();
//        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(incomeData);
//        System.out.println(incomeDataAdapter.getName());
//        System.out.println(incomeDataAdapter.getCompanyName());
//        System.out.println(incomeDataAdapter.getCountryName());
//        System.out.println(incomeDataAdapter.getPhoneNumber());
//    }
}