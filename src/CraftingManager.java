import java.util.*;


public class CraftingManager {

public List<itemStack> getPossibleCraftingRecipes(itemStack[][] inventory){
	List<itemStack> possibleCrafts = new LinkedList<itemStack>();
	for (int i = 0; i < recipes.size(); i++){
		int itemsGotten[] = new int[recipes.get(i).itemAmmounts.size()];
		
		for (int x = 0; x<recipes.get(i).itemAmmounts.size();x++){
			itemsGotten[x] = recipes.get(i).itemAmmounts.get(x);
		}
		
		for (int i1 = 0; i1<8; i1++){
			for (int i2 = 0; i2<3; i2++){
				for (int in = 0; in < recipes.get(i).requiredItems.size(); in++){
					
					if (inventory[i1][i2].item == recipes.get(i).requiredItems.get(in)){
						itemsGotten[in] -= inventory[i1][i2].ammount;
					}
					
				}
			}
		}
		
		boolean flag = false;
		for (int x = 0; x<recipes.get(i).itemAmmounts.size();x++){
			if (itemsGotten[x] <= 0){
			}else{
				flag = true;
			}
		}
		
		if (flag == false){
			possibleCrafts.add(recipes.get(i).result);
		}
		
		
		
	}
	return possibleCrafts;
}


public void craftItemBasedOnItemStack(itemStack itemcrafted, EntityPlayer ep){
	for (int i = 0; i < recipes.size();i++){
		if (recipes.get(i).result.item == itemcrafted.item){
			for (int z = 0; z <recipes.get(i).requiredItems.size(); z++){
			int left = recipes.get(i).itemAmmounts.get(z);
				
			for (int a = 0; a < 8; a++){
				for (int b = 0; b < 3; b++){
					if (ep.inventory[a][b].item == recipes.get(i).requiredItems.get(z)){
						
						if (ep.inventory[a][b].ammount <= left){
							left -= ep.inventory[a][b].ammount;
							ep.inventory[a][b].item = null;
						}else{
							ep.inventory[a][b].ammount -= left;
							left = 0;
						}
						
						
					}
				}
			}
			}
			
			
			
			
			
		}
	}
	ep.addToInventory(itemcrafted.item.itemId, itemcrafted.ammount);
}


public void addRecipes(){
	
	
//planks
planks.requiredItems.add(Item.ItemWood.getItem());
planks.itemAmmounts.add(1);
planks.result = new itemStack();
planks.result.ammount = 4;
planks.result.item = Item.ItemStick.getItem();
recipes.add(planks);
//end of planks
//wooden pickaxe
WPick.requiredItems.add(Item.ItemWood.getItem());
WPick.requiredItems.add(Item.ItemStick.getItem());
WPick.itemAmmounts.add(3);
WPick.itemAmmounts.add(2);
WPick.result = new itemStack();
WPick.result.ammount = 1;
WPick.result.item = Item.WoodenPickaxe.getItem();
recipes.add(WPick);
//end of wooden pickaxe
//start of dirt backing
DBack.requiredItems.add(Item.DirtBlock.getItem());
DBack.itemAmmounts.add(1);
DBack.result = new itemStack();
DBack.result.ammount = 2;
DBack.result.item = Item.DirtBack.getItem();
recipes.add(DBack);
//end of dirt backing
//start of cobble backing
CBack.requiredItems.add(Item.StoneBlock.getItem());
CBack.itemAmmounts.add(1);
CBack.result = new itemStack();
CBack.result.ammount = 2;
CBack.result.item = Item.CobbleBack.getItem();
recipes.add(CBack);
//end of cobble backing
//start of sulphur
Sulphur.requiredItems.add(Item.StoneBlock.getItem());
Sulphur.itemAmmounts.add(1);
Sulphur.requiredItems.add(Item.ItemCoal.getItem());
Sulphur.itemAmmounts.add(1);
Sulphur.requiredItems.add(Item.ItemWood.getItem());
Sulphur.itemAmmounts.add(1);
Sulphur.requiredItems.add(Item.DirtBlock.getItem());
Sulphur.itemAmmounts.add(1);
Sulphur.result = new itemStack();
Sulphur.result.ammount = 5;
Sulphur.result.item = Item.ItemSulphur.getItem();
recipes.add(Sulphur);
//end of sulphur
//start of sulphur
TNT.requiredItems.add(Item.ItemSulphur.getItem());
TNT.itemAmmounts.add(4);
TNT.result = new itemStack();
TNT.result.ammount = 1;
TNT.result.item = Item.TNTBlock.getItem();
recipes.add(TNT);
//end of sulphur


}


public List<CraftingRecipeBase> recipes = new LinkedList<CraftingRecipeBase>();
private CraftingRecipeBase planks = new CraftingRecipeBase();
private CraftingRecipeBase WPick = new CraftingRecipeBase();
private CraftingRecipeBase DBack = new CraftingRecipeBase();
private CraftingRecipeBase CBack = new CraftingRecipeBase();
private CraftingRecipeBase Sulphur = new CraftingRecipeBase();
private CraftingRecipeBase TNT = new CraftingRecipeBase();
}
