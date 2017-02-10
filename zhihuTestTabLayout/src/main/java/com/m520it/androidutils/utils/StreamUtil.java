package com.m520it.androidutils.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
	/**
	 * @param is 输入流
	 * @return String 返回的字符串
	 * @throws IOException 
	 */
	public static String readFromStream(InputStream in) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) != -1) {
			baos.write(buffer, 0, len);
		}
		in.close();
		String result = baos.toString();
		baos.close();
		return result;
	}

}