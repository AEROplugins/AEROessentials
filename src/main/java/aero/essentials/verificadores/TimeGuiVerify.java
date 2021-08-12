package aero.essentials.verificadores;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import static aero.essentials.main.AEROessentials.*;
public class TimeGuiVerify implements Listener {
    private static final FileConfiguration cmsg = getInstancia().cmsgConfig();
    @EventHandler
    public void aoClickar(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(p.hasPermission("Time.usar") && e.getInventory().getName()
                .equalsIgnoreCase(cmsg.getString("time-command.menu").replace("&","§"))){
            e.setCancelled(true);
            try {
                if (e.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase(cmsg.getString("time-command.item-dia.nome").replace("&", "§"))) {
                    setTime(p,6000,cmsg.getString("time-command.sound-dia"));
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase(cmsg.getString("time-command.item-noite.nome").replace("&", "§"))) {
                    setTime(p,18000,cmsg.getString("time-command.sound-noite"));
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase(cmsg.getString("time-command.item-colocarchuva.nome").replace("&", "§"))) {
                    chuva(p,true,cmsg.getString("time-command.sound-colocarchuva"));
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName()
                        .equalsIgnoreCase(cmsg.getString("time-command.item-tirarchuva.nome").replace("&", "§"))) {
                    chuva(p,true,cmsg.getString("time-command.sound-tirarchuva"));
                }
            }catch (Exception ignored){

            }


        }

    }
    private void setTime(Player p,int time,String sound){
        p.getWorld().setTime(time);
        if(cmsg.getBoolean("time-command.sound-ativar")){
            p.playSound(p.getLocation(),sound,1,1);
        }

    }
    private void chuva(Player p,boolean ativar,String sound){
        p.getWorld().setThundering(ativar);
        if(ativar){
            p.getWorld().setWeatherDuration(200);
        }else{
            p.getWorld().setWeatherDuration(0);
        }
        if(cmsg.getBoolean("time-command.sound-ativar")){
            p.playSound(p.getLocation(),sound,1,1);
        }
    }

}
