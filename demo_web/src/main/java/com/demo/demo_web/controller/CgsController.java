package com.demo.demo_web.controller;/**
 * ClassName: com.demo.demo_web.controller
 * Function:
 * date: 2019-12-18 16:43
 *
 * @author zhaoshouyun
 * @version 1.0
 */

import com.demo.dao.model.CgsDksq;
import com.demo.demo_web.annotation.EncryptMethod;
import com.demo.service.CgsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author zhaoshouyun
 * @create 2019-12-18 16:43
 **/
@Controller
@RequestMapping("demo")
public class CgsController {

	//@Reference(version = "1.0.0",url = "dubbo://127.0.0.1:12345")
	@Reference(version = "1.0.0")
	CgsService cgsService;

	@GetMapping("cgs")
	@EncryptMethod
	public  String listCgs(Model model,String requestStr){
		List<CgsDksq> cgsDksqList = cgsService.listCgsDksq(new CgsDksq());
		model.addAttribute("cgsList",cgsDksqList);
		model.addAttribute("name","赵守云");
		return "hello";
	}


	/**获取车购税列表
	 * @Author zhaoshouyun
	 * @Description
	 * @Date 2020-01-13 04:40
	 * @Param model
	 * @return java.lang.String
	 **/
	@RequestMapping("cgsList")
	public  String listIndex(Model model){
		List<CgsDksq> cgsDksqList = cgsService.listCgsDksq(new CgsDksq());
		model.addAttribute("cgsList",cgsDksqList);
		model.addAttribute("name","赵守云");
		return "cgs/cgsIndex";
	}
}
