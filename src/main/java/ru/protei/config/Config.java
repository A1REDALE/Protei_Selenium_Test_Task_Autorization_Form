package ru.protei.config;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;

public class Config {
    public static final String EMPTY_FIELD = "";
    public static final String EMAIL = "test@protei.ru";
    public static final String PASSWORD = "test";
    private static final String RANDOM_EMAIL = RandomStringUtils.randomAlphabetic(4) + "@protei.ru";
    private static final String RANDOM_NAME = RandomStringUtils.randomAlphabetic(6);
    private static final String RANDOM_PASSWORD = RandomStringUtils.randomAlphabetic(4);
    public static final String INVALID_EMAIL = "protei.ru";
    public static String getRandomEmail() {
        return RANDOM_EMAIL;
    }
    public static String getRandomName() {
        return RANDOM_NAME;
    }
    public static String getRandomPassword() {
        return RANDOM_PASSWORD;
    }
}
