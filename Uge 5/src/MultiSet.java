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
		final Iterator<E> it = set.iterator();
		return new Iterator<E>() {
			
			E element;
			int unik;
			
			
			
			public boolean hasNext() {	
				//return unik > 0 || it.hasNext();
				
				if(unik > 0){
					return true;
				}
				return it.hasNext();
			}

			public E next() {
				if(unik > 0){
					unik--;
					return element;
				}
			
				element = it.next();
				unik = hm.get(element)-1;
				
				return element;
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
		if (!hm.containsKey(e)) {
			return false;
		}

		
		
		int value = hm.get(e);

		if(value > 1){
			hm.put(e, value-1);
		} else {
			hm.remove(e);
		}

		return true;

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
















