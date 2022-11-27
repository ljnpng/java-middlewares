package org.example.mongodb.mapper;

import com.mongodb.BasicDBObject;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MapperUtil {
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    @Source
    public String source(BasicDBObject object) {
        return (String) object.get("i");
    }
}
