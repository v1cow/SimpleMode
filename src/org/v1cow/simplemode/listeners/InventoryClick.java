package org.v1cow.simplemode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick
        implements Listener
{
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        Inventory inv = event.getInventory();
        if (!inv.getTitle().equals("Select a gamemode.")) {
            return;
        }
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        Player player = (Player)event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        if (item.getType() == Material.MOB_SPAWNER)
        {
            if (player.hasPermission("simplemode.creative"))
            {
                player.setGameMode(GameMode.CREATIVE);
            }
            if (!player.hasPermission("simplemode.creative")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this action.");
            }
        }
        if (item.getType() == Material.DIAMOND_SWORD)
        {
            if (player.hasPermission("simplemode.survival"))
            {
                player.setGameMode(GameMode.SURVIVAL);
            }
            if (!player.hasPermission("simplemode.survival")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this action.");
            }
        }
        if (item.getType() == Material.IRON_DOOR)
        {
            if (player.hasPermission("simplemode.adventure"))
            {
                player.setGameMode(GameMode.ADVENTURE);
                player.getWorld().playSound(player.getLocation(), Sound.ZOMBIE_HURT, 1.0F, 1.0F);
            }
            if (!player.hasPermission("simplemode.adventure")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this action.");
            }
        }
        event.setCancelled(true);
        player.closeInventory();
    }
}
