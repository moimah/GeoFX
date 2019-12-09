package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ConnectionModel {

	private StringProperty txtIpActual  = new SimpleStringProperty();
	private StringProperty lblIpAdress = new SimpleStringProperty();
	private StringProperty lblIpLocation = new SimpleStringProperty();
	private StringProperty lblCity = new SimpleStringProperty();
	private StringProperty lblHostName = new SimpleStringProperty();
	private StringProperty lblAsn = new SimpleStringProperty();

	public final StringProperty txtIpActualProperty() {
		return this.txtIpActual;
	}
	

	public final String getTxtIpActual() {
		return this.txtIpActualProperty().get();
	}
	

	public final void setTxtIpActual(final String txtIpActual) {
		this.txtIpActualProperty().set(txtIpActual);
	}	
	
	
	public final StringProperty lblIpAdressProperty() {
		return this.lblIpAdress;
	}
	
	public final String getLblIpAdress() {
		return this.lblIpAdressProperty().get();
	}
	
	public final void setLblIpAdress(final String lblIpAdress) {
		this.lblIpAdressProperty().set(lblIpAdress);
	}
	
	public final StringProperty lblIpLocationProperty() {
		return this.lblIpLocation;
	}
	
	public final String getLblIpLocation() {
		return this.lblIpLocationProperty().get();
	}
	
	public final void setLblIpLocation(final String lblIpLocation) {
		this.lblIpLocationProperty().set(lblIpLocation);
	}
	
	public final StringProperty lblCityProperty() {
		return this.lblCity;
	}
	
	public final String getLblCity() {
		return this.lblCityProperty().get();
	}
	
	public final void setLblCity(final String lblCity) {
		this.lblCityProperty().set(lblCity);
	}
	
	public final StringProperty lblHostNameProperty() {
		return this.lblHostName;
	}
	
	public final String getLblHostName() {
		return this.lblHostNameProperty().get();
	}
	
	public final void setLblHostName(final String lblHostName) {
		this.lblHostNameProperty().set(lblHostName);
	}


	public final StringProperty lblAsnProperty() {
		return this.lblAsn;
	}
	


	public final String getLblAsn() {
		return this.lblAsnProperty().get();
	}
	


	public final void setLblAsn(final String lblAsn) {
		this.lblAsnProperty().set(lblAsn);
	}
	
	
	
}
