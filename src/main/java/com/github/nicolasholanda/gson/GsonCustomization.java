package com.github.nicolasholanda.gson;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class GsonCustomization {

    record Employee(
        @SerializedName("full_name") String name,
        @SerializedName("years_old") int age,
        @Expose(serialize = false) String password,
        String department
    ) {}

    static class LocalDateSerializer implements JsonSerializer<LocalDate> {
        public JsonElement serialize(LocalDate src, Type type, JsonSerializationContext ctx) {
            return new JsonPrimitive(src.toString());
        }
    }

    static class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
        public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext ctx) {
            return LocalDate.parse(json.getAsString());
        }
    }

    record Event(String title, LocalDate date) {}

    static void execute() {
        Gson gson = new Gson();

        Employee emp = new Employee("John Doe", 35, "secret123", "Engineering");
        String json = gson.toJson(emp);
        System.out.println("SerializedName: " + json);

        Employee parsed = gson.fromJson("{\"full_name\":\"Jane\",\"years_old\":28,\"department\":\"HR\"}", Employee.class);
        System.out.println("Deserialized name: " + parsed.name() + ", age: " + parsed.age());

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Pretty print:\n" + prettyGson.toJson(emp));

        Gson serializeNullsGson = new GsonBuilder().serializeNulls().create();
        record WithNull(String name, String nickname) {}
        System.out.println("Serialize nulls: " + serializeNullsGson.toJson(new WithNull("Bob", null)));

        Gson customDateGson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .create();

        Event event = new Event("Conference", LocalDate.of(2026, 6, 15));
        String eventJson = customDateGson.toJson(event);
        System.out.println("Custom serializer: " + eventJson);

        Event parsedEvent = customDateGson.fromJson(eventJson, Event.class);
        System.out.println("Custom deserializer: " + parsedEvent.title() + " on " + parsedEvent.date());

        Gson versionGson = new GsonBuilder().setVersion(1.0).create();
        record Versioned(
            @com.google.gson.annotations.Since(1.0) String stable,
            @com.google.gson.annotations.Since(2.0) String experimental
        ) {}
        System.out.println("Versioned: " + versionGson.toJson(new Versioned("yes", "no")));
    }
}

