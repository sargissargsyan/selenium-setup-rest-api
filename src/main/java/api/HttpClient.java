package api;

import com.google.gson.JsonParser;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class HttpClient {
	private static String ACCESS_TOKEN = null;
	private static final String BASE_URL = "https://api.taiga.io/api/v1";
	private static final String USERNAME = "sqa.days@yandex.ru";
	private static final String PASSWORD = "Armenia2018";


	public static JsonParser parser = new JsonParser();

	public static String login(String username, String password) {
		Response response;
		String responseJson;
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "username=" + username +
			"&password=" + password + "&type=normal");
		Request request = new Request.Builder()
			.url(BASE_URL + "/auth")
			.post(body)
			.addHeader("Content-Type", "application/x-www-form-urlencoded")
			.build();

		try {
			response = client.newCall(request).execute();
			responseJson = response.body().string();
		} catch (IOException e) {
			throw new ApiException(e.getMessage());
		}
		return responseJson;
	}

	public static Response post(String url, String jsonInString) {
		if (ACCESS_TOKEN == null) {
			String jsonString = login(USERNAME, PASSWORD);
			ACCESS_TOKEN = parser.parse(jsonString).getAsJsonObject().get("auth_token").getAsString();
		}
		OkHttpClient httpClient = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, jsonInString);
		String authorization = "Bearer " + ACCESS_TOKEN;
		Request request = new Request.Builder()
			.url(BASE_URL + url)
			.post(body)
			.addHeader("authorization", authorization)
			.addHeader("content-type", "application/json")
			.build();
		Response response;
		try {
			response = httpClient.newCall(request).execute();
		} catch (IOException e) {
			throw new ApiException(e);
		}

		if (!response.isSuccessful())
			throw new ApiException("Failed : HTTP error code : "
				+ String.valueOf(response.code()));

		return response;
	}

	public static Response delete(String url) {
		if (ACCESS_TOKEN == null) {
			String jsonString = login(USERNAME, PASSWORD);
			ACCESS_TOKEN = parser.parse(jsonString).getAsJsonObject().get("auth_token").getAsString();
		}
		OkHttpClient httpClient = new OkHttpClient();
		String authorization = "Bearer " + ACCESS_TOKEN;
		Request request = new Request.Builder()
			.url(BASE_URL + url)
			.delete()
			.addHeader("authorization", authorization)
			.addHeader("content-type", "application/json")
			.build();
		Response response;
		try {
			response = httpClient.newCall(request).execute();
		} catch (IOException e) {
			throw new ApiException(e);
		}

		if (!response.isSuccessful())
			throw new ApiException("Failed : HTTP error code : "
				+ String.valueOf(response.code()));

		return response;
	}


}
