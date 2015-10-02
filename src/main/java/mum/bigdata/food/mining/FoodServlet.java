package mum.bigdata.food.mining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
		String res = yelpApi.searchForBusinessesByLocation("food", "Fairfield, IA");
		out.println(res);
	}
}
