package org.example.mongodb.model;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Column("_id")
    private Integer id;

    @Column
    private String reporter;

    @Column("clueId")
    private String clueId;

    @Column("appended")
    private boolean appended;

    @Column
    private Map<String, Object> content;

    @Column
    private List<String> orgs;

    @Column
    private Date createDate;
}
