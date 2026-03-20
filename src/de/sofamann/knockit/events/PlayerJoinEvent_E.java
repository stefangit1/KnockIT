package de.sofamann.knockit.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.sofamann.knockit.main.Main;

public class PlayerJoinEvent_E implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		e.setJoinMessage(null);
		
		FileConfiguration config = Main.getPlugin().getConfig();
		
		if(config.contains("Knock.World")) {
			
			p.setHealth(20);
			p.setFoodLevel(20);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().clear();
			
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
			
			ItemStack itemstack = new ItemStack(Material.STICK);
			ItemMeta itemmeta = itemstack.getItemMeta();
			itemmeta.setDisplayName("§7Knockback Stick");
			itemmeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
			itemstack.setItemMeta(itemmeta);
			p.getInventory().setItem(0, itemstack);
		
		}
		
	}

}