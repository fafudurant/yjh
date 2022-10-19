package com.byk.yygh.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.byk.yygh.model.hosp.HospitalSet;
import com.byk.yygh.vo.order.SignInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author byk
 */
public interface HospitalSetService extends IService<HospitalSet> {

    //2.根据传递过来医院编码，查询数据库，查询签名
    String getSignKey(String hoscode);

    //获取医院签名信息
    SignInfoVo getSignInfoVo(String hoscode);
}
