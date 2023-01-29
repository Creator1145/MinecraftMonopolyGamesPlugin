package com.Creator.Dfw;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Wool;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Scoreboard;

import com.Creator.Dfw.Event.event;
import com.Creator.Dfw.Event.motd;
import com.Creator.Dfw.command.command;
import com.Creator.Dfw.pointlx.empty;
import com.Creator.Dfw.pointlx.house;
import com.Creator.Dfw.pointlx.lxevent;
import com.Creator.Dfw.staticevent.DfwForwardEvent;
import com.Creator.Dfw.staticevent.DfwForwardEvent_Done;
import com.Creator.Dfw.staticevent.DfwNextPlayerEvent;
import com.Creator.Dfw.staticevent.DfwNextStateEvent;
import com.Creator.Dfw.staticevent.DfwPluignOnEnableEvent;
import com.Creator.Dfw.staticevent.DfwRegLxEvent;
import com.Creator.Dfw.staticevent.DfwRegLxEvent_Done;
import com.Creator.Dfw.staticevent.DfwSszEvent;
import com.Creator.Dfw.staticevent.DfwSszEvent_Done;
import com.Creator.Dfw.staticevent.DfwgamestartEvent;
import com.Creator.Dfw.team.team;
import com.Creator.Dfw.team.teamcolor;


