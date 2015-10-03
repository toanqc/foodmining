package mum.bigdata.food.mining;

import java.io.Serializable;
import java.util.List;

public class Restaurant implements Serializable {

	private static final long serialVersionUID = 2532712268904344195L;
	public List<Business> businesses;
}

class Business {
	private boolean is_claimed;
	private double rating;

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
}