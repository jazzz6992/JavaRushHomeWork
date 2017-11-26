package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by Alex on 17.12.2016.
 */
 class InfoCommand  implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.PATH + "info_en");
    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean money = false;
        for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators()){
            if (cur.hasMoney()){
                if (cur.getTotalAmount() > 0)
                {
                    ConsoleHelper.writeMessage(cur.getCurrencyCode() + " - " + cur.getTotalAmount());
                    money = true;
                }
            }
        }
        if (!money)
            ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
