package com.cow.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cow.enums.AuditStatusEnum;
import com.cow.enums.LeaveEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * <p>
 *
 * </p>
 *
 * @author cow
 * @since 2022-04-05
 */
@Getter
@Setter
@TableName("att_staff_leave")
@ApiModel(value = "StaffLeave对象", description = "")
public class StaffLeave implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工id")
    @TableField("staff_id")
    private Integer staffId;

    @ApiModelProperty("请假的天数")
    @TableField("days")
    private Integer days;

    @TableField("type_num")
    private LeaveEnum typeNum;

    @ApiModelProperty("请假的起始日期")
    @TableField("start_date")
    private Date startDate;

    @ApiModelProperty("0未审核，1审核通过，2驳回，3撤销")
    @TableField("status")
    private AuditStatusEnum status;

    @TableField("remark")
    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Timestamp createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Timestamp updateTime;

    @ApiModelProperty("逻辑删除，0未删除，1删除")
    @TableField("is_deleted")
    @TableLogic
    private Integer deleteFlag;


}
