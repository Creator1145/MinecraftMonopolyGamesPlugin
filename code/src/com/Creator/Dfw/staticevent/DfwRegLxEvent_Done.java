package com.Creator.Dfw.staticevent;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/**
 * ע���������ʱ��������������д����
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
