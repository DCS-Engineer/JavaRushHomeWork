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
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData)
        {
            this.incomeData = incomeData;
        }

        @Override
        public String getName()
        {
            return this.incomeData.getContactLastName() + ", " + this.incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.incomeData.getPhoneNumber()));
            int sbLength = sb.length();
            if (sbLength < 10)
                for (int i = 0; i < (10 - sbLength); i++)
                    sb.insert(0, "0");
            return "+" + String.valueOf(this.incomeData.getCountryPhoneCode()) + "(" + sb.substring(0, 3) + ")" + sb.substring(3, 6) + "-" + sb.substring(6, 8) + "-" + sb.substring(8, 10);
        }

        @Override
        public String getCompanyName()
        {
            return this.incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
            String value = null;
            for (Map.Entry<String, String> entry : countries.entrySet()){
                if (entry.getKey().equals(this.incomeData.getCountryCode())) value = entry.getValue();
            }
            return value;
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
}