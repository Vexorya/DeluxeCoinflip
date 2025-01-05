/*
 * DeluxeCoinflip Plugin
 * Copyright (c) 2021 - 2022 Lewis D (ItsLewizzz). All rights reserved.
 */

package net.zithium.deluxecoinflip.economy.provider;

import org.bukkit.OfflinePlayer;

public abstract class EconomyProvider {

    private final String identifier;
    private String currency;
    private String name;

    public EconomyProvider(String identifier) {
        this.identifier = identifier;
        this.name = identifier;
        this.currency = null;
    }

    public abstract void onEnable();

    public abstract double getBalance(OfflinePlayer player);

    public abstract void withdraw(OfflinePlayer player, double amount);

    public abstract void deposit(OfflinePlayer player, double amount);

    public String getIdentifier() {
        return identifier;
    }

    public void setCurrencyDisplayName(String name) {
        this.name = name;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDisplayName() {
        return name;
    }
}
