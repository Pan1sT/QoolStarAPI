package me.pan.qoolstarapi;

import lombok.Getter;
import lombok.Setter;
import me.pan.qoolstarapi.buff.AtkBuff;
import me.pan.qoolstarapi.buff.CritBuff;
import me.pan.qoolstarapi.buff.DefBuff;
import me.pan.qoolstarapi.cmds.testCMD;
import me.pan.qoolstarapi.events.onJoinQuit;
import me.pan.qoolstarapi.files.playerdataFile;
import me.pan.qoolstarapi.utils.Color;
import me.pan.qoolstarapi.utils.command.CommandFramework;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Setter
@Getter
public final class QoolStarAPI extends JavaPlugin {

    @Getter
    public static QoolStarAPI instance;
    @Getter
    public CommandFramework framework;
    public boolean loadedQRPG = false;
    public playerdataFile playerdataFile;



    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Color.translate("&c[&fQoolStarAPI&c]&2==================================================="));
        register();
        Bukkit.getConsoleSender().sendMessage(Color.translate("&c[&fQoolStarAPI&c]&f>> &5Status: &aEnabled"));
        Bukkit.getConsoleSender().sendMessage(Color.translate("&c[&fQoolStarAPI&c]&f>> &5Version: &6" + this.getDescription().getVersion()));
        Bukkit.getConsoleSender().sendMessage(Color.translate("&c[&fQoolStarAPI&c]&f>> &5Author: &6Pan >.0"));
        Bukkit.getConsoleSender().sendMessage(Color.translate("&c[&fQoolStarAPI&c]&2==================================================="));
    }

    @Override
    public void onDisable() {
        this.getPlayerdataFile().save();
    }

    public void register(){
        instance = this;
        loadFiles();
        loadEvents();
        loadCommands();
    }

    public void loadFiles() {
        long startT = System.currentTimeMillis();
        playerdataFile = new playerdataFile();
        long finishT = System.currentTimeMillis();
        Bukkit.getConsoleSender().sendMessage(Color.translate("&c[&fQoolStarAPI&c]&f>> &9[Files] &eSuccessfully Loaded! &7(TimeUsed: " + (finishT - startT) + " ms)"));
    }

    public void loadEvents() {
        long startT = System.currentTimeMillis();
        Arrays.asList(
                new onJoinQuit(),
                new AtkBuff(),
                new DefBuff(),
                new CritBuff()
        ).forEach(listener -> this.getServer().getPluginManager().registerEvents(listener, this));
        long finishT = System.currentTimeMillis();
        Bukkit.getConsoleSender().sendMessage(Color.translate("&c[&fQoolStarAPI&c]&f>> &9[Events] &eSuccessfully Loaded! &7(TimeUsed: " + (finishT - startT) + " ms)"));
    }

    public void loadCommands() {
        long startT = System.currentTimeMillis();
        framework = new CommandFramework(this);
        new testCMD();
        long finishT = System.currentTimeMillis();
        Bukkit.getConsoleSender().sendMessage(Color.translate("&c[&fQoolStarAPI&c]&f>> &9[Commands] &eSuccessfully Loaded! &7(TimeUsed: " + (finishT - startT) + " ms)"));
    }
}
