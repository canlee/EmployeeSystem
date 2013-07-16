package com.icss.employeeSystem.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	/**
	 * 发送json到客户端
	 * @param out
	 * @param objects	[0]为名字，[1]为数据，[2]为名字，[3]为数据....
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public static void sendJson(PrintWriter out, Object...objects) 
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		Map<String, Object> result = new HashMap<String, Object>();
		for(int i = 0; i < objects.length; i++) {
			result.put((String) objects[i++], objects[i]);
		}
		objectMapper.writeValue(out, result);
	}
	
}
