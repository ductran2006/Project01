package org.comit.sourse.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Util {

	public static Date parseDate(String str) {

		Date date = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = formatter.parse(str.trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public static Boolean parseBox(String boxType) {
		return (boxType == "vip") ? true : false;
	}
	
	public static int parseInt(String id) {
		return (id==null)?0:Integer.parseInt(id.trim());
	}
	
	public static String randomChar(int len) {
		String letter = "abcdefghijklmnopqrstuvwxyz";
		
		StringBuilder sb = new StringBuilder(len);
		  for (int i = 0; i < len; i++) {
		   int index = (int)(letter.length()* Math.random());
		   sb.append(letter.charAt(index));
		  }
		  String result= sb.toString();
		  result = result.substring(0,1).toUpperCase() + result.substring(1).toLowerCase();
		  return result;
	}
	
	public static String randomCharDigit(int len) {
		String letterAndDigit = "0123456789abcdefghijklmnopqrstuvwxyz";
		
		StringBuilder sb = new StringBuilder(len);
		  for (int i = 0; i < len; i++) {
		   int index = (int)(letterAndDigit.length()* Math.random());
		   sb.append(letterAndDigit.charAt(index));
		  }
		return sb.toString();
	}
	
	//generate database
	/*public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/pobox1";
		String dbUsername = "root";
		String dbPassword = "root";

		String sql = "INSERT INTO USER (idUser, firstName,  lastName,  userName,  password,  email,  boxName,  boxType,  dateRent,  parcel,)"
				+ " VALUES  (?,?,?,?,?,?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
				PreparedStatement st = con.prepareStatement(sql);) {
			System.out.println("Connection was successful!");
			
			Random r = new Random();
			int len =3+ r.nextInt(3);
			Calendar cal = Calendar.getInstance();
			int i=1;

			long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis);  
			
			Scanner sn = new Scanner(System.in);
			System.out.println("Input the number of row: ");
			int n=sn.nextInt();
			
			while (i <= n) {
				
				st.setInt(1, i);
				st.setString(2, randomChar(len));
				st.setString(3, randomChar(len));
				st.setString(4, randomChar(len));
				st.setString(5, randomCharDigit(len));
				st.setString(6, randomChar(len)+"@gmail.com");
				st.setString(7, "box"+i);
				st.setString(8, "normal");
				st.setDate(9,date);
				st.setInt(10, r.nextInt(len));
				
				System.out.println(st);
				i++;
			}
			System.out.println("Rows Affected: " + (i - 1));

		} catch (SQLException e) {
			System.out.println("Some error happened.");
			e.printStackTrace();
		}
	}*/
	
}
