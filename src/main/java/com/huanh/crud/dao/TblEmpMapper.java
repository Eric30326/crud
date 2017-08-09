package com.huanh.crud.dao;

import com.huanh.crud.domain.TblEmp;
import com.huanh.crud.domain.basic.Where;

import java.util.List;

public interface TblEmpMapper {
    int deleteByPrimaryKey(Integer empId);

    int insert(TblEmp record);

    int insertSelective(TblEmp record);

    TblEmp selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(TblEmp record);

    int updateByPrimaryKey(TblEmp record);

    List<TblEmp> selectByWhereWithDept(Where where);

    TblEmp selectByPrimaryKeyWithDept(Integer empId);
}