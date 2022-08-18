package entities;

import java.util.Date;

public class HourContract {
	public Double valuesHour;
	public Integer hour;
	public Date date;
	
	public HourContract() {

	}
	
	public HourContract(Double valuesHour, Integer hour, Date date) {
		this.valuesHour = valuesHour;
		this.hour = hour;
		this.date = date;
	}

	public Double getValuesHour() {
		return valuesHour;
	}

	public void setValuesHour(Double valuesHour) {
		this.valuesHour = valuesHour;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public double totalValue() {
		return valuesHour * hour;
	}
	
	
}
