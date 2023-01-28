package com.Creator.Dfw.runnable;

import org.bukkit.scheduler.BukkitRunnable;

import com.Creator.Dfw.main;

public class statetime extends BukkitRunnable{

	@Override
	public void run() {
	if(main.gamestart) {
		if(main.statetime==0) {
			main.nextstate();
		
		}else {
			main.statetime--;
		}
	}
		
	}

}
