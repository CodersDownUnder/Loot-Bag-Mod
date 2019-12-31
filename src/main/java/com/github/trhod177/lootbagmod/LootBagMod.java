package com.github.trhod177.lootbagmod;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.trhod177.lootbagmod.LootBagConfig;

@Mod(modid = LootBagMod.MODID, version = LootBagMod.VERSION, name = LootBagMod.NAME)
public class LootBagMod {
	public static final String MODID = "lootbagmod";
	public static final String VERSION = "1.1";
	public static final String NAME = "Loot Bag Mod";

	@Mod.Instance
	public static LootBagMod instance;

	@SidedProxy(clientSide = "com.github.trhod177.lootbagmod.ClientProxy", serverSide = "com.github.trhod177.lootbagmod.ServerProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e); 
		LootTables.registerTables();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
		// listItems();
		// listBlocks();
		
		for (Object item : Item.REGISTRY) {
			String name = Item.REGISTRY.getNameForObject((Item) item).toString();

			if (true) {
				ItemBasicRewardBag.Droppables.add(name.toString());
			}
		}
		
		List<String> stringList = new ArrayList<String>(Arrays.asList(LootBagConfig.Blacklist));
	
		ItemBasicRewardBag.Droppables.removeAll(stringList);
		
		if (LootBagConfig.debugmode == true) {
		System.out.println(ItemBasicRewardBag.Droppables);
		listItems();
		blackListItems();
		}
	
	}		
	
	 @Mod.EventBusSubscriber(modid = LootBagMod.MODID)
	    static class LootTables {
	    	
	    	public static void registerTables() {
	    		
	    		registerTable("desert_pyramid");
	    		registerTable("abandoned_mineshaft");
	    		registerTable("end_city_treasure");
	    		registerTable("jungle_temple");
	    		registerTable("simple_dungeon");
	    		registerTable("stronghold_corridor");
	    		registerTable("stronghold_crossing");
	    		registerTable("stronghold_library");
	    		
	    	}
	    	
	    	@SubscribeEvent
	    	public static void onEvent(LootTableLoadEvent event) {
	    		
	    		LootTable table = event.getTable();
	    		String tableName = event.getName().toString();
	    		
	    		if (tableName.equals("minecraft:chests/desert_pyramid")) { table.addPool(newPoolEntry("desert_pyramid")); }
	    		if (tableName.equals("minecraft:chests/abandoned_mineshaft")) { table.addPool(newPoolEntry("abandoned_mineshaft")); } 
	    		if (tableName.equals("minecraft:chests/end_city_treasure")) { table.addPool(newPoolEntry("end_city_treasure")); } 
	    		if (tableName.equals("minecraft:chests/jungle_temple")) { table.addPool(newPoolEntry("jungle_temple")); } 
	    		if (tableName.equals("minecraft:chests/simple_dungeon")) { table.addPool(newPoolEntry("simple_dungeon")); } 
	    		if (tableName.equals("minecraft:chests/stronghold_corridor")) { table.addPool(newPoolEntry("stronghold_corridor")); } 
	    		if (tableName.equals("minecraft:chests/stronghold_crossing")) { table.addPool(newPoolEntry("stronghold_crossing")); } 
	    		if (tableName.equals("minecraft:chests/stronghold_library")) { table.addPool(newPoolEntry("stronghold_library")); } 
	    	}
	    	
	    	public static void registerTable(String name) {
	    		
	    		LootTableList.register(new ResourceLocation(MODID, "inject/" + name));
	    		
	    	}
	    	
	    	public static LootPool newPoolEntry(String name) {
	    		
	    		return new LootPool(new LootEntry[] {new LootEntryTable(new ResourceLocation(MODID, "inject/" + name), 1, 0, new LootCondition[0], "slaughtercraft")}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "slaughtercraft");
	    		
	    	}

	    }

	
	public static void listItems() {	
		BufferedWriter outstream = null;
		File itemlist = new File("config/" + MODID + "-droppableitems.txt");
		if(itemlist.exists()) itemlist.delete(); 
		try {
			outstream = new BufferedWriter(new 
					FileWriter(itemlist.toString()));
			
			for (String item : ItemBasicRewardBag.Droppables) {
				String name = item;

				if (true) {
					outstream.write(name);
					outstream.newLine();
				}
			}
			
			if(outstream != null) outstream.close();
		} catch (IOException e) {
			System.err.println("Error: Could not write file droppableitems.txt");
			e.printStackTrace();
		}		
	}
	
	
	public static void blackListItems() {	
		BufferedWriter outstream = null;
		File itemlist = new File("config/" + MODID + "-blacklisteditems.txt");
		if(itemlist.exists()) itemlist.delete(); 
		try {
			outstream = new BufferedWriter(new 
					FileWriter(itemlist.toString()));
			
			for (String item : LootBagConfig.Blacklist) {
				String name = item;

				if (true) {
					outstream.write(name);
					outstream.newLine();
				}
			}
			
			if(outstream != null) outstream.close();
		} catch (IOException e) {
			System.err.println("Error: Could not write file blacklisteditems.txt");
			e.printStackTrace();
		}		
	}

}
