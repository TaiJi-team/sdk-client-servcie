package com.example.httpclient.sdk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class DemoApplicationTests {

	public static void main(String[] args) {
		String filePath = "/home/yuan/data/work-dir/project-microservice/api-sdk/new/sdk/src/test/java/com/example/httpclient/sdk/body_test.json";
		String url = "http://localhost:8080/test/datacollect";
		try {
			String response = HttpClientUtil.httpPost(url, fileToStr(filePath));
			System.out.println(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String fileToStr(String fileFath) {
		int len = 0;
		StringBuffer str = new StringBuffer("");
		File file = new File(fileFath);
		try {
			FileInputStream is = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader in = new BufferedReader(isr);
			String line = null;
			while ((line = in.readLine()) != null) {
				if (len != 0) {
					str.append("\r\n" + line);
				} else {
					str.append(line);
				}
				len++;
			}
			in.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str.toString();
	}

}
