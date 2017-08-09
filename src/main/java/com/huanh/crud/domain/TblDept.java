package com.huanh.crud.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class TblDept implements Serializable{

    private static final long serialVersionUID = 3705949879468165269L;

    private Integer deptId;

    private String deptName;

}