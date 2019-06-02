package me.pan.qoolstarapi.buff;

import me.pan.qoolstarapi.PlayerManager;
import me.pan.qoolstarapi.QoolStarAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;
import java.util.UUID;

public class CritBuff implements Listener {

    @EventHandler
    public void onCrit(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            UUID uuid = e.getDamager().getUniqueId();
            if (probCrit(uuid)) {
                ((Player) e.getDamager()).sendTitle(ChatColor.YELLOW + "暴撃!", "", 5, 10, 5);
                e.setDamage((e.getDamage() * getCritMultiplier(uuid)));
            }
        }
    }

    public boolean probCrit(UUID uuid) {
        if (!PlayerManager.getPlayerDataHashMap().containsKey(uuid)) {
            return false;
        }
        int prob = PlayerManager.getProfile(uuid).getCrit_Probit();
        if (new Random().nextInt(100) < prob) {
            return true;
        }
        return false;
    }

    public int getCritMultiplier(UUID uuid) {
        if (!PlayerManager.getPlayerDataHashMap().containsKey(uuid)) {
            return 0;
        }
        int multiplier = (PlayerManager.getProfile(uuid).getCrit_Multiplier());
        return multiplier;
    }
}
