package org.v1cow.simplemode;

import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.v1cow.simplemode.commands.Switch;
import org.v1cow.simplemode.listeners.InventoryClick;


public class SimpleMode
        extends JavaPlugin
{

    public void onEnable()
    {
        registerCommands();
        registerEvents();
    }

    public void onDisable() {

    }

    public void registerCommands()
    {
        getCommand("switch").setExecutor(new Switch());
    }

    public void registerEvents()
    {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryClick(), this);
    }
}
