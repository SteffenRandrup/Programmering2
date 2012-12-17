import java.util.*;

public class MultiSet<E> extends AbstractCollection<E> {

	private HashMap<E, Integer> hm;
	private Set<E> set;

	public MultiSet() {
		instatiateVariables();
	}

	public MultiSet(Collection<E> c) {
		instatiateVariables();
		addAll(c);
	}

	private void instatiateVariables() {
		hm = new HashMap<E, Integer>();
		set = hm.keySet();
	}

	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
//			E element = set.iterator().next();
//			int unik = hm.get(element);
			E element;
			int unik;
			
			public boolean hasNext() {	
				
				if(unik > 0){
					return true;
				}
				return set.iterator().hasNext();
			}

			public E next() {
				if(unik > 0){
					unik--;
					System.out.println(unik);
					return element;
				}
			
				element = set.iterator().next();
				unik = hm.get(element);
				
				return element;
				
				// set.iterator().next rykker ikke til det næste element i sættet!!!!
				// Er ideen med at bruge set ikke lige netop, at jeg kan kalde denne
				// funktion for at få næste key i mit hashMap???
				//
				// Ved udskrifter er jeg kommet frem til
				// set = ["foo","bar"]
				// element = "foo"
				// element = set.iterator().next();
				// element = "foo"
				//
				// I det sidste skridt troede jeg, at den skulle være ændret fra "foo" til "bar",
				// men curseren har ikke rykket sig! Hvilket, som jeg havde forstået det, er meningen
				// med next() metoden.
				// 
				// Den tager helt rigtigt det første element, men så bevæger den sig ikke videre
				
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
	}

	@Override
	public int size() {

		int result = 0;
		for(E e : set){
			result = result + hm.get(e);
		}
		System.out.println(result);
		return result;
	}

	@Override
	public boolean add(E e) {

		int value = 1;		
		if (hm.containsKey(e)) {
			value = hm.get(e) + 1;
		}
		hm.put(e, value);
		return true;
	}

	@Override
	public String toString() {
		return hm.toString();
	}

	@Override
	public int hashCode() {
		return hm.hashCode();
	}

	@Override
	public boolean remove(Object o) {
		@SuppressWarnings("unchecked")
		E e = (E) o;
		if (hm.containsKey(e)) {
			int value = hm.get(e);
			
			if(value > 1){
				hm.put(e, value-1);
			} else {
				hm.remove(e);
			}

			return true;
		} else {
			
			return false;
		}
	}

	@Override
	public boolean equals(Object o) {			
		if(this == o) return true;
		if(o == null) return false;
		if(getClass() != o.getClass()) return false;
		
		@SuppressWarnings("unchecked")
		MultiSet<E> test = (MultiSet<E>) o;		
		return hm.equals(test.returnHashMap());
	}
	
	public HashMap<E, Integer> returnHashMap(){
		return hm;
	}
}
















