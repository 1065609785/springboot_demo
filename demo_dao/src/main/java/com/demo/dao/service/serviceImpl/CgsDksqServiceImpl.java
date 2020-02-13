package com.demo.dao.service.serviceImpl;

import com.demo.dao.model.CgsDksq;
import com.demo.dao.mapper.CgsDksqMapper;
import com.demo.dao.service.ICgsDksqService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车购税代开申请 服务实现类
 * </p>
 *
 * @author zhaoshouyun
 * @since 2019-12-18
 */
@Service
@Primary
public class CgsDksqServiceImpl extends ServiceImpl<CgsDksqMapper, CgsDksq> implements ICgsDksqService {

}
