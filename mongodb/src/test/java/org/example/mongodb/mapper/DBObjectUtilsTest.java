package org.example.mongodb.mapper;

import com.mongodb.DBObject;
import org.example.mongodb.model.Feedback;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.util.*;

class DBObjectUtilsTest {

    @Test
    void toDBObject() throws OperationNotSupportedException, IllegalAccessException, InstantiationException {
        Map<String, Object> content = new HashMap<>();
        content.put("key1", "boy");
        content.put("key2", 1);
        Map<String, Object> innerContent = new HashMap<>();
        innerContent.put("inner1", 1);
        innerContent.put("inner2", true);
        innerContent.put("inner3", null);
        innerContent.put("inner4", "good");
        content.put("key3", innerContent);
        List<String> list = new ArrayList<>();
        list.add("org1");
        list.add("org3");
        Feedback feedback = Feedback.builder()
                .id(1)
                .reporter("廖")
                .appended(false)
                .content(content)
                .orgs(list)
                .createDate(new Date())
                .build();

        DBObject dbObject = DBObjectUtils.toDBObject(feedback);
        Feedback feedback1 = DBObjectUtils.toTojo(dbObject, Feedback.class);
        Assertions.assertEquals(feedback, feedback1);

        System.out.println(DBObjectUtils.toDBObject(Feedback.builder().build()));
        System.out.println(dbObject);
    }

}