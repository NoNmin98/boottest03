package com.lzy.boottest03.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author: lzy
 * @description:
 * @date: 2021-03-03-17:01
 */
//get,set,有参，无参构造器
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("tbl_stu")
public class Person {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stuName;
    private String stuGender;

}
