package main;

import cn.nukkit.Player;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import listener.Move;
import listener.Sneak;
import util.language;

import java.util.ArrayList;

public class main extends PluginBase {
    private static main instance;
    ArrayList<Player> Jump;

    @Override
    public void onLoad() {
        instance = this;
        super.onLoad();
    }

    @Override
    public void onEnable() {
        language.init();
        this.getLogger().info(language.getMessage("enable"));
        registerCommends();
        registerListener();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.getLogger().info(language.getMessage("disable"));
        super.onDisable();
    }

    private void registerCommends() {
        SimpleCommandMap commandMap = this.getServer().getCommandMap();
    }

    private void registerListener() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Move(), this);
        pm.registerEvents(new Sneak(), this);
    }

    public static main getInstance() {
        return instance;
    }

    public void addPlayertoJump(Player player) {
        Jump.add(player);
    }

    public void removePlayertoJump(Player player) {
        for(int i = 0; i < Jump.size(); i++) {
            if(Jump.get(i).equals(player)) {
                Jump.remove(i);
                i = Jump.size();
            }
        }
    }
}