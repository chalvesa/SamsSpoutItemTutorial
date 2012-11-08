package edu.unca.schalvet.TerrainGenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class TerrainGeneratorTowerPopulator extends BlockPopulator {

	public int lowestBlock(Chunk chunk){
		
		int x, y, z, lowest=200;

		
		for(x=0;x<16; ++x){
			for (z=0;z<16;++z){
					for (y=200; chunk.getBlock(x, y, z).getType()== Material.AIR; --y);
					
					  if(lowest>y)
						lowest=y;
				}
			}
		
		return lowest;
	}
	
	
	public void populate(World world, Random random, Chunk chunk) {
		int y = lowestBlock(chunk);
		
		if(y>75){
			int x, z;
	
			int height = y+random.nextInt(20)+10;
			
			//Block block;
			
			for(x=0;x<15; ++x){
				for (z=0;z<15;++z){
					for (int i=0; (y+i)<height; ++i)
						chunk.getBlock(x, y+i, z).setType(Material.COBBLESTONE);
						
						
					}
				}
			
			for(x=0;x<15; ++x){
				if(x%2 == 0)
				for (z=0;z<15;++z){
					if(((z%2 == 0) && (x==0 || x==14)) || ((z==0||z==14)  && (x%2==0)) ){
						chunk.getBlock(x, height, z).setType(Material.COBBLESTONE);
						chunk.getBlock(x, height+1, z).setType(Material.TORCH);
					}
						
					}
				}
		}
	}

}

