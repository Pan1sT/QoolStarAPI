package me.pan.qoolstarapi.events;

import me.pan.qoolstarapi.PlayerManager;
import me.pan.qoolstarapi.QoolStarAPI;
import me.pan.qoolstarapi.files.playerdataFile;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class onJoinQuit implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        getData(uuid);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        saveData(uuid);
    }


    public void saveData(UUID uuid) {
        PlayerManager playerManager = PlayerManager.getProfile(uuid);
        playerdataFile.getInstance().getConfiguration().set("PlayerData." + uuid.toString() + ".Atk_Multiplier", playerManager.getAtk_Multiplier());
        playerdataFile.getInstance().getConfiguration().set("PlayerData." + uuid.toString() + ".Def_Multiplier", playerManager.getDef_Multiplier());
        playerdataFile.getInstance().getConfiguration().set("PlayerData." + uuid.toString() + ".Crit_Probit", playerManager.getCrit_Probit());
        playerdataFile.getInstance().getConfiguration().set("PlayerData." + uuid.toString() + ".Crit_Multiplier", playerManager.getCrit_Multiplier());
        playerdataFile.getInstance().save();
        PlayerManager.getPlayerDataHashMap().remove(uuid);
    }


    public void getData(UUID uuid) {
        //無紀錄新玩家
        if ( (playerdataFile.getInstance().getConfiguration().getConfigurationSection("PlayerData") == null )
        || (!playerdataFile.getInstance().getConfiguration().getConfigurationSection("PlayerData").contains(uuid.toString())) ) {
            Bukkit.broadcastMessage(playerdataFile.getInstance().getInt("PlayerData." + uuid.toString() + ".Atk_Multiplier") + "");
            int Atk_Multiplier = 1;
            int Def_Multiplier = 1;
            int Crit_Probit = 0;
            int Crit_Multiplier = 1;
            playerdataFile.getInstance().getConfiguration().set("PlayerData." + uuid.toString() + ".Atk_Multiplier", Atk_Multiplier);
            playerdataFile.getInstance().getConfiguration().set("PlayerData." + uuid.toString() + ".Def_Multiplier", Def_Multiplier);
            playerdataFile.getInstance().getConfiguration().set("PlayerData." + uuid.toString() + ".Crit_Probit",Crit_Probit);
            playerdataFile.getInstance().getConfiguration().set("PlayerData." + uuid.toString() + ".Crit_Multiplier", Crit_Multiplier);
            playerdataFile.getInstance().save();
            PlayerManager.getPlayerDataHashMap().put(uuid, new PlayerManager(uuid.toString(), Atk_Multiplier, Def_Multiplier, Crit_Probit, Crit_Multiplier));
            return;
        }
        PlayerManager playerManager = PlayerManager.getProfile(uuid);
        int Atk_Multiplier = playerdataFile.getInstance().getInt("PlayerData." + uuid.toString() + ".Atk_Multiplier");
        int Def_Multiplier = playerdataFile.getInstance().getInt("PlayerData." + uuid.toString() + ".Def_Multiplier");
        int Crit_Probit = playerdataFile.getInstance().getInt("PlayerData." + uuid.toString() + ".Crit_Probit");
        int Crit_Multiplier = playerdataFile.getInstance().getInt("PlayerData." + uuid.toString() + ".Crit_Multiplier");
        PlayerManager.getPlayerDataHashMap().put(uuid, new PlayerManager(uuid.toString(), Atk_Multiplier, Def_Multiplier, Crit_Probit, Crit_Multiplier));

    }
}
