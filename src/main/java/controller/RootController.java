package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.dialog.ProgressDialog;

import client.classes.location.Language;
import client.utils.Service;
import javafx.beans.Observable;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TabPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import model.RootModel;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;

public class RootController implements Initializable {
	@FXML
	private TabPane root;
	@FXML
	private Tab locationTab;
	@FXML
	private Tab connectionTab;
	@FXML
	private Tab securityTab;
	
	//Subcontrollers
	private ConnectionController subcontrollerConnection; 
	private LocationController subcontrollerLocation; 
	private SecurityController subcontrollerSecurity; 
	
	//Others
	
	private RootModel model = new RootModel();
	
	private Service service = new Service();
	private String ip;
	
	//Tarea asincrona	
	private Task<Void> tarea;
	
	private ArrayList<String> dataFromServices = new ArrayList<String>(); 
	
	public RootController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
		try {			
			
			subcontrollerConnection = new ConnectionController();			
			subcontrollerLocation = new LocationController();
			subcontrollerSecurity = new SecurityController();
			
		} catch (Exception e) {
			System.out.println("Error al cargar las vistas");
		}
		
		//Obtener los views
		VBox viewConnection =  subcontrollerConnection.getView();
		viewConnection.setAlignment(Pos.CENTER);
		VBox viewLocation = subcontrollerLocation.getView();
		viewLocation.setAlignment(Pos.CENTER);
		VBox viewSecurity = subcontrollerSecurity.getView();
		viewSecurity.setAlignment(Pos.CENTER);
		
		//Agregar a los tabs
		connectionTab.setContent(viewConnection);
		locationTab.setContent(viewLocation);
		securityTab.setContent(viewSecurity);	
		
		//Inyeccion de rootController en subcontrollers
		subcontrollerConnection.injectRootController(this);
		subcontrollerLocation.injectRootController(this);
		
		//Bindeos de los textfield de ip
		
		model.ipProperty().bindBidirectional(subcontrollerConnection.getModel().txtIpActualProperty());
		model.ipProperty().bindBidirectional(subcontrollerLocation.getModel().txtIpActualProperty());
		model.ipProperty().bindBidirectional(subcontrollerSecurity.getModel().txtIpActualProperty());
		
		//Listeners de los botones de los subcontroladores
		
		subcontrollerLocation.getBtnCheckIp().setOnAction(e -> onButtonPressed(e));
		subcontrollerConnection.getBtnCheckIp().setOnAction(e -> onButtonPressed(e));
		subcontrollerSecurity.getBtnCheckIp().setOnAction(e -> onButtonPressed(e));
		
