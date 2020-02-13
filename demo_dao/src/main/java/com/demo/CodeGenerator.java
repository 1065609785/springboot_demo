package com.demo;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author zhaoshouyun
 * @create 2019-12-16 13:34
 **/
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	public static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}

	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		final String projectPath = System.getProperty("user.dir");
		System.err.println("url:"+projectPath);
		//gc.setOutputDir(projectPath + "/dzfpdk-provider-rpc/dzfpdk-provider-rpc-dao/src/main/java");
		gc.setOutputDir(projectPath + "/demo_dao/src/main/java");
		gc.setAuthor("zhaoshouyun");
		gc.setOpen(false);
		//gc.setSwagger2(true);
		gc.setActiveRecord(true);
		gc.setDateType(DateType.ONLY_DATE);
		mpg.setGlobalConfig(gc);

		// 数据源配置
		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:oracle:thin:@192.168.201.106:1521:orcl");
		// dsc.setSchemaName("public");
		dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
		dsc.setUsername("wtdz_ww2");
		dsc.setPassword("wtdz_ww2");
		mpg.setDataSource(dsc);

		dsc.setTypeConvert(new OracleTypeConvert(){
			@Override
			public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
				System.out.println("转换类型：" + fieldType);
				String t = fieldType.toLowerCase();
				if (t.contains("clob")) {
					return DbColumnType.STRING;
				}
				if (t.contains("number")) {
					return DbColumnType.BIG_DECIMAL;
				}
				return super.processTypeConvert(globalConfig, fieldType);
			}
		});


		mpg.setDataSource(dsc);


		// 包配置
		final PackageConfig pc = new PackageConfig();
		// pc.setModuleName(scanner("模块名"));
		pc.setParent("com.demo.dao");
		pc.setMapper("mapper");
		pc.setEntity("model");
		pc.setService("service");
		pc.setServiceImpl("service.serviceImpl");

		mpg.setPackageInfo(pc);


		InjectionConfig cfg = new InjectionConfig() {
			//自定义属性注入:abc
			//在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};
		//配置自定义属性注入
		cfg.setFileOutConfigList(null);
		mpg.setCfg(cfg);
		mpg.setTemplate(new TemplateConfig().setXml(null).setController(null));

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setSuperEntityClass("com.baomidou.mybatisplus.samples.generator.common.BaseEntity");
		strategy.setEntityLombokModel(false);
		strategy.setSuperEntityClass(Model.class);
		strategy.setInclude(scanner("表名"));
		strategy.setSuperEntityColumns(scanner("主键"));

		//  strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(pc.getModuleName() + "_");
		mpg.setStrategy(strategy);
		// 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}
}
