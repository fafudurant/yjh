package com.byk.yygh.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.byk.yygh.model.user.Patient;

import java.util.List;

/**
 * @author byk
 */
public interface PatientService extends IService<Patient> {

    //获取就诊人列表
    List<Patient> findAllUserId(Long userId);

    //根据id获取就诊人信息
    Patient getPatientId(Long id);
}
