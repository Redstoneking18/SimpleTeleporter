package listener;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.metadata.MetadataStore;
import cn.nukkit.metadata.MetadataValue;
import cn.nukkit.network.protocol.PlayerActionPacket;
import cn.nukkit.potion.Effect;
import util.language;
import main.main;

public class Move implements Listener {
    //private main plugin;

    @EventHandler
    public void onJump(DataPacketReceiveEvent e){
     //   this.plugin.getServer().getLogger().info("DataPacket");
        if (e.getPacket() instanceof PlayerActionPacket) {
          //  this.plugin.getServer().getLogger().info("Spieler Packet");
            PlayerActionPacket action = (PlayerActionPacket) e.getPacket();
            if (action.action == PlayerActionPacket.ACTION_JUMP) {
             //   this.plugin.getServer().getLogger().info("Jump");
                Player player = e.getPlayer();
                if(player.hasPermission("simpleteleporter.up")&&(player.getLocation().subtract(0, 1, 0).getLevelBlock().getId()==Block.DAYLIGHT_DETECTOR||player.getLocation().subtract(0, 0, 0).getLevelBlock().getId()==Block.DAYLIGHT_DETECTOR)){
            //        this.plugin.getServer().getLogger().info("JumpPermission");
                    int i = 4;
                    while (i < 20) {
                  //      this.plugin.getServer().getLogger().info("Jump While "+i);
                        double pos = i + 0.0;
                        if (player.getLocation().add(0, pos, 0).getLevelBlock().getId() == Block.DAYLIGHT_DETECTOR) {
                            if (player.getLocation().add(0, i + 1, 0).getLevelBlock().getId() == Block.AIR && player.getLocation().add(0, i + 2, 0).getLevelBlock().getId() == Block.AIR) {
                                player.sendMessage(language.getMessage("teleportet"));
                                player.teleport(player.getLocation().add(0, i, 0));
                            } else {
                                player.sendMessage(language.getMessage("notsave"));
                            }
                            break;
                        }
                        i++;
                        if (i == 20) {
                            player.sendMessage(language.getMessage("noteleporter"));
                        }
                    }
                }
            }
        }
    }
}