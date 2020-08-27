package com.zhaogang.demo.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author baiyang
 * @date 2020/8/11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sims_student")
@ApiModel(value = "SimsStudent",description = "学生信息表")
public class SimsStudent implements Serializable,Cloneable{

    private static final long serialVersionUID = 7683588624293418005L;
    /** 所在学院 */
    private String collegeId ;
    /** 所在班级 */
    private String classId ;
    /** 学号 */
    @Id
    @GeneratedValue
    private Long id ;
    /** 学生姓名 */
    private String name ;
    /** 身份证号 */
    private String idCardNo ;
    /** 英文名 */
    private String engName ;
    /** 手机号 */
    private String mobilePhone ;
    /** 性别 */
    private String gender ;
    /** 出生日期 */
    @ApiModelProperty(value = "生日")
    private Date birth ;
    /** 头像 */
    private String avatar ;
    /** 身高 */
    private Double height ;
    /** 体重 */
    private Double weight ;
    /** 名族 */
    private String nation ;
    /** 政治面貌 */
    private String political ;
    /** 婚姻状况 */
    private String marital ;
    /** 籍贯（省）;国标行政区域代码-省级 */
    private String domicilePlaceProvince ;
    /** 籍贯（市）;国标行政区域代码-市级 */
    private String domicilePlaceCity ;
    /** 户籍地址 */
    private String domicilePlaceAddress ;
    /** 爱好 */
    private String hobby ;
    /** 简要介绍 */
    private String intro ;
    /** 居住地址 */
    private String presentAddress ;
    /** 电子邮件 */
    private String email ;
    /** 入学日期 */
    @ApiModelProperty(value = "入学日期")
    private Date entryDate ;
    /** 状态 */
    private String status ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    @ApiModelProperty(value = "入学日期")
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;
}
