package org.example.mongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author neo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Column("_id")
//    @JsonProperty("basic._id")
    private Integer id;

    @Column
//    @JsonProperty("basic.jsr")
    private String reporter;

    @Column("clueId")
//    @JsonProperty("basic.xsid")
    private String clueId;

    @Column("appended")
//    @JsonProperty("basic.tj")
    private boolean appended;

    @Column
//    @JsonProperty("basic.zhengwen")
    private Map<String, Object> content;

    @Column
//    @JsonProperty("basic.zz")
    private List<String> org;

    @Column("crtm")
//    @JsonProperty("basic.crtm")
    private Date createDate;

    @Column
    private GroceryItem groceryItem;

}
