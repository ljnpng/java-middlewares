package org.example.mybatis.plus.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class ClueUserPo {
    @TableField("clue_id")
    private String clueId;
    @TableField("user_id")
    private String userId;
}
