package com.demo.demo_rpc_service.fastdfs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_demo
 * @description:
 * @author: zhaoshouyun
 * @create: 2020-01-17 17:42
 **/
@Data
@Component
@ConfigurationProperties("storage")
public class DfsResConfig {
    private String resHost;
    private String resPort;
}
