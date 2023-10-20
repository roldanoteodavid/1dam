package org.example.orders;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GSONCustomSerDerExample {

    public static void main(String[] args) {
        Order order = new Order(100," Book purchase","Java Head First",LocalDate.now(),LocalDateTime.now());

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());

        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

        Gson gson = gsonBuilder.setPrettyPrinting().create();

        // Convert to JSON
        System.out.println(gson.toJson(order));
        try(PrintWriter pw = new PrintWriter("data/Orders.json")){
            pw.println(gson.toJson(order));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String orderJson = "{\r\n" + "  \"id\": 100,\r\n" + "  \"orderName\": \"Book purchase\",\r\n" +
                "  \"orderDesc\": \"Java Head First\",\r\n" + "  \"orderCreatedDate\": \"26-Oct-2018\",\r\n" +
                "  \"orderCreatedDateTime\": \"26::Oct::2018 11::09::05\",\r\n" +
                "  \"orderCreatedZonedDateTime\": \"Oct 26 2018  11:09 AM\"\r\n" + "}";
        // Convert to java objects
        Order one = gson.fromJson(orderJson, Order.class);
        System.out.println(one);

    }

}








