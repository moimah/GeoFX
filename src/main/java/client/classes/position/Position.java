package client.classes.position;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author moimah
 * This class created by jsonschema2pojo and
 * uses the API FROM www.ip-api.com
 *
 */

public class Position {	


		@SerializedName("query")
		@Expose
		private String query;
		@SerializedName("status")
		@Expose
		private String status;
		@SerializedName("continent")
		@Expose
		private String continent;
		@SerializedName("continentCode")
		@Expose
		private String continentCode;
		@SerializedName("country")
		@Expose
		private String country;
		@SerializedName("countryCode")
		@Expose
		private String countryCode;
		@SerializedName("region")
		@Expose
		private String region;
		@SerializedName("regionName")
		@Expose
		private String regionName;
		@SerializedName("city")
		@Expose
		private String city;
		@SerializedName("district")
		@Expose
		private String district;
		@SerializedName("zip")
		@Expose
		private String zip;
		@SerializedName("lat")
		@Expose
		private Double lat;
		@SerializedName("lon")
		@Expose
		private Double lon;
		@SerializedName("timezone")
		@Expose
		private String timezone;
		@SerializedName("currency")
		@Expose
		private String currency;
		@SerializedName("isp")
		@Expose
		private String isp;
		@SerializedName("org")
		@Expose
		private String org;
		@SerializedName("as")
		@Expose
		private String as;
		@SerializedName("asname")
		@Expose
		private String asname;
		@SerializedName("reverse")
		@Expose
		private String reverse;
		@SerializedName("mobile")
		@Expose
		private Boolean mobile;
		@SerializedName("proxy")
		@Expose
		private Boolean proxy;

		public String getQuery() {
		return query;
		}

		public void setQuery(String query) {
		this.query = query;
		}

		public String getStatus() {
		return status;
		}

		public void setStatus(String status) {
		this.status = status;
		}

		public String getContinent() {
		return continent;
		}

		public void setContinent(String continent) {
		this.continent = continent;
		}

		public String getContinentCode() {
		return continentCode;
		}

		public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
		}

		public String getCountry() {
		return country;
		}

		public void setCountry(String country) {
		this.country = country;
		}

		public String getCountryCode() {
		return countryCode;
		}

		public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		}

		public String getRegion() {
		return region;
		}

		public void setRegion(String region) {
		this.region = region;
		}

		public String getRegionName() {
		return regionName;
		}

		public void setRegionName(String regionName) {
		this.regionName = regionName;
		}

		public String getCity() {
		return city;
		}

		public void setCity(String city) {
		this.city = city;
		}

		public String getDistrict() {
		return district;
		}

		public void setDistrict(String district) {
		this.district = district;
		}

		public String getZip() {
		return zip;
		}

		public void setZip(String zip) {
		this.zip = zip;
		}

		public Double getLat() {
		return lat;
		}

		public void setLat(Double lat) {
		this.lat = lat;
		}

		public Double getLon() {
		return lon;
		}

		public void setLon(Double lon) {
		this.lon = lon;
		}

		public String getTimezone() {
		return timezone;
		}

		public void setTimezone(String timezone) {
		this.timezone = timezone;
		}

		public String getCurrency() {
		return currency;
		}

		public void setCurrency(String currency) {
		this.currency = currency;
		}

		public String getIsp() {
		return isp;
		}

		public void setIsp(String isp) {
		this.isp = isp;
		}

		public String getOrg() {
		return org;
		}

		public void setOrg(String org) {
		this.org = org;
		}

		public String getAs() {
		return as;
		}

		public void setAs(String as) {
		this.as = as;
		}

		public String getAsname() {
		return asname;
		}

		public void setAsname(String asname) {
		this.asname = asname;
		}

		public String getReverse() {
		return reverse;
		}

		public void setReverse(String reverse) {
		this.reverse = reverse;
		}

		public Boolean getMobile() {
		return mobile;
		}

		public void setMobile(Boolean mobile) {
		this.mobile = mobile;
		}

		public Boolean getProxy() {
		return proxy;
		}

		public void setProxy(Boolean proxy) {
		this.proxy = proxy;
		}

		
	

}
