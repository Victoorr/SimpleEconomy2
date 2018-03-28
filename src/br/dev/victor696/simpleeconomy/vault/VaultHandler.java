package br.dev.victor696.simpleeconomy.vault;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import br.dev.victor696.simpleeconomy.SimpleEconomy;
import br.dev.victor696.simpleeconomy.model.Money;
import br.dev.victor696.simpleeconomy.utils.Methods;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;

public class VaultHandler implements Economy {

	@Override
	public EconomyResponse bankBalance(String arg0) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public EconomyResponse bankDeposit(String arg0, double arg1) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public EconomyResponse bankHas(String arg0, double arg1) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public EconomyResponse bankWithdraw(String arg0, double arg1) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public EconomyResponse createBank(String arg0, String arg1) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public EconomyResponse createBank(String arg0, OfflinePlayer arg1) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public boolean createPlayerAccount(String arg0) {
		try {
			Methods.loadPlayer(Bukkit.getPlayer(arg0));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0) {
		try {
			Methods.loadPlayer(arg0);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createPlayerAccount(String arg0, String arg1) {
		try {
			Methods.loadPlayer(Bukkit.getPlayer(arg0));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createPlayerAccount(OfflinePlayer arg0, String arg1) {
		try {
			Methods.loadPlayer(arg0);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String currencyNamePlural() {
		return "Coins";
	}

	@Override
	public String currencyNameSingular() {
		return "Coin";
	}

	@Override
	public EconomyResponse deleteBank(String arg0) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, double arg1) {
		if (arg1 < 0) {
			return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Valor negativo");
		}
		Money m = SimpleEconomy.getInstance().getMoney().get(Bukkit.getPlayer(arg0).getUniqueId());
		if (m == null) {
			Methods.loadPlayer(Bukkit.getPlayer(arg0));
		}
		m.addMoney(arg1);
		return new EconomyResponse(0, m.getMoney(), ResponseType.SUCCESS, "Valor adicionado");
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, double arg1) {
		return depositPlayer(arg0.getName(), arg1);
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, String arg1, double arg2) {
		return depositPlayer(arg0, arg2);
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		return depositPlayer(arg0.getName(), arg2);
	}

	@Override
	public String format(double arg0) {
		return Methods.formatDouble(arg0);
	}

	@Override
	public int fractionalDigits() {
		return 0;
	}

	@Override
	public double getBalance(String arg0) {
		Money m = SimpleEconomy.getInstance().getMoney().get(Bukkit.getPlayer(arg0).getUniqueId());
		if (m == null) {
			Methods.loadPlayer(Bukkit.getPlayer(arg0));
		}
		return m.getMoney();
	}

	@Override
	public double getBalance(OfflinePlayer arg0) {
		return getBalance(arg0.getName());
	}

	@Override
	public double getBalance(String arg0, String arg1) {
		return getBalance(arg0);
	}

	@Override
	public double getBalance(OfflinePlayer arg0, String arg1) {
		return getBalance(arg0.getName());
	}

	@Override
	public List<String> getBanks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "SimpleEconomy V2";
	}

	@Override
	public boolean has(String arg0, double arg1) {
		Money m = SimpleEconomy.getInstance().getMoney().get(Bukkit.getPlayer(arg0).getUniqueId());
		if (m == null)
			return false;
		
		if (m.getMoney() >= 0) {
			return m.getMoney() >= arg1;
		}
		return false;
	}

	@Override
	public boolean has(OfflinePlayer arg0, double arg1) {
		return has(arg0.getName(), arg1);
	}

	@Override
	public boolean has(String arg0, String arg1, double arg2) {
		return has(arg0, arg2);
	}

	@Override
	public boolean has(OfflinePlayer arg0, String arg1, double arg2) {
		return has(arg0.getName(), arg2);
	}

	@Override
	public boolean hasAccount(String arg0) {
		Money m = SimpleEconomy.getInstance().getMoney().get(Bukkit.getPlayer(arg0).getUniqueId());
		if (m == null)
			return false;
		return true;
	}

	@Override
	public boolean hasAccount(OfflinePlayer arg0) {
		return hasAccount(arg0.getName());
	}

	@Override
	public boolean hasAccount(String arg0, String arg1) {
		return hasAccount(arg0);
	}

	@Override
	public boolean hasAccount(OfflinePlayer arg0, String arg1) {
		return hasAccount(arg0.getName());
	}

	@Override
	public boolean hasBankSupport() {
		return false;
	}

	@Override
	public EconomyResponse isBankMember(String arg0, String arg1) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public EconomyResponse isBankMember(String arg0, OfflinePlayer arg1) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, String arg1) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, OfflinePlayer arg1) {
		return new EconomyResponse(0.0, 0.0, ResponseType.NOT_IMPLEMENTED, "Este plugin não possui suporte para este tipo de acão.");
	}

	@Override
	public boolean isEnabled() {
		return SimpleEconomy.getInstance().isEnabled();
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, double arg1) {
		Money m = SimpleEconomy.getInstance().getMoney().get(Bukkit.getPlayer(arg0).getUniqueId());
		if (m == null) {
			return new EconomyResponse(0, 0, ResponseType.FAILURE, "Conta inexistente");
		}
		if (arg1 <= 0) {
			return new EconomyResponse(0, 0, ResponseType.FAILURE, "Valor negativo");
		}
		m.removeMoney(arg1);
		return new EconomyResponse(0, m.getMoney(), ResponseType.SUCCESS, "Valor removido");
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, double arg1) {
		return withdrawPlayer(arg0.getName(), arg1);
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2) {
		return withdrawPlayer(arg0, arg2);
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer arg0, String arg1, double arg2) {
		return withdrawPlayer(arg0.getName(), arg2);
	}

}