import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.npc.skin.SkinnableEntity;
import net.citizensnpcs.util.NMS;
import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class main extends JavaPlugin {
	 public static ArrayList<Player> dfwplayers=new ArrayList<Player>();
	 public static Boolean gamestart;
	 public static ArrayList<Player> dfwspectator=new ArrayList<Player>();
	 public static ArrayList<teamcolor> team_color=new ArrayList<teamcolor>();
	 public static ArrayList<dfwpoint> point = new ArrayList<dfwpoint>();
	 public static ArrayList<String> playerpoint = new ArrayList<String>();
	 public static ArrayList<NPC> npcs=new ArrayList<NPC>();
	 public static ArrayList<Entity> ArmorStands_player=new ArrayList<Entity>();
	 public static ArrayList<dfwstate> state = new ArrayList<dfwstate>();
	 //public static ArrayList<Entity> ArmorStands_point=new ArrayList<Entity>();
	// public static ArrayList<Block> blocks=new ArrayList<Block>();
	 public static ArrayList<String> qian = new ArrayList<String>();
	 public static int starttime;
	 public static int stratplayer;
	 public static int maxplayer;
	 public static int dqplayer=0;
	 public static int dqstate=0;
	 public static int num = 1;
	 public static int statetime;
	 public static Player szp;
	 public static String szc;
	 public static Boolean isenable;
	 public static Boolean FoodLevelChange;
	 public static List<String> sz =new ArrayList<String>();
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		 this.getCommand("dfw").setExecutor(new command());
		 gamestart=false;
		 FoodLevelChange=getConfig().getBoolean("FoodLevelChange");
		 isenable = this.getConfig().getBoolean("game_enable");
		 stratplayer=this.getConfig().getInt("playerint");
		 starttime=this.getConfig().getInt("waittime");
		 maxplayer=this.getConfig().getInt("maxplayer");
		 getServer().getPluginManager().registerEvents(new lxevent(), this);
		 getServer().getPluginManager().registerEvents(new motd(), this);
		 if(isenable) {new com.Creator.Dfw.runnable.runnable().runTaskTimer(this,0,1);
		 new com.Creator.Dfw.runnable.runnable2().runTaskTimer(this,0,1);
		 new com.Creator.Dfw.runnable.time().runTaskTimer(this,0,20);
		 new com.Creator.Dfw.runnable.statetime().runTaskTimer(this,0,20);
		 getServer().getPluginManager().registerEvents(new event(), this);
		 //new com.Creator.Dfw.runnable.runnable3().runTaskTimer(this,0,1);
		 new com.Creator.Dfw.runnable.sc().runTaskTimer(this,0,1);
		 getpointfromconfig();}
		sz=getConfig().getStringList("sz");
		ConfigurationSection c =getConfig().getConfigurationSection("state");
		for(String item : c.getKeys(false)) {
			state.add(new dfwstate(getConfig().getString("state."+item+".name"),getConfig().getInt("state."+item+".time"),getConfig().getString("state."+item+".Internal_name")));
		}
		DfwPluignOnEnableEvent e = new DfwPluignOnEnableEvent() ;
		Bukkit.getPluginManager().callEvent(e);
		regpointlx();
		System.out.print(this.getServer().getVersion());
	}
	@Override
	public void onDisable() {
		remplayernpc();
	}
	public static int sti(String s) {//将文本转为整数
		int i = Integer.parseInt(s);		
		return i;		
	} 
	public static String its(int i) {//将整数转为文本
		String s = String.valueOf(i);		
		return s;		
	}
	/**
	 * 发送Actiontitle
	 * @param message 发送的文本
	 * @param player 玩家
	 */
	public static void sendActionMessage(String message,Player player){//通过发包来实现Actiontitle
	    ChatComponentText cCT = new ChatComponentText(message);
	    IChatBaseComponent iCBC = cCT;
	    CraftPlayer craftPlayer = (CraftPlayer) player;
	    craftPlayer.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(iCBC, (byte) 2));
	}
    /**
     * 移除所有的玩家npc
     */
	public static void remplayernpc() {
		for(int i = 0 ;i<npcs.size();i++) {CitizensAPI.getNPCRegistry().deregister(npcs.get(i));
		ArmorStands_player.get(i).remove();
		
		}
	/*	for(int i = 0;i<main.blocks.size();i++) {
			main.blocks.get(i).setType(Material.AIR);
			main.ArmorStands_point.get(i).remove();
		}*/
	}
	/**
	 * 向前走
	 * @param i 走的格数
	 * @param p 走的玩家
	 */
	public static void forward(int i,Player p) {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		for(int n =0;n<main.dfwplayers.size();n++) {
			if(main.dfwplayers.get(n).equals(p)) {
				int pp1 =main.sti(main.playerpoint.get(n));
				DfwForwardEvent event = new DfwForwardEvent(p,i);
				Bukkit.getPluginManager().callEvent(event);
				if(!event.isCancelled()) {
					NPC npc = main.npcs.get(n);
					for(int b =0;b<i;b++) {
						
						int pp = main.sti(main.playerpoint.get(n));
						if(pp+1<main.point.size()) {
							npc.teleport(main.point.get(pp+1).getloc(), TeleportCause.PLUGIN);
							main.playerpoint.set(n, main.its(pp+1));
							
						}else {
							
							npc.teleport(main.point.get(0).getloc(), TeleportCause.PLUGIN);
							main.playerpoint.set(n, "0");
							for(int f= 0;f<main.dfwplayers.size();f++) {
						      if(main.dfwplayers.get(f).equals(p)) {
						    	  main.qian.set(f, main.its(main.sti(main.qian.get(f))+plugin.getConfig().getInt("jgqdqian")));
						    	  
							}
							}
						}
					}
					if(pp1+i<main.point.size()) {
						DfwForwardEvent_Done event1 = new DfwForwardEvent_Done(p,pp1+i,npc.getEntity().getLocation());
						Bukkit.getPluginManager().callEvent(event1);
					}else {
						DfwForwardEvent_Done event1 = new DfwForwardEvent_Done(p,0,npc.getEntity().getLocation());
						Bukkit.getPluginManager().callEvent(event1);
					}
					
				}
				
			}
		}
	}
	/**
	 * 获取插件内部使用的物品
	 * @param i 标识符
	 * @return 物品
	 */
	public static ItemStack getitem(int i) {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		ItemStack is = null ;
		
		if(i==0) {
			is= new ItemStack(Material.matchMaterial(plugin.getConfig().getString("startitem")),1);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(color.color(plugin.getConfig().getString("startitem_name")));
			im.setLore(color.color_list(plugin.getConfig().getStringList("startitem_lore")));
			is.setItemMeta(im);
		}
		if(i==1) {
			is= new ItemStack(Material.matchMaterial(plugin.getConfig().getString("reitem")),1);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(color.color(plugin.getConfig().getString("reitem_name")));
			im.setLore(color.color_list(plugin.getConfig().getStringList("reitem_lore")));
			is.setItemMeta(im);
		}
		if(i==2) {
			is= new ItemStack(Material.matchMaterial(plugin.getConfig().getString("jzitem")),1);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(color.color(plugin.getConfig().getString("jzitem_name")));
			im.setLore(color.color_list(plugin.getConfig().getStringList("jzitem_lore")));
			is.setItemMeta(im);
		}
		if(i==3) {
			is= new ItemStack(Material.matchMaterial(plugin.getConfig().getString("teamitem")),1);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(color.color(plugin.getConfig().getString("teamitem_name")));
			im.setLore(color.color_list(plugin.getConfig().getStringList("teamitem_lore")));
			is.setItemMeta(im);
		}
		if(i==5) {
			is= new ItemStack(Material.DIAMOND_BLOCK,1);
			
		}
		if(i==6) {
			 if(plugin.getConfig().getItemStack("pointczitem")==null) {
				 is=new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
			 }else {is=plugin.getConfig().getItemStack("pointczitem");}
			
		}
		if(i==4) {
			is= new ItemStack(Material.COMPASS,1);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(color.color("&e位置矫正器（右键使用）"));
			List<String> l = new ArrayList<String>();
			l.add("右键方块可以传送到方块的坐标");
			im.setLore(l);
			is.setItemMeta(im);
		}
		
		
		return is;
	}
	/**
	 * 获取玩家的头（有皮肤）
	 * @param name 玩家名
	 * @return 头颅物品
	 */
	public static ItemStack getskil(String name) {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		ItemStack is1 = new ItemStack (Material.SKULL_ITEM ,1,(short) 3);
		SkullMeta im = (SkullMeta) is1.getItemMeta();
		im.setOwner(name);
		
		
		is1.setItemMeta(im);
		return is1;
		
	}
	/**
	 * 将皮革装备染色
	 * @param color 颜色
	 * @param is 需要染色的物品物品
	 * @return 染色后的物品
	 */
	public static ItemStack setcolor(Color color , ItemStack is) {//将皮革装备染色
		try {
			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
			im.setColor(color);
			is.setItemMeta(im);
			return is;
		}catch(ClassCastException expected) {}
		return null;
		
	}
	/*public static void spawnpointarmorstand() {
		ArrayList<Location> l =main.point;
		for(int i =0 ;i<l.size();i++) {
			Location lb = l.get(i);
			lb.setY(lb.getY()+10);
			Block b =lb.getBlock();
			b.setType(Material.BARRIER);
			main.blocks.add(b);
			lb.setY(lb.getY()+1);
			Entity e =lb.getWorld().spawnEntity(lb,EntityType.ARMOR_STAND );
			e.setCustomName("awa");
			e.setCustomNameVisible(true);
			ArmorStand as = (ArmorStand) e;
			as.setVisible(false);
			as.setHelmet(new ItemStack(Material.DIAMOND_BLOCK));
			lb.setY(lb.getY()-11);
			
			main.ArmorStands_point.add(as);
		}
	}*/
	/**
	 * 生成玩家的npc
	 * @param p 玩家
	 * @param l 位置
	 */
	public static void spwanPlayer(Player p,Location l) {
	
		Entity e =p.getWorld().spawnEntity(l,EntityType.ARMOR_STAND );
		e.setCustomName(p.getPlayerListName());
		e.setCustomNameVisible(true);
		ArmorStand as = (ArmorStand) e;
		as.setArms(true);
		as.setBasePlate(false);
		
		as.setVisible(false);
		/*as.setHelmet(main.getskil(p.getName()));
		as.setChestplate(main.setcolor(team.getteamcolor(p).getColor(),new ItemStack(Material.LEATHER_CHESTPLATE)));
		as.setLeggings(main.setcolor(team.getteamcolor(p).getColor(),new ItemStack(Material.LEATHER_LEGGINGS)));
		as.setBoots(main.setcolor(team.getteamcolor(p).getColor(),new ItemStack(Material.LEATHER_BOOTS)));*/

		NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "");
		npc.spawn(l);
		 SkinnableEntity skin = NMS.getSkinnable(npc.getEntity());
		 skin.setSkinName(p.getName());
		 
		main.npcs.add(npc);
		main.ArmorStands_player.add(as);
		
	}

