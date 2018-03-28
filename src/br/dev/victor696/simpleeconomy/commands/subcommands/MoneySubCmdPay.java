package br.dev.victor696.simpleeconomy.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import br.dev.victor696.simpleeconomy.SimpleEconomy;
import br.dev.victor696.simpleeconomy.commands.EconomyCommand;
import br.dev.victor696.simpleeconomy.manager.MessagesManager;
import br.dev.victor696.simpleeconomy.model.Money;
import br.dev.victor696.simpleeconomy.utils.Methods;

public class MoneySubCmdPay extends EconomyCommand {

	public MoneySubCmdPay() {
		super("pay", "simpleeconomy.cmd.pay", new String[] { "pagar", "enviar" });
	}

	@Override
	public void onCommand(Player p, String[] args) {
		if (args.length > 0) {
			if (args.length == 1 || args.length == 2) {
				p.sendMessage(MessagesManager.PayArgumento);
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

			Money mm = SimpleEconomy.getInstance().getMoney().get(p.getUniqueId());
			if (mm == null) {
				Methods.loadPlayer(p);
			}
			
			if (value > mm.getMoney()) {
				p.sendMessage(MessagesManager.JogadorMoneySuficiente);
				return;
			}

			Money m = SimpleEconomy.getInstance().getMoney().get(pp.getUniqueId());
			if (m == null) {
				Methods.loadPlayer(pp);
			}
			
			if (!m.getToggle()) {
				p.sendMessage(MessagesManager.JogadorNaoEstaRecebendoMoney);
				return;
			}
			
			mm.removeMoney(value);
			m.addMoney(value);
			p.sendMessage(MessagesManager.JogadorEnviouMoney.replace("{player}", pp.getName()).replace("{valor}",
					Methods.formatDouble(value)));
			pp.sendMessage(MessagesManager.JogadorRecebeuMoney.replace("{player}", p.getName()).replace("{valor}",
					Methods.formatDouble(value)));
			return;

		}
	}
}
