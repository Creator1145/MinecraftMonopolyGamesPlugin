package com.Creator.Dfw.staticevent;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Creator.Dfw.main;
/**
 * 玩家将要前进时触发
 * @author Creator
 *
 */
public class DfwForwardEvent extends Event implements Cancellable{
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
	private int Pointint;
	private Player player;

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
  public DfwForwardEvent(Player p,int pointint) {super();  Pointint=pointint;player=p;}
  /**
   * 是否取消
   */
public boolean isCancelled() { return this.cancelled; }
/**
 * 获取前进的格数
 * @return 前进的格数
 */
public int getforwardint() {return Pointint;}
/**
 * 获取前进的玩家
 * @return 前进的玩家
 */
public Player getplayer() {
	return player;
}
/**
 * 取消前进
 */
  public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
	  public static HandlerList getHandlerList() { return handlers; }

}
