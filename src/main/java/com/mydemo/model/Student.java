package com.mydemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wuwei
 * @create 2019/9/30 9:14
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="用户实体")
public class Student {

    @ApiModelProperty("用户编号")
    private String id;
    @ApiModelProperty("用户年龄")
    private Integer age;
    @ApiModelProperty("用户名称")
    private String nickName;
    @ApiModelProperty("创建日期")
    private Date createDate;
}
