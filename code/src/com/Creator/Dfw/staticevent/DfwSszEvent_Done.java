package com.Creator.Dfw.staticevent;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/**
 * 玩家甩完甩子时触发
 * @author Creator
 *
 */
public class DfwSszEvent_Done extends Event{
	private static final HandlerList handlers = new HandlerList();
	private Player player ;
	private String c;
	private int n;

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
  public DfwSszEvent_Done(Player p,String cause,int num) {super(); c=cause;player=p;n=num;}
  /**
   * 获取甩到的数字
   * @return 甩到的数字
   */
public int getnum() {n++;return n;}
/**
 * 获取甩甩子的原因
 * @return 甩甩子的原因
 */
public String getcause() {return c;}
/**
 * 获取甩甩子的玩家
 * @return 甩甩子的玩家
 */
public Player getplayer() {
	return player;
}
	  public static HandlerList getHandlerList() { return handlers; }
}
