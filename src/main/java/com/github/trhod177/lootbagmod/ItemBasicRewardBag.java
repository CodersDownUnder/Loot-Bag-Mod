package com.github.trhod177.lootbagmod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicRewardBag extends Item {

	public static ArrayList<String> Droppables = new ArrayList<String>();
	
	public ItemBasicRewardBag() {
		setRegistryName("lootbag");
		setUnlocalizedName(LootBagMod.MODID + ".lootbag");
		setCreativeTab(CreativeTabs.MISC);
		//this.maxStackSize = 1;

	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		
		Random rand = new Random();
		if (!worldIn.isRemote) {

			
			int drops = LootBagConfig.drops;
			for (drops = 0; drops < 10; drops++) {
				int n = rand.nextInt(Droppables.size());
				int split = rand.nextInt(LootBagConfig.stacksize);
				int n2 = rand.nextInt(LootBagConfig.stacksize - split);
				Collections.shuffle(Droppables);
				if (LootBagConfig.debugmode == true) {
				System.out.println(Droppables.get(n));
				}
				if (n2 >= 1) {
			
					playerIn.dropItem(new ItemStack(Item.getByNameOrId(Droppables.get(n)), n2), true);
				} else if (n2 <= 0) {
					int n3 = n2 + 1;
					playerIn.dropItem(new ItemStack(Item.getByNameOrId(Droppables.get(n)), n3), true);
				}
				
				
			}
			
		} else {

		}
		
		 if(playerIn.inventory.hasItemStack(new ItemStack(this)))
	        {
	            int invSize = playerIn.inventory.getSizeInventory();
	            for(int i=0; i<invSize; i++)
	            {
	                if(playerIn.inventory.getStackInSlot(i).getItem() == this)
	                {
	                    ItemStack IronIngotFound = playerIn.inventory.getStackInSlot(i);
	                    int stacksize = IronIngotFound.getCount();
	                    IronIngotFound.setCount(stacksize -1);;
	                }
	            }
	        }
	        
	        
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
