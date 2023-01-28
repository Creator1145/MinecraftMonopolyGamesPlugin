package com.Creator.Dfw.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.Plugin;

import com.Creator.Dfw.color;
import com.Creator.Dfw.main;

public class motd implements Listener{
@EventHandler
public void ServerListPing(ServerListPingEvent e) {
	if(main.isenable) {
		Plugin plugin =com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		if(main.gamestart) {
			e.setMotd(color.color(plugin.getConfig().getString("game_start_motd")));
		}else {
			if(main.dfwplayers.size()==main.maxplayer) {
				e.setMotd(color.color(plugin.getConfig().getString("game_full_motd")));
			}else {
				e.setMotd(color.color(plugin.getConfig().getString("game_wait_motd")
						.replace("{player}", main.its(main.dfwplayers.size())).replace("{maxplayer}", main.its(main.maxplayer))		
						));
			}
		}
	}
}
}
