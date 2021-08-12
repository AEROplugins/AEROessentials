package aero.essentials.guis;

import aero.essentials.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import static aero.essentials.main.AEROessentials.*;
public class TimeInventory {
    private static final FileConfiguration cmsg = getInstancia().cmsgConfig();
    private Inventory inv;

    public TimeInventory(){
        inv = Bukkit.createInventory(null,9*3,cmsg.getString("time-command.menu").replace("&","§"));
        carregarItems();
    }

    private void carregarItems(){

        ItemStack dia = new Item(Material.WOOL,1,(short) 3)
                .mudarNome(cmsg.getString("time-command.item-dia.nome").replace("&","§"))
                .setLore(cmsg.getStringList("time-command.item-dia.lore"))
                .getItemStack();
        ItemStack noite = new Item(Material.WOOL,1,(short) 15)
                .mudarNome(cmsg.getString("time-command.item-noite.nome").replace("&","§"))
                .setLore(cmsg.getStringList("time-command.item-noite.lore"))
                .getItemStack();
        ItemStack colocarchuva = new Item(Material.WATER_BUCKET,1,(short) 0)
                .mudarNome(cmsg.getString("time-command.item-colocarchuva.nome").replace("&","§"))
                .setLore(cmsg.getStringList("time-command.item-colocarchuva.lore"))
                .getItemStack();
        ItemStack tirarchuva = new Item(Material.BUCKET,1,(short) 0)
                .mudarNome(cmsg.getString("time-command.item-tirarchuva.nome").replace("&","§"))
                .setLore(cmsg.getStringList("time-command.item-tirarchuva.lore"))
                .getItemStack();

        inv.setItem(10,dia);
        inv.setItem(11,noite);
        inv.setItem(14,colocarchuva);
        inv.setItem(15,tirarchuva);
    }

    public Inventory getInv() {
        return inv;
    }
}
