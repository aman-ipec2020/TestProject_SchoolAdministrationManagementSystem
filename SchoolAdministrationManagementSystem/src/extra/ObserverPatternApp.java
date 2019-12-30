package extra;

public class ObserverPatternApp {

	public static void main(String[] args) {
		
		Entity entity1 = new Entity("Aman");
		
			Entity entity2 = new Entity("Sonam");
			Entity entity3 = new Entity("Harsh");
			Entity entity4 = new Entity("Kiran");
			Entity entity5 = new Entity("Pravin");
		
		entity1.subscribe(entity2);
		entity1.subscribe(entity3);
		entity1.subscribe(entity4);
		entity1.subscribe(entity5);
		
		entity1.notifyAllEntities(10);
		System.out.println(entity1);
		
		System.out.println();
		
		entity1.unSubscribe(entity3);
		
		entity1.setData(20);
		entity1.notifyAllEntities(entity1.getData());
		System.out.println(entity1);
	}
}
