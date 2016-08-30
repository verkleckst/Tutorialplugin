package de.verkleckst.Tutorial.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.verkleckst.Tutorial.Hauptklasse;

public class CM_Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		
		Player p = (Player)sender;
		
		if((sender instanceof Player))
		{
			p.setHealth(20D);
			p.setHealthScale(20D);
			p.setFoodLevel(20);
			p.sendMessage(Hauptklasse.prefix + "§7Du wurdest von §e" + sender.getName() + " §cgeheilt§7!");
		}
		
		return true;
	}

}
