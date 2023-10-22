package com.yupi.springbootinit.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 计算记录
 * @TableName calculator_res
 */
@TableName(value ="calculator_res")
public class CalculatorResVO implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 计算表达式
     */
    @TableField(value = "exp")
    private String exp;

    /**
     * 计算结果
     */
    @TableField(value = "res")
    private String res;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 计算表达式
     */
    public String getExp() {
        return exp;
    }

    /**
     * 计算表达式
     */
    public void setExp(String exp) {
        this.exp = exp;
    }

    /**
     * 计算结果
     */
    public String getRes() {
        return res;
    }

    /**
     * 计算结果
     */
    public void setRes(String res) {
        this.res = res;
    }

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
        CalculatorResVO other = (CalculatorResVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExp() == null ? other.getExp() == null : this.getExp().equals(other.getExp()))
            && (this.getRes() == null ? other.getRes() == null : this.getRes().equals(other.getRes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExp() == null) ? 0 : getExp().hashCode());
        result = prime * result + ((getRes() == null) ? 0 : getRes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", exp=").append(exp);
        sb.append(", res=").append(res);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}