package client.utils;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import client.classes.ip.Ip;
import client.classes.location.LocationMessage;
import client.classes.position.Position;
import client.classes.timezone.TimeZone;

public class Service {
	
	public Service() {
		Unirest.setObjectMapper(new UnirestObjectMapper()); //TOCHECK 
	}
	
	//TODO Excepciones persoalizadas
	public LocationMessage getIPAPI(String ip) throws GeoFXserviceException {
		
			try {
				LocationMessage ipapi= Unirest
						.get("http://api.ipapi.com/api/" + ip + "?access_key=" + Token.IPAPI_KEY)
						.asObject(LocationMessage.class).getBody();

				return ipapi;

			} catch (UnirestException e) {
				throw new GeoFXserviceException("Error retrieving DATA from IPAPI");		

		}
		
		
	}
	
	public String getIPIFY() throws GeoFXserviceException {
		
		try {
			Ip ip = Unirest
					.get("https://geo.ipify.org/api/v1?apiKey="+Token.IPIFY_KEY)
					.asObject(Ip.class).getBody();
			return ip.getIp();
		} catch (UnirestException e) {
			throw new GeoFXserviceException("Error retrieving DATA from IPIFY");
		}
		
	
		
	}
	
public TimeZone getWorldTimeAPI() throws GeoFXserviceException {
	try {
		TimeZone timeZone = Unirest
				.get("http://worldtimeapi.org/api/ip")
				.asObject(TimeZone.class).getBody();
		return timeZone;
	} catch (UnirestException e) {
		throw new GeoFXserviceException("Error retrieving DATA WorldTimeAPI");
	}		
		
	}

public Position getPosition(String ip) throws GeoFXserviceException {
	try {
		Position position = Unirest
				.get("http://ip-api.com/json/"+ ip +"?fields=16515071&lang=es")
				.asObject(Position.class).getBody();
		return position;
	} catch (UnirestException e) {
		throw new GeoFXserviceException("Error retrieving DATA ip-api");
	}		
		
	}


}
