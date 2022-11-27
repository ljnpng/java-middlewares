package org.example.mongodb.model;

import lombok.Data;

import java.util.Map;

@Data
public class Feedback {

    private String id;

    private String reporter;

    private String clueId;

    private boolean appended;

    private Map<String, Object> content;
}
