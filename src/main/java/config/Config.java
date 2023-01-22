package config;

    public class Config {

        private static final String URL = "file:///C:/Users/AIREDALE/Downloads/Telegram%20Desktop/qa-test.html";
        private static final String EMPTY_FIELD = "";
        private static final String EMAIL = "test@protei.ru";
        private static final String PASSWORD = "test";
        public static String getURL() {
            return URL;
        }
        public static String getEmail(){
            return EMAIL;
        }
        public static String getEmptyField() {
            return EMPTY_FIELD;
        }
        public static String getPassword(){
            return PASSWORD;
        }
    }
