package com.Creator.Dfw.Scoreboard;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Creator.Dfw.color;
import com.Creator.Dfw.main;
import com.Creator.Dfw.team.teamcolor;

public class sb {
public static Scoreboard getplayergamenotstart(Player p) {
	Plugin plugin =com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
	ScoreboardManager m= Bukkit.getScoreboardManager();
	Scoreboard s = m.getNewScoreboard();
	Objective o = s.registerNewObjective(color.color(plugin.getConfig().getString("sb_player_gamenotstart_name")), "dummy");
	o.setDisplaySlot(DisplaySlot.SIDEBAR);
	List<String> l = plugin.getConfig().getStringList("sb_player_gamenotstart");
	for(int i = 0;i<l.size();i++) {
		String team = "";
		String tc="";
	if(com.Creator.Dfw.team.team.getteamcolor(p)!=null) {
		tc=com.Creator.Dfw.team.team.getteamcolor(p).getChatColor().toString();
		List<String> l2 = plugin.getConfig().getStringList("team");
		List<String> l1 = plugin.getConfig().getStringList("teamname");
		for(int n= 0 ;n<l2.size();n++) {
			if(teamcolor.valueOf(l2.get(n)).equals(com.Creator.Dfw.team.team.getteamcolor(p))) {team=l1.get(n);}
		}
		}else {team="ÎÞ¶ÓÎé";tc="";}
		Score sc = o.getScore(color.color(l.get(i)
				.replace("{starttime}",main.its(main.starttime))
				.replace("{playerstartint}",main.its(main.stratplayer))
				.replace("{dqplayerint}",main.its(main.dfwplayers.size()))
				.replace("{team}",team)
				.replace("{teamcolor}",tc)
				));
		sc.setScore(l.size()-i);
	}
	
	
	return s;
}
public static Scoreboard getplayergamestart(Player p) {
	Plugin plugin =com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
	ScoreboardManager m= Bukkit.getScoreboardManager();
	Scoreboard s = m.getNewScoreboard();
	Objective o = s.registerNewObjective(color.color(plugin.getConfig().getString("sb_player_gamestart_name")), "dummy");
	o.setDisplaySlot(DisplaySlot.SIDEBAR);
	List<String> l = plugin.getConfig().getStringList("sb_player_gamestart");
	for(int i = 0;i<l.size();i++) {
		int point=-1;
		String q="";
for(int n =0;n<main.dfwplayers.size();n++) {
	if(main.dfwplayers.get(n).equals(p)) {point=main.sti(main.playerpoint.get(n));q=main.qian.get(n);}
}

		Score sc = o.getScore(color.color(l.get(i)
				.replace("{dqplayer}",main.dfwplayers.get(main.dqplayer).getPlayerListName())
				.replace("{point}",main.its(point))
				.replace("{dqplayerint}",main.its(main.dfwplayers.size()))
				.replace("{qian}",q)
				.replace("{dqstate}",main.state.get(main.dqstate).getname())
				.replace("{statetime}",main.its(main.statetime))
				));
		sc.setScore(l.size()-i);
	}
	
	
	return s;
}
}
