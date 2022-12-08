package org.example.clue.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import lombok.Data;

/**
 * 线索表
 * @TableName clue
 */
@TableName(value ="clue")
@Data
public class Clue implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Object id;

    /**
     * 线索名称
     */
    @TableField(value = "clue_title")
    private String clueTitle;

    /**
     * 线索编号
     */
    @TableField(value = "clue_code")
    private String clueCode;

    /**
     * 线索状态
     */
    @TableField(value = "clue_status")
    private Integer clueStatus;

    /**
     * 
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 
     */
    @TableField(value = "create_user")
    private Integer createUser;

    /**
     * 
     */
    @TableField(value = "is_del")
    private byte[] isDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Clue other = (Clue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClueTitle() == null ? other.getClueTitle() == null : this.getClueTitle().equals(other.getClueTitle()))
            && (this.getClueCode() == null ? other.getClueCode() == null : this.getClueCode().equals(other.getClueCode()))
            && (this.getClueStatus() == null ? other.getClueStatus() == null : this.getClueStatus().equals(other.getClueStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (Arrays.equals(this.getIsDel(), other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClueTitle() == null) ? 0 : getClueTitle().hashCode());
        result = prime * result + ((getClueCode() == null) ? 0 : getClueCode().hashCode());
        result = prime * result + ((getClueStatus() == null) ? 0 : getClueStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + (Arrays.hashCode(getIsDel()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clueTitle=").append(clueTitle);
        sb.append(", clueCode=").append(clueCode);
        sb.append(", clueStatus=").append(clueStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}