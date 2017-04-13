package com.mcl.bysj.utils;

import org.apache.commons.configuration.PropertiesConfiguration;
/**
 * 配置文件读取工具类
 * Created by mingchunlin on 17/4/13.
 */
public class PropReadUtil
{
	private PropReadUtil()
	{

	}

	private static PropReadUtil propReadUtil = null;
	/**
	 * 单例模式，返回PropReadUtil的实例化对象
	 * 
	 * @return propReadUtil
	 */
	public static PropReadUtil getInstance()
	{
		if (propReadUtil == null)
		{
			propReadUtil = new PropReadUtil();
		}
		return propReadUtil;
	}
	/**
	 * 根据key，读取相应value
	 * @param name key
	 * @return String
	 */
	public String getResources(String name)
	{
		PropertiesConfiguration resourcesConfig = null;
		try
		{
			resourcesConfig = new PropertiesConfiguration("./key.properties");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null != resourcesConfig ? resourcesConfig.getString(name, "") : "";
	}
}
