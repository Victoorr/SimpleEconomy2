package br.dev.victor696.simpleeconomy.commands.subcommands;

import org.bukkit.entity.Player;

import br.dev.victor696.simpleeconomy.SimpleEconomy;
import br.dev.victor696.simpleeconomy.commands.EconomyCommand;
import br.dev.victor696.simpleeconomy.manager.MessagesManager;
import br.dev.victor696.simpleeconomy.model.Money;
import br.dev.victor696.simpleeconomy.utils.Methods;

public class MoneySubCmdToggle extends EconomyCommand {

	public MoneySubCmdToggle() {
		super("toggle", "simpleeconomy.cmd.toggle", new String[] { "preferencias", "config", "recebimento" });
	}

	@Override
	public void onCommand(Player p, String[] args) {
		if (args.length > 0) {
			Money m = SimpleEconomy.getInstance().getMoney().get(p.getUniqueId());
			if (m == null) {
				Methods.loadPlayer(p);
			}
			
			if (m.getToggle()) {
				m.setToggle(true);
				p.sendMessage(MessagesManager.JogadorAtivouToggle);
				return;
			}
			m.setToggle(false);
			p.sendMessage(MessagesManager.JogadorDesativouToggle);
			return;

		}
	}
}
