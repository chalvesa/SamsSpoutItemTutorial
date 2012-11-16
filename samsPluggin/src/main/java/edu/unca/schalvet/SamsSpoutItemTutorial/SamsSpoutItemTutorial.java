package edu.unca.schalvet.SamsSpoutItemTutorial;

import java.util.logging.Level;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;

/*
 * This is the main class of the sample plug-in
 */
public class SamsSpoutItemTutorial extends JavaPlugin {
	public TestItem frisbee;
	public SamsSpoutItemTutorialCommandExecutor executor;

	/*
	 * This is called when your plug-in is enabled
	 */
	@Override
	public void onEnable() {

		// from Spout tutorial
		SpoutManager.getFileManager().addToPreLoginCache(this,
				"http://joe.cs.unca.edu/~chalvesa/frisbee.png");
		frisbee = new TestItem(this, "Frisbee",
				"http://joe.cs.unca.edu/~chalvesa/frisbee.png");
		addQuaffleRecipe();

		getLogger().log(Level.INFO, "[Spout Item Test Plugin] Enabled!");

		// save the configuration file
		saveDefaultConfig();

		// Create the SampleListener
		new SamsSpoutItemTutorialListener(this);

		// set the command executor for sample
		executor = new SamsSpoutItemTutorialCommandExecutor(this);
		this.getCommand("message").setExecutor(executor);
		this.getCommand("changeMe").setExecutor(executor);
		this.getCommand("changeMeBack").setExecutor(executor);
	}

	/*
	 * This is called when your plug-in shuts down
	 */
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		getLogger().log(Level.INFO, "[Spout Item Test Plugin] Disabled");
	}

	public void addQuaffleRecipe() {
		SpoutItemStack item = new SpoutItemStack(frisbee, 1);
		SpoutShapedRecipe recipe = new SpoutShapedRecipe(item);
		recipe.shape("XXX", "XOX", "XXX");// top : middle : bottom
		recipe.setIngredient('X', MaterialData.clay);
		recipe.setIngredient('O', MaterialData.redWool);
		SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
	}

}
