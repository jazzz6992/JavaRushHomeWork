package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Alex on 17.12.2016.
 */
 class WithdrawCommand implements Command
{
   private ResourceBundle res = ResourceBundle.getBundle(CashMachine.PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
      CurrencyManipulator m = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        int x;
      while (true) {
          ConsoleHelper.writeMessage(res.getString("specify.amount"));

          try
          {
              x =Integer.parseInt(ConsoleHelper.readString());
          } catch (NumberFormatException e) {
              ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
              continue;
          }
          if (x > 0) {
              if (m.isAmountAvailable(x)) {
                  try
                  {
                      Map<Integer, Integer> map = m.withdrawAmount(x);
                      Set<Integer> set =  map.keySet();
                      ArrayList<Integer> list = new ArrayList<>(set);
                      Collections.sort(list);
                      Collections.reverse(list);
                      for (Integer i :
                              list)
                      {
                          ConsoleHelper.writeMessage("\t" + i + " - " + map.get(i));
                      }
                      ConsoleHelper.writeMessage(String.format(res.getString("success.format"), x, m.getCurrencyCode()));
                      break;

                  } catch (NotEnoughMoneyException e) {
                      ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                      continue;
                  }
              } else {
                  ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                  continue;
              }
          } else {
              ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
          }
      }

    }
}
