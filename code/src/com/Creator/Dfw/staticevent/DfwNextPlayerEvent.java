package com.Creator.Dfw.staticevent;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Creator.Dfw.main;
/**
 * 下一个玩家时触发
 * @author Creator
 *
 */
public class DfwNextPlayerEvent extends Event implements Cancellable{
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
	private int thisplayer;

	
  public DfwNextPlayerEvent(int dqplayer) {super();thisplayer=dqplayer;  }
/**
 * 是否取消
 */
  public boolean isCancelled() { return this.cancelled; }
  /**
   * 获取当前的玩家
   * @return 当前的玩家
   */
public Player getplayer() {
	return main.dfwplayers.get(thisplayer);
}
/**
 * 获取下一个玩家
 * @return 下一个玩家
 */
public Player getnextplayer() {
	if(thisplayer+1<main.dfwplayers.size()) {
		return main.dfwplayers.get(thisplayer+1);
	}else {
		return main.dfwplayers.get(0);
	}
}
/**
 * 设置是否取消
 */
  public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
	  public static HandlerList getHandlerList() { return handlers; }
	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return handlers;
	}

}
