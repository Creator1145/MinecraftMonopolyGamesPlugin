package com.Creator.Dfw.staticevent;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.InventoryView;

import com.Creator.Dfw.dfwpoint;
/**
 * ���ʹ��GUI��Ѻʱ����
 * @author Creator
 *
 */
public class DfwPlayerMortgageEvent extends InventoryClickEvent implements Cancellable{
	private dfwpoint Point;
	public DfwPlayerMortgageEvent(dfwpoint point,InventoryView view, SlotType type, int slot, ClickType click, InventoryAction action) {
		super(view, type, slot, click, action);
		Point=point;
		// TODO Auto-generated constructor stub
	}
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
public dfwpoint getpoint() {return Point;}
public Player getplayer() {return (Player)getWhoClicked();}
	/**
	 * �Ƿ�ȡ��
	 */
	  public boolean isCancelled() { return this.cancelled; }
	  /**
	   * �����Ƿ�ȡ��
	   */
	    public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
	  	  public static HandlerList getHandlerList() { return handlers; }
	  	@Override
	  	public HandlerList getHandlers() {
	  		return handlers;
	  	}
}
