package com.Creator.Dfw.runnable;



import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

import com.Creator.Dfw.main;
import com.Creator.Dfw.Scoreboard.sb;


public class sc extends BukkitRunnable{

	@Override
	public void run() {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		List<Player> pl =new ArrayList<>(plugin.getServer().getOnlinePlayers()); 
		for(int i =0;i<pl.size();i++) {
			Player p = pl.get(i);
			for(int n=0;n<main.dfwplayers.size();n++) {
				if(main.dfwplayers.get(n).equals(p)) {
					if(main.gamestart) {
						p.setScoreboard(sb.getplayergamestart(p));
					}else{p.setScoreboard(sb.getplayergamenotstart(p));
						
					}
				}
			}
		
		}
		
	}

}
