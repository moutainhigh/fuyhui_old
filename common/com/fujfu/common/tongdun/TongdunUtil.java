package com.fujfu.common.tongdun;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class TongdunUtil {

	private final static String REQUEST_CHARSET = "UTF-8";
	private final static String RESPONSE_CHARSET = "UTF-8";
	private final static int CONNECT_TIMEOUT = 5000; // 调用连接超时时间
	private final static int REQUEST_TIMEOUT = 10000; // 调用获取数据超时时间

	private final static String PARTNER_CODE = "fuzhifu"; // 合作方标识
	private final static String PARTNER_KEY = "08848473ab5d41c5baa227f9c9b7fd80"; // 合作方密钥


	/***
	 * 通过Https调用同盾基础数据服务，不建议长连接
	 * 
	 * @param parameterList
	 * @return JSON格式的字符串
	 * @throws IOException
	 */
	public static String invoke(List<NameValuePair> parameterList, String URL) throws IOException {
		HttpPost httpPost = null;
		String result = "";
		try {

			// 拼接URL
			String url = String.format("%s?partner_code=%s&partner_key=%s", URL, PARTNER_CODE, PARTNER_KEY);
			httpPost = new HttpPost(url);

			// 设置超时时间
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
					.setSocketTimeout(REQUEST_TIMEOUT).build();
			httpPost.setConfig(requestConfig);

			CloseableHttpClient httpClient = HttpClients.createDefault();
			httpPost.setEntity(new UrlEncodedFormEntity(parameterList, REQUEST_CHARSET));
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();

			// 返回值不是200，进行错误处理
			if (HttpStatus.SC_OK != httpResponse.getStatusLine().getStatusCode()) {
				// 相关处理
				if (null != httpPost) {
					httpPost.abort();
				}
				return result;
			}

			// 获取结果
			result = EntityUtils.toString(httpEntity, RESPONSE_CHARSET);

		} catch (Exception e) {
			if (null != httpPost) {
				httpPost.abort();
			}
			throw e;
		}
		return result;
	}
}
