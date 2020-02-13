package com.demo.demo_rpc_service.controller;/**
 * ClassName: com.demo.demo_rpc_service.controller
 * Function:
 * date: 2019-12-18 14:48
 *
 * @author zhaoshouyun
 * @version 1.0
 */

import com.demo.dao.model.CgsDksq;
import com.demo.service.CgsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author zhaoshouyun
 * @create 2019-12-18 14:48
 **/
/*@RestController
@RequestMapping("demo")*/
public class TestController {
   @Autowired
	CgsService cgsService;

	//@RequestMapping("test")
	public List<CgsDksq> listCgs(String name){
		return cgsService.listCgsDksq(new CgsDksq());
	}

}
