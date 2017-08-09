package com.huanh.crud.dao;

import com.huanh.crud.domain.TblDept;

public interface TblDeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TblDept record);

    int insertSelective(TblDept record);

    TblDept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TblDept record);

    int updateByPrimaryKey(TblDept record);
}