package com.Creator.Dfw.runnable;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.Creator.Dfw.color;
import com.Creator.Dfw.main;
import com.Creator.Dfw.staticevent.DfwgamestartEvent;


public class time extends BukkitRunnable{

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		
		if(main.dfwplayers.size()>=plugin.getConfig().getInt("playerint")) {
			if(main.starttime==0) {
				main.gamestart=true;
				 
				 Bukkit.getPluginManager().callEvent(new DfwgamestartEvent());
				ArrayList<Player> pl = main.dfwplayers;
				for(int i =0;i<pl.size();i++) {
					Player p = pl.get(i);
					
				
				}
				this.cancel();
				
			}else {main.starttime=main.starttime-1;
			 ArrayList<Player> pl = new ArrayList<>(plugin.getServer().getOnlinePlayers());
			for(int i = 0 ; i<pl.size();i++) {
				Player p = pl.get(i);
				if(main.starttime==5) {
					p.sendTitle(color.color(plugin.getConfig().getString("time5")),color.color(plugin.getConfig().getString("ltitle")));
				}
				if(main.starttime==4) {
					p.sendTitle(color.color(plugin.getConfig().getString("time4")),color.color(plugin.getConfig().getString("ltitle")));
				}
				if(main.starttime==3) {
					p.sendTitle(color.color(plugin.getConfig().getString("time3")),color.color(plugin.getConfig().getString("ltitle")));
				}
				if(main.starttime==2) {
					p.sendTitle(color.color(plugin.getConfig().getString("time2")),color.color(plugin.getConfig().getString("ltitle")));
				}
				if(main.starttime==1) {
					p.getInventory().clear();
					p.sendTitle(color.color(plugin.getConfig().getString("time1")),color.color(plugin.getConfig().getString("ltitle")));
				}
			}
			}
		}
		
	}

}
