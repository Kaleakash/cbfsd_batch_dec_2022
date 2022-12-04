package cbfsd.com.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shipments {
	@Id
	@Column(name="shipmentid")
	private int shipmentId;
	@Column(name="orderid")
	private int orderId;
	@Column(name="shipmentstatus")
	private int shipmentStatus;
	@Column(name="shipmenttitle")
	private String shipmentTitle;
	@Column(name="shipmentdate")
	private LocalDate shipmentDate;
	@Column(name="expecteddeliverydate")
	private LocalDate expectedDeliveryDate;
	@Column(name="shipmentmethod")
	private String shipmentMethod;
	@Column(name="shipmentcompany")
	private String shipmentCompany;
	public Shipments(int shipmentId, int orderId, int shipmentStatus, String shipmentTitle, LocalDate shipmentDate,
			LocalDate expectedDeliveryDate, String shipmentMethod, String shipmentCompany) {
		super();
		this.shipmentId = shipmentId;
		this.orderId = orderId;
		this.shipmentStatus = shipmentStatus;
		this.shipmentTitle = shipmentTitle;
		this.shipmentDate = shipmentDate;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.shipmentMethod = shipmentMethod;
		this.shipmentCompany = shipmentCompany;
	}
	public Shipments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getShipmentStatus() {
		return shipmentStatus;
	}
	public void setShipmentStatus(int shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	public String getShipmentTitle() {
		return shipmentTitle;
	}
	public void setShipmentTitle(String shipmentTitle) {
		this.shipmentTitle = shipmentTitle;
	}
	public LocalDate getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}
	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public String getShipmentMethod() {
		return shipmentMethod;
	}
	public void setShipmentMethod(String shipmentMethod) {
		this.shipmentMethod = shipmentMethod;
	}
	public String getShipmentCompany() {
		return shipmentCompany;
	}
	public void setShipmentCompany(String shipmentCompany) {
		this.shipmentCompany = shipmentCompany;
	}
	
}
