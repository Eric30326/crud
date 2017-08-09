package com.huanh.crud.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class TblEmp implements Serializable{

    private static final long serialVersionUID = 544779681828396517L;

    private Integer empId;

    private String empName;

    private String gender;

    private String email;

    private Integer deptId;

    private TblDept tblDept;
}