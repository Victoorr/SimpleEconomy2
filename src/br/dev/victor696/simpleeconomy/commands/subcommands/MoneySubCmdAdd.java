package br.dev.victor696.simpleeconomy.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import br.dev.victor696.simpleeconomy.SimpleEconomy;
import br.dev.victor696.simpleeconomy.commands.EconomyCommand;
import br.dev.victor696.simpleeconomy.manager.MessagesManager;
import br.dev.victor696.simpleeconomy.model.Money;
import br.dev.victor696.simpleeconomy.utils.Methods;

public class MoneySubCmdAdd extends EconomyCommand {

	public MoneySubCmdAdd() {
		super("add", "simpleeconomy.cmd.add", new String[] { "adicionar", "dar" });
	}

	@Override
	public void onCommand(Player p, String[] args) {
		if (args.length > 0) {
			if (args.length == 1 || args.length == 2) {
				p.sendMessage(MessagesManager.AddArgumento);
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
				Methods.loadPlayer(pp);
			}
			m.addMoney(value);
			p.sendMessage(MessagesManager.ValorAdicionado.replace("{player}", pp.getName()).replace("{valor}",
					Methods.formatDouble(value)));
			return;

		}
	}
}
