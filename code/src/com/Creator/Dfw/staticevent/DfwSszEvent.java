package com.Creator.Dfw.staticevent;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/**
 * ��ҽ�˦˦��ʱ����
 * @author Creator
 *
 */
public class DfwSszEvent extends Event implements Cancellable{
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
	private Player player ;
	private String c;

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
  public DfwSszEvent(Player p,String cause) {super(); c=cause;player=p;}
  /**
   * �Ƿ�ȡ����
   */
public boolean isCancelled() { return this.cancelled; }
/**
 * ��ȡ˦˦�ӵ�ԭ��
 * @return ˦˦�ӵ�ԭ��
 */
public String getcause() {return c;}
/**
 * ��ȡ˦˦�ӵ����
 * @return ˦˦�ӵ����
 */
public Player getplayer() {
	return player;
}
/**
 * �����Ƿ�ȡ��
 */
  public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
	  public static HandlerList getHandlerList() { return handlers; }
}
