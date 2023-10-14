package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.IsteMYSQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class sifreController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_kaydet;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private AnchorPane sifrePane;

    @FXML
    private TextField txt_kul;

    @FXML
    private PasswordField txt_pass;

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

    	 sql="UPDATE login SET sifre=? WHERE kul_adi=?";
    	   	
    	  try {
    	            
    	    		sorguIfadesi=database.Baglan().prepareStatement(sql);
    	    		sorguIfadesi.setString(2,txt_kul.getText().trim());
    	    		sorguIfadesi.setString(1, VeritabaniUtil.MD5Sifrele(txt_pass.getText().trim()));
    	    		
    	    		sorguIfadesi.execute();
    	    		lbl_sonuc.setText("Şifre güncelleme işlemi başarılı ");
    	    		
    	    		  database.Kapat();
    	    		  sorguIfadesi.close();
    	    		  
    	    		  Alert alert = new Alert(AlertType.ERROR);
    	    		  alert.setTitle("GNC DİŞ KLİNİĞİ");
    	    		  alert.setHeaderText("Uyarı mesajı");
    	    		  alert.setContentText("Şifre Güncelleme işlemi ");
    	    		  alert.showAndWait();
    	    		  	 
    	        } 
    	    	  catch(Exception e) {
    	    		 lbl_sonuc.setText(e.getMessage().toString());}
    	
    }

    @FXML
    void initialize() {
       
    	Tooltip tip1 = new Tooltip();
        tip1.setStyle("-fx-background-color:gray;");
        tip1.setText("Şifre güncelleme işlemi yapar.");
        btn_kaydet.setTooltip(tip1);
        
        
        Tooltip tip2 = new Tooltip();
        tip2.setStyle("-fx-background-color:gray;");
        tip2.setText("Çıkış işlemi yapar.");
        btn_cikis.setTooltip(tip2);
    }

}
