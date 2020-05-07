package br.com.southsystem.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.southsystem.utils.Log;

/**
 * Order Entity
 * 
 * @author marcioferoli <marcioferoli@gmail.com>
 * @version 1.0
 * @since 2020-05-07
 */
public class Order {

	public static final int TYPE = 3;

	private static final String ITEM_SEPARATOR = ",";
	private static final String DETAIL_SEPARATOR = "-";

	private String saleID = null;
	private BigDecimal totalPrice = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private String salesmanName = null;

	/**
	 * Constructor
	 */
	public Order(String[] line) {
		super();
		this.saleID = line[1];

		String[] items = line[2].replace("[", "").replace("]", "").split(ITEM_SEPARATOR);
		for (String item : items) {
			String[] details = item.split(DETAIL_SEPARATOR);
			BigDecimal itemQuantity = new BigDecimal(details[1]);
			BigDecimal itemPrice = new BigDecimal(details[2]);
			Log.info(String.format("OrderItem [%s][%s][%s]", details[0], itemQuantity, itemPrice));
			this.totalPrice = this.totalPrice.add(itemPrice.multiply(itemQuantity)).setScale(2, RoundingMode.HALF_UP);
		}

		this.salesmanName = line[3];

		Log.info(String.format("Order [%s][%s][%s]", saleID, totalPrice, salesmanName));
	}

	public String getSaleID() {
		return saleID;
	}

	public void setSaleID(String saleID) {
		this.saleID = saleID;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}
