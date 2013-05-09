package net.teamwraith.gamemode;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Lobby {

	Location spawn;
	World world;
	Gamemode mode;
	/**
	 * This includes floor and ceiling.
	 */
	public static int LOBBY_HEIGHT = 5, LOBBY_WIDTH = 7;
	
	public Lobby(Gamemode mode) {
		this.mode = mode;
		System.out.println(mode);
		world = mode.getServer().getWorlds().get(0);
		spawn = world.getSpawnLocation();
		spawn.setY(spawn.getBlockY()+30);
		world.setSpawnLocation(spawn.getBlockX(), spawn.getBlockY(), spawn.getBlockZ());
	}
	
	/**
	 * Builds the lobby.
	 */
	public void build() {
		// TODO: Actually make the damn thing.
	}
}
