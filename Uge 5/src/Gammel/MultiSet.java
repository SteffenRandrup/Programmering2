import java.util.*;

public class MultiSet<E> extends AbstractCollection<E> {

	private HashMap<E, Integer> hm;
	private Set<E> set;

	public MultiSet() {

		instatiateVariables();
	}

	public MultiSet(Collection<E> c) {
		instatiateVariables();
		//TODO her skal bruges addAll
		for (E e : c) {
			add(e);
		}
	}

	private void instatiateVariables() {

		hm = new HashMap<E, Integer>();
		set = hm.keySet();
	}

	@Override
	public Iterator<E> iterator() {
//		return new Iterator<E>() {
//
//			@Override
//			public boolean hasNext() {
//				return set.iterator().hasNext();
//			}
//
//			@Override
//			public E next() {
//				System.out.println(set.iterator().next());
//				return (E) set.iterator().next();
//			}
//
//			@Override
//			public void remove() {
//				throw new UnsupportedOperationException();
//			}
//
//		};
		return set.iterator();
		//TODO skal løbe over alle elementer ikke kun forskellige elementer
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
		@SuppressWarnings("unchecked")
		MultiSet<E> test = (MultiSet<E>) o;		
		return hm.equals(test.returnHashMap());
	}
	
	public HashMap<E, Integer> returnHashMap(){
		return hm;
	}
}
















