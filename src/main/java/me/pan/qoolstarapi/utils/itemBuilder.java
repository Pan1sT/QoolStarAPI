package me.pan.qoolstarapi.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class itemBuilder
{
    private final ItemStack is;

    public itemBuilder(ItemStack is)
    {
        this.is = is;
    }

    public itemBuilder name(String name)
    {
        ItemMeta meta = this.is.getItemMeta();
        meta.setDisplayName(name);
        this.is.setItemMeta(meta);
        return this;
    }

    public itemBuilder lore(String... name)
    {
        return lore(Arrays.asList(name));
    }

    public itemBuilder lore(List<String> name)
    {
        ItemMeta meta = this.is.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new ArrayList();
        }
        lore.addAll(name);
        meta.setLore(lore);
        this.is.setItemMeta(meta);
        return this;
    }

    public ItemStack build()
    {
        return this.is;
    }
}
