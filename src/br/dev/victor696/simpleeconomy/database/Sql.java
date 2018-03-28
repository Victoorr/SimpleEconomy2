package br.dev.victor696.simpleeconomy.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import br.dev.victor696.simpleeconomy.SimpleEconomy;

public class Sql {

	public static Connection conexao;

	public static void criarTabelas() {
		executarUpdate("CREATE TABLE IF NOT EXISTS simpleeconomy (UUID VARCHAR(255), Player VARCHAR(16), Money DOUBLE(16), Toggle BOOLEAN(16))");
	}

	public synchronized static void abrirConexao() {
		if (SimpleEconomy.instance.getConfig().getBoolean("SQL.Use")) {

			try {
				String host = SimpleEconomy.instance.getConfig().getString("SQL.Host");
				int porta = SimpleEconomy.instance.getConfig().getInt("SQL.Port");
				String usuario = SimpleEconomy.instance.getConfig().getString("SQL.User");
				String senha = SimpleEconomy.instance.getConfig().getString("SQL.Password");
				String tabela = SimpleEconomy.instance.getConfig().getString("SQL.DB");
				conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + tabela, usuario,
						senha);
				SimpleEconomy.getInstance().mysql = true;
			} catch (SQLException ex) {
				Bukkit.getConsoleSender().sendMessage("" + ex);
				Bukkit.getPluginManager().disablePlugin(SimpleEconomy.instance);
			}

		} else {

			try {
				File file = new File(SimpleEconomy.instance.getDataFolder(), "simpleeconomy.db");
				String URL = "jdbc:sqlite:" + file;
				Class.forName("org.sqlite.JDBC");
				conexao = DriverManager.getConnection(URL);
				SimpleEconomy.getInstance().mysql = true;
			} catch (Exception e) {
				Bukkit.getConsoleSender().sendMessage("" + e);
				Bukkit.getPluginManager().disablePlugin(SimpleEconomy.instance);
			}

		}
	}

	public static PreparedStatement prepareStatement(String statement) {
		try {
			return conexao.prepareStatement(statement);
		} catch (SQLException ex) {
			Bukkit.getConsoleSender().sendMessage("" + ex);
			return null;
		}
	}

	public static void executarUpdate(String update) {
		try {
			conexao.createStatement().executeUpdate(update);
		} catch (SQLException ex) {
			Bukkit.getConsoleSender().sendMessage("" + ex);
		}
	}

	public static void execute(String update) {
		try {
			conexao.createStatement().execute(update);
		} catch (SQLException ex) {
			Bukkit.getConsoleSender().sendMessage("" + ex);
		}
	}

	public static void fecharConexao() {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (Exception ex) {
				Bukkit.getConsoleSender().sendMessage("" + ex);
			}
		}
	}

}
