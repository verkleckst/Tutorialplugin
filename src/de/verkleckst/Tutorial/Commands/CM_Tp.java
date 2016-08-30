package de.verkleckst.Tutorial.Commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.verkleckst.Tutorial.Hauptklasse;

public class CM_Tp implements CommandExecutor {
	
	HashMap<Player, Long> Cooldown = new HashMap();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		if((!(sender instanceof Player)) || (!p.hasPermission("tutorial.tp")))
		{
			sender.sendMessage(Hauptklasse.prefix + "§7Dir fehlen dazu die §cRechte");
		}
		else if (args.length == 1)
		{
			String Name = args[0];
			if(Bukkit.getPlayer(Name) != null)
			{
				if(this.Cooldown.containsKey(p))
				{
					if (((Long)this.Cooldown.get(p)).longValue() > System.currentTimeMillis())
					{
						p.sendMessage(Hauptklasse.prefix + "§7Du musst leider noch warten!");
						return true;
					}
					this.Cooldown.remove(p);
				}
				Player target = Bukkit.getPlayer(Name);
				p.teleport(target);
				sender.sendMessage(Hauptklasse.prefix + "§7Du hast dich zu §r" + target.getDisplayName() + " §7teleportiert");
				return true;
			}
			sender.sendMessage(Hauptklasse.prefix + "§7Der Spieler ist unbekannt O_o");
		}
		else
		{
			sender.sendMessage(Hauptklasse.prefix + "§7Du meinst doch wohl\n§e§o/tp <spieler>");
			return false;
		}
		
		return false;
	}

}
