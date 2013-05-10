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
	 * Width and height of the lobby. This includes floor, ceiling and walls.
	 */
	public static int LOBBY_HEIGHT = 5, LOBBY_WIDTH = 12;
	
	public Lobby(Gamemode mode) {
		this.mode = mode;
		world = mode.getServer().getWorlds().get(0);
		spawn = world.getSpawnLocation();
		spawn.setY(spawn.getBlockY()+30);
		world.setSpawnLocation(spawn.getBlockX(), spawn.getBlockY(), spawn.getBlockZ());
		System.out.println(spawn);
	}
	
	/**
	 * Builds the lobby.
	 * 
	 * It's so inefficient it's not even funny.
	 */
	public void build() {
		// First we create the cube... 
		for (int x = spawn.getBlockX()-1; x <= LOBBY_WIDTH + spawn.getBlockX(); x++) {
			for (int y = spawn.getBlockY(); y <= LOBBY_HEIGHT + spawn.getBlockY(); y++) {
				for (int z = spawn.getBlockZ()-1; z <= LOBBY_WIDTH + spawn.getBlockZ(); z++) {
					Block block = world.getBlockAt(x, y, z);
					System.out.println("FILL - x: " + x + " y: " + y + " z: " + z);
					block.setType(Material.GLASS);
				}
			}
		}
		
		// ... and then we hollow it out.
		for (int x = spawn.getBlockX(); x <= LOBBY_WIDTH + spawn.getBlockX()-1; x++) {
			for (int y = spawn.getBlockY()+1; y <= LOBBY_HEIGHT + spawn.getBlockY()-1; y++) {
				for (int z = spawn.getBlockZ(); z <= LOBBY_WIDTH + spawn.getBlockZ()-1; z++) {
					Block block = world.getBlockAt(x, y, z);
					System.out.println("HOLLOW - x: " + x + " y: " + y + " z: " + z);
					block.setType(Material.AIR);
				}
			}
		}
	}
}
