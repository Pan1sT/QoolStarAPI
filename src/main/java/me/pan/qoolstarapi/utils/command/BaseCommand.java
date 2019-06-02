package me.pan.qoolstarapi.utils.command;

import me.pan.qoolstarapi.QoolStarAPI;

public abstract class BaseCommand {

    public QoolStarAPI main = QoolStarAPI.getInstance();

    public BaseCommand() {
        main.getFramework().registerCommands(this);
    }

    public abstract void onCommand(CommandArgs command);

}
