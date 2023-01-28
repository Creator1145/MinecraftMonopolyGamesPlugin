package com.Creator.Dfw.staticevent;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/**
 * 插件完成加载触发
 * @author Creator
 *
 */
@Deprecated
public class DfwPluignOnEnableEvent extends Event{
	private static final HandlerList handlers = new HandlerList();
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	  public static HandlerList getHandlerList() { return handlers; }
}
