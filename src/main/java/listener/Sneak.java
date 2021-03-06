package listener;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.event.player.PlayerToggleSneakEvent;
import main.main;
import util.language;

public class Sneak implements Listener {
    private main plugin;

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e){
        Player player = e.getPlayer();
       // this.plugin.getServer().getLogger().info("SNEAK");
        if(((!player.isSneaking())&&player.hasPermission("simpleteleporter.down")&&player.getLocation().subtract(0, 0, 0).getLevelBlock().getId()==Block.DAYLIGHT_DETECTOR)){
         //   this.plugin.getServer().getLogger().info("Berechnitung Sneak");
            int i = 4;
            while (i < 20) {
            //    this.plugin.getServer().getLogger().info("While "+i);
                double pos = i+0.0;
                if(player.getLocation().subtract(0, pos,0).getLevelBlock().getId()==Block.DAYLIGHT_DETECTOR) {
                    if (player.getLocation().subtract(0, i-1, 0).getLevelBlock().getId() == Block.AIR && player.getLocation().subtract(0, i-2, 0).getLevelBlock().getId() == Block.AIR) {
                        player.sendMessage(language.getMessage("teleportet"));
                        player.teleport(player.getLocation().subtract(0, i, 0));
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