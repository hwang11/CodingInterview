package Stack6;
import java.util.*;

public class AnimalQueue {
	LinkedList dogs = new LinkedList();
	LinkedList cats = new LinkedList();
	private int order = 0; // timestamp의 역할을 한다.
	
	public void enqueue(Animal a) {
		//개와 고양이의 수용 순서를 비교하기 위해 timestamp를 사용해서 이들의 순서를정한다.
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog) dogs.addLast((Dog)a);
		else if(a instanceof Cat) cats.addLast((Cat)a);
	}
	public Animal dequeueAny() {
		//개와 고양이 큐의 맨앞을 살펴본뒤 그중 더 오래전에 들어온 동물을 큐에서 빼낸다.
		if(dogs.size()==0) {
			return (Animal) dequeueCats();
		}else if(cats.size() == 0) {
			return (Animal) dequeueDogs();
		}
		Dog dog = (Dog) dogs.peek();
		Cat cat = (Cat) cats.peek();
		if(((Animal) dog).isOlderThan(cat)) {
			return (Animal) dequeueDogs();
		}else {
			return (Animal) dequeueCats();
		}
		
	}
	public Dog dequeueDogs() {
		return (Dog) dogs.poll();
	}
	public Cat dequeueCats() {
		return (Cat) cats.poll();
	}
	
	public static void main(String args[]) {
		AnimalQueue an = new AnimalQueue();
		Cat	c1 = new Cat("냥이1");
		Cat	c2 = new Cat("냥이2");
		Cat	c3 = new Cat("냥이3");
		Dog d1 = new Dog("댕댕1");
		Dog d2 = new Dog("댕댕2");
		Dog d3 = new Dog("댕댕3");
		
		an.enqueue(c1);
		an.enqueue(c2);
		an.enqueue(c3);
		an.enqueue(d1);
		an.enqueue(d2);
		an.enqueue(d3);
		
		/*Scanner sc = new Scanner(System.in);
		
		if(sc.nextLine() == "냥이") {
			an.dequeueAny();
		}else if(sc.nextLine() == "댕") {
			an.dequeueAny();
		}*/
		System.out.println(an.dequeueDogs().name);
		System.out.println(an.dequeueCats().name);
		System.out.println(an.dequeueAny().name);
	}
	
}

