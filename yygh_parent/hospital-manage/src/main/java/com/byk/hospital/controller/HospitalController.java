package com.byk.hospital.controller;

import com.byk.hospital.service.ApiService;
import com.byk.hospital.service.HospitalService;
import com.byk.hospital.util.HttpRequestHelper;
import com.byk.hospital.util.Result;
import com.byk.hospital.util.ResultCodeEnum;
import com.byk.hospital.util.YyghException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * @author byk
 *
 */
@Api(tags = "医院管理接口")
@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private ApiService apiService;

	/**
	 * 预约下单
	 * @param request
	 * @return
	 */
	@PostMapping("/order/submitOrder")
	public Result AgreeAccountLendProject(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
			if(!HttpRequestHelper.isSignEquals(paramMap, apiService.getSignKey())) {
				throw new YyghException(ResultCodeEnum.SIGN_ERROR);
			}

			Map<String, Object> resultMap = hospitalService.submitOrder(paramMap);
			return Result.ok(resultMap);
		} catch (YyghException e) {
			return Result.fail().message(e.getMessage());
		}
	}

	/**
	 * 更新支付状态
	 * @param request
	 * @return
	 */
	@PostMapping("/order/updatePayStatus")
	public Result updatePayStatus(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
			if(!HttpRequestHelper.isSignEquals(paramMap, apiService.getSignKey())) {
				throw new YyghException(ResultCodeEnum.SIGN_ERROR);
			}

			hospitalService.updatePayStatus(paramMap);
			return Result.ok();
		} catch (YyghException e) {
			return Result.fail().message(e.getMessage());
		}
	}

	/**
	 * 更新取消预约状态
	 * @param request
	 * @return
	 */
	@PostMapping("/order/updateCancelStatus")
	public Result updateCancelStatus(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
			System.out.println(paramMap);
			if(!HttpRequestHelper.isSignEquals(paramMap, apiService.getSignKey())) {
				System.out.println(11111);
				throw new YyghException(ResultCodeEnum.SIGN_ERROR);
			}
			System.out.println(2222222);
			hospitalService.updateCancelStatus(paramMap);
			return Result.ok();
		} catch (Exception e) {
			System.out.println(33333333);
			return Result.fail().message(e.getMessage());
		}
	}
}

