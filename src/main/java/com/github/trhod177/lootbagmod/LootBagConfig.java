package com.github.trhod177.lootbagmod;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = LootBagMod.MODID, name = LootBagMod.NAME)
public class LootBagConfig {
	
	@Comment("How many items/blocks drop when you use a loot bag")
	public static int drops = 10;
	
	@Comment("Enabled Debug Mode")
	public static boolean debugmode = false;
	
	@Comment("Blacklist")
	public static String[] Blacklist = {
		"minecraft:air",
		"minecraft:command_block",
		"minecraft:structure_block",
		"minecraft:knowledge_book",
		"minecraft:chain_command_block",
		"minecraft:repeating_command_block",
		"minecraft:barrier",
		"minecraft:enchanted_book",
		"minecraft:written_book",
		"minecraft:potion",
		"minecraft:splash_potion",
		"minecraft:lingering_potion",
		"minecraft:spawn_egg",
		"minecraft:structure_void",
		"minecraft:mob_spawner",
		"thermalfoundation:fluid_crude_oil",
		"thermalfoundation:fluid_redstone",
		"thermalfoundation:fluid_glowstone",
		"thermalfoundation:fluid_ender",
		"thermalfoundation:fluid_pyrotheum",
		"thermalfoundation:fluid_cryotheum",
		"thermalfoundation:fluid_aerotheum",
		"thermalfoundation:fluid_petrotheum",
		"thermalfoundation:fluid_mana",
		"thermalfoundation:ore_fluid",
		"thermalfoundation:ore",
		"appliedenergistics2:material",
		"appliedenergistics2:cable_bus",
		"appliedenergistics2:paint_ball",
		"appliedenergistics2:paint",
		"appliedenergistics2:dummy_fluid_item",
		"appliedenergistics2:facade",
		"tconstruct:pattern",
		"tconstruct:materials",
		"tconstruct:nuggets",
		"tconstruct:ingots",
		"tconstruct:edible",
		"tconstruct:metal",
		"tconstruct:shard",
		"tconstruct:sharpening_kit",
		"tconstruct:pick_head",
		"tconstruct:shovel_head",
		"tconstruct:axe_head",
		"tconstruct:broad_axe_head",
		"tconstruct:sword_blade",
		"tconstruct:large_sword_blade",
		"tconstruct:hammer_head",
		"tconstruct:excavator_head",
		"tconstruct:kama_head",
		"tconstruct:scythe_head",
		"tconstruct:pan_head",
		"tconstruct:sign_head",
		"tconstruct:tool_rod",
		"tconstruct:tough_tool_rod",
		"tconstruct:binding",
		"tconstruct:tough_binding",
		"tconstruct:wide_guard",
		"tconstruct:hand_guard",
		"tconstruct:cross_guard",
		"tconstruct:large_plate",
		"tconstruct:knife_blade",
		"tconstruct:bow_limb",
		"tconstruct:bow_string",
		"tconstruct:arrow_head",
		"tconstruct:arrow_shaft",
		"tconstruct:fletching",
		"tconstruct:bolt_core",
		"tconstruct:pickaxe",
		"tconstruct:shovel",
		"tconstruct:hatchet",
		"tconstruct:mattock",
		"tconstruct:kama",
		"tconstruct:hammer",
		"tconstruct:excavator",
		"tconstruct:lumberaxe",
		"tconstruct:scythe",
		"tconstruct:broadsword",
		"tconstruct:longsword",
		"tconstruct:rapier",
		"tconstruct:frypan",
		"tconstruct:battlesign",
		"tconstruct:cleaver",
		"tconstruct:shortbow",
		"tconstruct:longbow",
		"tconstruct:crossbow",
		"tconstruct:arrow",
		"tconstruct:bolt",
		"tconstruct:shuriken",
		"tconstruct:cast",
		"tconstruct:cast_custom",
		"tconstruct:clay_cast",
		"tconstruct:fancy_frame",
		"conarm:helmet_core",
		"conarm:armor_trim",
		"conarm:armor_plate",
		"conarm:chest_core",
		"conarm:leggings_core",
		"conarm:boots_core",
		"conarm:helmet",
		"conarm:chestplate",
		"conarm:leggings",
		"conarm:boots",
		"conarm:polishing_kit",
		"thermalexpansion:machine",
		"thermalexpansion:apparatus",
		"thermalexpansion:device",
		"thermalexpansion:dynamo",
		"thermalexpansion:cell",
		"thermalexpansion:tank",
		"thermalexpansion:cache",
		"thermalexpansion:strongbox",
		"thermalexpansion:capacitor",
		"thermalexpansion:reservoir",
		"thermalexpansion:satchel",
		"thermalexpansion:frame",
		"thermalexpansion:augment",
		"thermalexpansion:florb",
		"thermalexpansion:morb",
		"thermalfoundation:coin",
		"thermalfoundation:fertilizer",
		"thermalfoundation:bait",
		"thermalfoundation:dye",
		"thermalfoundation:material",
		"thermalfoundation:upgrade",
		"thermalfoundation:ore",
		"thermalfoundation:ore_fluid",
		"thermalfoundation:storage",
		"thermalfoundation:storage_alloy",
		"thermalfoundation:storage_resource",
		"thermalfoundation:glass",
		"thermalfoundation:glass_alloy",
		"thermalfoundation:rockwool",
		"projecte:item.pe_wind_projectile",
		"projecte:item.pe_lava_orb",
		"projecte:item.pe_water_orb"
		

	};
	
	@Comment("Max Stack Size")
	public static int stacksize = 5; 

	@Mod.EventBusSubscriber(modid = LootBagMod.MODID)
	private static class EventHandler {

		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(LootBagMod.MODID)) {
				ConfigManager.sync(LootBagMod.MODID, Config.Type.INSTANCE);
			}
		}
	}
	
}
