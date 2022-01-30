package ru.restoclub.tests;

import com.github.javafaker.Faker;


public class TestData extends TestBase {

    static Faker faker = new Faker();

    public static String nickName = faker.name().firstName(),
            email = faker.internet().emailAddress(),
            password = faker.internet().password();
}
