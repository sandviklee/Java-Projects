package oving2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Assertions;

public class TestHelper {

    public static void checkIfFieldsPrivate(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            Assertions.assertTrue(Modifier.isPrivate(field.getModifiers()),
                    "Expected field " + field.getName() + " to be private!");
        }
    }
}
