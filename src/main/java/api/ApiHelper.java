package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Response;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class ApiHelper {
	static final String AB = "abcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	public static JsonParser parser = new JsonParser();
	public static Gson gson = new GsonBuilder().create();


	public static String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public static JsonObject createProject() {
		HashMap projectMap = new HashMap();
		projectMap.put("is_private", false);
		projectMap.put("creation_template", 1);
		projectMap.put(	"name", "Test Project Name " + randomString(5));
		projectMap.put(	"description", "Test Project Description" + randomString(10));
		String jsonString = gson.toJson(projectMap);
		Response response = HttpClient.post("/projects", jsonString);
		return getJsonObject(response);
	}

	public static JsonObject createIssue(JsonObject project) {
		HashMap projectMap = new HashMap();
		projectMap.put("project", project.get("id").getAsInt());
		projectMap.put(	"subject", "Test Issue Subject " + randomString(5));
		projectMap.put(	"description", "Test Issue Description" + randomString(10));
		String jsonString = gson.toJson(projectMap);
		Response response = HttpClient.post("/issues", jsonString);
		return getJsonObject(response);
	}

	public static void deleteProject(JsonObject project) {
		HashMap projectMap = new HashMap();
		projectMap.put("is_private", false);
		projectMap.put("creation_template", 1);
		projectMap.put(	"name", randomString(5));
		projectMap.put(	"description", randomString(20));
		HttpClient.delete("/projects/" + project.get("id").getAsString());
	}

	public static JsonObject getJsonObject(Response response) {
		String responseJson = null;
		try {
			responseJson = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parser.parse(responseJson).getAsJsonObject();
	}
}
