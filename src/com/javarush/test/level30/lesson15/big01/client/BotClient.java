package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Alex on 04.02.2017.
 */
public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        Random random = new Random();
        int x = random.nextInt(99);
        return "date_bot_" + x;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] msg = message.split(": ");
            if (msg.length == 2) {
                String name = msg[0];
                String data = msg[1];
                SimpleDateFormat simpleDateFormat = null;
                switch (data) {
                    case "дата":
                        simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        simpleDateFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        simpleDateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        simpleDateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        simpleDateFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        simpleDateFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        simpleDateFormat = new SimpleDateFormat("s");
                        break;
                }
                if (simpleDateFormat != null) {
                    String answer;
                    Calendar calendar = Calendar.getInstance();
                    answer = simpleDateFormat.format(calendar.getTime());
                    answer = String.format("Информация для %s: %s", name, answer);
                    sendTextMessage(answer);
                }
            }
        }
    }
}
