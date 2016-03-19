package country_from_ip_lookup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/*-*
Country from IP Lookup – 
Enter an IP address and find the country that IP is registered in.
 */
/**
 *
 * @author jingchen
 *
 */
public class IPLookup {

	Logger logger = LoggerFactory.getLogger(IPLookup.class);

	private static final String IP_INFO = "http://ipinfo.io/";

	public String lookup(String ip) {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(IP_INFO + ip + "/json");
		BufferedReader reader = null;
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if (httpResponse == null) {
				logger.error("No Response!");
				return "";
			}
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				logger.error("Http error: " + httpResponse.getStatusLine().getStatusCode());
				return httpResponse.getStatusLine().getStatusCode() + "";
			}
			reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}

			ObjectMapper mapper = new ObjectMapper();
			IPInfo ipinfo = mapper.readValue(response.toString(), IPInfo.class);
			StringBuilder result = new StringBuilder();
			result.append("IP:").append(ipinfo.getIp()).append("\n").append("Hostname:").append(ipinfo.getHostname())
					.append("\n").append("City:").append(ipinfo.getCity()).append("\n").append("State:")
					.append(ipinfo.getState()).append("\n").append("Country:").append(ipinfo.getCountry()).append("\n")
					.append("Location:").append(ipinfo.getLocation()).append("\n").append("Organization:")
					.append(ipinfo.getOrganization()).append("\n").append("Zipcode:").append(ipinfo.getZipcode())
					.append("\n");

			return result.toString();
		} catch (ClientProtocolException e) {
			logger.debug(e.getMessage());
		} catch (IOException e) {
			logger.debug(e.getMessage());
		} finally {
			try {
				reader.close();
				httpClient.close();
			} catch (IOException e) {
				logger.debug(e.getMessage());
			}
		}
		return "";
	}

	public static void main(String[] args) {
		IPLookup iplookup = new IPLookup();
		System.out.println(iplookup.lookup("99.98.123.58"));
	}

}
/*-----------------------------Output------
IP:99.98.123.58
Hostname:99-98-123-58.lightspeed.miamfl.sbcglobal.net
City:Miami
State:Florida
Country:US
Location:25.8535,-80.1811
Organization:AS7018 AT&T Services, Inc.
Zipcode:33138


*/