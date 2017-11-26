package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vsevolodvisnevskij on 03.02.17.
 */
public class Server {
    private static final Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> loop : connectionMap.entrySet()) {
            try {
                loop.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Cant't send message to " + loop.getKey());
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message answer = connection.receive();
            if (answer.getType() == MessageType.USER_NAME) {
                String name = answer.getData();
                if (name.length() > 0 && !connectionMap.containsKey(name)) {
                    connectionMap.put(name, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return name;
                } else {
                    return serverHandshake(connection);
                }
            } else {
                return serverHandshake(connection);
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                String name = entry.getKey();
                Message message = new Message(MessageType.USER_ADDED, name);
                if (!userName.equals(name)) {
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String text = String.format("%s: %s", userName, message.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else {
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }

        @Override
        public void run() {
            String name = null;
            try (Connection connection = new Connection(socket)) {
                ConsoleHelper.writeMessage("установлено новое соединение с удаленным адресом " + connection.getRemoteSocketAddress());
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            }
            if (name != null) {
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Ошибка сокета");
        }
    }
}
