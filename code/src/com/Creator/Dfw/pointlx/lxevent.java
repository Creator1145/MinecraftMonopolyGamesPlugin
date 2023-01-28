package com.Creator.Dfw.pointlx;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import com.Creator.Dfw.color;
import com.Creator.Dfw.dfwpoint;
import com.Creator.Dfw.main;
import com.Creator.Dfw.staticevent.DfwForwardEvent_Done;
import com.Creator.Dfw.staticevent.DfwPluignOnEnableEvent;
import com.Creator.Dfw.staticevent.DfwPointCzItemRightClick;
import com.Creator.Dfw.staticevent.DfwRegLxEvent;
import com.Creator.Dfw.staticevent.DfwRegLxEvent_Done;

public class lxevent implements Listener {
@EventHandler
public void DfwPluignOnEnable(DfwPluignOnEnableEvent e) {
	System.out.print(e.getEventName());
	//main.regpointlx(new house("house",null));
	
}
@EventHandler
public void DfwForwardEvent_D(DfwForwardEvent_Done e) {
e.getplayer().sendMessage(e.getpoint().getlx().getlxInternal_name());
	if(e.getpoint().getlx().getlxInternal_name().equals("house")) {
	((house) e.getpoint().getlx()).jg(e.getplayer(),e.getpoint().getwz());
}	
if(e.getpoint().getlx().getlxInternal_name().equals("tax")) {

	((tax) e.getpoint().getlx()).jg(e.getplayer(),e.getpoint().getwz());
}	
}
@EventHandler
public void  DfwPointCzItemRightClic( DfwPointCzItemRightClick e) {
	if(e.getpoint().getlx().getlxInternal_name().equals("house")) {
		e.getPlayer().openInventory(((house) e.getpoint().getlx()).dinv(e.getpoint().getwz(),e.getPlayer()));
	}
	if(e.getpoint().getlx().getlxInternal_name().equals("empty")) {
		e.getPlayer().sendMessage(color.color("&c&l无操作!"));
	}
}
@EventHandler
public void DfwRegLx(DfwRegLxEvent e) {
	if(e.getlxname()!=null&&e.getlxname().equals("house")) {
		e.setdfwpointlx(new house("house"));
	}
	if(e.getlxname()!=null&&e.getlxname().equals("tax")) {
		e.setdfwpointlx(new tax("tax"));
	}
	System.out.print(main.point.get(e.getint()).getlx().getlxInternal_name());
}
@EventHandler
public void DfwRegLxd(DfwRegLxEvent_Done e) {
	new house("house").setconfigsettingfordfwconfig();
	new tax("tax").setconfigsettingfordfwconfig();
}
@EventHandler
public void InventoryClick(InventoryClickEvent e) {
if(e.getInventory().getType().equals(InventoryType.CHEST)&&e.getSlot()!=-999) {
		Player p = (Player) e.getWhoClicked();
		dfwpoint n =null;
		for(int i = 0;i<main.dfwplayers.size();i++) {
			if(main.dfwplayers.get(i).equals(p)) {
				n=main.point.get(main.sti(main.playerpoint.get(i)));
			}
		}
		if(e.getInventory().getTitle().equals(color.color("&b房子" ))) {
			house h =(house) n.getlx();
			
			if(n!=null&&e.getInventory().getTitle().equals(h.dinv(n.getwz(),p).getTitle())) {
				if(e.getCurrentItem().equals(h.getitem(0, n.getwz()))) {
				h.buyhouse(1, p, n.getwz());
				p.sendMessage(h.getowner().getPlayerListName()+","+h.getdqhouse());
				}
				if(e.getCurrentItem().equals(h.getitem(1, n.getwz()))) {
					h.buyhouse(2, p, n.getwz());
					p.sendMessage(h.getowner().getPlayerListName()+","+h.getdqhouse());
					}
				if(e.getCurrentItem().equals(h.getitem(2, n.getwz()))) {
					h.buyhouse(3, p, n.getwz());
					p.sendMessage(h.getowner().getPlayerListName()+","+h.getdqhouse());
					}
			}
		}
		
}
	
}
@EventHandler
public void DfwForwardEvent(DfwForwardEvent_Done e) {
	if(e.getpoint().getlx().getlxInternal_name().equals("house")) {
		((house) e.getpoint().getlx()).jg(e.getplayer(),e.getpoint().getwz());
	}
}
}
