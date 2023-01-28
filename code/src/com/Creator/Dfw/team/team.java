package com.Creator.Dfw.team;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.Creator.Dfw.color;
import com.Creator.Dfw.main;

public class team {
	
	public static String getnameontab(Player p) {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		ChatColor c = team.getteamcolor(p).getChatColor();
		
		return plugin.getConfig().getString("nameontab").replace("{teamcolor}",c.toString()).replace("{playername}",p.getName());
	}
	public static teamcolor getteamcolor(Player p) {
		ArrayList<Player> pl =main.dfwplayers;
		for(int i = 0 ; i<pl.size();i++) {
			if(pl.get(i).equals(p)) {
				return main.team_color.get(i);
				
			}
			}
		return null;
		
	}
	public static Boolean setplayertoteam(Player p ,String tc) {
		ArrayList<Player> pl =main.dfwplayers;
		for(int i = 0 ; i<pl.size();i++) {
			if(pl.get(i).equals(p)) {
				teamcolor t = teamcolor.valueOf(tc);
				List<teamcolor> temp = main.team_color;
				for(int n = 0;n<temp.size();n++) {
					if(temp.get(i)!=null) {
						if(temp.get(i).equals(t)) {
							return false;
						}
					}
				}
				main.team_color.set(i,teamcolor.valueOf(tc));
				p.sendMessage(main.team_color.get(i).toString());
				p.setPlayerListName( color.color(team.getnameontab(p)));
				return true;
			}
		}
		return false;
	}
}
