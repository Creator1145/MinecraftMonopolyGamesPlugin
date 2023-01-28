package com.Creator.Dfw.runnable;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;




public class runnable3 extends BukkitRunnable{

	@Override
	public void run() {
		/*ArrayList<Entity> l =main.ArmorStands_point;
		for(int i =0;i<l.size();i++) {
			
			ArmorStand as = (ArmorStand) l.get(i);
			if(!as.getHelmet().equals(main.getitem(5))) {
				Dfwpointarmor_standrightclick event =new Dfwpointarmor_standrightclick(l.get(i));
				Bukkit.getPluginManager().callEvent(event);
				if(!event.isCancelled()) {
					as.setHelmet(main.getitem(5));
				}
				
			}
		}*/
	}

}
