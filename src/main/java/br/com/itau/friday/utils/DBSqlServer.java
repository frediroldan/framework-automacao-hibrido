package br.com.itau.friday.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSqlServer {
	String driver = "jdbc:sqlserver://";
	private String dbURL;
	private String databaseName;
	private String user;
	private String pass;

	public void setAmbiente() {
		int x = 1;
		if (x == 1) {
			this.dbURL = driver + "krt-ksk-sqlmi-dev.71525297c2a6.database.windows.net";
			this.databaseName = "KRT-CAPITALHUMANO-DEV";
			this.user = "usr_capitalhumano";
			this.pass = "xxxxxxxx";
		} else {
			this.dbURL = driver + "krt-ksk-sqlmi-stg.f640035b0099.database.windows.net";
			this.databaseName = "KRT-CAPITALHUMANO-STG";
			this.user = "usr_capitalhumano";
			this.pass = "xxxxxxx";
		}
	}

	public String connectSQLServerSelect(String sql) {
		setAmbiente();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String consulta = null;
		try {
			String connectionUrl = this.dbURL + ";databaseName=" + this.databaseName + ";user=" + this.user
					+ ";password=" + this.pass;
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// System.out.println(rs.getString("X") + " " + rs.getString("Y"));
				consulta = rs.getString(1);
				System.out.println(consulta);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
		}
		return consulta;
	}

	public void connectSQLServerUpdate(String sql) {
		setAmbiente();
		Connection conn = null;
		Statement stmt = null;
		int rs;
		try {
			String connectionUrl = this.dbURL + ";databaseName=" + this.databaseName + ";user=" + this.user
					+ ";password=" + this.pass;
			conn = DriverManager.getConnection(connectionUrl);

			stmt = conn.createStatement();
			rs = stmt.executeUpdate(sql);
			System.out.println(rs);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}

		}
	}

	public void connectSQLServerExec(String sql) {
		setAmbiente();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String connectionUrl = this.dbURL + ";databaseName=" + this.databaseName + ";user=" + this.user
					+ ";password=" + this.pass;
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();
			stmt.executeQuery(sql);
		} catch (SQLException ex) {
			if (ex.toString().contains("A instrucao nao retornou um conjunto de resultados")) {
				System.out.println("Unidade da estrutura excluida");
			} else if (ex.toString().contains("Estrutura nao encontrada")) {
				System.out.println("Unidade da estrutura nao encontrada");
			} else {
				ex.printStackTrace();
			}

		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
		}
	}
}
