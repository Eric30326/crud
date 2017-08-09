package com.huanh.crud.service.impl;

import com.huanh.crud.dao.TblEmpMapper;
import com.huanh.crud.domain.TblEmp;
import com.huanh.crud.service.TblEmpServiceApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tblEmpService")
public class TblEmpServiceImpl implements TblEmpServiceApi{

    @Resource
    private TblEmpMapper tblEmpMapper;

    public List<TblEmp> getAllEmployees() {
        List<TblEmp> tblEmps = tblEmpMapper.selectByWhereWithDept(null);
        return tblEmps;
    }
}
