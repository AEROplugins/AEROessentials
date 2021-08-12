package aero.essentials.main;

import aero.essentials.comandos.Time;
import aero.essentials.config.ComandsMsg;
import aero.essentials.server.Login;
import aero.essentials.server.ServerMotd;
import aero.essentials.verificadores.TimeGuiVerify;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public class AEROessentials extends JavaPlugin {

    private static AEROessentials instancia;
    private ComandsMsg cmsg;
    @Override
    public void onEnable() {
        instancia = this;
        carregarConfig();
        cmsg = new ComandsMsg();

        registrarComandos();
        registrarEventos();
    }

    @Override
    public void onDisable() {

    }

    public static AEROessentials getInstancia() {
        return instancia;
    }

    private void carregarConfig(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public FileConfiguration cmsgConfig(){
        return this.cmsg.getConfig();
    }

    private void registrarEventos(){
        Bukkit.getPluginManager().registerEvents(new Login(),this);
        Bukkit.getPluginManager().registerEvents(new ServerMotd(),this);
        Bukkit.getPluginManager().registerEvents(new TimeGuiVerify(),this);
    }
    private void registrarComandos(){
        getCommand("time").setExecutor(new Time());
    }

}
