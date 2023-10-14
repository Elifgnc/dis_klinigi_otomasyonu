package com.IsteMYSQL.Util;
import java.sql.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class VeritabaniUtil {
public Connection conn =null;

public  Connection Baglan() {
	try {
		//"jdbc:mysql://ServerIPAdresi/db_ismi", "kullanici","sifre"
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projem_fx","root","");
		return conn;
} 
	catch(Exception e) {
	System.out.println(e.getMessage().toString());
	return conn;
}}
	public void Kapat() {
		try {
			conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage().toString());}
		
	}

	
	public static String MD5Sifrele(String icerik) {
		try {
			
			MessageDigest md= MessageDigest.getInstance("MD5");
			byte[] sifrelenmis= md.digest(icerik.getBytes());
			
			BigInteger no= new BigInteger(1, sifrelenmis);
			
			String hashIcerik=no.toString(16);
			while(hashIcerik.length()<32) {
				hashIcerik="0"+ hashIcerik;
				
			}
			
		return hashIcerik;
			
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
			
		}	

	}
}
