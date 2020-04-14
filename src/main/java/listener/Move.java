package listener;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.metadata.MetadataStore;
import cn.nukkit.metadata.MetadataValue;
import cn.nukkit.potion.Effect;
import util.language;
import main.main;

public class Move implements Listener {
    private main plugin;

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        if(player.hasPermission("simpleteleporter.up")&&player.getLocation().subtract(0, 0.2, 0).getLevelBlock().getId()== Block.DAYLIGHT_DETECTOR&&player.getLocation().add(0, 0, 0).getLevelBlock().getId()== Block.AIR){
            int i = 4;
            /*          player.addEffect(Effect.getEffect(Effect.SLOW_FALLING).setVisible(false).setDuration(5).setAmplifier(10));*/
            while (i < 20) {
                double pos = i+0.0;
                if(player.getLocation().add(0, pos,0).getLevelBlock().getId()==Block.DAYLIGHT_DETECTOR) {
                    if (player.getLocation().add(0, i+1, 0).getLevelBlock().getId() == Block.AIR && player.getLocation().add(0, i+2, 0).getLevelBlock().getId() == Block.AIR) {
                        /*player.sendMessage(language.getMessage("teleportet"));*/
                        player.teleport(player.getLocation().add(0, i, 0));
                    } else {
                        player.sendMessage(language.getMessage("notsave"));
                    }
                    break;
                }
                i++;
                if(i==20) {
                    player.sendMessage(language.getMessage("noteleporter"));
                }
            }
        }
    }
}
