package com.byk.yygh.user.client;

import com.byk.yygh.common.result.Result;
import com.byk.yygh.model.user.Patient;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author byk
 */
@FeignClient(value = "service-user")
@Repository
public interface PatientFeignClient {

    //获取就诊人信息，根据id
    @GetMapping("/api/user/patient/inner/get/{id}")
    public Patient getPatientOrder(@PathVariable("id") Long id);
}
