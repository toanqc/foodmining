package mum.bigdata.food.mining;

import java.io.Serializable;
import java.util.List;

public class Restaurant implements Serializable {

	private static final long serialVersionUID = 2532712268904344195L;
	private List<Business> businesses;

	/**
	 * @return the businesses
	 */
	public List<Business> getBusinesses() {
		return businesses;
	}

	/**
	 * @param businesses
	 *            the businesses to set
	 */
	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
}

class Business {
	private boolean is_claimed;
	private double rating;
	private int review_count;
	private String name;
	private String phone;
	private String id;
	private String url;
	private Location location;

	/**
	 * @return the is_claimed
	 */
	public boolean isIs_claimed() {
		return is_claimed;
	}

	/**
	 * @param is_claimed
	 *            the is_claimed to set
	 */
	public void setIs_claimed(boolean is_claimed) {
		this.is_claimed = is_claimed;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the review_count
	 */
	public int getReview_count() {
		return review_count;
	}

	/**
	 * @param review_count
	 *            the review_count to set
	 */
	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
}

class Location {
	private String city;
	private String[] address;
	private String postal_code;
	private String country_code;
	private String state_code;

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the address
	 */
	public String[] getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String[] address) {
		this.address = address;
	}

	/**
	 * @return the postal_code
	 */
	public String getPostal_code() {
		return postal_code;
	}

	/**
	 * @param postal_code
	 *            the postal_code to set
	 */
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}

	/**
	 * @param country_code
	 *            the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	/**
	 * @return the state_code
	 */
	public String getState_code() {
		return state_code;
	}

	/**
	 * @param state_code
	 *            the state_code to set
	 */
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
}