public static void setpoint(Location l,String name,String lx) {
	Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
	plugin.getConfig().set("point."+name+".location",l);
	
	plugin.getConfig().set("point."+name+".lx.Internal name",lx);
	plugin.saveConfig();
}
public static void getpointfromconfig() {
	Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
	ConfigurationSection c =plugin.getConfig().getConfigurationSection("point");
	int i=-1;
	for(String item : c.getKeys(false)) {
		i++;
		ItemStack is =plugin.getConfig().getItemStack("point."+item+".ItemStack");
		String name="无名称";
		if(is==null) {
			is=main.getitem(2);
		}
		if(plugin.getConfig().getString("point."+item+".name")!=null) {
			name=plugin.getConfig().getString("point."+item+".name");
		}
		main.point.add(new dfwpoint(name,new empty("empty"),(Location) plugin.getConfig().get("point."+item+".location"),is,i));
	}
}
/**
 * 下一个玩家
 */
public static void nextplayer() {
	
	DfwNextPlayerEvent event = new DfwNextPlayerEvent(main.dqplayer);
	Bukkit.getPluginManager().callEvent(event);
	if(!event.isCancelled()) {
		if(main.dqplayer+1<main.dfwplayers.size()) {
			main.dqplayer++;
		}else {
			main.dqplayer=0;
		}
	}
	}
