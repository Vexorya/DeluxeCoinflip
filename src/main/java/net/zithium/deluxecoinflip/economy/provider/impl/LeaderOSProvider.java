package net.zithium.deluxecoinflip.economy.provider.impl;

import net.leaderos.plugin.api.LeaderOSAPI;
import net.zithium.deluxecoinflip.economy.provider.EconomyProvider;
import org.bukkit.OfflinePlayer;

public class LeaderOSProvider extends EconomyProvider {

    public LeaderOSProvider() {
        super("LeaderOS");
    }

    @Override
    public void onEnable() {
        // No need to do anything here
    }

    @Override
    public double getBalance(OfflinePlayer player) {
        return LeaderOSAPI.getCreditManager().get(player.getName());
    }

    @Override
    public void withdraw(OfflinePlayer player, double amount) {
        LeaderOSAPI.getCreditManager().remove(player.getName(), amount);
    }

    @Override
    public void deposit(OfflinePlayer player, double amount) {
        LeaderOSAPI.getCreditManager().add(player.getName(), amount);
    }

}
