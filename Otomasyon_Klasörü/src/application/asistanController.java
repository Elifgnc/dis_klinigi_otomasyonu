package application;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import com.IsteMYSQL.Util.VeritabaniUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;

 
public  class asistanController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_ara;
    
    @FXML
    private Button btn_doktor;

    @FXML
    private Button btn_güncelle;

    @FXML
    private Button btn_iletisim;

    @FXML
    private Button btn_islemler;

    @FXML
    private Button btn_kaydet;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_temizle;
    
    @FXML
    private Button btn_yenile;

    @FXML
    private DatePicker dtpicker;
    
    @FXML
    private TableColumn<Kayitlar_asistan, String> col_ad;

    @FXML
    private TableColumn<Kayitlar_asistan, String> col_hasta_ad;

    @FXML
    private TableColumn<Kayitlar_asistan, String> col_hasta_soy;

    @FXML
    private TableColumn<Kayitlar_asistan, String> col_iletisim;
    
    @FXML
    private TableView<Kayitlar_asistan> tableview_kayitlar;

    @FXML
    private TableColumn<Kayitlar_asistan, String> col_tarih;

    @FXML
    private TableColumn<Kayitlar_asistan, String> col_tc;
    
    @FXML
    private Label lbl_sonuc;


    @FXML
    private TextField txt_doktoradi;
    

    @FXML
    private TextField txt_ara;
    

    @FXML
    private TextField txt_hastaadi;

    @FXML
    private TextField txt_hastasoyadi;

    @FXML
    private TextField txt_iletisim;

    @FXML
    private TextField txt_tc;

    
    VeritabaniUtil database=new VeritabaniUtil();
    Connection baglanti;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen;
    String sql;
    
    
    @FXML
    void btn_cikis_Click(ActionEvent event) {
    	 System.exit(0);

    }

    @FXML
    void btn_doktor_Click(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION );
    	alert.setTitle("GNC Diş Polikliniği");
    	alert.setHeaderText("Bilgilendirme Mesajı");
    	alert.setContentText("DİŞ HEKİMLERİMİZ:" + "\n" + "Serdar YILMAZ" + "\n" + "Eda ŞAHİN");
    	alert.showAndWait();

    }

    @FXML
    void btn_güncelle_Click(ActionEvent event) {
  
    sql="UPDATE asistan SET doktor_adi=?,hasta_adi=?,hasta_soyadi=?,tarih=?,telefon=? WHERE hasta_TC=?";
   	
  try {
            
    		sorguIfadesi=database.Baglan().prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_doktoradi.getText().trim());
    		sorguIfadesi.setString(2,txt_hastaadi.getText().trim());
    		sorguIfadesi.setString(3,txt_hastasoyadi.getText().trim());
    		sorguIfadesi.setString(4,dtpicker.getValue().toString());
    		sorguIfadesi.setString(5,txt_iletisim.getText().trim());
    		sorguIfadesi.setString(6,txt_tc.getText().trim());
    		sorguIfadesi.execute();
    		lbl_sonuc.setText("Kayıt güncelleme işlemi başarılı ");
    		
    		  database.Kapat();
    		  sorguIfadesi.close();
    		  
    		  Alert alert = new Alert(AlertType.ERROR);
    		  alert.setTitle("GNC DİŞ KLİNİĞİ");
    		  alert.setHeaderText("Uyarı mesajı");
    		  alert.setContentText("Kayıt Güncelleme işlemi");
    		  alert.showAndWait();
    		  	 
        } 
    	  catch(Exception e) {
    		 lbl_sonuc.setText(e.getMessage().toString());}
    }

    @FXML
     void btn_iletisim_Click(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.INFORMATION );
    	alert.setTitle("GNC Diş Polikliniği");
    	alert.setHeaderText("iletişim Mesajı");
    	alert.setContentText("İletişim Numarası : 05347896415 " +"\n" + "İletişim Adresimiz : gncpoliklinik@gmail.com ");
    	
    	ButtonType btn1 = new ButtonType("Tamam",ButtonData.OK_DONE);
    	ButtonType btn2 = new ButtonType("İptal",ButtonData.CANCEL_CLOSE);
    	alert.getButtonTypes().setAll(btn1,btn2);
    	Optional<ButtonType>sonuc=alert.showAndWait();
    	
    	if(sonuc.get()==btn1) {
    		System.out.println("Tamam butonuna basildi.");
    	}
    	
    	else if(sonuc.get()==btn2) {
    		System.out.println("İptal butonuna basildi.");
    	}

    }

    @FXML
    void btn_islemler_Click(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.INFORMATION );
    	alert.setTitle("GNC Diş Polikliniği");
    	alert.setHeaderText("Bilgilendirme Mesajı");
    	alert.setContentText("YAPILAN İŞLEMLER :" + "\n" + "Diş Çekimi" + "\n" + "Kanal Tedavisi " + "\n" + "Diş Beyazlatma" + "\n" + "İmplant Uygulama" + "\n" + "Diş Teli Uygulama");
    	
    	ButtonType btn3 = new ButtonType("Tamam",ButtonData.OK_DONE);
    	ButtonType btn4 = new ButtonType("İptal",ButtonData.CANCEL_CLOSE);
    	alert.getButtonTypes().setAll(btn3,btn4);
    	Optional<ButtonType>sonuc=alert.showAndWait();
    	
    	if(sonuc.get()==btn3) {
    		System.out.println("Tamam butonuna basildi.");
    	}
    	
    	else if(sonuc.get()==btn4) {
    		System.out.println("İptal butonuna basildi.");
    	}


    }
    
    

    @FXML
    void btn_kaydet_Click(ActionEvent event) {
    	sql="insert into asistan(doktor_adi,hasta_TC,hasta_adi,hasta_soyadi,tarih,telefon) values (?,?,?,?,?,?)";
    	
    	try {
            
    		sorguIfadesi=database.Baglan().prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_doktoradi.getText().trim());
    		sorguIfadesi.setString(2,txt_tc.getText().trim());
    		sorguIfadesi.setString(3,txt_hastaadi.getText().trim());
    		sorguIfadesi.setString(4,txt_hastasoyadi.getText().trim());
    		sorguIfadesi.setString(5,dtpicker.getValue().toString());
    		sorguIfadesi.setString(6,txt_iletisim.getText().trim());
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
    

    @FXML
    void btn_sil_Click(ActionEvent event) {
    	sql="delete from asistan where doktor_adi=? and hasta_TC=?";
    	
    	try {
            
    		sorguIfadesi=database.Baglan().prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_doktoradi.getText().trim());
    		sorguIfadesi.setString(2,txt_tc.getText().trim());
    		sorguIfadesi.execute();
    		lbl_sonuc.setText("Kayıt silme işlemi başarılı ");
    		
    		  database.Kapat();
    		  sorguIfadesi.close();
    		  	 
    		  
    		  Alert alert = new Alert(AlertType.ERROR);
    		  alert.setTitle("GNC DİŞ KLİNİĞİ");
    		  alert.setHeaderText("Uyarı mesajı");
    		  alert.setContentText("Kayıt silme işlemi");
    		  alert.showAndWait();
        } 
    	  catch(Exception e) {
    		 lbl_sonuc.setText(e.getMessage().toString());}
    
    }

    @FXML
    void btn_temizle_Click(ActionEvent event) {
    	
    txt_doktoradi.clear();
    txt_tc.clear();
    txt_hastaadi.clear();
    txt_hastasoyadi.clear();
    txt_iletisim.clear();
    
    }
    
    
    @FXML
    void btn_yenileClick(ActionEvent event) {
    	
    	DegerleriGetir();
    }
    
    
    @FXML
    void btn_ara_Click(ActionEvent event) {
    	
    	aramaOlayi(tableview_kayitlar);
    	
    	 Alert alert = new Alert(AlertType.ERROR);
		  alert.setTitle("GNC DİŞ KLİNİĞİ");
		  alert.setHeaderText("Uyarı mesajı");
		  alert.setContentText("Kayıt arama işlemi");
		  alert.showAndWait();

    }
    
    public void aramaOlayi(TableView<Kayitlar_asistan> table) {
    	
    	   sql = "SELECT * FROM asistan WHERE hasta_tc=?";
    		ObservableList<Kayitlar_asistan> kayitlarliste=FXCollections.observableArrayList();
    	try {
			sorguIfadesi=database.Baglan().prepareStatement(sql);
            sorguIfadesi.setString(1, String.valueOf(txt_ara.getText()));
    		getirilen = sorguIfadesi.executeQuery();
    		while(getirilen.next()) {
				kayitlarliste.add(new Kayitlar_asistan(getirilen.getString("doktor_adi"), getirilen.getString("hasta_TC"),getirilen.getString("hasta_adi"),getirilen.getString("hasta_soyadi"),getirilen.getString("tarih"),getirilen.getString("telefon")));
    		}
    		col_ad.setCellValueFactory(new PropertyValueFactory<>("doktor_ad"));
			col_tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
			col_hasta_ad.setCellValueFactory(new PropertyValueFactory<>("hasta_ad"));
			col_hasta_soy.setCellValueFactory(new PropertyValueFactory<>("hasta_soyad"));
			col_tarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
			col_iletisim.setCellValueFactory(new PropertyValueFactory<>("iletisim"));
			tableview_kayitlar.setItems(kayitlarliste);
			
    		} catch (Exception e) {
    			
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setHeaderText(null);
    			alert.setContentText(e.getMessage().toString());
    			alert.show();
    			}	
    		}
    
    
    

    //ObservableList<Kayitlar_asistan> kayitlarliste=FXCollections.observableArrayList();
    public void DegerleriGetir() {
    	
    	sql= "select * from asistan";
    	ObservableList<Kayitlar_asistan> kayitlarliste=FXCollections.observableArrayList();
    	try {
			sorguIfadesi=database.Baglan().prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
				kayitlarliste.add(new Kayitlar_asistan(getirilen.getString("doktor_adi"), getirilen.getString("hasta_TC"),getirilen.getString("hasta_adi"),getirilen.getString("hasta_soyadi"),getirilen.getString("tarih"),getirilen.getString("telefon")));
			tableview_kayitlar.setItems(kayitlarliste);
			}
			col_ad.setCellValueFactory(new PropertyValueFactory<>("doktor_ad"));
			col_tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
			col_hasta_ad.setCellValueFactory(new PropertyValueFactory<>("hasta_ad"));
			col_hasta_soy.setCellValueFactory(new PropertyValueFactory<>("hasta_soyad"));
			col_tarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
			col_iletisim.setCellValueFactory(new PropertyValueFactory<>("iletisim"));
			
		} catch (Exception e) {
			
			
		}
    }
    
   Kayitlar_asistan table=null;
    
    @FXML
    void tableview_MouseClick(MouseEvent event) {
    	
     table=tableview_kayitlar.getSelectionModel().getSelectedItem();
     txt_doktoradi.setText(table.getDoktor_ad());
     txt_tc.setText(table.getTc());
     txt_hastaadi.setText(table.getHasta_ad());
     txt_hastasoyadi.setText(table.getHasta_soyad());
    Date d = Date.valueOf(table.getTarih());
    dtpicker.setValue(d.toLocalDate());
    txt_iletisim.setText(table.getIletisim());

    }
    

    @FXML
    void initialize() {
        Tooltip tip1 = new Tooltip();
        tip1.setStyle("-fx-background-color:gray;");
        tip1.setText("Ekleme işlemi yapar.");
        btn_kaydet.setTooltip(tip1);

        
        Tooltip tip2 = new Tooltip();
        tip2.setStyle("-fx-background-color:gray;");
        tip2.setText("Silme işlemi yapar.");
        btn_sil.setTooltip(tip2);
        
        Tooltip tip3 = new Tooltip();
        tip3.setStyle("-fx-background-color:gray;");
        tip3.setText("Güncelleme işlemi yapar.");
        btn_güncelle.setTooltip(tip3);
        
        
        Tooltip tip4 = new Tooltip();
        tip4.setStyle("-fx-background-color:gray;");
        tip4.setText("Araçları temizleme işlemi yapar.");
        btn_temizle.setTooltip(tip4);

        
        Tooltip tip5 = new Tooltip();
        tip5.setStyle("-fx-background-color:gray;");
        tip5.setText(" arama işlemi yapar.");
        btn_ara.setTooltip(tip4);
        
        
        Tooltip tip6 = new Tooltip();
        tip6.setStyle("-fx-background-color:gray;");
        tip6.setText(" yenileme işlemi yapar.");
        btn_yenile.setTooltip(tip6);
        
        DegerleriGetir();



    }

}
