package br.dev.victor696.simpleeconomy.manager;

import java.util.ArrayList;
import java.util.List;

import br.dev.victor696.simpleeconomy.SimpleEconomy;

public class MessagesManager {
	
	public static String AddArgumento;
	public static String ValorAdicionado;
	public static String JogadorNaoEncontrado;
	public static String ValorPrecisaSerNumero;
	public static String ValorPrecisaSerMaiorQueZero;
	public static String RemoveArgumento;
	public static String ValorRemovido;
	public static String ValorRemovidoMaisDoQueTinha;
	public static String MoneyDoJogador;
	public static String MoneyDeOutroJogador;
	public static String SemPermissao;
	public static String SetArgumento;
	public static String ValorSetado;
	public static String ValorPrecisaSerMaiorOuIgualAZero;
	public static String PayArgumento;
	public static String JogadorMoneySuficiente;
	public static String JogadorEnviouMoney;
	public static String JogadorRecebeuMoney;
	public static String ToggleArgumento;
	public static String JogadorAtivouToggle;
	public static String JogadorDesativouToggle;
	public static String JogadorNaoEstaRecebendoMoney;
	public static String TopFormato;
	public static List<String> TopPrefixo = new ArrayList<>();
	
	public static int TopTamanho;
	
	public static void loadMessages() {
		AddArgumento = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.AddArgumento").replaceAll("&", "§");
		ValorAdicionado = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.ValorAdicionado").replaceAll("&", "§");
		JogadorNaoEncontrado = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.JogadorNaoEncontrado").replaceAll("&", "§");
		ValorPrecisaSerNumero = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.ValorPrecisaSerNumero").replaceAll("&", "§");
		ValorPrecisaSerMaiorQueZero = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.ValorPrecisaSerMaiorQueZero").replaceAll("&", "§");
		RemoveArgumento = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.RemoveArgumento").replaceAll("&", "§");
		ValorRemovido = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.ValorRemovido").replaceAll("&", "§");
		ValorRemovidoMaisDoQueTinha = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.ValorRemovidoMaisDoQueTinha").replaceAll("&", "§");
		MoneyDoJogador = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.MoneyDoJogador").replaceAll("&", "§");
		MoneyDeOutroJogador = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.MoneyDeOutroJogador").replaceAll("&", "§");
		SemPermissao = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.SemPermissao").replaceAll("&", "§");
		SetArgumento = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.SetArgumento").replaceAll("&", "§");
		ValorSetado = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.ValorSetado").replaceAll("&", "§");
		ValorPrecisaSerMaiorOuIgualAZero = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.ValorPrecisaSerMaiorOuIgualAZero").replaceAll("&", "§");
		PayArgumento = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.PayArgumento").replaceAll("&", "§");
		JogadorMoneySuficiente = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.JogadorMoneySuficiente").replaceAll("&", "§");
		JogadorEnviouMoney = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.JogadorEnviouMoney").replaceAll("&", "§");
		JogadorRecebeuMoney = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.JogadorRecebeuMoney").replaceAll("&", "§");
		ToggleArgumento = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.ToggleArgumento").replaceAll("&", "§");
		JogadorAtivouToggle = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.JogadorAtivouToggle").replaceAll("&", "§");
		JogadorDesativouToggle = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.JogadorDesativouToggle").replaceAll("&", "§");
		JogadorNaoEstaRecebendoMoney = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.JogadorNaoEstaRecebendoMoney").replaceAll("&", "§");
		TopFormato = SimpleEconomy.getInstance().getMensagens().getConfig().getString("Mensagens.TopFormato").replaceAll("&", "§");
		TopPrefixo = SimpleEconomy.getInstance().getMensagens().getConfig().getStringList("Mensagens.TopPrefixo");

		TopTamanho = SimpleEconomy.getInstance().getConfig().getInt("Geral.TopTamanho");
	}

}
