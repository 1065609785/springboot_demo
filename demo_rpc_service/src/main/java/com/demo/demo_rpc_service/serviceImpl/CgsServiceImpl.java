package com.demo.demo_rpc_service.serviceImpl;

import com.demo.dao.mapper.CgsDksqMapper;
import com.demo.dao.model.CgsDksq;
import com.demo.dao.service.ICgsDksqService;
import com.demo.demo_rpc_service.mapper.one.OneTestMapper;
import com.demo.demo_rpc_service.mapper.two.TwoTestMapper;
import com.demo.demo_rpc_service.mq.fanout.RabbitFanOutProducer;
import com.demo.demo_rpc_service.mq.general.RabbitProducer;
import com.demo.demo_rpc_service.mq.topic.RabbitTopicProducer;
import com.demo.demo_rpc_service.redis.RedisUtils;
import com.demo.service.CgsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**车购税服务实现类
 *
 * @author zhaoshouyun
 * @create 2019-12-18 14:46
 **/
@Service(version = "1.0.0")
@Component
@Slf4j
public class CgsServiceImpl implements CgsService {

	@Autowired
	OneTestMapper oneTestMapper;
	@Autowired
	TwoTestMapper twoTestMapper;

	/*@Autowired
	ICgsDksqService cgsDksqService;*/
	@Autowired
	ICgsDksqService iCgsDksqService;

	@Autowired
	CgsDksqMapper cgsDksqMapper;

	@Autowired
	RedisUtils redisUtils;

	@Autowired
	RabbitProducer producer;

	@Autowired
	RabbitFanOutProducer rabbitFanOutProducer;

	@Autowired
	RabbitTopicProducer rabbitTopicProducer;

	/**
	 * 描述:获取车购税列表
	 *
	 * @param cgsDksq
	 * @return java.util.List<com.demo.dao.model.CgsDksq>
	 * @author zhaoshouyun
	 * @date 2019-12-18 14:44
	 */
	@Override
	public List<CgsDksq> listCgsDksq(CgsDksq cgsDksq) {
		CgsDksq cgsDksq1 = new CgsDksq();

		/*for (int i = 0 ; i < 50 ;i++){
			//普通队列
			//producer.send("测试普通队列,i="+i);
			//广播 队列
			rabbitFanOutProducer.fanoutSend("测试广播队列,i="+i);
		}*/
				//rabbitTopicProducer.topicTopicASend();
		rabbitTopicProducer.topicTopic1Send();
		rabbitTopicProducer.topicTopic2Send();
		rabbitTopicProducer.topicTopic3Send();

		//cgsDksqMapper.selectList(new QueryWrapper<>());
		if (redisUtils.get("test") != null){
			return (List<CgsDksq>) redisUtils.get("test");
		}
		List<CgsDksq> list  = iCgsDksqService.list();
        redisUtils.set("test",list,60);
		System.err.println("数据列表："+list.size());
		List<Map> maps = oneTestMapper.listJdc(new HashMap<>());
        //log.debug(JSON.toJSONString(maps));
		System.out.println("第一个数据源结果："+maps.size());
		List<Map> maps2 = twoTestMapper.listJdc(new HashMap<>());
		System.out.println("第二个数据源结果："+maps2.size());
		//log.debug(JSON.toJSONString(maps));
		List<CgsDksq> list1 = cgsDksq1.selectAll();

		return list1;
	}

}
