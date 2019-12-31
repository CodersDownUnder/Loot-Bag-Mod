package com.github.trhod177.lootbagmod;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
    }

    @SubscribeEvent
    public void postInit(FMLPostInitializationEvent e) {
    	
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	
    	 event.getRegistry().register(new ItemBasicRewardBag());
    }
    
}
