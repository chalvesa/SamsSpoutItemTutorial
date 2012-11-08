package edu.unca.schalvet.TerrainGenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class TerrainGeneratorGrassPopulator extends BlockPopulator {


	public void populate(World world, Random random, Chunk chunk) {
		int x, y, z;
		Block block;
		
		for(x=0;x<16; ++x){
			for (z=0;z<16;++z){
				if(random.nextInt(100)<10){
					for (y=100; chunk.getBlock(x, y, z).getType()== Material.AIR; --y);
					
					block = chunk.getBlock(x, y+1, z);
					block.setType(Material.LONG_GRASS);
					block.setData((byte)0x1);
					
					
				}
			}
		}

	}

}
