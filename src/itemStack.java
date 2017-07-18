
public class itemStack {
public ItemBase item;
public int ammount;
public itemStack(ItemBase i, int am){
	item = i;
	ammount = am;
}

public itemStack() {
	item = null;
	ammount = 0;
}

public void addToStack(int amm){
	ammount += amm;
}
public boolean takeFromStack(int amm){
	ammount -= amm;
	if (ammount <= 0){
		return false;
	}
	return true;
}
public ItemBase getItem(){
	return item;
}

public void setItem(ItemBase ib){
	item = ib;
}


}
