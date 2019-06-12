package net.royalreisen.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class ConfigWerte {

    private File file = new File("plugins//RoyalMain//Messages.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    //Settings
    public final String Prefix = cfg.getString("Settings.Prefix");
    public final String PluginStart = cfg.getString("Settings.PluginStart");
    public final String NoPerm = cfg.getString("Settings.NoPerm");

    //Reisen
    public final String SetReisepunkt = cfg.getString("RoyalTravel.Reisen.SetReisepunkt");
    public final String ReisepunktExistiert = cfg.getString("RoyalTravel.Reisen.ReisepunktExistiert");
    public final String ReisePrefix = cfg.getString("RoyalTravel.Reisen.ReisePrefix");
    public final String ReisepunktExistiertNicht = cfg.getString("RoyalTravel.Reisen.ReisepunktExistiertNicht");
    public final String RemoveReisepunkt = cfg.getString("RoyalTravel.Reisen.RemoveReisepunkt");
    public final String Gereist = cfg.getString("RoyalTravel.Reisen.Gereist");
    public final String Format = cfg.getString("RoyalTravel.Reisen.Format");

    public static void playerMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    public static void consoleMessage(String message){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    public static void broadcastMessage(String message){
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',message));
    }
}
