package com.demo.demo_rpc_service.mapper.one;

import java.util.List;
import java.util.Map;
/**第一个数据库测试
 * @Author zhaoshouyun
 * @Description
 * @Date 2020-01-14 02:17
 * @Param null
 * @return
 **/
public interface OneTestMapper {

    List<Map> listJdc(Map<String,String> paramerMap);
}
