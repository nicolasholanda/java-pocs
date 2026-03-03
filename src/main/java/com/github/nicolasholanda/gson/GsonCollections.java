package com.github.nicolasholanda.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;

public class GsonCollections {

    record Product(String name, double price) {}

    static void execute() {
        Gson gson = new Gson();

        List<String> names = List.of("Alice", "Bob", "Charlie");
        String jsonList = gson.toJson(names);
        System.out.println("Serialized list: " + jsonList);

        List<String> parsedNames = gson.fromJson(jsonList, new TypeToken<List<String>>(){}.getType());
        System.out.println("Deserialized list: " + parsedNames);

        List<Product> products = List.of(new Product("Keyboard", 99.9), new Product("Mouse", 49.9));
        String jsonProducts = gson.toJson(products);
        System.out.println("Serialized object list: " + jsonProducts);

        List<Product> parsedProducts = gson.fromJson(jsonProducts, new TypeToken<List<Product>>(){}.getType());
        parsedProducts.forEach(p -> System.out.println(p.name() + " -> " + p.price()));

        Map<String, Integer> scores = Map.of("Alice", 95, "Bob", 87);
        String jsonMap = gson.toJson(scores);
        System.out.println("Serialized map: " + jsonMap);

        Map<String, Integer> parsedMap = gson.fromJson(jsonMap, new TypeToken<Map<String, Integer>>(){}.getType());
        System.out.println("Deserialized map: " + parsedMap);

        int[] numbers = {1, 2, 3, 4, 5};
        String jsonArray = gson.toJson(numbers);
        System.out.println("Serialized array: " + jsonArray);

        int[] parsedArray = gson.fromJson(jsonArray, int[].class);
        System.out.println("Deserialized array length: " + parsedArray.length);
    }
}

