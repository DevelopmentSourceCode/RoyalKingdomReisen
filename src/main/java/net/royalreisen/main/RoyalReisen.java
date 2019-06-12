package net.royalreisen.main;

import net.royalreisen.commands.ReisenCMD;
import net.royalreisen.util.ConfigWerte;
import net.royalreisen.util.MessageConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class RoyalReisen extends JavaPlugin {

    private MessageConfig mc;
    private ConfigWerte cw;

    @Override
    public void onEnable() {
        mc = new MessageConfig();
        mc.setMessages();
        cw = new ConfigWerte();
        ConfigWerte.consoleMessage("     ");
        ConfigWerte.consoleMessage(cw.Prefix + cw.PluginStart);
        ConfigWerte.consoleMessage("     ");
        registerCommands();
    }

    private void registerCommands() {
        getCommand("setReisepunkt").setExecutor(new ReisenCMD());
        getCommand("reisen").setExecutor(new ReisenCMD());
        getCommand("delReisepunkt").setExecutor(new ReisenCMD());
    }
}
