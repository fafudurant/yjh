package com.byk.yygh.hosp.repository;

import com.byk.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author byk
 */
@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {

    //上传科室接口
    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);
}
