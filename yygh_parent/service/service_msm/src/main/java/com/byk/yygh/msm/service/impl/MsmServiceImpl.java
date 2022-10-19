package com.byk.yygh.msm.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.byk.yygh.msm.service.MsmService;
import com.byk.yygh.msm.utils.ConstantPropertiesUtils;
import com.byk.yygh.msm.utils.HttpUtils;
import com.byk.yygh.vo.msm.MsmVo;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author byk
 */
@Service
public class MsmServiceImpl implements MsmService {

    //调用service方法，通过整合短信服务进行发送
    @Override
    public boolean send(String phone, String code) {
        //判断手机号是否为空
        System.out.println(code);
        if(StringUtils.isEmpty(phone)){
            return false;
        }
        ////整合阿里云短信服务
        ////设置相关参数
        //DefaultProfile profile = DefaultProfile.
        //        getProfile(ConstantPropertiesUtils.REGION_Id,
        //                ConstantPropertiesUtils.ACCESS_KEY_ID,
        //                ConstantPropertiesUtils.SECRECT);
        //IAcsClient client = new DefaultAcsClient(profile);
        //CommonRequest request = new CommonRequest();
        ////request.setProtocol(ProtocolType.HTTPS);
        //request.setMethod(MethodType.POST);
        //request.setDomain("dysmsapi.aliyuncs.com");
        //request.setVersion("2017-05-25");
        //request.setAction("SendSms");
        //
        ////手机号
        //request.putQueryParameter("PhoneNumbers", phone);
        ////签名名称
        //request.putQueryParameter("SignName", "阿里云短信测试");
        ////模板code
        //request.putQueryParameter("TemplateCode", "SMS_254750507");
        ////验证码  使用json格式   {"code":"123456"}
        //Map<String,Object> param = new HashMap();
        //param.put("code",code);
        //request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));
        ////调用方法进行短信发送
        //try {
        //    CommonResponse response = client.getCommonResponse(request);
        //    System.out.println(response.getData());
        //    return response.getHttpResponse().isSuccess();
        //} catch (ServerException e) {
        //    e.printStackTrace();
        //} catch (ClientException e) {
        //    e.printStackTrace();
        //}
        //return false;
        if(!StringUtils.isEmpty(code)) {
            String host = "https://dfsns.market.alicloudapi.com";
            String path = "/data/send_sms";
            String method = "POST";
            String appcode = "05b88f5e0fb6476a80d43b2ffe2b9546";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 05b88f5e0fb6476a80d43b2ffe2b9546
            headers.put("Authorization", "APPCODE " + appcode);
            //根据API的要求，定义相对应的Content-Type
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            Map<String, String> querys = new HashMap<String, String>();
            Map<String, String> bodys = new HashMap<String, String>();
            bodys.put("content", "code:" + code);
            bodys.put("phone_number", phone);
            bodys.put("template_id", "TPL_0000");
            try {
                /**
                 * 重要提示如下:
                 * HttpUtils请从
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
                 * 下载
                 *
                 * 相应的依赖请参照
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
                 */
                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                System.out.println(response.toString());
                return true;
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    ////mq使用发送短信
    @Override
    public boolean send(MsmVo msmVo) {
        if(!StringUtils.isEmpty(msmVo.getPhone())){
            String code = (String) msmVo.getParam().get("code");
            boolean isSend = this.send(msmVo.getPhone(), code);
            return isSend;
        }
        return false;
    }
}
