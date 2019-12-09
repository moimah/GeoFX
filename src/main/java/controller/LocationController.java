package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import client.utils.GeoFXserviceException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.LocationModel;



public class LocationController implements Initializable {
	@FXML
	private VBox root;
	@FXML
	private TextField txtIpActual;
	@FXML
	private Button btnCheckIp;
	@FXML
	private Label lblLatitude;
	@FXML
	private Label lblLongitude;
	@FXML
	private Label lblLocation;
	@FXML
	private ImageView imvFlag;
	@FXML
	private ImageView imvWifi;	
	@FXML
	private Label lblCity;
	@FXML
	private Label lblZipCode;
	@FXML
	private Label lblTimeZone;
	@FXML
	private Label lblCurrency;
	@FXML
	private Label lblCallingCode;
	@FXML
	private Label lblLanguage;	
	
	//Others
	private RootController rootController;
	private LocationModel model = new LocationModel();
	
	
	//Constructor
	
	public LocationController() throws IOException {		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LocationView.fxml"));
		loader.setController(this);
		loader.load();
			
		
	}
	
	//Injectors
	public void injectRootController(RootController rootController) {
		this.rootController = rootController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		model.imvFlagProperty().bindBidirectional(imvFlag.imageProperty()); //Bindeo de image
		model.txtIpActualProperty().bindBidirectional(txtIpActual.textProperty());
		model.blLanguageProperty().bindBidirectional(lblLanguage.textProperty());
		model.lblCallingCodeProperty().bindBidirectional(lblCallingCode.textProperty());
		model.lblCityProperty().bindBidirectional(lblCity.textProperty());
		model.lblCurrencyProperty().bindBidirectional(lblCurrency.textProperty());
		model.lblLatitudeProperty().bindBidirectional(lblLatitude.textProperty());
		model.lblLocationProperty().bindBidirectional(lblLocation.textProperty());
		model.lblLongitudeProperty().bindBidirectional(lblLongitude.textProperty());
		model.lblTimeZoneProperty().bindBidirectional(lblTimeZone.textProperty());
		model.lblZipCodeProperty().bindBidirectional(lblZipCode.textProperty());
		
		
		
		
						
	}

	// Event Listener on Button[#btnCheckIp].onAction
	@FXML
	public void onClickBtnCheckIp(ActionEvent event) throws GeoFXserviceException {	
			
		
	}
	
		
	

	public void setServices(ArrayList<String> data) {		
	
		model.setTxtIpActual(data.get(0));			
		model.setLblLatitude(data.get(2)); //From IPAPI
		model.setLblLongitude(data.get(3)); //From IPAPI
		model.setLblLocation(data.get(4)); //From IPAPI		
		model.setImvFlag(new Image(data.get(5))); //Añadimos el countrycode al url para obtener la bandera
		model.setLblCity(data.get(6)); //From IPAPI
		model.setBlLanguage(data.get(7));
		model.setLblCallingCode(data.get(8)); //From IPAPI
		model.setLblZipCode(data.get(9));	//From IPAPI		
		model.setLblTimeZone(data.get(10)); //From TimeZoneAPI
		model.setLblCurrency(data.get(11));
		
		
	}
	


	public LocationModel getModel() {
		return model;
	}
	
	
	
	
	

	public Button getBtnCheckIp() {
		return btnCheckIp;
	}

	public VBox getView() {
		return root;
	}
	
	

	
 
	
}





