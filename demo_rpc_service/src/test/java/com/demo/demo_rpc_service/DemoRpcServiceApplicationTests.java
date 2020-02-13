package com.demo.demo_rpc_service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.bean.DemoResult;
import com.demo.dao.mapper.CgsDksqMapper;
import com.demo.dao.model.CgsDksq;
import com.demo.dao.service.ICgsDksqService;
import com.demo.demo_rpc_service.fastdfs.DfsResConfig;
import com.demo.demo_rpc_service.fastdfs.FastDfsClientUtil;
import com.demo.demo_rpc_service.mapper.one.OneTestMapper;
import com.demo.demo_rpc_service.mapper.two.TwoTestMapper;
import com.demo.demo_rpc_service.mq.fanout.RabbitFanOutProducer;
import com.demo.demo_rpc_service.mq.general.RabbitProducer;
import com.demo.demo_rpc_service.mq.topic.RabbitTopicProducer;
import com.demo.demo_rpc_service.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class DemoRpcServiceApplicationTests {
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private OneTestMapper oneTestMapper;
	@Autowired
	TwoTestMapper twoTestMapper;

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

	@Autowired
	FastDfsClientUtil fastDfsClientUtil;

	@Autowired
	DfsResConfig dfsResConfig;

	private MockMvc mvc;
	private MockHttpSession session;

	@Before
	public void setupMockMvc(){
		mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
		session = new MockHttpSession();
		//User user =new User("root","root");
	//	session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
	}

	//测试数据源
	@Test
	void dataSource(){
		List<CgsDksq> list = iCgsDksqService.list();
		log.info("默认数据源查询出的结果，第一种方式：{}",list.size());
		CgsDksq cgsDksq = new CgsDksq();
		List<CgsDksq> cgsDksqs = cgsDksq.selectAll();
		log.info("默认数据源查询出的结果，第二种方式：{}",cgsDksqs.size());
		List<CgsDksq> cgsDksqss = cgsDksqMapper.selectList(new QueryWrapper<>());
		log.info("默认数据源查询出的结果，第三种方式：{}",cgsDksqss.size());
		List<Map> maps = oneTestMapper.listJdc(new HashMap<>());
		log.info("第一个数据源查询出的结果：{}",maps.size());
		List<Map> mapss = twoTestMapper.listJdc(new HashMap<>());
		log.info("第二个数据源查询出的结果：{}",mapss.size());
	}
	//测试redis
	@Test
	void testRedis(){
		String key = "zsy_test";
		Object o = redisUtils.get(key);
		if (o == null){
			redisUtils.set(key,"123123",60);
		}else{
			log.info("redis-key:{},value:{}",key,o.toString());
		}
	}

	//测试RabbmitMQ
	@Test
	void testRabbmitMQ(){
		producer.send("普通的MQ-");
		rabbitFanOutProducer.fanoutSend("广播模式MQ-");
		rabbitTopicProducer.topicTopic1Send();
		rabbitTopicProducer.topicTopic2Send();
		rabbitTopicProducer.topicTopic3Send();
	}

	//测试fastdfs
	@Test
	void testFastDfs(){
		File file = new File("C:\\Users\\赵守云\\Desktop\\文档路径\\委托代开代征需求记录表（原型地址+需求范围+文档路径）.xlsx");
		DemoResult<String> stringDemoResult = fastDfsClientUtil.uploadFile(file);
		log.info("上传结果：{}:{}/{}", dfsResConfig.getResHost(),dfsResConfig.getResPort(),stringDemoResult.getData());
		DemoResult demoResult = fastDfsClientUtil.deleteFile("http://192.168.204.48:8888/group1/M00/00/93/wKjKS14j8OOAAkaZAABZ4IM3p0E95.xlsx");
	    log.info("删除结果：{}",demoResult.toString());
	}

	@Test
	void contextLoads() {
	}

}
