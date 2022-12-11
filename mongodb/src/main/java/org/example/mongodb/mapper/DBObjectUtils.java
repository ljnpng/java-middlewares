package org.example.mongodb.mapper;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.example.mongodb.model.Column;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
                            if (dbObject.get(key) != null) {
                                // 继续添加map list 等类型
                                if (field.getType().isPrimitive()
                                        || field.getType().equals(Integer.class)
                                        || field.getType().equals(String.class)
                                        || field.getType().equals(Date.class)
                                        || field.getType().equals(Map.class)
                                        || field.getType().equals(List.class)) {
                                    field.set(t, dbObject.get(key));
                                } else {
                                    field.set(t, toTojo((DBObject) dbObject.get(key), field.getType()));
                                }

                            }
                        } catch (IllegalAccessException | InstantiationException e) {
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
                        if (field.getType().isPrimitive()
                                || field.getType().equals(Integer.class)
                                || field.getType().equals(String.class)
                                || field.getType().equals(Date.class)
                                || field.getType().equals(Map.class)
                                || field.getType().equals(List.class)) {
                            value = field.get(pojo);
                        } else {
                            value = toDBObject(field.get(pojo));
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    basicDBObject.put(key, value);

                });
        return basicDBObject;
    }

}
