package application;


public class Kayitlar_asistan {
   private String doktor_ad;
   private String tc;
   private String hasta_ad;
   private String hasta_soyad;
   private String tarih;
   private String iletisim;
   
   
  public  Kayitlar_asistan(String doktor_ad,String tc,String hasta_ad,String hasta_soyad,String tarih,String iletisim){
		 this.doktor_ad=doktor_ad;
		 this.tc=tc;
		 this.hasta_ad=hasta_ad;
		 this.hasta_soyad=hasta_soyad;
		 this.tarih=tarih;
		 this.iletisim=iletisim;
	   }
   
   
   public String getDoktor_ad() {
	return doktor_ad;
}



public void setDoktor_ad(String doktor_ad) {
	this.doktor_ad = doktor_ad;
}



public String getTc() {
	return tc;
}



public void setTc(String tc) {
	this.tc = tc;
}



public String getHasta_ad() {
	return hasta_ad;
}



public void setHasta_ad(String hasta_ad) {
	this.hasta_ad = hasta_ad;
}



public String getHasta_soyad() {
	return hasta_soyad;
}



public void setHasta_soyad(String hasta_soyad) {
	this.hasta_soyad = hasta_soyad;
}



public String getTarih() {
	return tarih;
}



public void setTarih(String tarih) {
	this.tarih = tarih;
}



public String getIletisim() {
	return iletisim;
}



public void setIletisim(String iletisim) {
	this.iletisim = iletisim;
}




   

   
 
   
   
   
}
