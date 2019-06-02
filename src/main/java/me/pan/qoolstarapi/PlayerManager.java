package me.pan.qoolstarapi;

import lombok.Getter;
import lombok.Setter;
import me.pan.qoolstarapi.files.playerdataFile;

import java.util.HashMap;
import java.util.UUID;

@Getter
@Setter
public class PlayerManager {

    @Getter
    @Setter
    public static HashMap<UUID, PlayerManager> playerDataHashMap = new HashMap<>();
    private String uuid;
    private int Atk_Multiplier;
    private int Def_Multiplier;
    private int Crit_Probit;
    private int Crit_Multiplier;



    public PlayerManager(String uuid, int Atk_Multiplier, int Def_Multiplier, int Crit_Probit, int Crit_Multiplier) {
        this.uuid = uuid;
        this.Atk_Multiplier = Atk_Multiplier;
        this.Def_Multiplier = Def_Multiplier;
        this.Crit_Probit = Crit_Probit;
        this.Crit_Multiplier = Crit_Multiplier;

    }

    public static PlayerManager getProfile(UUID uuid) {
        PlayerManager playerManager = PlayerManager.getPlayerDataHashMap().get(uuid);
        if (playerManager != null) {
            return playerManager;
        }
        playerManager = new PlayerManager(uuid.toString(), 1, 1, 0, 1);
        PlayerManager.getPlayerDataHashMap().put(uuid, playerManager);
        return playerManager;
    }

}
