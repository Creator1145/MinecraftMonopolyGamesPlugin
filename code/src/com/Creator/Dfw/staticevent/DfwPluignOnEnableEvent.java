package com.Creator.Dfw.staticevent;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/**
 * �����ɼ��ش���
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
