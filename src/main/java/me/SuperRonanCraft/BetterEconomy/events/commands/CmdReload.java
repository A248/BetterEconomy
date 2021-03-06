package me.SuperRonanCraft.BetterEconomy.events.commands;

import org.bukkit.command.CommandSender;

public class CmdReload implements EconomyCommand, EconomyCommandHelpable {

    @Override
    public void execute(CommandSender sendi, String label, String[] args) {
        getPl().load(true);
        //for (Player p : Bukkit.getOnlinePlayers())
        getPl().getMessages().getReload(sendi);
    }

    @Override
    public boolean hasPerm(CommandSender sendi) {
        return getPl().getPerms().getReload(sendi);
    }

    @Override
    public String getHelp() {
        return getPl().getMessages().getMessagesHelp().getReload();
    }
}
