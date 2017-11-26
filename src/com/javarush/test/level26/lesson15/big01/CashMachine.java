package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Alex on 16.12.2016.
 */
public class CashMachine
{
    public static String PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args)
    { try
    {
        Locale.setDefault(Locale.ENGLISH);
//CurrencyManipulator m = CurrencyManipulatorFactory.getManipulatorByCurrencyCode("USD");
//m.addAmount(500, 2);
//m.addAmount(200, 3);
//m.addAmount(100, 2);
CommandExecutor.execute(Operation.LOGIN);
        Operation operation;
        do
        {
            operation = ConsoleHelper.askOperation();

            CommandExecutor.execute(operation);
        }
        while (operation != Operation.EXIT);
    } catch (InterruptOperationException e) {
        ConsoleHelper.printExitMessage();
    }

    }
}
