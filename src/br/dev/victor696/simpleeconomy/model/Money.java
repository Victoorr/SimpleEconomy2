package br.dev.victor696.simpleeconomy.model;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.UUID;

import org.bukkit.Bukkit;

import br.dev.victor696.simpleeconomy.database.Sql;
import br.dev.victor696.simpleeconomy.manager.SqlManager;

public class Money {

	private String player;
	private UUID uuid;
	private double money;
	private boolean toggle;

	public Money(String player, UUID uuid, double money, boolean toggle) {
		this.player = player;
		this.uuid = uuid;
		this.money = money;
		this.toggle = toggle;
	}

	public String getPlayer() {
		return this.player;
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public double getMoney() {
		return this.money;
	}

	public String getFormatedMoney() {
		return formatDouble(getMoney());
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void addMoney(double money) {
		this.money += money;
	}

	public void removeMoney(double money) {
		this.money -= money;
	}

	public boolean getToggle() {
		return this.toggle;
	}

	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}

	public void loadAccount() {
		if (SqlManager.hasPlayer(uuid)) {
			try {
				ResultSet rs = Sql
						.prepareStatement("SELECT * FROM simpleeconomy WHERE UUID = '" + this.uuid.toString() + "'")
						.executeQuery();
				while (rs.next()) {
					this.money = Double.parseDouble(rs.getString("Money"));
					this.toggle = Boolean.parseBoolean(rs.getString("Toggle"));
				}
			} catch (Exception e) {
				Bukkit.getConsoleSender().sendMessage("" + e);
			}
			return;
		}
		SqlManager.newPlayer(Bukkit.getPlayer(player));
		money = 0.0;
		toggle = true;
	}

	public void saveAccount() {
		try {
			Sql.executarUpdate("UPDATE simpleeconomy SET Money = '" + this.money + "' WHERE UUID = '"
					+ this.uuid.toString() + "'");
			Sql.executarUpdate("UPDATE simpleeconomy SET Toggle = '" + this.toggle + "' WHERE UUID = '"
					+ this.uuid.toString() + "'");
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage("" + e);
		}
	}

	public String formatDouble(double money) {
		DecimalFormat numberFormat = new DecimalFormat("###,###.###");
		String d = numberFormat.format(money);
		if (d.equalsIgnoreCase(".00")) {
			d = "0.0";
		}
		return d;
	}

}
