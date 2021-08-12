package aero.essentials.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Item {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public Item(Material material,int quantidade,short data){
        itemStack = new ItemStack(material,quantidade,data);
        itemMeta = itemStack.getItemMeta();
    }

    public Item mudarNome(String nome){
        itemMeta.setDisplayName(nome);
        itemStack.setItemMeta(itemMeta);
        return this;
    }
    public Item setLore(List<String> lores){
        itemMeta.setLore(lores);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
