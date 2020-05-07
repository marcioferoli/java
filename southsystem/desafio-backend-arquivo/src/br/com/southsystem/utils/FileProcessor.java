package br.com.southsystem.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import br.com.southsystem.entity.Customer;
import br.com.southsystem.entity.Order;
import br.com.southsystem.entity.Salesman;

/**
 * Valid Files Processor
 * 
 * @author marcioferoli <marcioferoli@gmail.com>
 * @version 1.0
 * @since 2020-05-07
 */
public class FileProcessor {

	private static final String LINE_SEPARATOR = "ç";

	private boolean isAValidFile = false;
	private int linesWithErrors = 0;

	private Map<String, Salesman> salesmanMap = new HashMap<>();
	private Map<String, Customer> customerMap = new HashMap<>();
	private Map<String, Order> orderMap = new HashMap<>();

	/**
	 * Constructor
	 */
	public FileProcessor(File fileToProcess) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileToProcess.getPath()))) {

			int lineNumber = 1;
			String line;
			while ((line = br.readLine()) != null) {
				Log.info(String.format("Reading line [%s][%s]", lineNumber, line));
				readLine(line);
				lineNumber++;
			}
			if (linesWithErrors == 0) {
				isAValidFile = true;
			}

		} catch (FileNotFoundException e) {
			Log.severe(e);
		} catch (IOException e) {
			Log.severe(e);
		}
	}

	private void readLine(String line) {
		if ((line == null) || line.length() == 0) {
			return;
		}
		String[] columns = line.split(LINE_SEPARATOR);

		try {
			int type = Integer.parseInt(columns[0]);
			switch (type) {
			case 1:
				salesmanMap.put(columns[1], new Salesman(columns));
				break;
			case 2:
				customerMap.put(columns[1], new Customer(columns));
				break;
			case 3:
				orderMap.put(columns[1], new Order(columns));
				break;
			default:
				throw new Exception("Type not found");
			}
		} catch (Exception e) {
			linesWithErrors++;
			Log.severe(e);
		}
	}

	public StringBuffer getSummary() {
		StringBuffer summary = new StringBuffer();

		int totalCustomers = customerMap.size();
		int totalSalesman = salesmanMap.size();

		String worstSellerName = null;
		BigDecimal worstSellerTotal = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

		String mostExpensiveSaleID = null;
		BigDecimal mostExpensiveSale = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

		Map<String, BigDecimal> sellerMap = new HashMap<>();
		for (String currentSaleID : orderMap.keySet()) {
			Order order = orderMap.get(currentSaleID);

			// Searching for the most expensive saleID ...
			if (mostExpensiveSaleID == null) {
				mostExpensiveSaleID = currentSaleID;
				mostExpensiveSale = order.getTotalPrice();
			} else if (mostExpensiveSale.compareTo(order.getTotalPrice()) < 0) {
				mostExpensiveSaleID = currentSaleID;
				mostExpensiveSale = order.getTotalPrice();
			}

			BigDecimal totalSeller = sellerMap.get(order.getSalesmanName());
			if (totalSeller == null) {
				sellerMap.put(order.getSalesmanName(), order.getTotalPrice());
			} else {
				sellerMap.put(order.getSalesmanName(),
						totalSeller.add(order.getTotalPrice()).setScale(2, RoundingMode.HALF_UP));
			}
		}

		// Searching for the worst seller ...
		for (String currentSellerID : sellerMap.keySet()) {
			BigDecimal currentSellerTotal = sellerMap.get(currentSellerID);
			if (worstSellerName == null) {
				worstSellerName = currentSellerID;
				worstSellerTotal = currentSellerTotal;
			} else if (worstSellerTotal.compareTo(currentSellerTotal) > 0) {
				worstSellerName = currentSellerID;
				worstSellerTotal = currentSellerTotal;
			}
		}

		summary.append(String.format("Total of Customers [%s]\n", totalCustomers));
		summary.append(String.format("Total of Salesman [%s]\n", totalSalesman));
		summary.append(String.format("The most expensive SaleID [%s][%s]\n", mostExpensiveSaleID, mostExpensiveSale));
		summary.append(String.format("The worst seller [%s][%s]\n", worstSellerName, worstSellerTotal));

		return summary;
	}

	public boolean isAValidFile() {
		return isAValidFile;
	}

	public int getLinesWithErrors() {
		return linesWithErrors;
	}

}
