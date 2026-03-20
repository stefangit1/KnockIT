package de.sofamann.knockit.main;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.sofamann.knockit.commands.CMD_knock;
import de.sofamann.knockit.events.Cancelled;
import de.sofamann.knockit.events.EntityDamageEvent_E;
import de.sofamann.knockit.events.PlayerJoinEvent_E;
import de.sofamann.knockit.events.PlayerQuitEvent_E;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	public void onEnable() {
		
		plugin= this;
		
		getCommand("knock").setExecutor(new CMD_knock());
		
		PluginManager plm = Bukkit.getPluginManager();
		
		plm.registerEvents(new PlayerJoinEvent_E(), this);
		plm.registerEvents(new Cancelled(), this);
		plm.registerEvents(new EntityDamageEvent_E(), this);
		plm.registerEvents(new PlayerQuitEvent_E(), this);
		
		FileConfiguration config = Main.getPlugin().getConfig();
		Bukkit.getWorld(config.getString("Knock.World")).setDifficulty(Difficulty.PEACEFUL);

	}
	
public static Main getPlugin() {
		
		return plugin;
		
	}

}