package de.sofamann.knockit.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEvent_E implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		e.setQuitMessage(null);
		
	}

}