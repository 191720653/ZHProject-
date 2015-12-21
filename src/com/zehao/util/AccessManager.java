package com.zehao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessManager {

	private Connection connection = null;
	private Statement statement = null;
	private String path = null;
	private boolean sign = false;

	public AccessManager(String path) {
		this.path = path;
	}

	public Connection init() {
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
				+ path;
		sign = false;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection(url);
			System.out.println("Access���ݿ����ӳɹ�");
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println("Access���ݿ�����ʧ��" + e);
		}
		return connection;
	}

	public void close() {
		try {
			if (statement != null)
				statement.close();
		} catch (Exception e) {
			System.out.println("Access statement �ر��쳣" + e);
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				System.out.println("Access connection �ر��쳣" + e);
			}
		}
		sign = true;
	}

	public void execute(String sql) throws SQLException {
		statement.execute(sql);
	}

	public boolean isSign() {
		return sign;
	}

}
