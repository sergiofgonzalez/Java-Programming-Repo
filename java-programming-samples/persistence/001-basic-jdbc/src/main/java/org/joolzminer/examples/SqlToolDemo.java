package org.joolzminer.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlToolDemo {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SqlToolDemo.class);
	
	private String dbDriverClass;
	private String dbUrl;
	private String dbUserName;
	private String dbPassword;
	
	private static final int COLUMN_WIDTH = 25;
	
	public SqlToolDemo(String dbDriverClass, String dbUrl, String dbUserName, String dbPassword) {
		this.dbDriverClass = dbDriverClass;
		this.dbUrl = dbUrl;
		this.dbUserName = dbUserName;
		this.dbPassword = dbPassword;
	}
	
	public void issueSql(String sql) {
		if (sql == null) {
			return;
		}
		
		sql = sql.trim();
		try {
			Class.forName(dbDriverClass);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Error loading jdbc driver: ", e);
		}
		
		try (	Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
				Statement statement = connection.createStatement();) {
			if (sql.toUpperCase().startsWith("SELECT")) {
				try (ResultSet resultSet = statement.executeQuery(sql)) {
					ResultSetMetaData metaData = resultSet.getMetaData();
					int columnCount = metaData.getColumnCount();
					for (int i = 0; i < columnCount; i++) {
						System.out.print(pad(metaData.getColumnName(i + 1)));
					}
					int length = columnCount * COLUMN_WIDTH;
					StringBuilder sb = new StringBuilder(length);
					for (int i = 0; i < length; i++) {
						sb.append('=');
					}
					System.out.println();
					System.out.println(sb.toString());
					
					while (resultSet.next()) {
						String[] row = new String[columnCount];
						for (int i = 0; i < columnCount; i++) {
							row[i] = resultSet.getString(i + 1);
							System.out.print(pad(row[i]));
						}
						System.out.println();
					}
				} catch (SQLException e) {
					LOGGER.error("Error reading results: ", e);
				}
			} else {
				int rowsUpdated = statement.executeUpdate(sql);
				System.out.println(rowsUpdated + " row" + ((rowsUpdated == 1)? "" : "(s) affected"));
			}
		} catch (SQLException e) {
			LOGGER.error("Error issuing SQL Statement: ", e);
		}
	}
	
	private String pad(String s) {
		int padCount = COLUMN_WIDTH - s.length();
		StringBuilder sb = new StringBuilder(25);
		sb.append(s);
		for (int i = 0; i < padCount; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String dbDriverClass = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/test";
		String dbUserName = "root";
		String dbPassword = "Accenture1";
		
		SqlToolDemo sqlToolDemo = new SqlToolDemo(dbDriverClass, dbUrl, dbUserName, dbPassword);
		String sql = JOptionPane.showInputDialog(null, "Enter an SQL Statement:");
		sqlToolDemo.issueSql(sql);
	}
}
