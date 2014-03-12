package org.joolzminer.examples;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlParsingDemo {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.yahoo.com:80/en/index.html?name=john&uid=10101132#first");
		
		System.out.println(url);
		System.out.println("protocol: " + url.getProtocol());
		System.out.println("host    : " + url.getHost());
		System.out.println("port    : " + url.getPort());
		System.out.println("path    : " + url.getPath());
		System.out.println("file    : " + url.getFile());
		System.out.println("query   : " + url.getQuery());
		System.out.println("ref     : " + url.getRef());
	}
}
