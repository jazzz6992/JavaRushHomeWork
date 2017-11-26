package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Alex on 16.12.2016.
 */
public class CurrencyManipulatorFactory
{
  private static Map<String, CurrencyManipulator> manipulators = new HashMap<>();
   public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
       for (Map.Entry<String, CurrencyManipulator> pair :
               manipulators.entrySet())
       {
           if (pair.getKey().equals(currencyCode)) {
               return pair.getValue();
           }
       }
       CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
       manipulators.put(currencyCode,currencyManipulator);
       return currencyManipulator;
   }

   public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
       return manipulators.values();
   }

    private CurrencyManipulatorFactory()
    {
    }
}
