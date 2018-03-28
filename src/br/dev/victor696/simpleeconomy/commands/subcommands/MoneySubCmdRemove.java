package br.dev.victor696.simpleeconomy.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import br.dev.victor696.simpleeconomy.SimpleEconomy;
import br.dev.victor696.simpleeconomy.commands.EconomyCommand;
import br.dev.victor696.simpleeconomy.manager.MessagesManager;
import br.dev.victor696.simpleeconomy.model.Money;
import br.dev.victor696.simpleeconomy.utils.Methods;

public class MoneySubCmdRemove extends EconomyCommand {

	public MoneySubCmdRemove() {
		super("remove", "simpleeconomy.cmd.remove", new String[] { "tirar", "remover", "del" });
	}

	@Override
	public void onCommand(Player p, String[] args) {
		if (args.length > 0) {
			if (args.length == 1 || args.length == 2) {
				p.sendMessage(MessagesManager.RemoveArgumento);
				return;
			}

			Player pp = Bukkit.getPlayer(args[1]);
			if (pp == null) {
				p.sendMessage(MessagesManager.JogadorNaoEncontrado);
				return;
			}

			Integer value = 0;

			try {
				value = Integer.valueOf(args[2]);
			} catch (Exception e) {
				p.sendMessage(MessagesManager.ValorPrecisaSerNumero);
				return;
			}

			if (value <= 0) {
				p.sendMessage(MessagesManager.ValorPrecisaSerMaiorQueZero);
				return;
			}
			
			Money m = SimpleEconomy.getInstance().getMoney().get(pp.getUniqueId());
			if (m == null) {
				try {
					Methods.loadPlayer(pp);
				} catch (Exception e) {
				}
			}
			
			if (m.getMoney() < value) {
				p.sendMessage(MessagesManager.ValorRemovidoMaisDoQueTinha.replace("{player}", pp.getName()));
				m.setMoney(0.0);
				return;
			}
			
			m.removeMoney(value);
			p.sendMessage(MessagesManager.ValorRemovido.replace("{player}", pp.getName()).replace("{valor}", Methods.formatDouble(value)));
			return;

		}
	}
}
