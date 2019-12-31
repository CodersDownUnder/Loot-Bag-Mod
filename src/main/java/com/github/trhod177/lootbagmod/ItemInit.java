package com.github.trhod177.lootbagmod;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemInit {
	
    @ObjectHolder("lootbagmod:lootbag")
    public static ItemBasicRewardBag lootbag;
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
       lootbag.initModel();
    }

}
