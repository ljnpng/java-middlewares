package org.example.mongodb.mapper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.example.mongodb.model.Feedback;
import org.example.mongodb.model.GroceryItem;
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
                .org(list)
                .createDate(new Date())
                .groceryItem(new GroceryItem("1", "juse", 3, "hah"))
                .build();


        DBObject dbObject = DBObjectUtils.toDBObject(feedback);
        Feedback feedback1 = DBObjectUtils.toTojo(dbObject, Feedback.class);
        Assertions.assertEquals(feedback, feedback1);

        System.out.println(DBObjectUtils.toDBObject(Feedback.builder().build()));
        System.out.println(dbObject);
    }


    @Test
    @SuppressWarnings("unchecked")
    void json() {
        Feedback someone = Feedback.builder().id(1)
                .createDate(Calendar.getInstance().getTime())
                .content(null)
                .clueId("CLUE-1")
                .appended(false)
                .reporter("someone")
                .build();

        Map<String, Object> o = (Map<String, Object>) JSON.toJSON(someone);
        System.out.println(o);

        BasicDBObject basicDBObject = new BasicDBObject(o);

        System.out.println(basicDBObject);

        Feedback t = JSON.toJavaObject(new JSONObject(basicDBObject), Feedback.class);

        System.out.println(t);

    }

    @Test
    void json2() {
         Feedback someone = Feedback.builder().id(1)
                .createDate(Calendar.getInstance().getTime())
                .content(null)
                .clueId("CLUE-1")
                .appended(false)
                .reporter("someone")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        // 忽略 null
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // convert pojo to map
        Map<String, Object> map = mapper.convertValue(someone, new TypeReference<Map<String, Object>>() {
        });

        BasicDBObject basicDBObject = new BasicDBObject(map);

        // map to pojo
        Feedback newSomeOne = mapper.convertValue(basicDBObject, someone.getClass());

        Assertions.assertEquals(someone, newSomeOne);

    }
}