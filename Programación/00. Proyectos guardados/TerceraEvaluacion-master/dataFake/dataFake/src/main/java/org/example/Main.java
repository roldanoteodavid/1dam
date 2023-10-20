package org.example;

import net.datafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.pokemon().name());
        System.out.println(faker.vForVendetta().characters());
    }
}