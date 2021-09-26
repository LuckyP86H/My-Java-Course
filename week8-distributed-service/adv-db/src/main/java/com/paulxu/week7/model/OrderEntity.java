package com.paulxu.week7.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@TableName("t_order")
public class OrderEntity extends Model<OrderEntity> {
    @TableId(value = "id" , type = IdType.ASSIGN_ID)
    private Long id;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "user_address_id")
    private Long userAddressId;

    @TableField(value = "logistics_id")
    private Long logisticsId;

    @TableField(value = "status")
    private String status;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Timestamp updateTime;

}
