package com.huanh.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huanh.crud.common.JsonResult;
import com.huanh.crud.domain.TblEmp;
import com.huanh.crud.service.TblEmpServiceApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class EmployeeController {

    @Resource
    private TblEmpServiceApi tblEmpService;

    @RequestMapping("/emps")
    public JsonResult getEmployees(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(pn, 5);
        List<TblEmp> tblEmps = tblEmpService.getAllEmployees();
        PageInfo pageInfo = new PageInfo(tblEmps,5);
        jsonResult.setData(pageInfo);
        jsonResult.setCode("200");
        jsonResult.setMsg("成功");
        jsonResult.setOk(true);
        return jsonResult;
    }
}
