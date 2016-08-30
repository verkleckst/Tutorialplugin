package de.verkleckst.Tutorial;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.verkleckst.Tutorial.Commands.CM_Heal;
import de.verkleckst.Tutorial.Commands.CM_Tp;

public class Hauptklasse extends JavaPlugin{
	
	public static String prefix = "§8[§6TutorialPlugin§8] ";
	
	public void onEnable()
	{
		System.out.println("Tutorialplugin by verkleckst");
		System.out.println("Plugin aktiviert");
		
		registerEvents();
	}
	
	public void onDisable()
	{
		System.out.println("Tutorialplugin by verkleckst");
		System.out.println("Plugin deaktiviert");
	}
	
	public void registerEvents()
	{
		PluginManager pm = Bukkit.getPluginManager();
		
		//Events\\
		
		
		//Commands\\
		getCommand("heal").setExecutor(new CM_Heal());
		getCommand("tp").setExecutor(new CM_Tp());
	}
	
}
