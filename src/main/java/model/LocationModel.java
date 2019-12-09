package model;

import java.awt.event.ActionEvent;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LocationModel {

	private ObjectProperty<javafx.scene.image.Image> imvFlag = new SimpleObjectProperty<javafx.scene.image.Image>();	
	private StringProperty txtIpActual = new SimpleStringProperty();
	private StringProperty lblLatitude = new SimpleStringProperty();
	private StringProperty lblLongitude = new SimpleStringProperty();
	private StringProperty lblLocation = new SimpleStringProperty();
	private StringProperty lblCity = new SimpleStringProperty();
	private StringProperty lblZipCode = new SimpleStringProperty();
	private StringProperty lblTimeZone = new SimpleStringProperty();
	private StringProperty lblCurrency = new SimpleStringProperty();
	private StringProperty lblCallingCode = new SimpleStringProperty();
	private StringProperty blLanguage = new SimpleStringProperty();
	
	
	
	
	public final ObjectProperty<javafx.scene.image.Image> imvFlagProperty() {
		return this.imvFlag;
	}
	
	public final Image getImvFlag() {
		return this.imvFlagProperty().get();
	}
	
	public final void setImvFlag(final Image imvFlag) {
		this.imvFlagProperty().set(imvFlag);
	}
	
	public final StringProperty txtIpActualProperty() {
		return this.txtIpActual;
	}
	
	public final String getTxtIpActual() {
		return this.txtIpActualProperty().get();
	}
	
	public final void setTxtIpActual(final String txtIpActual) {
		this.txtIpActualProperty().set(txtIpActual);
	}
	
	public final StringProperty lblLatitudeProperty() {
		return this.lblLatitude;
	}
	
	public final String getLblLatitude() {
		return this.lblLatitudeProperty().get();
	}
	
	public final void setLblLatitude(final String lblLatitude) {
		this.lblLatitudeProperty().set(lblLatitude);
	}
	
	public final StringProperty lblLongitudeProperty() {
		return this.lblLongitude;
	}
	
	public final String getLblLongitude() {
		return this.lblLongitudeProperty().get();
	}
	
	public final void setLblLongitude(final String lblLongitude) {
		this.lblLongitudeProperty().set(lblLongitude);
	}
	
	public final StringProperty lblLocationProperty() {
		return this.lblLocation;
	}
	
	public final String getLblLocation() {
		return this.lblLocationProperty().get();
	}
	
	public final void setLblLocation(final String lblLocation) {
		this.lblLocationProperty().set(lblLocation);
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
	
	public final StringProperty lblZipCodeProperty() {
		return this.lblZipCode;
	}
	
	public final String getLblZipCode() {
		return this.lblZipCodeProperty().get();
	}
	
	public final void setLblZipCode(final String lblZipCode) {
		this.lblZipCodeProperty().set(lblZipCode);
	}
	
	public final StringProperty lblTimeZoneProperty() {
		return this.lblTimeZone;
	}
	
	public final String getLblTimeZone() {
		return this.lblTimeZoneProperty().get();
	}
	
	public final void setLblTimeZone(final String lblTimeZone) {
		this.lblTimeZoneProperty().set(lblTimeZone);
	}
	
	public final StringProperty lblCurrencyProperty() {
		return this.lblCurrency;
	}
	
	public final String getLblCurrency() {
		return this.lblCurrencyProperty().get();
	}
	
	public final void setLblCurrency(final String lblCurrency) {
		this.lblCurrencyProperty().set(lblCurrency);
	}
	
	public final StringProperty lblCallingCodeProperty() {
		return this.lblCallingCode;
	}
	
	public final String getLblCallingCode() {
		return this.lblCallingCodeProperty().get();
	}
	
	public final void setLblCallingCode(final String lblCallingCode) {
		this.lblCallingCodeProperty().set(lblCallingCode);
	}
	
	public final StringProperty blLanguageProperty() {
		return this.blLanguage;
	}
	
	public final String getBlLanguage() {
		return this.blLanguageProperty().get();
	}
	
	public final void setBlLanguage(final String blLanguage) {
		this.blLanguageProperty().set(blLanguage);
	}

		

	
	
}