/**
 * 下一个状态
 */
public static void nextstate() {
	DfwNextStateEvent event = new DfwNextStateEvent(main.dqstate);
	Bukkit.getPluginManager().callEvent(event);
	if(!event.isCancelled()) {
		if(main.dqstate+1<main.state.size()) {
			main.dqstate++;
			main.statetime=main.state.get(main.dqstate).gettime();
		}else {
			main.dqstate=0;
			main.nextplayer();
			main.statetime=main.state.get(main.dqstate).gettime();
		}
	}
	
}
/**
 * 使用甩子
 * @param p 使用甩子的玩家
 * @param cause 使用甩子的原因
 */
public static void sz(Player p,String cause) {
	DfwSszEvent event =new DfwSszEvent(p,cause);
	Bukkit.getPluginManager().callEvent(event);
	if(!event.isCancelled()) {
		Random i = new Random();	
		main.szp=p;
		main.szc=cause;
		new BukkitRunnable()
		{
			int time = 20; 
			Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);  
		    @Override
		    public void run() 
		    {
		    	if(time == 0)
		        {
		    		DfwSszEvent_Done event =new DfwSszEvent_Done(main.szp,main.szc,main.num);
		    		Bukkit.getPluginManager().callEvent(event);
		    		cancel();  
		             return;
		        }
		    	time--;
		    	num = i.nextInt(6);			
				p.sendTitle(color.color(main.sz.get(num)),color.color(plugin.getConfig().getString("sz_player_xtitle")));
		    }                
		}.runTaskTimer(main.getPlugin(com.Creator.Dfw.main.class), 0L, 10L);	
	}
}
public static void regpointlx() {
	Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
	 ConfigurationSection c =plugin.getConfig().getConfigurationSection("point");
	 int i =-1;	
	 for(String item : c.getKeys(false)) {
	 	i++	;
	 	
	 	Bukkit.getPluginManager().callEvent(new DfwRegLxEvent(main.point.get(i),i));
	 	}
	 Bukkit.getPluginManager().callEvent(new DfwRegLxEvent_Done());
}
/**
 * 花费
 * @param p 花费的玩家
 * @param qian 需要的钱
 * @return 是否花费成功
 */
public static Boolean pay(Player p,int qian) {
	for(int i =0;i<main.dfwplayers.size();i++) {
		if(main.dfwplayers.get(i).equals(p)) {
			if(main.sti(main.qian.get(i))<qian) {
				return false;
			}else {
				int n = main.sti(main.qian.get(i))-qian;
				main.qian.set(i, main.its(n));
				return true;
			}
		}
	}
	return false;
}
/**
 * 获得玩家可抵押资产全部抵押可获得的钱
 * @param p 玩家
 * @return 玩家可抵押资产全部抵押可获得的钱
 */
public static int getmortgageqian(Player p ) {
	List<dfwpoint> temp=main.point;
	int qian=0;
	for(int i=0;i<temp.size();i++) {
		dfwpoint point =temp.get(i);
		if(point.getlx().isenablemortgage()) {
			if(p.equals(point.getlx().getowner())) {
				qian=qian+point.getlx().getmortgageqian();
				}
			}
			}
	return qian;
}
/**
 * 给玩家钱
 * @param p 玩家
 * @param qian 金额
 */
public static void give(Player p,int qian) {
	int i =main.dfwplayers.indexOf(p);
	main.qian.set(i,main.its(main.sti(main.qian.get(i))+qian));
}
}
