package com.example.MCPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EconCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length < 2) {
            commandSender.sendMessage(ChatColor.RED+"Usage: /econ add/remove/show <Player> [Amount]");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "add":
                double bal = 0.0;
                try {
                    bal = Double.parseDouble(args[2]);
                } catch (Exception e) {
                    commandSender.sendMessage(ChatColor.RED+"Amount must be number");
                    return true;
                }
                if (EconManager.hasAc(args[1])) {
                    EconManager.setBalance(args[1], bal + EconManager.getBalance(args[1]));
                } else {
                    EconManager.setBalance(args[1], bal);
                }
                commandSender.sendMessage(ChatColor.GREEN+"Success!");
                break;
            case "remove":
                double toRemove = 0.0;
                try {
                    toRemove = Double.parseDouble(args[2]);
                } catch (Exception e) {
                    commandSender.sendMessage(ChatColor.RED+"Amount must be number");
                    return true;
                }
                if (EconManager.hasAc(args[1])) {
                    if (toRemove > EconManager.getBalance(args[1])) {
                        commandSender.sendMessage(ChatColor.RED+"Remove amount is bigger than user's balance");
                        return true;
                    }
                    EconManager.setBalance(args[1], EconManager.getBalance(args[1]) - toRemove);
                    commandSender.sendMessage(ChatColor.GREEN+"Success!");
                } else {
                    commandSender.sendMessage(ChatColor.RED+"No account found for user");
                    return true;
                }
                break;
            case "show":
                if (EconManager.hasAc(args[1])) {
                    commandSender.sendMessage(ChatColor.GREEN+"User balance: " + EconManager.getBalance(args[1]));
                } else {
                    commandSender.sendMessage(ChatColor.RED+"No account found for user");
                    return true;
                }
                break;
        }
        return true;
    }
}
