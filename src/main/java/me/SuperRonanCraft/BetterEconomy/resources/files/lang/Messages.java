package me.SuperRonanCraft.BetterEconomy.resources.files.lang;

import me.SuperRonanCraft.BetterEconomy.BetterEconomy;
import me.SuperRonanCraft.BetterEconomy.resources.files.FileLangs;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Messages {

    private final String preM = "Messages.";
    private MessagesHelp messagesHelp = new MessagesHelp(this);
    private MessagesUsage messagesUsage = new MessagesUsage(this);

    public MessagesHelp getMessagesHelp() {
        return messagesHelp;
    }

    public MessagesUsage getMessagesUsage() {
        return messagesUsage;
    }

//MESSAGES
    public void errorConsole(String label) {
        getPl().getLogger().severe("Console cannot do this! Type '/{0} help'".replace("{0}", label));
    }

    public void getBalance(CommandSender sendi, Double bal) {
        sms(sendi, getLang().getString(preM + "Balance").replace("{0}", String.valueOf(bal)));
    }

    public void getReload(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Reload"));
    }

    //PROCESSING
    public void sms(CommandSender sendi, String msg) {
        if (!msg.equals(""))
            sendi.sendMessage(colorPre(msg));
    }

    public void sms(CommandSender sendi, List<String> msg) {
        if (msg != null && !msg.isEmpty())
            try {
                msg.forEach(s -> msg.set(msg.indexOf(s), colorPre(s)));
                sendi.sendMessage(msg.toArray(new String[0]));
            } catch (NullPointerException e) {
                sendi.sendMessage(colorPre("&cWhoops! Seems like the server owner didn't update their " +
                        "messages file! Please contact an admin for help!"));
            }
    }

    private String getPrefix() {
        return getLang().getString(preM + "Prefix");
    }

    public String colorPre(String str) {
        return color(str.replace("%prefix%", getPrefix()));
    }

    public String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    FileLangs getLang() {
        return getPl().getFiles().getLang();
    }

    private BetterEconomy getPl() {
        return BetterEconomy.getInstance();
    }
}