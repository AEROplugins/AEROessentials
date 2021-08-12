package aero.essentials.server;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Locale;

import static aero.essentials.main.AEROessentials.*;
public class Login implements Listener {

    private final FileConfiguration cfg = getInstancia().getConfig();
    private Player p;

    @EventHandler
    public void aoEntrar(PlayerJoinEvent e){
        p = e.getPlayer();
        if(cfg.getBoolean("playerjoin.ativar-join-msg")) {
            e.setJoinMessage(cfg.getString("playerjoin.join-msg")
                    .replace("%player%",""+p.getName())
                    .replace("&","§"));
        }else e.setJoinMessage(null);
        if(cfg.getBoolean("playerjoin.ativar-join-sound")){
            String sound = "minecraft:"+cfg.getString("playerjoin.join-sound").toLowerCase(Locale.ROOT);
            if (cfg.getBoolean("playerjoin.som-para-todos"))
                Bukkit.getOnlinePlayers().forEach(p -> p.playSound(p.getLocation(), sound, 1, 1));
            else p.playSound(p.getLocation(), sound, 1, 1);
        }


    }

}
