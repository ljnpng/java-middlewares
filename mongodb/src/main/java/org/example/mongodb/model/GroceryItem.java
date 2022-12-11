package org.example.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("GroceryItem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroceryItem {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private int quantity;

    @Column
    private String category;
}
