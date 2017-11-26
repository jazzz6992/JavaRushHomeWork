package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Alex on 16.12.2016.
 */
public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.PATH + "common_en");

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String s = null;
        try
        {
            s = reader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if (s.equalsIgnoreCase("EXIT")) {
            throw new InterruptOperationException();
        }
        return s;
    }



    public static String askCurrencyCode() throws InterruptOperationException
    {
         String askCode;
         while (true)
         {
             writeMessage(res.getString("choose.currency.code"));
             askCode = readString();
             if (askCode.length() != 3) {
                 writeMessage(res.getString("invalid.data"));
             } else {
                 return askCode.toUpperCase();
             }
         }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String massive;
        String[] arg;
       while (true){
        try{
            massive = readString();
            arg = massive.split(" ");
            Integer currency = Integer.valueOf(arg[0]);
            Integer number = Integer.valueOf(arg[1]);

            if(arg.length != 2 || currency <0 || number < 0) {
                writeMessage(res.getString("invalid.data"));
                continue;
            } else
                  break;

        }catch (NumberFormatException o){
            writeMessage(res.getString("invalid.data"));

            continue;
        }
       }


       return arg;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("choose.operation"));
        ConsoleHelper.writeMessage(1 + " for " + res.getString("operation.INFO"));
        ConsoleHelper.writeMessage(2 + " for " + res.getString("operation.DEPOSIT"));
        ConsoleHelper.writeMessage(3 + " for " + res.getString("operation.WITHDRAW"));
        ConsoleHelper.writeMessage(4 + " for " + res.getString("operation.EXIT"));
        try
        {
            return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
        } catch (IllegalArgumentException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
            return askOperation();
        }
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
}
}

