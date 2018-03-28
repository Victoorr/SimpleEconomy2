package br.dev.victor696.simpleeconomy.listeners;

import java.sql.SQLException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import br.dev.victor696.simpleeconomy.SimpleEconomy;
import br.dev.victor696.simpleeconomy.utils.Methods;

public class Listeners implements Listener {

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) throws SQLException {
		if (SimpleEconomy.getInstance().getMoney().get(e.getPlayer().getUniqueId()) == null)
			Methods.loadPlayer(e.getPlayer());
	}
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent e) {
		if (SimpleEconomy.getInstance().getMoney().get(e.getPlayer().getUniqueId()) != null)
			Methods.savePlayer(e.getPlayer());
	}

}
