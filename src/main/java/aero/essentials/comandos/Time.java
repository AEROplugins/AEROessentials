package aero.essentials.comandos;

import aero.essentials.guis.TimeInventory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Locale;

import static aero.essentials.main.AEROessentials.*;
public class Time implements CommandExecutor {
    private final FileConfiguration cfg = getInstancia().getConfig();
    private final FileConfiguration cmsg = getInstancia().cmsgConfig();
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        Player p;
        Location local;
        if(s instanceof Player) p = (Player) s;
        else p = null;

        if(p != null) local = p.getLocation();
        else local = null;

        if(p != null && !(p.hasPermission("Time.usar"))){
            p.sendMessage(cfg.getString("server-msg.no-perm")
                    .replace("&","§"));
            p.playSound(local,"minecraft:"+cfg.getString("server-msg.no-perm-sound")
                    .toLowerCase(Locale.ROOT),1,1);
            return false;
        }

        if(args.length < 1){
            if(p == null){
                Bukkit.getConsoleSender().sendMessage("[TIME-COMMAND] time <time> <mundo>");
                return false;
            }
            p.openInventory(new TimeInventory().getInv());
            p.playSound(local,cmsg.getString("time-command.sound-openmenu"),1,1);
        }
        if(args.length == 1){
            if(p == null){
                Bukkit.getConsoleSender().sendMessage("[TIME-COMMAND] time <time> <mundo>");
                return false;
            }
            setTime(p,args,local,null);

        }
        if(args.length == 2){
            setTime(p,args,local,Bukkit.getWorld(args[1]));
        }

        return false;
    }
    private void setTime(Player p,String[] args,Location local,World world){

        try{
            if(world == null) p.getWorld().setTime(Integer.parseInt(args[0]));
            else world.setTime(Integer.parseInt(args[0]));
            if(p != null) p.sendMessage(cmsg.getString("time-command.sucesso")
                    .replace("%time%",""+args[0])
                    .replace("&","§"));
            else Bukkit.getConsoleSender().sendMessage(cmsg.getString("time-command.sucesso")
                    .replace("%time%",""+args[0])
                    .replace("&","§"));
            if(p != null) p.playSound(local,cmsg.getString("time-command.cmdsound"),1,1);
        }catch (Exception error){
            if(p != null) p.sendMessage(cmsg.getString("time-command.invalidarg").replace("&","§"));
            else Bukkit.getConsoleSender().sendMessage(cmsg.getString("time-command.invalidarg").replace("&","§"));
            if(p != null) p.playSound(local,cmsg.getString("time-command.cmdinvalidsound"),1,1);
        }
    }
}
