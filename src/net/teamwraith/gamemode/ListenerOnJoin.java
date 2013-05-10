package net.teamwraith.gamemode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerOnJoin implements Listener {

	Gamemode mode;
	
	public ListenerOnJoin(Gamemode mode) {
		this.mode = mode;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().teleport(mode.getServer().getWorlds().get(0).getSpawnLocation().add(2, 2, 2));
	}
	
}
