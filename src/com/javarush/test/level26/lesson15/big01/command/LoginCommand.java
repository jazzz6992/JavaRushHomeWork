package com.javarush.test.level26.lesson15.big01.command;
import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String tempCardNumber;
        String tempPin;
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            tempCardNumber = ConsoleHelper.readString();
            tempPin = ConsoleHelper.readString();
            if (tempCardNumber.length() != 12) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (tempPin.length() != 4){
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
continue;
            }
            else {
                if (validCreditCards.containsKey(tempCardNumber)) {
                    if (validCreditCards.getString(tempCardNumber).equals(tempPin)) {
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), tempCardNumber));
                        break;
                    }
                    else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), tempCardNumber));

                    }
                } else {
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));

                }

            }
        }
    }
}
