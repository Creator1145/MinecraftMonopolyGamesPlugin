package com.Creator.Dfw.runnable;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.Creator.Dfw.main;

public class runnable2 extends BukkitRunnable{
	@Override
	public void run() {
		
		ArrayList<Player> pl = main.dfwspectator;
		for(int i =0;i<pl.size();i++) {
			Player p = pl.get(i);
		p.setGameMode(GameMode.SPECTATOR);
		
		p.getInventory().setItem(8, main.getitem(1));
		}
		
	}
}
