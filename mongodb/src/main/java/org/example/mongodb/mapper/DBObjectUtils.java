package org.example.mongodb.mapper;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.example.mongodb.model.Column;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;


public class DBObjectUtils {


    public static <T> T toTojo(DBObject dbObject, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        Field[] declaredFields = clazz.getDeclaredFields();
        T t = clazz.newInstance();
        for (Field declaredField : declaredFields) {
            if (!declaredField.isAnnotationPresent(Column.class)) {
                continue;
            }

            declaredField.setAccessible(true);
            Column annotation = declaredField.getAnnotation(Column.class);
            String key = annotation.value().equals("") ? declaredField.getName() : annotation.value();
            if (!dbObject.containsField(key)) {
                continue;
            }

            declaredField.set(t, dbObject.get(key));
        }
        return t;
    }

    public static <T> DBObject toDBObject(T pojo) throws IllegalAccessException {
        if (pojo == null) {
            return new BasicDBObject();
        }
        Field[] declaredFields = pojo.getClass().getDeclaredFields();
        BasicDBObject basicDBObject = new BasicDBObject();
        for (Field declaredField : declaredFields) {
            if (!declaredField.isAnnotationPresent(Column.class)) {
                continue;
            }

            Column annotation = declaredField.getAnnotation(Column.class);
            declaredField.setAccessible(true);
            String key = annotation.value().equals("") ? declaredField.getName() : annotation.value();

            Object o = declaredField.get(pojo);
            // 没有限制 null
            if (o == null) {
                basicDBObject.put(key, null);
                continue;
            }
//            Class<?> type = declaredField.getType();
            basicDBObject.put(key, o);
//            if (type.isPrimitive()) {
//                basicDBObject.put(key, o);
//            } else if (type.equals(Integer.class) || type.equals(String.class)
//                    || type.equals(Boolean.class) || type.equals(Long.class)) {
//                basicDBObject.put(key, o);
//            } else if (type.equals(Map.class)) {
//                basicDBObject.put(key, o);
//            } else if (type.equals(List.class)) {
//                basicDBObject.put(key, o);
//            } else if (type.equals(Date.class)) {
//                basicDBObject.put(key, o);
//
//            } else {
//                throw new OperationNotSupportedException("暂不支持转换 " + type.getName() + " 类型的字段");
//            }

        }
        return basicDBObject;
    }
}
