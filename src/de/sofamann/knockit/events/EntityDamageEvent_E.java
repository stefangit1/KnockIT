package de.sofamann.knockit.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import de.sofamann.knockit.main.Main;

public class EntityDamageEvent_E implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		
		if(e.getEntity() instanceof Player) {
			
			Player p = (Player) e.getEntity();
		
			FileConfiguration config = Main.getPlugin().getConfig();
		
			e.setCancelled(true);
		
			if(e.getCause() == DamageCause.VOID) {
			
				World world = Bukkit.getWorld(config.getString("Knock.World"));
				double x = config.getDouble("Knock.X");
				double y = config.getDouble("Knock.Y");
				double z = config.getDouble("Knock.Z");
				float yaw = (float) config.getDouble("Knock.Yaw");
				float pitch = (float) config.getDouble("Knock.Pitch");
				Location location = new Location(world, x, y, z, yaw, pitch);
				p.teleport(location);
	
				Location loc = p.getLocation();
				Sound sound = Sound.EXPLODE;
				p.playSound(loc, sound, 100, (float) 1.0);
			
			} else if(e.getCause() == DamageCause.ENTITY_ATTACK) {
		
				if(p.getLocation().getY() < config.getDouble("Knock.Y") - 5) {
							
					e.setCancelled(false);
					p.setHealth(20);
		
				}
		
			} else if(e.getCause() == DamageCause.FALL) {
				
				e.setCancelled(true);
				
			}
		
		}
		
	}

}