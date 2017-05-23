package com.ai.emm.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created with IntelliJ IDEA.
 * User: chengzj
 * Date: 15-2-6
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */

public abstract class CookieUtil {

	private static Log logger = LogFactory.getLog(CookieUtil.class);
	  
	public static final String U_KEY_ID = "_u_id_";
	public static final String U_KEY_PWD = "_u_p_";

	public static String getCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie ck : cookies) {
				if (StringUtils.equals(key, ck.getName())) {
					return ck.getValue();
				}
			}
		}
		return null;
	}

	public static Cookie get(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie ck : cookies) {
				if (StringUtils.equals(key, ck.getName())) {
					return ck;
				}
			}
		}
		return null;
	}

	public static void setCookie(HttpServletResponse response, String domain,
			String key, String value, int maxAge) {
		Cookie cookie = new Cookie(key, value);
		cookie.setPath("/ecard");
		cookie.setSecure(true);
		cookie.setDomain(domain);
		if (maxAge > 0) {
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}

	public static void removeCookie(HttpServletRequest request,
			HttpServletResponse response, String domain,String key) {
		Cookie cookie = get(request, key);
		if (cookie != null) {
			cookie.setMaxAge(0);
			cookie.setPath("/ecard");
            cookie.setDomain(domain);
			response.addCookie(cookie);
		}
	}

}
