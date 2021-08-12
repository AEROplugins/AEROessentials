package aero.essentials.server;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.Random;

import static aero.essentials.main.AEROessentials.*;
public class ServerMotd implements Listener {
    private final FileConfiguration cfg = getInstancia().getConfig();
    Random random = new Random();

    @EventHandler
    public void serverMotd(ServerListPingEvent e){
        if(cfg.getBoolean("servermotd.ativar-motd")) {
            int i = random.nextInt(cfg.getStringList("servermotd.motd").size());
            int i2 = random.nextInt(cfg.getStringList("servermotd.whitelist").size());
            if(cfg.getBoolean("servermotd.ativar-motd"))
                e.setMotd(cfg.getStringList("servermotd.motd").get(i).replace("&","§"));
            if(cfg.getBoolean("servermotd.ativar-whitelistmotd") && Bukkit.hasWhitelist())
                e.setMotd(cfg.getStringList("servermotd.whitelist").get(i2).replace("&","§"));
        }
        if(cfg.getBoolean("servermotd.ativar-fakeslot"))
            e.setMaxPlayers(cfg.getInt("servermotd.fake-slot"));
        if(cfg.getBoolean("servermotd.ativar-whitelistfakeslot") && Bukkit.hasWhitelist())
            e.setMaxPlayers(cfg.getInt("servermotd.whitelist-slot"));
    }

}
