package com.byk.yygh.msm.service;

import com.byk.yygh.vo.msm.MsmVo;

/**
 * @author byk
 */
public interface MsmService {

    //调用service方法，通过整合短信服务进行发送
    boolean send(String phone, String code);

    //mq使用发送短信
    boolean send(MsmVo msmVo);
}
