package net.zithium.deluxecoinflip.economy.provider.impl;

import net.zithium.deluxecoinflip.economy.provider.EconomyProvider;
import org.bukkit.OfflinePlayer;
import su.nightexpress.coinsengine.api.CoinsEngineAPI;
import su.nightexpress.coinsengine.api.currency.Currency;

public class CoinsEngineProvider extends EconomyProvider {

    private Currency currency;

    public CoinsEngineProvider() {
        super("CoinsEngine");
    }

    @Override
    public void onEnable() {
        if (getCurrency() == null) {
            currency = CoinsEngineAPI.getCurrencyManager().getVaultCurrency().orElse(null);
        } else {
            currency = CoinsEngineAPI.getCurrency(getCurrency());
        }
    }

    @Override
    public double getBalance(OfflinePlayer player) {
        return CoinsEngineAPI.getBalance(player.getUniqueId(), currency);
    }

    @Override
    public void withdraw(OfflinePlayer player, double amount) {
        CoinsEngineAPI.removeBalance(player.getUniqueId(), currency, amount);
    }

    @Override
    public void deposit(OfflinePlayer player, double amount) {
        CoinsEngineAPI.addBalance(player.getUniqueId(), currency, amount);
    }

}
