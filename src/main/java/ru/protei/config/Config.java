package ru.protei.config;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;

public class Config {
    public static final String EMPTY_FIELD = "";
    public static final String EMAIL = "test@protei.ru";
    public static final String PASSWORD = "test";
    private static final String randomEmail = RandomStringUtils.randomAlphabetic(4) + "@protei.ru";
    private static final String randomName = RandomStringUtils.randomAlphabetic(6);
    private static final String randomPassword = RandomStringUtils.randomAlphabetic(4);
    public static final String invalidEmail = "protei.ru";
    public static String getRandomEmail() {
        return randomEmail;
    }
    public static String getRandomName() {
        return randomName;
    }
    public static String getRandomPassword() {
        return randomPassword;
    }
}
