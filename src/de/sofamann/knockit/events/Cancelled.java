package de.sofamann.knockit.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Cancelled implements Listener {
	
	@EventHandler
	public void onChange(FoodLevelChangeEvent e) {
		
		e.setCancelled(true);
		
		if(e.getEntity().getGameMode() == GameMode.CREATIVE) {
			
			e.setCancelled(false);
			
		}
		
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		
		e.setCancelled(true);
		
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
			
			e.setCancelled(false);
			
		}
		
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		
		e.setCancelled(true);
		
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
			
			e.setCancelled(false);
			
		}		
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		e.setCancelled(true);
		
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
			
			e.setCancelled(false);
			
		}
		
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		
		e.setCancelled(true);
		
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
			
			e.setCancelled(false);
			
		}		
	}
	
	@EventHandler
	public void onSpawn(CreatureSpawnEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onBlock(EntityChangeBlockEvent e) {
		
		e.setCancelled(true);
		
		if(e.getEntity() instanceof Player) {
		
			Player p = (Player) e.getEntity();
		
			if(p.getGameMode() == GameMode.CREATIVE) {
			
				e.setCancelled(false);
			
			}		
		
		}
		
	}
	
	@EventHandler
	public void onChange(WeatherChangeEvent e) {
		
		e.setCancelled(true);
		
	}

}