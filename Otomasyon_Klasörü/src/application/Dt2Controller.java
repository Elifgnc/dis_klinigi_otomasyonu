package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.IsteMYSQL.Util.VeritabaniUtil;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Dt2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_kaydet;

    @FXML
    private Button btn_randevu;

    @FXML
    private Button btn_temizle;

    @FXML
    private ComboBox<String> cmb_islem;
    
    @FXML
    private AnchorPane dt2Pane;
    
    @FXML
    private Label lbl_sonuc;

    @FXML
    private TextField txt_tc;

    @FXML
    void btn_cikis_Click(ActionEvent event) {
    	System.exit(0);
    }
    
    VeritabaniUtil database=new VeritabaniUtil();
    Connection baglanti;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen;
    String sql;

    @FXML
    void btn_kaydet_Click(ActionEvent event) {
    sql="insert into dt2(hasta_TC,islem) values (?,?)";
    	
    	try {
            
    		sorguIfadesi=database.Baglan().prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_tc.getText().trim());
    		sorguIfadesi.setString(2,cmb_islem.getSelectionModel().getSelectedItem());
    		
    	
    		sorguIfadesi.execute();
    		lbl_sonuc.setText("Kayıt ekleme işlemi başarılı ");
    		
    		  database.Kapat();
    		  sorguIfadesi.close();
    		 
    		  Alert alert = new Alert(AlertType.ERROR);
    		  alert.setTitle("GNC DİŞ KLİNİĞİ");
    		  alert.setHeaderText("Uyarı mesajı");
    		  alert.setContentText("Kayıt ekleme işlemi");
    		  alert.showAndWait();
        } 
    	  catch(Exception e) {
    		 lbl_sonuc.setText(e.getMessage().toString());
    }
      
    }
    
    
    public void stage(String stageName) {
  		try {
  			Stage stage1= new Stage();
  			AnchorPane pane1 =(AnchorPane)FXMLLoader.load(getClass().getResource(stageName));
  			Scene scene = new Scene(pane1);
  			stage1.setScene(scene);
  			stage1.show();
  			Stage stage2=(Stage) dt2Pane.getScene().getWindow();
  			stage2.close();
  		}
  		catch(Exception e) {
  			e.printStackTrace();
  		}
  	}


    @FXML
    void btn_randevu_Click(ActionEvent event) {
    	stage("asistan.fxml"); 
    }

    @FXML
    void btn_temizle_Click(ActionEvent event) {
    	txt_tc.clear();
    }
   ObservableList<String> liste;   
   @FXML
    void initialize() {
    	Tooltip tip1 = new Tooltip();
        tip1.setStyle("-fx-background-color:gray;");
        tip1.setText("Ekleme işlemi yapar.");
        btn_kaydet.setTooltip(tip1);

        
        Tooltip tip2 = new Tooltip();
        tip2.setStyle("-fx-background-color:gray;");
        tip2.setText("Yeni Randevu Oluşturur.");
        btn_randevu.setTooltip(tip2);
        
        Tooltip tip3 = new Tooltip();
        tip3.setStyle("-fx-background-color:gray;");
        tip3.setText("Çıkış işlemi yapar.");
        btn_cikis.setTooltip(tip3);
        
        
        Tooltip tip4 = new Tooltip();
        tip4.setStyle("-fx-background-color:gray;");
        tip4.setText("Araçları temizleme işlemi yapar.");
        btn_temizle.setTooltip(tip4);
        
        liste=FXCollections.observableArrayList("Diş Teli (Başlangıç)","Diş Teli (Yenileme)","Diş Teli (Çıkarma)","Diş Çekimi");
        cmb_islem.getItems().addAll(liste);
        
       
    }

}
