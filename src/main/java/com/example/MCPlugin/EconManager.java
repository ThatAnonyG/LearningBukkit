package com.example.MCPlugin;

import java.util.HashMap;

public class EconManager {
    public static HashMap<String, Double> balance = new HashMap<>();

    public static void setBalance(String player, Double newBal) {
        balance.put(player, newBal);
    }

    public static Double getBalance(String player) {
        return balance.get(player);
    }

    public static boolean hasAc(String player) {
        return balance.containsKey(player);
    }
}
