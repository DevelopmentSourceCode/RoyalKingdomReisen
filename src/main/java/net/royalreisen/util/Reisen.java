package net.royalreisen.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Reisen {

    public Reisen(Location location, String root){
        this.location = location;
        this.root = root;
    }

    public Reisen(String root){
        this.root = root;

    }

    public Reisen(){


    }

    private File file = new File("plugins//RoyalTravel//Reisepunkte.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private String root;
    private Location location;

    private ConfigWerte cw;

    //Location Root
    public void setReisepunkt(){
        String path = "Reisepunkte." + root;
        cfg.set(path + ".world", location.getWorld().getName());
        cfg.set(path + ".x", location.getX());
        cfg.set(path + ".y", location.getY());
        cfg.set(path + ".z", location.getZ());
        cfg.set(path + ".yaw", location.getYaw());
        cfg.set(path + ".pitch", location.getPitch());
        save();
    }

    //Root
    public Location getReisepunkt(){
        String path = "Reisepunkte." + root;
        String world = cfg.getString(path + ".world");
        World w = Bukkit.getWorld(world);
        double x = cfg.getDouble(path + ".x");
        double y = cfg.getDouble(path + ".y");
        double z = cfg.getDouble(path + ".z");
        float yaw = (float)cfg.getDouble(path + ".yaw");
        float pitch = (float)cfg.getDouble(path + ".pitch");

        return new Location(w,x,y,z,yaw,pitch);
    }

    //Root
    public boolean reisepunktExist(){
        if(cfg.contains("Reisepunkte." + root))
            return true;
        return false;
    }

    //Nichts
    public String reisepunkteList(){
        cw = new ConfigWerte();
        ConfigurationSection cs = cfg.getConfigurationSection("Reisepunkte");
        String out = "";
        for(String s : cs.getKeys(false)){
            out = cw.Format.replace("%reise%", s).replace("%reise2%",out);
        }

        out = out.trim();
        out = out.substring(0, out.length() -1);
        if(out != null)
            return out;

        return null;
    }

    //Root
    public void removeReisepunkt(){
        cfg.set("Reisepunkte." + root, null);
        save();
    }

    public void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
