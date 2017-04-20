package com.epam.httpserver.util;

import com.epam.httpserver.resources.CommonConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class HttpMethodUtils {

	public static List<String> getHeaderValue(BufferedReader rq) throws IOException {

		List<String> headerValue = new ArrayList<String>();
		String strForReadHeader;
		strForReadHeader = rq.readLine();
		while (strForReadHeader != null && !strForReadHeader.equals("")) {
			headerValue.add(strForReadHeader);
			strForReadHeader = rq.readLine();
		}
		int contentLength = getContentLength(headerValue);
		if (contentLength > 0) {

			headerValue.add(getPostBody(rq, contentLength));
		}
		return headerValue;
	}

	private static int getContentLength(List<String> headerValue) {
		int contentLength = 0;
		for (String header : headerValue) {

			if (header.contains(CommonConstants.CONTENT_LENGTH)) {
				contentLength = Integer.parseInt(SplitUtils.getLastSplitValueBy(header, CommonConstants.COLON_SPLITTER));
			}
		}
		return contentLength;
	}

	private static String getPostBody(BufferedReader rq, int contentLeng) throws IOException {

		StringWriter postRequest = new StringWriter();
		char[] buffer = new char[1024];
		int charToWrite = 0;
		while ((charToWrite = rq.read(buffer)) != -1) {
			postRequest.write(buffer, 0, charToWrite);
			if (charToWrite == contentLeng) {
				break;
			}
		}
		return postRequest.toString();
	}
}
