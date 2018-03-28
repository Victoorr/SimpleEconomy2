package br.dev.victor696.simpleeconomy.manager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import br.dev.victor696.simpleeconomy.database.Sql;

public class SqlManager {
	
	public static void newPlayer(Player p) {
		try {
			PreparedStatement stm = Sql.conexao.prepareStatement("INSERT INTO simpleeconomy (UUID, Player, Money, Toggle) VALUES (?,?,?,?)");
			stm.setString(1, p.getUniqueId().toString());
			stm.setString(2, p.getName());
			stm.setDouble(3, 0.0);
			stm.setBoolean(4, true);
			stm.executeUpdate();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("" + e);
		}
	}
	
	public static boolean hasPlayer(Player p) {
		try {
			return Sql.conexao.createStatement().executeQuery("SELECT * FROM simpleeconomy WHERE UUID = '" + p.getUniqueId().toString() + "'").next();
		} catch (SQLException ex) {
			return false;
		}
	}
	
	public static boolean hasPlayer(UUID uuid) {
		try {
			return Sql.conexao.createStatement().executeQuery("SELECT * FROM simpleeconomy WHERE UUID = '" + uuid.toString() + "'").next();
		} catch (SQLException ex) {
			return false;
		}
	}
	
	public static void delete() {
		try {
			PreparedStatement stm = Sql.conexao.prepareStatement("DELETE FROM simpleeconomy");
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
