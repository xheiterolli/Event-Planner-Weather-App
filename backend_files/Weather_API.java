import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Weather_API {
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} catch (Exception e) {
			return null;
		} finally {
			is.close();
		}
	}

	// todo: url exception handing

	public void api_call(String city_name) throws IOException, JSONException {

        JSONObject json;
        JSONObject json_specific;
        Double result_temp;
        JSONArray json_list;
        JSONObject json_specific_day;
        JSONArray json_weather;
        JSONObject json_weather_specific;
        JSONObject json_city;
        String json_city_name;

		SimpleDateFormat df1 = new SimpleDateFormat("EEE", Locale.ENGLISH);
		Calendar c = Calendar.getInstance();
		try {
			int a = 1;
			json = readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast/daily?q=" + city_name + "&mode=json&units=metric&cnt=7&appid=9e305a41be9379cb679ece450324f811");

			json_list = json.getJSONArray("list");
			json_city = json.getJSONObject("city");
			json_city_name = json_city.getString("name");

			System.out.println("\n" + "The Forecast for " + json_city_name
					+ " is: " + "\n");
			for (int j = 0; j < 7; j++) {
				Double result_temp2 = null;

				json_specific_day = json_list.getJSONObject(j);
				json_specific = json_specific_day.getJSONObject("temp");
				result_temp = json_specific.getDouble("day");
				result_temp2 = json_specific.getDouble("night");

				json_weather = json_specific_day.getJSONArray("weather");
				json_weather_specific = json_weather.getJSONObject(0);
				String description = json_weather_specific
						.getString("description");

				if (j > 0) {
					c.add(Calendar.DATE, a);
				}
                String output = df1.format(c.getTime());
                System.out.println(output + ". It is " + result_temp
                        + "°C, and at Night it is " + result_temp2 + "°C with "
                        + description + ".");

			}
			System.out.println();
			GetCurrentTime();
			
			// "temp":{"min":-2.78,"eve":-2.78,"max":-1.4,"morn":-2.78,"night":-1.4,"day":-2.78}}
		} catch (Exception e) {
			System.out.println("Overload 429");
		}
	}
	
	public static void GetCurrentTime(){
		java.util.Date date = new java.util.Date();
		System.out.println(new Timestamp(date.getTime()));
		
	}
}
