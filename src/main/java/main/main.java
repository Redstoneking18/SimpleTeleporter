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
        registerlistener();
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

    private void registerlistener(){
        getServer().getPluginManager().registerEvents(new Move(), this);
        getServer().getPluginManager().registerEvents(new Sneak(), this);
    }

    public static main getInstance() {
        return instance;
    }
}