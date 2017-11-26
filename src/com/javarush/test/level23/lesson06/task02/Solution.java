package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public static final class Constants {
        static final String SNAE = "Server is not accessible for now.";
        static final String UUE = "User is not authorized.";
        static final String BUE = "User is banned.";
        static final String RE = "Access is denied.";

    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SNAE);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SNAE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.UUE);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UUE, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BUE);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BUE, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.RE);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.RE, cause);
        }
    }
}
