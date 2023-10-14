package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.IsteMYSQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import java.sql.*;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
 

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_bilgi;

    @FXML
    private Button btn_cikis;
    
    @FXML
    private Button btn_sifre;

    @FXML
    private Button btn_giris;
    
    @FXML
    private Label lbl_sonuc;
    
    @FXML
    private TextField txt_kul;

    @FXML
    private PasswordField txt_pass;
    
    @FXML
    private AnchorPane loginPane;

    @FXML
    void btn_bilgi_Click(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION );
    	alert.setTitle("GNC Diş Polikliniği");
    	alert.setHeaderText("Bilgi Mesajı");
    	alert.setContentText("Sağlıklı gülüşler için GNC Diş Polikliniği'ne bekleriz.");
    	alert.showAndWait();

    }

    @FXML
    void btn_cikis_Click(ActionEvent event) {
    	System.exit(0);

    }
    
    public void stage(String stageName) {
		try {
			Stage stage1= new Stage();
			AnchorPane pane1 =(AnchorPane)FXMLLoader.load(getClass().getResource(stageName));
			Scene scene = new Scene(pane1);
			stage1.setScene(scene);
			stage1.show();
			Stage stage2=(Stage) loginPane.getScene().getWindow();
			stage2.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    VeritabaniUtil database=new VeritabaniUtil();
    Connection baglanti;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen;
    String sql;

   @FXML
    void btn_giris_Click(ActionEvent event) {
    
    try {
        sql="select * from login where kul_adi=? and sifre=?";
		sorguIfadesi=database.Baglan().prepareStatement(sql);
		sorguIfadesi.setString(1,txt_kul.getText().trim());
		sorguIfadesi.setString(2, VeritabaniUtil.MD5Sifrele(txt_pass.getText().trim()));
		getirilen=sorguIfadesi.executeQuery();
		if(!getirilen.next()) {
			lbl_sonuc.setText(" Kullanıcı adı veya şifre hatalı");
		}
		else {
		getirilen.getString(1); // tabloda 1. sütundaki değer
		System.out.println("Kullanici:" + getirilen.getString("kul_adi"));	
		System.out.println("Sifre:" + getirilen.getString("sifre"));
		if("0".equals(getirilen.getString("giris_turu"))) {
    	stage("asistan.fxml");    	
    	System.out.println("0");
    	
    	Alert alert = new Alert(AlertType.INFORMATION );
    	alert.setTitle("GNC Diş Polikliniği");
    	alert.setHeaderText("Bilgi Mesajı");
    	alert.setContentText("Asistan Giriş Yaptı.");
    	alert.showAndWait();
    }
        else if("1".equals(getirilen.getString("giris_turu"))) {
        stage("Dt2.fxml");
    	System.out.println("1");
    	
    	Alert alert = new Alert(AlertType.INFORMATION );
    	alert.setTitle("GNC Diş Polikliniği");
    	alert.setHeaderText("Bilgi Mesajı");
    	alert.setContentText(" Eda Şahin Giriş Yaptı.");
    	alert.showAndWait();
    }
        else if("2".equals(getirilen.getString("giris_turu"))) {
        stage("Dt1.fxml");
    	System.out.println("2");

    	Alert alert = new Alert(AlertType.INFORMATION );
    	alert.setTitle("GNC Diş Polikliniği");
    	alert.setHeaderText("Bilgi Mesajı");
    	alert.setContentText(" Serdar Yılmaz Giriş Yaptı.");
    	alert.showAndWait();}
		}
		  database.Kapat();
		  sorguIfadesi.close();
		  getirilen.close();	 
    } 
	  catch(Exception e) {
      lbl_sonuc.setText(e.getMessage().toString());
}
    }
   
   @FXML
   void btn_sifre_Click(ActionEvent event) {
	   stage("sifre_degistir.fxml");
   }
   

    @FXML
    void initialize() {
    	Tooltip tip1 = new Tooltip();
        tip1.setStyle("-fx-background-color:gray;");
        tip1.setText("Giriş işlemi yapar.");
        btn_giris.setTooltip(tip1);
        
        Tooltip tip2 = new Tooltip();
        tip2.setStyle("-fx-background-color:gray;");
        tip2.setText("Çıkış işlemi yapar.");
        btn_cikis.setTooltip(tip2);
        
        Tooltip tip3 = new Tooltip();
        tip3.setStyle("-fx-background-color:gray;");
        tip3.setText("Bilgilendirme yapar.");
        btn_bilgi.setTooltip(tip3);
        
        Tooltip tip4 = new Tooltip();
        tip4.setStyle("-fx-background-color:gray;");
        tip4.setText("Şifre yenileme yapar.");
        btn_sifre.setTooltip(tip4);
 
    }

}
