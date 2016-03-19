package country_from_ip_lookup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author jingchen
 *
 */
public class IPInfo {
	private String ip;
	private String hostname;
	private String city;
	private String state;
	private String country;
	private String location;
	private String organization;
	private String zipcode;

	@JsonProperty("ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@JsonProperty("hostname")
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("region")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("loc")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@JsonProperty("org")
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@JsonProperty("postal")
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "IP Information [ip=" + ip + ", hostname=" + hostname + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", location=" + location + ", organization=" + organization + ", zipcode="
				+ zipcode + "]";
	}
}
