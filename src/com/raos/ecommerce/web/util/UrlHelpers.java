package com.raos.ecommerce.web.util;

public class UrlHelpers {
	public static String toURL(String scheme, String host, int port, String contextPath) {
		return scheme + "://" + host
				+ ((("http".equals(scheme) && port == 80) || ("https".equals(scheme) && port == 443)) ? "" : ":" + port)
				+ contextPath;
	}
}
