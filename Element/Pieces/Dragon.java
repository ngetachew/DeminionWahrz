package Element.Pieces;

import Element.Unit;
import Element.Element;
import Grid.GameGrid;

public class Dragon extends Unit //
{
	//private float burnChance; Mess with this later
	
	public Dragon(int x, int y, GameGrid gr){
		super("Dragon", "imageName", 5, Race.TOKKOKINO, "soldier", 5, 0, 1, 2, 5);
		putSelfInGrid(gr, x, y);
		//burnChance = 10;
	}
	
	public void attack(Element element){
		element.setHealth(element.getHealth() - getDamageDealt());
	}
	
	public void attack(Unit u){
		int damage = getDamageDealt() - u.getDefense();
		if(u.getHealth() <= damage){
			u.setHealth(u.getHealth() - damage);
		}else{
			u.setHealth(u.getHealth() - damage);
			setHealth(getHealth() - (u.getDamageDealt() - getDefense()));
		}
	}
	public void move(int row, int col)
	{
		moveTo(row, col);
		getGameGrid().getTile(row, col).setElement(this);
		//modify tile's setElement so that it changes unit's damage dealt
	}
	
}