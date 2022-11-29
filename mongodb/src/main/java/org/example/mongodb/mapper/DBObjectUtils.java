package org.example.mongodb.mapper;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.example.mongodb.model.Column;

import java.lang.reflect.Field;
import java.util.Arrays;


public class DBObjectUtils {


    public static <T> T toTojo(DBObject dbObject, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        Field[] declaredFields = clazz.getDeclaredFields();
        T t = clazz.newInstance();
        Arrays.stream(declaredFields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    Column annotation = field.getAnnotation(Column.class);
                    String key = annotation.value().equals("") ? field.getName() : annotation.value();
                    if (dbObject.containsField(key)) {
                        try {
                            field.set(t, dbObject.get(key));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
        return t;
    }

    public static <T> DBObject toDBObject(T pojo) {
        if (pojo == null) {
            return new BasicDBObject();
        }

        BasicDBObject basicDBObject = new BasicDBObject();
        Arrays.stream(pojo.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    Column annotation = field.getAnnotation(Column.class);
                    String key = annotation.value().equals("") ? field.getName() : annotation.value();
                    Object value;
                    try {
                        value = field.get(pojo);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    basicDBObject.put(key, value);

                });
        return basicDBObject;
    }
}
