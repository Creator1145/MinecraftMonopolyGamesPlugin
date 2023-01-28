package com.Creator.Dfw.runnable;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.Creator.Dfw.main;

public class runnable extends BukkitRunnable{

	@Override
	public void run() {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		ArrayList<Player> pl = main.dfwplayers;
		for(int i =0;i<pl.size();i++) {
			Player p = pl.get(i);
			if(!main.gamestart) {
			
				
				p.setGameMode(GameMode.ADVENTURE);
				main.sendActionMessage(main.its(main.starttime), p);
				p.setLevel(main.starttime);
			float st=main.starttime;
			float yt=plugin.getConfig().getInt("waittime");
			float n = st/yt;	
			p.setExp(n);
				if(p.isOp()) {			
					p.getInventory().setItem(8, main.getitem(1));
					p.getInventory().setItem(1, main.getitem(0));
					p.getInventory().setItem(0, main.getitem(3));
				}else {p.getInventory().setItem(0, main.getitem(3));p.getInventory().setItem(8, main.getitem(1));}
			}else {
				p.setAllowFlight(true);
				
			}
		}
			
		
		}
		
	}


