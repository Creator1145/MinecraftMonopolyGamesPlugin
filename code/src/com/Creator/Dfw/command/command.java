package com.Creator.Dfw.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.Creator.Dfw.color;
import com.Creator.Dfw.main;

import com.Creator.Dfw.Scoreboard.sb;
import com.Creator.Dfw.gui.MortgageGui;
import com.Creator.Dfw.pointlx.house;
import com.Creator.Dfw.team.team;
import com.Creator.Dfw.team.teamcolor;

public class command implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lagel, String[] args) {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		if(cmd.getName().equalsIgnoreCase("dfw")) {
		if(!(sender instanceof Player) ) {
			if(args.length == 0) {
				Bukkit.getConsoleSender().sendMessage("¡ìb¡ìl===============[¡ìe¡ìlDFW¡ìb¡ìl]===============");
				Bukkit.getConsoleSender().sendMessage("          ");
				Bukkit.getConsoleSender().sendMessage(color.color("                &f&lVer:&e&l1.0.0"));
				Bukkit.getConsoleSender().sendMessage("         ");
				Bukkit.getConsoleSender().sendMessage(color.color("              &f&lBy:&e&lCreator                   "));
				Bukkit.getConsoleSender().sendMessage("    ");
				Bukkit.getConsoleSender().sendMessage("¡ìb¡ìl===============[¡ìe¡ìlDFW¡ìb¡ìl]===============");
			    return true;
			}
			if(args.length == 1 && args[0].equals("reload") ) {
				
				plugin.reloadConfig();
				return true;
			}
		}else {
			Player p = (Player)sender;
			if(args.length == 0 && p.isOp()) {
				p.sendMessage("¡ìb¡ìl===============[¡ìe¡ìlDFW¡ìb¡ìl]===============");
				p.sendMessage("          ");
			    p.sendMessage(color.color("                &f&lVer:&e&l1.0.0"));
				p.sendMessage("         ");
				p.sendMessage(color.color("              &f&lBy:&e&lCreator                     "));
				p.sendMessage("    ");
				p.sendMessage("¡ìb¡ìl===============[¡ìe¡ìlDFW¡ìb¡ìl]===============");
				return true;
			}
			if(args.length == 1 && args[0].equals("setresourcepack") ) {
			System.out.print(plugin.getConfig().getString("resourcepack.url"));
				p.setResourcePack(plugin.getConfig().getString("resourcepack.url"));
			}
			if(args.length == 1 && args[0].equals("help") && p.isOp()) {

				p.sendMessage("¡ìb¡ìl===============[¡ìe¡ìlElevator¡ìb¡ìl]===============");
				p.sendMessage(" ");
				p.sendMessage("  ");
				p.sendMessage("¡ìb¡ìl===============[¡ìe¡ìlElevator¡ìb¡ìl]===============");
				return true;
				

			}
			if(args.length == 1 && args[0].equals("addstartplayer") && p.isOp()) {
				p.setAllowFlight(false);
				p.getInventory().clear();
				main.dfwplayers.add(p);
				main.team_color.add(null);
			}
			if(args.length == 3 && args[0].equals("addpoint") && p.isOp()) {
				main.setpoint(p.getLocation(), args[1],args[2]);
				return true;
			}
			if(args.length == 2 && args[0].equals("setgameenable") && p.isOp()) {
				if(args[1].equals("false")) {
					plugin.getConfig().set("game_enable",false);
					plugin.saveConfig();
					plugin.getServer().shutdown();
					return true;
				}
				if(args[1].equals("true")) {
					plugin.getConfig().set("game_enable",true);
					plugin.saveConfig();
					plugin.getServer().shutdown();
					return true;
				}
				return false;
			}
			if(args.length == 1 && args[0].equals("getpointtool") && p.isOp()) {
				p.getInventory().addItem(main.getitem(4));
			}
			if(args.length == 1 && args[0].equals("reload") && p.isOp()) {
		
				plugin.reloadConfig();
				return true;
			}
			if(args.length == 2 && args[0].equals("cs") && p.isOp()) {
				main.forward(main.sti(args[1]), p);
			}
			if(args.length == 1 && args[0].equals("cs") && p.isOp()) {
			//	 for(int n = 0;n<main.point.size();n++) {
					// System.out.print(((house) main.point.get(n).getlx()).getdqhouse());
				// }
				MortgageGui .open(p);
				//main.nextstate();
				//main.setpoint(p.getLocation(), args[1],args[2]);
			//main.spwanPlayer(p, p.getLocation());
			//main.forward(main.sti(args[1]), p);
//p.openInventory(new house("house").dinv(0));
			/*	ItemStack is =new ItemStack(Material.IRON_PICKAXE,1);
				ItemMeta im =is.getItemMeta();
				im.setDisplayName("µãÎ»²Ù×÷");
				List<String> l = new ArrayList<String>();
				l.add("qwq");
				im.setLore(l);
				is.setItemMeta(im);
				plugin.getConfig().set("pointczitem", is);
				plugin.saveConfig();*/
			//main.nextplayer();
			//p.sendMessage(main.its(main.sz(p)));
			//main.sz(p,"forward");
		//	p.setScoreboard(sb.getplayergamenotstart(p));
		p.setItemInHand(main.getitem(6));
			}
			if(args.length == 1 && args[0].equals("addsp") && p.isOp()) {
				p.setAllowFlight(false);
				p.getInventory().clear();
				main.dfwspectator.add(p);
			}
			if(args.length == 2 && args[0].equals("setteam_color") && p.isOp()) {
				team.setplayertoteam(p, args[1]);
			}
			}
		}
		return false;
		}
	}
		
	
		
		
