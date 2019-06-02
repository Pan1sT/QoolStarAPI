package me.pan.qoolstarapi.buff;

import me.pan.qoolstarapi.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.UUID;

public class AtkBuff implements Listener {

    @EventHandler
    public void onATK(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            UUID uuid = e.getDamager().getUniqueId();
            e.setDamage((e.getDamage() * getAtkMultiplier(uuid)));
            Bukkit.broadcastMessage("攻擊加成: " + PlayerManager.getProfile(uuid).getAtk_Multiplier());
            Bukkit.broadcastMessage("防禦加成: " + PlayerManager.getProfile(uuid).getDef_Multiplier());
            Bukkit.broadcastMessage("暴撃機率: " + PlayerManager.getProfile(uuid).getCrit_Probit());
            Bukkit.broadcastMessage("暴撃加成: " + PlayerManager.getProfile(uuid).getCrit_Multiplier());
        }
    }

    public int getAtkMultiplier(UUID uuid) {
        if (!PlayerManager.getPlayerDataHashMap().containsKey(uuid)) {
            return 0;
        }
        int multiplier = (PlayerManager.getProfile(uuid).getAtk_Multiplier());
        return multiplier;
    }

}
