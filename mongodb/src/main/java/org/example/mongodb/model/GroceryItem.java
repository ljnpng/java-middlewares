package org.example.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("GroceryItem")
@Getter
@Setter
@AllArgsConstructor
public class GroceryItem {

    @Id
    private String id;

    private String name;

    private int quantity;

    private String category;
}
