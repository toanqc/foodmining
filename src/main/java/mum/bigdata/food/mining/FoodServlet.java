package mum.bigdata.food.mining;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import com.google.gson.Gson;

public class FoodServlet extends HttpServlet {

	private static final long serialVersionUID = 6045703010453109L;

	/*
	 * Update OAuth credentials below from the Yelp Developers API site:
	 * http://www.yelp.com/developers/getting_started/api_access
	 */
	private static final String CONSUMER_KEY = "TGqkmncgeHOwFQsXYAiP0g";
	private static final String CONSUMER_SECRET = "nXKABarDf6O7K2t656-zPW_g8X8";
	private static final String TOKEN = "xaUy9Ljh04-_8xvftQyJEnpj_o8XKNlU";
	private static final String TOKEN_SECRET = "S0n8YRxHrqeMYMt0_gs6e4uXFPU";
	private static final int SEARCH_LIMIT = 20;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		File currentDir = new File("businesses.csv").getAbsoluteFile();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currentDir), "UTF-8"));
		YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);

		buildHeader(bw);

		String res = null;

		int totalRecords = 0;
		Gson gson = new Gson();

		/* Restaurants in Iowa State */
		int index = 0;
		for (int i = 0; i < 20; i++) {
			res = yelpApi.searchForBusinessesByLocation("Restaurants", "Iowa", SEARCH_LIMIT, index);
			Restaurant restaurant = gson.fromJson(res, Restaurant.class);
			writeToCsvFile(restaurant.getBusinesses(), bw);
			totalRecords += restaurant.getBusinesses().size();
			index += SEARCH_LIMIT;
		}

		/* Restaurant in Fairfield only */
		/*
		 * index = 0; for (int i = 0; i < 3; i++) { res =
		 * yelpApi.searchForBusinessesByLocation("Restaurants", "Fairfield, IA",
		 * SEARCH_LIMIT, index); Restaurant restaurant = gson.fromJson(res,
		 * Restaurant.class); writeToCsvFile(restaurant.getBusinesses(), bw);
		 * totalRecords += restaurant.getBusinesses().size(); index +=
		 * SEARCH_LIMIT; }
		 */

		bw.flush();
		bw.close();

		out.println("Get total: " + totalRecords + " records successfully");
	}

	private static final String CSV_SEPARATOR = ",";

	private void buildHeader(BufferedWriter bw) throws IOException {
		StringBuffer header = new StringBuffer();
		header.append("Id");
		header.append(CSV_SEPARATOR);
		header.append("Name");
		header.append(CSV_SEPARATOR);
		header.append("Address");
		header.append(CSV_SEPARATOR);
		header.append("City");
		header.append(CSV_SEPARATOR);
		header.append("State");
		header.append(CSV_SEPARATOR);
		header.append("Zip");
		header.append(CSV_SEPARATOR);
		header.append("Telephone");
		header.append(CSV_SEPARATOR);
		header.append("Website");
		header.append(CSV_SEPARATOR);
		header.append("Rating");
		header.append(CSV_SEPARATOR);
		bw.write(header.toString());
		bw.newLine();
	}

	private void writeToCsvFile(List<Business> businesses, BufferedWriter bw) {
		try {
			for (Business business : businesses) {
				StringBuffer oneLine = new StringBuffer();
				oneLine.append(business.getId());
				oneLine.append(CSV_SEPARATOR);
				String escapedName = StringEscapeUtils.escapeCsv(business.getName());
				oneLine.append(escapedName == null ? "" : escapedName);
				oneLine.append(CSV_SEPARATOR);
				String escapedAddress = StringEscapeUtils.escapeCsv(business.getLocation().getAddress()[0]);
				oneLine.append(escapedAddress == null ? "" : escapedAddress);
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(business.getLocation().getCity() == null ? "" : business.getLocation().getCity());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(
						business.getLocation().getState_code() == null ? "" : business.getLocation().getState_code());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(
						business.getLocation().getPostal_code() == null ? "" : business.getLocation().getPostal_code());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(business.getPhone() == null ? "" : business.getPhone());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(business.getUrl() == null ? "" : business.getUrl());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(business.getRating());
				bw.write(oneLine.toString());
				bw.newLine();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
