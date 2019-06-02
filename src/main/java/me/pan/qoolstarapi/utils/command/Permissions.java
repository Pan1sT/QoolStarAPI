package me.pan.qoolstarapi.utils.command;

import org.bukkit.entity.Player;

public class Permissions {

    public static String adminPerms = "";
    public static String playerPerms = "";

    public static boolean checkAdmin(Player p){
        if (p.hasPermission(adminPerms) || p.isOp()){
            return true;
        }else{
            return false;
        }
    }
}
