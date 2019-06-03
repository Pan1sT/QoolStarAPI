package me.pan.qoolstarapi.cmds;

import me.pan.qoolstarapi.PlayerManager;
import me.pan.qoolstarapi.stones.ATK_STONE;
import me.pan.qoolstarapi.utils.command.BaseCommand;
import me.pan.qoolstarapi.utils.command.Command;
import me.pan.qoolstarapi.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class testCMD extends BaseCommand {
    @Command(name = "atk")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        if (args.length == 1){
            switch (args[0]){
                case "1":
                    player.getInventory().addItem(new ATK_STONE().getlv1());
                    player.sendTitle("LV1", "", 5, 10, 5);
                    break;
                case "2":
                    player.getInventory().addItem(new ATK_STONE().getlv2());
                    player.sendTitle("LV2", "", 5, 10, 5);
                    break;
                case "3":
                    player.getInventory().addItem(new ATK_STONE().getlv3());
                    player.sendTitle("LV3", "", 5, 10, 5);
                    break;
                case "4":
                    player.getInventory().addItem(new ATK_STONE().getlv4());
                    player.sendTitle("LV4", "", 5, 10, 5);
                    break;
                default:
                    return;
            }
        }
        if (args.length == 4){
                int atk = Integer.parseInt(args[0]);
                int def = Integer.parseInt(args[1]);
                int crit_prob = Integer.parseInt(args[2]);
                int crit = Integer.parseInt(args[3]);
                PlayerManager.getPlayerDataHashMap().put(player.getUniqueId(), new PlayerManager(player.getUniqueId().toString(), atk, def, crit_prob, crit));
        }
    }
}
