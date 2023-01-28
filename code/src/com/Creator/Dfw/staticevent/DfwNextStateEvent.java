package com.Creator.Dfw.staticevent;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Creator.Dfw.dfwstate;
import com.Creator.Dfw.main;
/**
 * 下一个状态时触发
 * @author Creator
 *
 */
public class DfwNextStateEvent extends Event implements Cancellable{
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
	private int thisstate;

	
  public DfwNextStateEvent(int dqstate) {super();thisstate=dqstate;  }
  /**
   * 是否取消
   */
public boolean isCancelled() { return this.cancelled; }
/**
 * 获取当前的状态
 * @return 当前的状态
 */
public dfwstate getdqstate() {
	return main.state.get(thisstate);
}
/**
 * 获取下一个状态
 * @return 下一个状态
 */
public dfwstate getnextstate() {
	if(thisstate+1<main.state.size()) {
		return main.state.get(thisstate+1);
	}else {
		return main.state.get(0);
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
