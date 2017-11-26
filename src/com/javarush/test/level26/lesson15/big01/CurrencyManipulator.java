package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Alex on 16.12.2016.
 */
public class CurrencyManipulator
{
    String currencyCode;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public boolean hasMoney() {
        if (getTotalAmount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    Map<Integer, Integer> denominations = new HashMap<>();

    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);
    }

    public int getTotalAmount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair :
                denominations.entrySet())
        {
            sum+=(pair.getKey() * pair.getValue());
        }
        return sum;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Set<Integer> set = denominations.keySet();
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            int curAmmount = expectedAmount;
            Map<Integer, Integer> tmpDen = new HashMap<>(denominations);
            Map<Integer, Integer> tmpRes = new HashMap<>();
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) > curAmmount) {
                    continue;
                }


                while (tmpDen.get(list.get(j)) > 0 && curAmmount - list.get(j) >= 0) {
                    if (list.size() > j + 1) {
//                        if (curAmmount - list.get(j) >= list.get(j + 1) || curAmmount - list.get(j) == 0) {
                    curAmmount = curAmmount - list.get(j);
                    if (tmpRes.get(list.get(j)) == null) {
                        tmpRes.put(list.get(j), 1);
                    } else {
                        tmpRes.put(list.get(j), tmpRes.get(list.get(j)) + 1);
                    }
                    tmpDen.put(list.get(j), tmpDen.get(list.get(j)) - 1);
//                        } else {
//                            break;
//                        }
                    } else {
                        curAmmount = curAmmount - list.get(j);
                        if (tmpRes.get(list.get(j)) == null) {
                            tmpRes.put(list.get(j), 1);
                        } else {
                            tmpRes.put(list.get(j), tmpRes.get(list.get(j)) + 1);
                        }
                        tmpDen.put(list.get(j), tmpDen.get(list.get(j)) - 1);
                    }
                    if (curAmmount == 0) {
                        for (Map.Entry<Integer, Integer> pair :
                                tmpDen.entrySet()) {
                            denominations.put(pair.getKey(), pair.getValue());
                        }
                        return tmpRes;
                    }
                }
            }
        }
        throw new NotEnoughMoneyException();
    }

}
