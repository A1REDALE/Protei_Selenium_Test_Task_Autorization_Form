package config;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;

public class Config {

        private static final String URL = "file:///C:/Users/AIREDALE/Downloads/Telegram%20Desktop/qa-test.html";
        private static final String EMPTY_FIELD = "";
        private static final String EMAIL = "test@protei.ru";
        private static final String PASSWORD = "test";
        public static String randomEmail = RandomStringUtils.randomAlphabetic(4) + "@protei.ru";
        public static String randomName = RandomStringUtils.randomAlphabetic(6);
        public static String randomPassword = RandomStringUtils.randomAlphabetic(4);
        public static String invalidEmail = "protei.ru";
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
