package com.byk.yygh.msm.controller;

import com.byk.yygh.common.result.Result;
import com.byk.yygh.msm.service.MsmService;
import com.byk.yygh.msm.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author byk
 */
@Api(tags = "短信验证")
@RestController
@RequestMapping("/api/msm")
public class MsmApiController {

    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //发送手机验证码
    @ApiOperation("发送手机验证码")
    @PostMapping("/send/{phone}")
    public Result sendCode(@PathVariable("phone") String phone){
        //从redis获取验证码，如果获取获取到，返回ok
        //key 手机号 value 验证码
        String code = redisTemplate.opsForValue().get(phone);

        if(!StringUtils.isEmpty(code)){
            return Result.ok();
        }
        //如果从redis获取不到
        //生成验证码通过整合短信服务进行发送
        code = RandomUtil.getSixBitRandom();
        //调用service方法，通过整合短信服务进行发送
        boolean isSend = msmService.send(phone,code);
        System.out.println(isSend);
        //生成验证码放到redis里面，设置有效时间
        if(isSend){
            redisTemplate.opsForValue().set(phone,code,2, TimeUnit.MINUTES);
            return Result.ok();
        }else {
            return Result.fail().message("发送短信失败");
        }
    }
}
