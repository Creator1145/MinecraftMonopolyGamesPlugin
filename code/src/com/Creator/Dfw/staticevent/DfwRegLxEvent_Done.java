package com.Creator.Dfw.staticevent;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/**
 * 注册类型最后时触发，用于类型写配置
 * @author Creator
 *
 */
public class DfwRegLxEvent_Done extends Event{
	private static final HandlerList handlers = new HandlerList();
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	public static HandlerList getHandlerList() { return handlers; }
}
