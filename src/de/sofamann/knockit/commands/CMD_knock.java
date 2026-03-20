package de.sofamann.knockit.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.sofamann.knockit.main.Main;

public class CMD_knock implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(args.length == 0) {
				
				if(p.hasPermission("ki.*") || p.isOp()) {
					
					p.sendMessage("§7 §7 §7 §e§lKNOCK-IT §7 §7 §7 \n"
							+ " \n"
							+ "§7- /knock §8Zeigt diese Infos \n"
							+ "§7- /knock setspawn §8Setzt den Spawnpunkt \n"
							+ "§7- /knock setbase §8Setzt die Basis \n"
							+ " ");
					
					Location loc = p.getLocation();
					Sound sound = Sound.LEVEL_UP;
					p.playSound(loc, sound, 100, (float) 1.0);
					
				} else {
					
					p.sendMessage("§7[§eKnockIT§7] Du hast nicht genügend Berechtigung!");
					
					Location loc = p.getLocation();
					Sound sound = Sound.NOTE_BASS;
					p.playSound(loc, sound, 100, (float) 1.0);
					
				}
			
			} else if(args[0].equals("setspawn")) {
				
				if(p.hasPermission("ki.setspawn") || p.hasPermission("ki.*") || p.isOp()) {
					
					FileConfiguration config = Main.getPlugin().getConfig();
					config.set("Knock.World", p.getWorld().getName());
					config.set("Knock.X", p.getLocation().getX());
					config.set("Knock.Y", p.getLocation().getY());
					config.set("Knock.Z", p.getLocation().getZ());
					config.set("Knock.Yaw", p.getLocation().getYaw());
					config.set("Knock.Pitch", p.getLocation().getPitch());
					Main.getPlugin().saveConfig();
					
					p.sendMessage("§7[§eKnockIT§7] Der Spawnpunkt wurde gesetzt!");
					
					Location loc = p.getLocation();
					Sound sound = Sound.LEVEL_UP;
					p.playSound(loc, sound, 100, (float) 1.0);
					
				} else {
					
					p.sendMessage("§7[§eKnockIT§7] Du hast nicht genügend Berechtigung!");
					
					Location loc = p.getLocation();
					Sound sound = Sound.NOTE_BASS;
					p.playSound(loc, sound, 100, (float) 1.0);
					
				} 
				
			}  else {
				
				p.sendMessage("§7[§eKnockIT§7] Der Befehl wurde nicht gefunden!");
				
				Location loc = p.getLocation();
				Sound sound = Sound.NOTE_BASS;
				p.playSound(loc, sound, 100, (float) 1.0);
				
			}
			
		}
		return false;
	}

}