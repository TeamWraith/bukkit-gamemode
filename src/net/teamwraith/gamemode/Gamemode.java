package net.teamwraith.gamemode;

import org.bukkit.plugin.java.JavaPlugin;

public class Gamemode extends JavaPlugin {

	Lobby lobby;
	
	public void onEnable() {
		System.out.println(getServer().getWorlds().size());
		lobby = new Lobby(this);
		lobby.build();
		
		getServer().getPluginManager().registerEvents(new ListenerOnJoin(this), this);
	}
	
}
