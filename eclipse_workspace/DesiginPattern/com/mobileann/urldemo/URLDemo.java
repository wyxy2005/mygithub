package com.mobileann.urldemo;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL(
					"http://client.mobileann.com/page/gpc_help.php?os=android&id=2&target=blank");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// System.out.println("URL is " + url.toString());
		// System.out.println("protocol is " + url.getProtocol());
		// System.out.println("authority is " + url.getAuthority());
		// System.out.println("file name is " + url.getFile());
		// System.out.println("host is " + url.getHost());
		// System.out.println("path is " + url.getPath());
		// System.out.println("port is " + url.getPort());
		// System.out.println("default port is " + url.getDefaultPort());
		System.out.println("query is " + url.getQuery());
		// System.out.println("ref is " + url.getRef());

		String[] split = url.getQuery().split("&");
		for (int j = 0, count = split.length; j < count; j++) {
			String split2 = split[j].split("=")[1];
			System.out.println(split2);
		}
	}

}
