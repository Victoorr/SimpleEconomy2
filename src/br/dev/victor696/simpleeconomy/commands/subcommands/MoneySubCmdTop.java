package br.dev.victor696.simpleeconomy.commands.subcommands;

import java.util.List;

import org.bukkit.entity.Player;

import br.dev.victor696.simpleeconomy.commands.EconomyCommand;
import br.dev.victor696.simpleeconomy.manager.MessagesManager;
import br.dev.victor696.simpleeconomy.utils.Methods;

public class MoneySubCmdTop extends EconomyCommand {

	public MoneySubCmdTop() {
		super("top", "simpleeconomy.cmd.top", new String[] { "ricos" });
	}

	@Override
	public void onCommand(Player p, String[] args) {
		if (args.length > 0) {
			
			for (int i = 0; i < MessagesManager.TopPrefixo.size(); i++) {
				p.sendMessage(MessagesManager.TopPrefixo.get(i).replaceAll("&", "§"));
			}
			List<String> s = Methods.getListTop();
			for (int i = 0; i < MessagesManager.TopTamanho; i++) {
				if ((s.size()-1) >= i) {
					p.sendMessage(s.get(i));
				}
			}
			return;
		}
	}
}