		progressDialog(tarea);
		
	}
	

	public void onButtonPressed(Object e) {

		ip = model.getIp();
		
		progressDialog(tarea);
		
	}
	

	/**
	 * Obtiene de los servicios los elementos requeridos
	 * y la carga en un arrayList, en caso de excepción 
	 * lanzará un alert
	 */
	
	public ArrayList<String> getServices() {
		
		ArrayList<String> data = new ArrayList<String>();
	
		try {
			
			if(ip==null) {
				 ip = service.getIPIFY(); //From IPYFY
			}
			
			//Location			
			String cc = service.getIPAPI(ip).getCountryCode().toLowerCase(); //Variabe para el country code	
			String latitude = String.format("%.3f", service.getIPAPI(ip).getLatitude());
			String longitude = String.format("%.3f", service.getIPAPI(ip).getLongitude());
			String location = service.getIPAPI(ip).getCountryName().concat(" (").concat(service.getIPAPI(ip).getCountryCode().concat(")"));
			String urlFlag = "https://www.countryflags.io/"+ cc +"/flat/64.png";
			String city = service.getIPAPI(ip).getCity().concat(" (").concat(service.getIPAPI(ip).getRegionName().concat(")"));
			
			Language[] l = service.getIPAPI(ip).getLocation().getLanguages();
			String languaje = l[0].getName().concat(" (").concat(service.getIPAPI(ip).getCountryCode().concat(")"));
			String callingCode = service.getIPAPI(ip).getLocation().getCallingCode();
			String zipCode = service.getIPAPI(ip).getZip();
			String timeZone = service.getIPAPI(ip).getZip();
			String currency = service.getPosition(ip).getCurrency();
			
			//Connection
									
			String ipAddress = service.getIPAPI(ip).getIp();
			String ipLocation = deleteFirstWord(service.getPosition(ip).getAs()); //Se usa el metodo que elimina la primera palabra 
			String ipType = checkIPtype(ip);  //Se usa el metodo que distingue por tipos de ip	
			String hostNname = service.getPosition(ip).getReverse();
			String asn = service.getPosition(ip).getAs().replaceAll("\\D+",""); //Se extrae solo los digitos metiante un regex
			
			
			
			data.add(0, ip);
			data.add(1, cc);
			data.add(2, latitude);
			data.add(3, longitude);
			data.add(4, location);
			data.add(5, urlFlag);
			data.add(6, city);
			data.add(7, languaje);
			data.add(8, callingCode);
			data.add(9, zipCode);
			data.add(10, timeZone);
			data.add(11, currency);
			
			data.add(12, ipAddress);
			data.add(13, ipLocation);
			data.add(14, ipType);
			data.add(15, hostNname);
			data.add(16, asn);
			
			
			return data;
			
						
			
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("GeoFX");
			alert.setHeaderText("Atención");
			alert.setContentText("Comprueba que la IP sea valida, \n"
					+ "y que este conectado a la red");
			alert.showAndWait();
			
		} 
		
		return null;
		
	}
	
	/**
	 * Metodo que ejecuta una tarea. La tarea puede 
	 * ser recogida por un ProgressDialog
	 * @return
	 */	

	public Task executeTask() {
		 
	        Task task =  new Task() {
	            @Override
	            protected Object call() throws Exception {
	       
				for (int i = 0; i < 100; i++) {
					
					if(i==60) { //Cuando la barra se encuentra al 60% busca los servicios asi parece más guay
						dataFromServices = getServices();
					}
					
					Thread.sleep(20);
					updateMessage("Geolocalizando");
					updateProgress(i + 1, 100);
				}
				return true;
			}
		};
		
		task.setOnSucceeded(e -> {

			sendServicesToSubControllers(dataFromServices);

		});
	       
	        
	        return task; 
	    }
	
	
	
	/**
	 * ProgressDialog para ejecutar una tarea
	 * Recibe compo parametro una tarea, se ha de usar
	 * el método ejecutar tarea 
	 * @param tarea
	 */
	
	
	private void progressDialog(Task tarea){
		
		//Inicicar la tarea a realizar 
	   tarea = executeTask();
			
		
	    ProgressDialog dialog = new ProgressDialog(tarea);	    
	    dialog.setGraphic(null);  	   
	    //dialog.setContentText("GeoLocalizando");
	    dialog.setTitle("Obteniendo localización");	    
	    dialog.setHeaderText(null);
	    dialog.setGraphic(null);
	    dialog.initStyle(StageStyle.UTILITY);
	    new Thread(tarea).start();        
	    dialog.showAndWait();
	        
	   
	}
	
	/**
	 * Permite eliminar la primera palabra de un String
	 * @param originalString
	 * @return
	 */
	
	public String deleteFirstWord(String originalString) {
		String removedWord; 
		removedWord = originalString.substring(0,originalString.indexOf(' '));
		String newString = originalString.substring(originalString.indexOf(' ')+1);
		return newString;
	}
	
	/**
	 * Comprueba si una IP es ipv4 o ipv6
	 * si contiene : es ipv6
	 * @param ip
	 * @return
	 */
	
	public String checkIPtype(String ip) {
		
		if(ip.contains(":")) {
			return "IPv4";
		}else {
			return "IPv6";
		}		
		
	}
	
	/**
	 * Envia a los subcontrolladores un ArrayList con los
	 * datos obtenidos de las APIS
	 * @param data
	 */
	
	public void sendServicesToSubControllers(ArrayList<String> data) {
		
		subcontrollerLocation.setServices(data);
		subcontrollerConnection.setServices(data);
		
	}
		
	
	public ConnectionController getSubcontrollerConnection() {
		return subcontrollerConnection;
	}


	public LocationController getSubcontrollerLocation() {
		return subcontrollerLocation;
	}

	public SecurityController getSubcontrollerSecurity() {
		return subcontrollerSecurity;
	}

	
	public TabPane getRoot() {
		return root;
	}

}
