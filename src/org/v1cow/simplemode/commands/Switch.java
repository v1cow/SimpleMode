package org.v1cow.simplemode.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Switch
        implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "Console does not have permission to perform this command.");
            return false;
        }
        Inventory inv = Bukkit.createInventory(null, 27, "Select a gamemode.");
        ItemStack creative = nameItem(Material.MOB_SPAWNER, ChatColor.LIGHT_PURPLE + "Creative");
        ItemStack survival = nameItem(Material.DIAMOND_SWORD, ChatColor.RED + "Survival");
        ItemStack adventure = nameItem(Material.IRON_DOOR, ChatColor.GRAY + "Adventure");

        inv.setItem(11, creative);
        inv.setItem(13, survival);
        inv.setItem(15, adventure);
        Player player = (Player)sender;
        player.openInventory(inv);

        return true;
    }

    private ItemStack nameItem(ItemStack item, String name)
    {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack nameItem(Material item, String name)
    {
        return nameItem(new ItemStack(item), name);
    }
}

