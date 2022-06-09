package sen3004.app4.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class SampleObject {

	@NotNull(message = "Enter value.")
	@Size(min = 3, max = 50)
	private String name;
	@NotNull
	@Positive(message = "Price must be positive.")
	private Double price;
	@NotNull
	@Positive(message = "Price must be positive.")
	private int quantity;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;
	@NotEmpty
	private List<String> checkboxSelection;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the checkboxSelection
	 */
	public List<String> getCheckboxSelection() {
		return checkboxSelection;
	}
	/**
	 * @param checkboxSelection the checkboxSelection to set
	 */
	public void setCheckboxSelection(List<String> checkboxSelection) {
		this.checkboxSelection = checkboxSelection;
	}


	

}
