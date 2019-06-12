package net.royalreisen.commands;

import net.royalreisen.util.ConfigWerte;
import net.royalreisen.util.Reisen;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReisenCMD implements CommandExecutor {

    private ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        cw = new ConfigWerte();
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 0 && !cmd.getName().equalsIgnoreCase("warps")){

            }
            //setReisepunkt
            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("setReisepunkt")){
                    if(player.hasPermission("rkr.set")) {
                        Reisen reisen = new Reisen(player.getLocation(), args[0]);
                        if (!reisen.reisepunktExist()) {
                            reisen.setReisepunkt();
                            ConfigWerte.playerMessage(player, cw.Prefix + cw.SetReisepunkt.replace("%reisepunkt%",args[0]));
                        } else
                            ConfigWerte.playerMessage(player, cw.Prefix + cw.ReisepunktExistiert);
                    }else
                        ConfigWerte.playerMessage(player, cw.Prefix + cw.NoPerm);
                }
            }
            //reisepunkte
            if(cmd.getName().equalsIgnoreCase("reisen") && args.length == 0){
                Reisen reise = new Reisen();
                ConfigWerte.playerMessage(player,cw.Prefix + cw.ReisePrefix + reise.reisepunkteList());
            }else
            //Reisen
            if(args.length == 1 && cmd.getName().equalsIgnoreCase("reisen")){
                    Reisen reise = new Reisen(args[0]);
                    if(reise.reisepunktExist()){
                        player.teleport(reise.getReisepunkt());
                        ConfigWerte.playerMessage(player, cw.Prefix + cw.Gereist.replace("%reisepunkt%", args[0]));
                    }else
                        ConfigWerte.playerMessage(player,cw.Prefix + cw.ReisepunktExistiertNicht);
                }

            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("delReisepunkt")){
                    if(player.hasPermission("rkr.remove")) {
                        Reisen reise = new Reisen(args[0]);
                        if (reise.reisepunktExist()) {
                            reise.removeReisepunkt();
                            ConfigWerte.playerMessage(player, cw.Prefix + cw.RemoveReisepunkt.replace("%reisepunkt%", args[0]));
                        }
                    }
                }
            }
        }
        return false;
    }
}
