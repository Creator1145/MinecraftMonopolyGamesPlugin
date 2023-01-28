package com.Creator.Dfw.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.Plugin;

import com.Creator.Dfw.color;
import com.Creator.Dfw.main;
import com.Creator.Dfw.gui.teamgui;
import com.Creator.Dfw.staticevent.DfwForwardEvent;
import com.Creator.Dfw.staticevent.DfwForwardEvent_Done;
import com.Creator.Dfw.staticevent.DfwNextPlayerEvent;
import com.Creator.Dfw.staticevent.DfwNextStateEvent;
import com.Creator.Dfw.staticevent.DfwPointCzItemRightClick;
import com.Creator.Dfw.staticevent.DfwSszEvent_Done;
import com.Creator.Dfw.staticevent.DfwgamestartEvent;

import com.Creator.Dfw.team.team;
import com.Creator.Dfw.team.teamcolor;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;


public class event implements Listener {
	@EventHandler
	public void playerjoin(PlayerJoinEvent e) {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);  
		e.getPlayer().setAllowFlight(false);
		 e.getPlayer().teleport(new Location(plugin.getServer().getWorld(plugin.getConfig().getString("starthomeLocation.world")),plugin.getConfig().getDouble("starthomeLocation.x"),plugin.getConfig().getDouble("starthomeLocation.y"),plugin.getConfig().getDouble("starthomeLocation.z")));
		e.getPlayer().getInventory().clear();
		 if(!main.gamestart) {
			main.dfwplayers.add(e.getPlayer());
			main.team_color.add(null);
			main.qian.add(main.its(plugin.getConfig().getInt("csqian")));
		}else {
			main.dfwspectator.add(e.getPlayer());
		}
		 TextComponent message = new TextComponent( color.color(plugin.getConfig().getString("resourcepack.text")) );
		 message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/dfw setresourcepack" ) );
		 message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(color.color(plugin.getConfig().getString("resourcepack.showtext"))).create() ) );
		 e.getPlayer().spigot().sendMessage( message );
	
	}
	@EventHandler
	public void playerquit(PlayerQuitEvent e) {
		ArrayList<Player> pl =main.dfwplayers;
		ArrayList<Player> sl =main.dfwspectator;
		for(int i = 0 ; i<pl.size();i++) {
			if(pl.get(i).equals(e.getPlayer())) {
				pl.remove(i);
				main.team_color.remove(i);
				main.qian.remove(i);
			}
		}
		for(int i = 0 ; i<sl.size();i++) {
			if(sl.get(i).equals(e.getPlayer())) {
				sl.remove(i);
			}
		}
		if(pl.size()==0&&main.gamestart) {
			main.getPlugin(com.Creator.Dfw.main.class).getServer().shutdown();
		}
	}
	@EventHandler
	public void PlayerDropItem(PlayerDropItemEvent e) {
ItemStack	is=e.getItemDrop().getItemStack();
		if(is.equals(main.getitem(0))||is.equals(main.getitem(1))||is.equals(main.getitem(2))) {
			e.setCancelled(true);
	
		}
	}
	@EventHandler
	public void FoodLevelChange(FoodLevelChangeEvent e) {
		if(main.FoodLevelChange) {
		e.setCancelled(true);
		}
	}
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void PlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(p.getItemInHand().equals(main.getitem(4))) {
				
				Set hs=null;
				Location l = p.getTargetBlock(hs,100).getLocation();
				l.setY(l.getY()+1);
				p.teleport(l);
			}
		}
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)||e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			
			if(p.getItemInHand().equals(main.getitem(6))&&main.dfwplayers.get(main.dqplayer).equals(e.getPlayer())&&main.state.get(main.dqstate).getInternal_name().equals("cz")) {
				Bukkit.getPluginManager().callEvent(new DfwPointCzItemRightClick(e.getPlayer(),e.getAction(),e.getItem(),e.getClickedBlock(),e.getBlockFace()));
			}
			if(p.getItemInHand().equals(main.getitem(1))) {
				p.chat("/hub");
			}
			if(p.getItemInHand().equals(main.getitem(0))&&!main.gamestart) {
				
				p.sendMessage("正在开始游戏");
				if(main.dfwplayers.size()<main.stratplayer) {
					while(main.dfwplayers.size()<main.stratplayer) {
						main.dfwplayers.add(p);
						main.team_color.add(null);
						
					}
					main.starttime=6;
				}else {main.starttime=6;}
			}
			if(p.getItemInHand().equals(main.getitem(3))&&!main.gamestart) {
				p.openInventory(teamgui.returngui());
			
			}
		}
	}
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);  
	
		e.setCancelled(true);
		if(e.getInventory().getTitle().equals(color.color(plugin.getConfig().getString("MortgageGui.title")))) {
			
		}
		if(e.getInventory()!=null&&e.getInventory().getName().equals(color.color(plugin.getConfig().getString("gui(team)_Title")))){
			Player p = (Player) e.getWhoClicked();
		
		if(e.getCurrentItem().getType().toString().equals("WOOL")) {			
				List<String> l =plugin.getConfig().getStringList("team");
				if(e.getSlot()<=l.size()&& e.getSlot()!=-999) {
				
				String temp  =l.get(e.getSlot());
				
						
					
					if(team.setplayertoteam(p,temp)==true) {
						p.closeInventory();
					}else {p.sendMessage(color.color(plugin.getConfig().getString("teamfullmsg")));}
				
				}
				
			}
		}
	}
	@EventHandler
	public void EntityDamageEvent(org.bukkit.event.entity.EntityDamageEvent e) {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);  
		if(e.getEntityType().equals(EntityType.PLAYER)) {
			  Player p = (Player) e.getEntity();
			  if(e.getCause().equals(DamageCause.VOID)) {
				  e.setCancelled(true);
				 if(main.gamestart==false) {
					 p.teleport(new Location(plugin.getServer().getWorld(plugin.getConfig().getString("starthomeLocation.world")),plugin.getConfig().getDouble("starthomeLocation.x"),plugin.getConfig().getDouble("starthomeLocation.y"),plugin.getConfig().getDouble("starthomeLocation.z")));
				 }else {
					 p.teleport(new Location(plugin.getServer().getWorld(plugin.getConfig().getString("startgameLocation.world")),plugin.getConfig().getDouble("startgameLocation.x"),plugin.getConfig().getDouble("startgameLocation.y"),plugin.getConfig().getDouble("startgameLocation.z")));
				 }
			  }else {e.setCancelled(true);}
		  }
			
		
	}
	@EventHandler
	public void Dfwgamestart(DfwgamestartEvent e) {
		List<Player> pl = e.getgameplayers();
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);  
		for(int i = 0 ; i<pl.size();i++) {
			
			Player p = pl.get(i);
			List<String> l =plugin.getConfig().getStringList("team");
			p.sendTitle("游戏开始","");
			if(team.getteamcolor(p)==null) {
				for(int n = 0 ;n<l.size();n++) {
					if(team.setplayertoteam(p,l.get(n))==true) {break;}
				}
			}
			main.spwanPlayer(p, main.point.get(0).getloc());
			p.getInventory().clear();
			p.getInventory().setHelmet(main.setcolor(team.getteamcolor(p).getColor(), new ItemStack(org.bukkit.Material.LEATHER_HELMET)));
			p.getInventory().setItem(1, main.getitem(6));
			//main.spawnpointarmorstand();
			main.playerpoint.add("0");
			System.out.print(main.team_color);
		}
		
	}
	@EventHandler
	public void PlayerInteractEntit(PlayerInteractEntityEvent e) {
	System.out.print(e.getRightClicked().getType().toString());
		if(main.gamestart&&e.getRightClicked().getType().equals(EntityType.ARMOR_STAND)) {e.setCancelled(true);}
		
	}
	@EventHandler
	public void EntityTeleport(PlayerTeleportEvent e) {
		if(CitizensAPI.getNPCRegistry().isNPC(e.getPlayer())) {
			List<NPC>  l =main.npcs;
			NPC npc =CitizensAPI.getNPCRegistry().getNPC(e.getPlayer());
			for(int i =0;i<l.size();i++) {
				
				if(l.get(i).equals(npc)) {
					
					main.ArmorStands_player.get(i).teleport(e.getTo());
				}
			}
		}
	}
	@EventHandler
public void DfwNextPlayer(DfwNextPlayerEvent e) {

	e.getplayer().sendMessage("下一个玩家是："+e.getnextplayer().getPlayerListName());
	main.sz(e.getplayer(), "forward");
}
	@EventHandler
	public void DfwSszEvent_D(DfwSszEvent_Done e) {
		e.getplayer().sendMessage("你甩到了:"+e.getnum()+"原因为:"+e.getcause()+"来自"+e.getEventName());
		if(e.getcause().equals("forward")) {main.forward(e.getnum()-1, e.getplayer());main.nextstate();}
	}
	/*@EventHandler
	public void Dfwpointar(Dfwpointarmor_standrightclick e) {
		e.getplayer().sendMessage("你右键了"+e.getarmor_stand()+",于第"+e.getpoint()+"个点,位置为"+main.point.get(e.getpoint()));
	}*/
@EventHandler
public void DfwNextstate(DfwNextStateEvent e) {
	System.out.print("准备下一个状态！当前状态:"+e.getdqstate().getname()+",后面为:"+e.getnextstate().getname());
}

}
