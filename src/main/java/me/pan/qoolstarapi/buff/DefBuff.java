package me.pan.qoolstarapi.buff;

import me.pan.qoolstarapi.PlayerManager;
import me.pan.qoolstarapi.QoolStarAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.UUID;

public class DefBuff implements Listener {

    @EventHandler
    public void onDEF(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            UUID uuid = e.getEntity().getUniqueId();
            e.setDamage((e.getDamage() * getDefMultiplier(uuid)));
        }
    }

    public int getDefMultiplier(UUID uuid) {
        if (!PlayerManager.getPlayerDataHashMap().containsKey(uuid)) {
            return 0;
        }
        int multiplier = (PlayerManager.getProfile(uuid).getDef_Multiplier());
        return multiplier;
    }
}
