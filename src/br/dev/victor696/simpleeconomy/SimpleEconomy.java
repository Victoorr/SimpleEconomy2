package br.dev.victor696.simpleeconomy;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import br.dev.victor696.simpleeconomy.commands.MoneyCommand;
import br.dev.victor696.simpleeconomy.database.Sql;
import br.dev.victor696.simpleeconomy.listeners.Listeners;
import br.dev.victor696.simpleeconomy.manager.MessagesManager;
import br.dev.victor696.simpleeconomy.model.Money;
import br.dev.victor696.simpleeconomy.thread.Update;
import br.dev.victor696.simpleeconomy.utils.Config;
import br.dev.victor696.simpleeconomy.utils.Methods;
import br.dev.victor696.simpleeconomy.vault.VaultEconomy;
import br.dev.victor696.simpleeconomy.vault.VaultHandler;
import net.milkbowl.vault.economy.Economy;

public class SimpleEconomy extends JavaPlugin {

	public static SimpleEconomy instance;
	public HashMap<UUID, Money> money;
	public boolean mysql;
	public Sql sql;
	public VaultEconomy economy;
	public Config mensagens = new Config(this, "mensagens.yml");
	public Economy vault;

	public static SimpleEconomy getInstance() {
		return instance;
	}

	public HashMap<UUID, Money> getMoney() {
		return this.money;
	}

	public Sql getSql() {
		return this.sql;
	}

	public VaultEconomy getVault() {
		return this.economy;
	}

	public Config getMensagens() {
		return this.mensagens;
	}

	public Economy getEconomy() {
		return vault;
	}

	public SimpleEconomy() {
		instance = this;
		money = new HashMap<>();
		sql = new Sql();
		economy = new VaultEconomy();
	}

	public void setupVault() {
		vault = new VaultHandler();
		getServer().getServicesManager().register(Economy.class, vault, this, ServicePriority.Highest);
	}

	@Override
	public void onEnable() {

		System.out.print("SimpleEconomy V2 Iniciado - by Victor696");

		saveDefaultConfig();

		this.mysql = false;

		Sql.abrirConexao();
		Sql.criarTabelas();

		if (!mensagens.existeConfig()) {
			mensagens.saveDefaultConfig();
		}

		economy.setup();
		setupVault();

		Bukkit.getPluginManager().registerEvents(new Listeners(), this);

		getCommand("money").setExecutor(new MoneyCommand());
		getCommand("money").setTabCompleter(new MoneyCommand());

		Methods.loadOnlinePlayers();

		MessagesManager.loadMessages();
		Methods.loadTop();
		Update.start();
	}

	@Override
	public void onDisable() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			Methods.savePlayer(p);
		}
		money.clear();
		Sql.fecharConexao();
	}

}
