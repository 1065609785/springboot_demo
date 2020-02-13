package com.demo.demo_web;

import cn.hutool.core.lang.ObjectId;
import com.demo.utils.AESUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;


@SpringBootTest
@Slf4j
class DemoWebApplicationTests {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mvc;
	private MockHttpSession session;

	public static void main(String[] args) {
		String key = ObjectId.next();
		String content = "{\"success\":true,\"script\":null,\"data\":{\"code\":\"0\",\"msg\":\"操作成功\",\"data\":{\"CgsYjsf\":{\"yjsfUuid\":\"d2c4c9c4c3e74bf0bf81a5dc6c112e79\",\"dksqUuid\":\"e8adb7f31acf4f128cc69feb8072e4e9\",\"yzpzxh\":\"10013420000007382240\",\"zsxmDm\":\"10116\",\"zspmDm\":\"101160000\",\"ybtse\":\"8849.56\",\"jkqx\":\"2020-03-09\",\"nssbrq\":\"2020-01-08\",\"skssswjgDm\":\"13407060000\",\"cjrq\":\"2020-01-08 11:02:24\",\"crjId\":\"516205465221678585\",\"skssqq\":\"2020-01-08\",\"skssqz\":\"2020-01-08\",\"djxh\":\"20123400000008517079\",\"dzsphm\":\"334076200100004774\",\"yzpzmxxh\":\"1\",\"zsuuid\":\"BB803C07E82F384A5CEB04FA73D7BB41\"},\"CgsPay\":[{\"payUuid\":\"11a7951006fd41bc91cb93a0707ba16b\",\"orderId\":\"334076200100004774\",\"cjrq\":\"2020-01-08 11:02:29\",\"crjId\":\"516205465221678585\",\"amount\":8849.56,\"pzxh\":\"334076200100004774\",\"swjgdm\":\"13407060000\",\"nsrsbh\":\"340823198509066110\",\"payTime\":null,\"xgrId\":\"516205465221678585\",\"xgrq\":\"2020-01-08 11:03:25\",\"payZt\":\"2\",\"dksqUuid\":\"e8adb7f31acf4f128cc69feb8072e4e9\",\"queryId\":null,\"payType\":\"2\",\"sbYy\":null,\"skyCljg\":null}],\"CgsWszm\":{\"wszmUuid\":\"6069f56448c742e0a3350f045416a6c6\",\"gt3Cgssbuuid\":\"650D7489FD10A6A041EB5E21A541FB72\",\"gt3Cgsuuid\":\"EC1390B78D34F175A0CED9452B5F7277\",\"gt3Cldauuid\":\"FDA17C645D5C743D648564A2A8AB553B\",\"gt3Cldabh\":\"13407060020200108100190019\",\"cjrq\":\"2020-01-08 11:03:25\",\"dksqUuid\":\"e8adb7f31acf4f128cc69feb8072e4e9\",\"cjrId\":\"516205465221678585\",\"xgrq\":null,\"xgrId\":null,\"pzhm\":\"91340706000020010800024\",\"pzzgDm\":null,\"pzzlDm\":null,\"zt\":\"1\",\"ewtmc\":null,\"ewtmt\":null},\"CgsDksq\":{\"dksqUuid\":\"e8adb7f31acf4f128cc69feb8072e4e9\",\"gt3Sbuuid\":\"4628F3E8400FBFCF78BC70367EEB2C94\",\"gt3CgsSbuuid\":\"650D7489FD10A6A041EB5E21A541FB72\",\"gt3Pzxh\":10013420000007382240,\"nsrsbh\":\"340823198509066110\",\"nsrmc\":\"左鸿亮\",\"nsrZjlx\":\"201\",\"nsrZjmc\":\"居民身份证\",\"nsrLxdh\":\"13865104111\",\"nsrHyDm\":\"Z990\",\"nsrZclxdm\":\"900\",\"spXzqhCode\":\"340705\",\"clcd\":null,\"fpdm\":\"134071922281\",\"fphm\":\"00034228\",\"clsbdh\":\"LVTDB21B9KD221159\",\"jdccchgzbh\":\"WEU07KD00221159\",\"sbzt\":\"1\",\"sbSj\":\"2020-01-08 11:02:18\",\"sbSbyy\":null,\"jkZt\":\"2\",\"jksj\":\"2020-01-08 11:03:25\",\"jksbSbyy\":null,\"kjwszmZt\":\"1\",\"kjwszmSj\":\"2020-01-08 11:03:25\",\"kjwszmSbyy\":null,\"clcp\":\"奇瑞牌SQR6471T1AT9\",\"clxh\":\"SQR6471T1AT9\",\"cllbDm\":\"1\",\"cllx\":\"06\",\"clgzsrlnyzlDm\":\"A\",\"scqymc\":\"奇瑞汽车股份有限公司\",\"cdsx\":\"1\",\"clgzdsxDm\":\"1\",\"zdjsjg\":null,\"hdjsjg\":null,\"clgzssblxDm\":\"0100\",\"tdsfyylxDm\":null,\"clgzsjsfsDm\":\"1\",\"clgzstsjsyjlxDm\":null,\"clgzsmjstjDm\":null,\"ywszmhm\":null,\"jdcxstyfpbhsjghj\":88495.58,\"escxstyfpbhsjghj\":null,\"ccnssbrq\":\"2020-01-08 00:00:00\",\"mstjxsrq\":null,\"gzrq\":\"2020-01-08 00:00:00\",\"xjqx\":\"2020-03-09 00:00:00\",\"xnyqclxDm\":null,\"zfbz1\":\"1\",\"zfrDm\":null,\"zfrq1\":null,\"lrrDm\":\"tlcgs01    \",\"lrrq\":\"2020-01-08 00:00:00\",\"xgrDm\":\"516205465221678585\",\"xgrq\":\"2020-01-08 00:00:00\",\"zsjgDm\":\"13407060000\",\"sbjsjg\":88495.58,\"jsjg\":88495.58,\"sl1\":0.1,\"jmse\":0,\"ynse\":8849.56,\"ybtse\":8849.56,\"yjse\":0,\"znj\":0,\"yjjhj\":8849.56,\"djxh\":20123400000008517079,\"fdjhm\":\"ABKL00200\",\"clxlh\":\"34020106027098\",\"clmc\":\"多用途乘用车\",\"dljgUuid\":\"1cdd4420b02d4881b437b0948ca93cd3\",\"gcmsbz\":\"0\",\"sfxny\":\"0\",\"cjrId\":\"516205465221678585\",\"cjrYhm\":\"tlcgs01\",\"cjrMc\":\"胡泽原\",\"kpyQyMc\":null,\"kpyQyNsrsbh\":null,\"kpyQyDz\":null,\"pql\":\"1598\",\"zws\":\"5\",\"gl\":\"145\",\"zypz\":null,\"nsrLx\":\"1\",\"nsrDz\":\"铜陵市\"},\"CgsFpmx\":{\"cgsfpUuid\":\"ca85e11ec14f4580bfa7681750a46161\",\"dksqUuid\":\"e8adb7f31acf4f128cc69feb8072e4e9\",\"sfescbz\":null,\"fpDm\":\"134071922281\",\"jdcxstyfphm\":\"00034228\",\"fpkjrq\":\"2020-01-08 00:00:00\",\"jdcxstyfpjg\":100000,\"zfbz1\":\"1\",\"zfrq1\":null,\"zfrDm\":null,\"lrrDm\":null,\"lrrq\":\"2020-01-08 00:00:00\",\"xgrDm\":null,\"xgrq\":null,\"pzxh\":null,\"jshj\":100000,\"bhsje\":88495.58,\"se\":11504.42,\"sv1\":0.13},\"CgsJdcFpxxes\":[]}},\"error\":0}";
		log.info("key:{}",key);
		JwtBuilder builder= Jwts.builder()
				.setId("888")   //设置唯一编号
				.setSubject("赵守云")//设置主题  可以是JSON数据
				.setIssuedAt(new Date())//设置签发日期
				.signWith(SignatureAlgorithm.HS256,key);//设置签名 使用HS256算法，并设置SecretKey(字符串)
         //构建 并返回一个字符串
		String compactJwt = builder.compact();
		System.out.println(  compactJwt);

		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(compactJwt).getBody();
		System.out.println(claims);

	}

	@Before
	public void setupMockMvc(){
		mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
		session = new MockHttpSession();
		//User user =new User("root","root");
		//	session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
	}

	@Test
	void encryTest() throws Exception{
		final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("name", AESUtil.encrypt("6"));
		params.add("age", AESUtil.encrypt("23"));
		params.add("sex", AESUtil.encrypt("男"));
		params.add("date", AESUtil.encrypt("2020-01-20"));

		String responseString =  mvc.perform(MockMvcRequestBuilders.post("/encry/test")
				// 设置参数
				.params(params)
				//设置headers
				// 代表发送端发送的数据格式
				.contentType(MediaType.APPLICATION_JSON)
				// 代表客户端希望接受的数据类型格式
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				//将response的content返回
				.andReturn().getResponse().getContentAsString();
		log.info("返回结果：{}-{}",responseString, AESUtil.decrypt(responseString));
	}
	@Test
	void contextLoads() {
	}

}
