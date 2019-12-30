package extra;

import java.util.ArrayList;
import java.util.List;

public class Entity {
	
	private String name;
	private int data;
	List<Entity> entity = new ArrayList<Entity>();
	
	public Entity()	{
		
	}
	
	public Entity(String name)	{
		this.name = name;
	}
	
	public Entity(String name, int data)	{
		this.name = name;
		this.data = data;
	}

	
	public void setData(int data)	{
		this.data = data;
	}
	public int getData()	{
		return this.data;
	}
	
	
	public void notifyAllEntities(int data)	{
		for(Entity obj : this.entity)
			obj.update(data);
	}
	
	public void update(int data)	{
		this.data = data;
		System.out.println("Entity [ Name : " + this.name + ", " + this.data + " ] is Updated...!!");
	}
	
	
	
	public void subscribe(Entity entity)	{
		this.entity.add(entity);
	}
	
	public void unSubscribe(Entity entity)	{
		this.entity.remove(entity);
	}

	
	
	@Override
	public String toString() {
		return "Entity [ Name = " + this.name + ", Data = " + this.data + " ]";
	}
}
