package com.welylabs.testmcp.domain;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service 
public class WeatherService {

	private final RestClient restClient;

	public WeatherService() {
		this.restClient = RestClient.builder()
			.baseUrl("https://api.weather.gov")
			.defaultHeader("Accept", "application/geo+json")
			.defaultHeader("User-Agent", "WeatherApiClient/1.0 (your@email.com)")
			.build();
	}

  @Tool(description = "Get weather forecast for a specific latitude/longitude")
  public String getWeatherForecastByLocation(
      Double latitude,   // Latitude coordinate
      Double longitude   // Longitude coordinate
  ) {
      return latitude.toString().concat(" ").concat(longitude.toString());
  }

  //@Tool(description = "Get weather alerts for a US state")
  //public String getAlerts(
  //    @ToolParam(description = "Two-letter US state code (e.g. CA, NY)") String state
  //) {
      // Returns active alerts including:
      // - Event type
      // - Affected area
      // - Severity
      // - Description
      // - Safety instructions
  //}

  // ......
}
