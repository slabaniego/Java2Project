import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.*;
import javafx.stage.Stage;

public class SellCarController extends CarsData{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected Button btnNextPage;

    @FXML
    protected RadioButton sedan;

    @FXML
    protected RadioButton hatchback;

    @FXML
    protected RadioButton truck;

    @FXML
    protected RadioButton SUV;

    @FXML
    protected TextField txtCarKM;

    @FXML
    protected TextField txtCarMake;

    @FXML
    protected TextField txtCarModel;

    @FXML
    protected TextField txtCarPrice;

    @FXML
    protected TextField txtCarVin;

    @FXML
    protected TextField txtCarYear;

    @FXML
    private ToggleGroup bodyType;

    @FXML
    void btnNextPage(ActionEvent event) throws IOException { 
        double carKM = Double.parseDouble(txtCarKM.getText());
        String carMake = txtCarMake.getText();
        String carModel = txtCarModel.getText();
        double carPrice = Double.parseDouble(txtCarPrice.getText());
        String carVin = txtCarVin.getText();
        int carYear = Integer.parseInt(txtCarYear.getText());
        if(sedan.isSelected()){

            // Initializes some of the fields so that it is passed to the next page
            Sedan sedan = new Sedan(carMake, carVin, carModel, carPrice, carYear, carKM, false, false, 4, false, "");
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SedanAddView.fxml"));
            SedanAddController sac = new SedanAddController();
            sac.setSedan(sedan);
            loader.setController(sac);
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if(hatchback.isSelected()){

            Hatchback hatch = new Hatchback(carMake, carVin, carModel, carPrice, carYear, carKM, false, false, 4, false, "");
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HatchbackAddView.fxml"));
            HatchbackAddController hac = new HatchbackAddController();
            hac.setHatch(hatch);
            loader.setController(hac);
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if(truck.isSelected()) {

            Truck truck = new Truck(carMake, carVin, carModel, carPrice, carYear, carKM, false, "", "", false);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TruckAddView.fxml"));
            TruckAddController tac = new TruckAddController();
            tac.setTruck(truck);
            loader.setController(tac);
            root = loader.load();
            
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if(SUV.isSelected()) {
            
            SUV suv = new SUV(carMake, carVin, carModel, carPrice, carYear, carKM, false, "", "");
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SUVAddView.fxml"));
            SUVAddController suvac = new SUVAddController();
            suvac.setSUV(suv);
            loader.setController(suvac);
            root = loader.load();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
  
}
