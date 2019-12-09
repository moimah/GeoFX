package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import client.utils.Service;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import model.ConnectionModel;

public class ConnectionController implements Initializable {
	@FXML
	private VBox root;
	@FXML
	private ImageView imvWifi;
	@FXML
	private TextField txtIpActual;
	@FXML
	private Button btnCheckIp;
	@FXML
	private Label lblIpAdress;
	@FXML
	private ImageView imvWorld;
	@FXML
	private Label lblIpLocation;
	@FXML
	private Label lblCity; //TODO CHANGE NAME
	@FXML
	private Label lblAsn;
	@FXML
	private Label lblHostName;
	
	//Others
	private ConnectionModel model = new ConnectionModel();
	private RootController rootController; 
	private Service service = new Service();
	
	//Constructor
	public ConnectionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConnectionView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	
	//Inyectors	
	public void injectRootController(RootController rootController) {
		this.rootController = rootController;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Bindeos
		model.txtIpActualProperty().bindBidirectional(txtIpActual.textProperty());
		model.lblCityProperty().bindBidirectional(lblCity.textProperty());
		model.lblHostNameProperty().bindBidirectional(lblHostName.textProperty());
		model.lblIpAdressProperty().bindBidirectional(lblIpAdress.textProperty());;
		model.lblIpLocationProperty().bindBidirectional(lblIpLocation.textProperty());
		model.lblAsnProperty().bindBidirectional(lblAsn.textProperty());
		
	}

	// Event Listener on Button[#btnCheckIp].onAction
	@FXML
	public void onClickBtnCheckIp(ActionEvent event) {
	
	}
			
	
	public void setServices(ArrayList<String> data) {		
				
		model.setLblIpAdress(data.get(12));		
		model.setLblIpLocation(data.get(12)); 
		model.setLblCity(data.get(14)); 	
		model.setLblHostName(data.get(15));
		model.setLblAsn(data.get(16));	
		
		
	}
	
	
	
	
	public ConnectionModel getModel() {
		return model;
	}
	
	


	public Button getBtnCheckIp() {
		return btnCheckIp;
	}

	public VBox getView() {
		return root;
	}


		

	
}
