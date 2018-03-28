package br.dev.victor696.simpleeconomy.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import br.dev.victor696.simpleeconomy.SimpleEconomy;
import br.dev.victor696.simpleeconomy.database.Sql;
import br.dev.victor696.simpleeconomy.manager.MessagesManager;
import br.dev.victor696.simpleeconomy.model.Money;

public class Methods {

	public static List<String> top = new ArrayList<>();;

	public static List<String> getListTop() {
		return top;
	}

	public static List<String> loadTop() {
		try {
			saveOnlinePlayers();
			top.clear();
			ResultSet rs = Sql.prepareStatement("SELECT * FROM simpleeconomy ORDER BY Money DESC LIMIT " + MessagesManager.TopTamanho + ";")
					.executeQuery();
			Integer i = 0;
			while (rs.next()) {
				i++;
				String player = rs.getString("Player");
				Double coins = rs.getDouble("Money");
				
				String prefix = "";
				String magnata = "";
				if (i == 1) {
					magnata = "";
				}
				
				top.add(MessagesManager.TopFormato.replaceAll("&", "§")
						.replace("{player}", player)
						.replace("{p}", Integer.toString(i))
						.replace("{magnata}", magnata)
						.replace("{preffix}", prefix)
						.replace("{valor}", formatDouble(coins)));
			}
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("" + e);
		}
		return top;
	}

	public static void loadPlayer(Player p) {
		Money m = new Money(p.getName(), p.getUniqueId(), 0.0, false);
		m.loadAccount();
		SimpleEconomy.getInstance().getMoney().put(p.getUniqueId(), m);
	}

	public static void loadPlayer(OfflinePlayer p) {
		Money m = new Money(p.getName(), p.getUniqueId(), 0.0, false);
		m.loadAccount();
		SimpleEconomy.getInstance().getMoney().put(p.getUniqueId(), m);
	}

	public static void savePlayer(Player p) {
		Money m = SimpleEconomy.getInstance().getMoney().get(p.getUniqueId());
		m.saveAccount();
		SimpleEconomy.getInstance().getMoney().remove(p.getUniqueId());
	}
	
	public static void saveOnlinePlayers() {
		if (Bukkit.getOnlinePlayers().size() == 0)
			return;

		for (Player p : Bukkit.getOnlinePlayers()) {
			savePlayer(p);
		}
		
	}
	
	public static void loadOnlinePlayers() {
		if (Bukkit.getOnlinePlayers().size() == 0)
			return;

		for (Player p : Bukkit.getOnlinePlayers()) {
			loadPlayer(p);
		}
	}

	public static String formatDouble(double money) {
		DecimalFormat numberFormat = new DecimalFormat("###,###.###");
		String d = numberFormat.format(money);
		if (d.equalsIgnoreCase(".00")) {
			d = "0.0";
		}
		return d;
	}

}
