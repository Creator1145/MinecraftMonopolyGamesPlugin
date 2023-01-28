package com.Creator.Dfw.staticevent;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.Creator.Dfw.dfwpoint;
import com.Creator.Dfw.main;
/**
 * 右键地点操作物品时触发
 * @author Creator
 *
 */
public class DfwPointCzItemRightClick extends PlayerInteractEvent{
private Player p;
private static final HandlerList handlers = new HandlerList();
@Override
public HandlerList getHandlers() {
	return handlers;
}
public static HandlerList getHandlerList() { return handlers; }
public DfwPointCzItemRightClick(Player who, Action action, ItemStack item, Block clickedBlock,
			BlockFace clickedFace) {
		super(who, action, item, clickedBlock, clickedFace);
		p=who;
		// TODO Auto-generated constructor stub
	}
/**
 * 获取当前的点
 * @return 当前的点
 */
public dfwpoint getpoint() {
	for(int i=0;i<main.dfwplayers.size();i++) {
		if(main.dfwplayers.get(i).equals(p)) {
			return main.point.get(main.sti(main.playerpoint.get(i)));
		}
	}
	return null;
}
	
}
