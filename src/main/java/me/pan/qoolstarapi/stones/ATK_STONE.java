package me.pan.qoolstarapi.stones;

import de.tr7zw.itemnbtapi.NBTCompound;
import de.tr7zw.itemnbtapi.NBTItem;
import de.tr7zw.itemnbtapi.NBTList;
import me.pan.qoolstarapi.utils.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ATK_STONE implements Stones {

    @Override
    public ItemStack getlv1() {
        ItemStack stone = new ItemStack(Material.END_CRYSTAL);
        //set item name
        ItemMeta im = stone.getItemMeta();
        im.setDisplayName(Color.translate("&a攻擊玄石"));
        stone.setItemMeta(im);
        //new NBT ITEM
        NBTItem nbti = new NBTItem(stone);
        nbti.addCompound("ATK_STONE");
        //set name
        nbti.setString("Name", Color.translate("攻擊玄石LV1"));
        //set tag
        nbti.setString("ATK_STONE", "LV1");
        //set lore
        NBTCompound disp = nbti.addCompound("display");
        NBTList lore = disp.getStringList("Lore");
        lore.add(Color.translate("&e品質: &a黃階"));
        lore.add(Color.translate("&e屬性: &a攻擊力 +3%"));
        //set hide + unbreakable
        nbti.setInteger("HideFlags", 4);
        nbti.setBoolean("Unbreakable", true);
        stone = nbti.getItem();
        return stone;
    }

    @Override
    public ItemStack getlv2() {
        ItemStack stone = new ItemStack(Material.END_CRYSTAL);
        //set item name
        ItemMeta im = stone.getItemMeta();
        im.setDisplayName(Color.translate("&9攻擊玄石"));
        stone.setItemMeta(im);
        //new NBT ITEM
        NBTItem nbti = new NBTItem(stone);
        nbti.addCompound("ATK_STONE");
        //set name
        nbti.setString("Name", Color.translate("攻擊玄石LV2"));
        //set tag
        nbti.setString("ATK_STONE", "LV2");
        //set lore
        NBTCompound disp = nbti.addCompound("display");
        NBTList lore = disp.getStringList("Lore");
        lore.add(Color.translate("&e品質: &9玄階"));
        lore.add(Color.translate("&e屬性: &a攻擊力 +5%"));
        //set hide + unbreakable
        nbti.setInteger("HideFlags", 4);
        nbti.setBoolean("Unbreakable", true);
        stone = nbti.getItem();
        return stone;
    }

    @Override
    public ItemStack getlv3() {
        ItemStack stone = new ItemStack(Material.END_CRYSTAL);
        //set item name
        ItemMeta im = stone.getItemMeta();
        im.setDisplayName(Color.translate("&6攻擊玄石"));
        stone.setItemMeta(im);
        //new NBT ITEM
        NBTItem nbti = new NBTItem(stone);
        nbti.addCompound("ATK_STONE");
        //set name
        nbti.setString("Name", Color.translate("攻擊玄石LV3"));
        //set tag
        nbti.setString("ATK_STONE", "LV3");
        //set lore
        NBTCompound disp = nbti.addCompound("display");
        NBTList lore = disp.getStringList("Lore");
        lore.add(Color.translate("&e品質: &6地階"));
        lore.add(Color.translate("&e屬性: &a攻擊力 +8%"));
        //set hide + unbreakable
        nbti.setInteger("HideFlags", 4);
        nbti.setBoolean("Unbreakable", true);
        stone = nbti.getItem();
        return stone;
    }

    @Override
    public ItemStack getlv4() {
        ItemStack stone = new ItemStack(Material.END_CRYSTAL);
        //set item name
        ItemMeta im = stone.getItemMeta();
        im.setDisplayName(Color.translate("&4攻擊玄石"));
        stone.setItemMeta(im);
        //new NBT ITEM
        NBTItem nbti = new NBTItem(stone);
        nbti.addCompound("ATK_STONE");
        //set NBT name
        nbti.setString("Name", Color.translate("攻擊玄石LV4"));
        //set tag
        nbti.setString("ATK_STONE", "LV4");
        //set lore
        NBTCompound disp = nbti.addCompound("display");
        NBTList lore = disp.getStringList("Lore");
        lore.add(Color.translate("&e品質: &4天階"));
        lore.add(Color.translate("&e屬性: &a攻擊力 +10%"));
        //set hide + unbreakable
        nbti.setInteger("HideFlags", 4);
        nbti.setBoolean("Unbreakable", true);
        stone = nbti.getItem();
        return stone;
    }
}
