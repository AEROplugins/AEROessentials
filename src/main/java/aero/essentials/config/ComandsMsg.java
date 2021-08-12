package aero.essentials.config;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.Arrays;

import static aero.essentials.main.AEROessentials.*;
public class ComandsMsg {

    private File file;
    private FileConfiguration fileConfiguration;

    public ComandsMsg(){
        file = new File(getInstancia().getDataFolder(),"comandsmsg.yml");
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
        if(!file.exists()){
            try{
                file.createNewFile();
                carregarConfigs();
                Bukkit.getConsoleSender().sendMessage("§2[AEROessentials] comandsmsg.yml foi criada com sucesso!");
            }catch (Exception error){
                Bukkit.getConsoleSender().sendMessage("§c[AEROessentials] comandsmsg.yml erro ao criar!");
            }
        }
    }

    public FileConfiguration getConfig() {
        return fileConfiguration;
    }

    public void saveConfig(){
        try{
        fileConfiguration.save(file);
            Bukkit.getConsoleSender().sendMessage("§2[AEROessentials] comandsmsg.yml foi salva com sucesso!");
        }catch (Exception error){
            Bukkit.getConsoleSender().sendMessage("§c[AEROessentials] comandsmsg.yml erro ao salvar!");
        }
    }

    private void carregarConfigs(){
        getConfig().createSection("time-command");
        getConfig().createSection("time-command.menu");
        getConfig().createSection("time-command.item-dia");
        getConfig().createSection("time-command.item-noite");
        getConfig().createSection("time-command.item-colocarchuva");
        getConfig().createSection("time-command.item-tirarchuva");
        getConfig().set("time-command.menu","§6Time set Menu");

        getConfig().set("time-command.sound-ativar",true);
        getConfig().set("time-command.sucesso","&2Tempo mudado Para: %time%");
        getConfig().set("time-command.invalidarg","&cVoce digitou o comando errado ex:/time 6000");
        getConfig().set("time-command.cmdsound","minecraft:entity.villager.yes");
        getConfig().set("time-command.cmdinvalidsound","minecraft:entity.villager.no");
        getConfig().set("time-command.sound-openmenu","minecraft:entity.player.levelup");
        getConfig().set("time-command.sound-dia","minecraft:entity.player.levelup");
        getConfig().set("time-command.sound-noite","minecraft:entity.player.levelup");
        getConfig().set("time-command.sound-colocarchuva","minecraft:entity.player.levelup");
        getConfig().set("time-command.sound-tirarchuva","minecraft:entity.player.levelup");

        getConfig().set("time-command.item-dia.nome","&9&lColocar Dia");
        getConfig().set("time-command.item-dia.lore", Arrays.asList("&2lore1","&3lore2"));
        getConfig().set("time-command.item-noite.nome","&8&lColocar Noite");
        getConfig().set("time-command.item-noite.lore", Arrays.asList("&2lore3","&3lore4"));
        getConfig().set("time-command.item-colocarchuva.nome","&e&lColocar Chuva");
        getConfig().set("time-command.item-colocarchuva.lore",Arrays.asList("&2lore5","&3lore6"));
        getConfig().set("time-command.item-tirarchuva.nome","&e&lTirar Chuva");
        getConfig().set("time-command.item-tirarchuva.lore",Arrays.asList("&2lore7","&3lore8"));
        saveConfig();
    }
}
