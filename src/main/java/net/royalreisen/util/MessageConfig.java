package net.royalreisen.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessageConfig {

    private File file = new File("plugins//RoyalMain//Messages.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void setMessages(){
        if(!cfg.contains("Settings")){
            cfg.set("Settings.Prefix", "&2RoyalKingdom &5> &r");
            cfg.set("Settings.PluginStart","&2&lDas Plugin ist Gestartet!");
            cfg.set("Settings.NoPerm", "&4Dazu hast du kein Recht, NEIN EINFACH NEIN!!!");
        }
        if(!cfg.contains("RoyalTravel")){
            cfg.set("RoyalTravel.Reisen.Format", "%reise%, %reise2%");
            cfg.set("RoyalTravel.Reisen.SetReisepunkt", "&2Du hast den Reisepunkt &6%reisepunkt% &2gesetzt!");
            cfg.set("RoyalTravel.Reisen.ReisepunktExistiert", "&4Der Reisepunkt existiert bereits!");
            cfg.set("RoyalTravel.Reisen.ReisePrefix", "Reisepunkte: ");
            cfg.set("RoyalTravel.Reisen.ReisepunktExistiertNicht", "Der Reisepunkt existiert nicht");
            cfg.set("RoyalTravel.Reisen.RemoveReisepunkt", "&4Der Reisepunkt &6&reisepunkt& &4wurde gelöscht!");
            cfg.set("RoyalTravel.Reisen.Gereist", "&2Du bist nach &6%reisepunkt% &2gereist!");
        }
        save();
    }


    private void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
