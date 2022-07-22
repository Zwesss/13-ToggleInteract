package dev.tim.interacttutorial.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ToggleFlyListener implements Listener {

    private List<UUID> enabled = new ArrayList<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getItem() != null){
                if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Vliegen")){
                    if(player.hasPermission("toggle.fly")){
                        if(enabled.contains(uuid)){
                            player.setAllowFlight(false);
                            enabled.remove(uuid);
                            player.sendMessage(ChatColor.RED + "Vliegen staat uit!");
                        } else {
                            player.setAllowFlight(true);
                            enabled.add(uuid);
                            player.sendMessage(ChatColor.GREEN + "Vliegen staat aan!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Je hebt geen permissie om te vliegen!");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        UUID uuid = e.getPlayer().getUniqueId();
        enabled.remove(uuid);
    }

}
