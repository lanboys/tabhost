package com.m520it.androidutils.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import android.text.TextUtils;
import android.util.Log;

import com.thoughtworks.xstream.XStream;

public class XmlUtils {

	public Object xml2BeanObject(InputStream in, HashMap<String, Class<?>> aliasMap) {
		if (in == null) {
			Log.w("xml2BeanObject", "in不允许为空");
			return "";
		}
		return xml2BeanObject(null, in, aliasMap);
	}

	public Object xml2BeanObject(String xml, HashMap<String, Class<?>> aliasMap) {

		if (xml == null) {
			Log.w("xml2BeanObject", "xml不允许为空");
			return "";
		}
		return xml2BeanObject(xml, null, aliasMap);

	}

	public Object xml2BeanObject(String xml, InputStream in, HashMap<String, Class<?>> aliasMap) {
		Object obj = null;
		try {
			if (TextUtils.isEmpty(xml)) {
				xml = StreamUtil.readFromStream(in);
			}
			XStream xStream = new XStream();
			for (Entry<String, Class<?>> entry : aliasMap.entrySet()) {
				xStream.alias(entry.getKey(), entry.getValue());
			}
			obj = xStream.fromXML(xml);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			Log.w("xml2BeanObject", "xml解析出错：" + e.getLocalizedMessage());
			return "";
		}
	}
}
