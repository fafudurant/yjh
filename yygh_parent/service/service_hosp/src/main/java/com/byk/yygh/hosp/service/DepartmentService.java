package com.byk.yygh.hosp.service;


import com.byk.yygh.model.hosp.Department;
import com.byk.yygh.vo.hosp.DepartmentQueryVo;
import com.byk.yygh.vo.hosp.DepartmentVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @author byk
 */
public interface DepartmentService {

    //上传科室接口
    void save(Map<String, Object> paramMap);

    //查看科室接口
    Page<Department> findPageDepartment(int page, int limit, DepartmentQueryVo departmentQueryVo);

    //删除科室接口
    void remove(String hoscode, String depcode);

    //根据医院编号，查询医院所有科室列表
    List<DepartmentVo> findDeptTree(String hoscode);

    //根据科室编号和医院编号，查询科室名称
    String getDepName(String hoscode, String depcode);

    //根据科室编号和医院编号，查询科室对象
    Department getDepartment(String hoscode, String depcode);
}
