package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;


public class SecurityModel {	
	
	private StringProperty txtIpActual = new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> imgSafe = new SimpleObjectProperty<javafx.scene.image.Image>();
	private StringProperty lblLocation1 = new SimpleStringProperty();
	private BooleanProperty chkProxy = new SimpleBooleanProperty();
	private StringProperty lblPotencialThreat = new SimpleStringProperty();
	private BooleanProperty chkCrawler = new SimpleBooleanProperty();
	private BooleanProperty chkTor = new SimpleBooleanProperty();	
	private StringProperty lblThreatLevel = new SimpleStringProperty();
	public final StringProperty txtIpActualProperty() {
		return this.txtIpActual;
	}
	
	public final String getTxtIpActual() {
		return this.txtIpActualProperty().get();
	}
	
	public final void setTxtIpActual(final String txtIpActual) {
		this.txtIpActualProperty().set(txtIpActual);
	}
	
	public final ObjectProperty<javafx.scene.image.Image> imgSafeProperty() {
		return this.imgSafe;
	}
	
	public final Image getImgSafe() {
		return this.imgSafeProperty().get();
	}
	
	public final void setImgSafe(final Image imgSafe) {
		this.imgSafeProperty().set(imgSafe);
	}
	
	public final StringProperty lblLocation1Property() {
		return this.lblLocation1;
	}
	
	public final String getLblLocation1() {
		return this.lblLocation1Property().get();
	}
	
	public final void setLblLocation1(final String lblLocation1) {
		this.lblLocation1Property().set(lblLocation1);
	}
	
	public final BooleanProperty chkProxyProperty() {
		return this.chkProxy;
	}
	
	public final boolean isChkProxy() {
		return this.chkProxyProperty().get();
	}
	
	public final void setChkProxy(final boolean chkProxy) {
		this.chkProxyProperty().set(chkProxy);
	}
	
	public final StringProperty lblPotencialThreatProperty() {
		return this.lblPotencialThreat;
	}
	
	public final String getLblPotencialThreat() {
		return this.lblPotencialThreatProperty().get();
	}
	
	public final void setLblPotencialThreat(final String lblPotencialThreat) {
		this.lblPotencialThreatProperty().set(lblPotencialThreat);
	}
	
	public final BooleanProperty chkCrawlerProperty() {
		return this.chkCrawler;
	}
	
	public final boolean isChkCrawler() {
		return this.chkCrawlerProperty().get();
	}
	
	public final void setChkCrawler(final boolean chkCrawler) {
		this.chkCrawlerProperty().set(chkCrawler);
	}
	
	public final BooleanProperty chkTorProperty() {
		return this.chkTor;
	}
	
	public final boolean isChkTor() {
		return this.chkTorProperty().get();
	}
	
	public final void setChkTor(final boolean chkTor) {
		this.chkTorProperty().set(chkTor);
	}
	
	public final StringProperty lblThreatLevelProperty() {
		return this.lblThreatLevel;
	}
	
	public final String getLblThreatLevel() {
		return this.lblThreatLevelProperty().get();
	}
	
	public final void setLblThreatLevel(final String lblThreatLevel) {
		this.lblThreatLevelProperty().set(lblThreatLevel);
	}
	
	

}
