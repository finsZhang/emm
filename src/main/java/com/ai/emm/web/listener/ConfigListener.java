package com.ai.emm.web.listener;

import com.ai.emm.common.util.cache.DictCache;
import com.ai.emm.web.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听
 * @author fangll
 *
 */
public class ConfigListener implements ServletContextListener {
	private  static Logger logger = LoggerFactory.getLogger(ConfigListener.class);
	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		UserUtil.saveJmjUser();
		DictCache.loadDataFromFile();
		logger.debug("ConfigListener start");
		//System.setProperty("javax.net.ssl.trustStore", "/https");
	}
}
