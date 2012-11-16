package edu.unca.schalvet.SamsSpoutBlockTutorial;

import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class EyeBlock extends GenericCubeCustomBlock {
	public EyeBlock(Plugin plugin) {
		super(plugin, "TestBlock",
				"http://joe.cs.unca.edu/~chalvesa/dice2.png", 16);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z,
			int changedId) {
	}

	@Override
	public void onBlockPlace(World world, int x, int y, int z) {
	}

	@Override
	public void onBlockPlace(World world, int x, int y, int z,
			LivingEntity living) {
	}

	@Override
	public void onBlockDestroyed(World world, int x, int y, int z) {
	}

	@Override
	public boolean onBlockInteract(World world, int x, int y, int z,
			SpoutPlayer player) {
		return true;
	}

	@Override
	public void onEntityMoveAt(World world, int x, int y, int z, Entity entity) {
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z,
			SpoutPlayer player) {
	}

	@Override
	public boolean isProvidingPowerTo(World world, int x, int y, int z,
			BlockFace face) {
		return false;
	}

	@Override
	public boolean isIndirectlyProvidingPowerTo(World world, int x, int y,
			int z, BlockFace face) {
		return false;
	}
}