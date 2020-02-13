package com.demo.service;

import com.demo.dao.model.CgsDksq;

import java.util.List;

/**
 * 车购税服务
 * @author zhaoshouyun
 * @create 2019-12-18 14:42
 **/
public interface CgsService {
	/**
	 *描述:获取车购税列表
	 * @author zhaoshouyun
	 * @date 2019-12-18 14:44
	 * @param
	 * @return java.util.List<com.demo.dao.model.CgsDksq>
	 */
    List<CgsDksq> listCgsDksq(CgsDksq cgsDksq);
}
