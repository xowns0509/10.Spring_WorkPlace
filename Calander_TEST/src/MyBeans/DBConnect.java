package MyBeans;

import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;

public class DBConnect {
	Connection dbconn = null;

	String dburl = new String();
	String dbuser = new String();
	String dbpass = new String();


	public DBConnect() {
		//아이피는 바꿔주세요
		dburl = "jdbc:oracle:thin:@192.168.0.115:1521:orcl";
		//유저이름 수정
		dbuser = "scott";
		//패스워드 수정
		dbpass = "tiger";
	}


	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
		}

		try {
			dbconn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (SQLException e) {
		}

		return dbconn;
	}


	public void close() {
		try {
			if(!dbconn.isClosed()) {
				dbconn.close();
			}
		} catch (SQLException e) {
		}
	}

}