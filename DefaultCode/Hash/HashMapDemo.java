import java.util.HashMap;

/**
 * @author Nate Fuller
 * HashMap is like ArrayList, except it uses the hashing algorithm.
 * Implements the MAP interface and uses a key object to map to a value object.
 * Is useful when you want to quickly retrieve the value object when given the key object.
 *
 * Other methods to use from MAP interface:
 * 
 * public BASE_TYPE_VALUE put(BASE_TYPE_KEY k, BASE_TYPE_VALUE v)
 * public BASE_TYPE_VALUE get(Object k)
 * public void clear()
 * public BASE_TYPE_VALUE remove(Object k)
 * public boolean containsKey(Object k)
 * public boolean containsValue(Object v)
 * public boolean isEmpty()
 * public int size()
 * public Set <BASE_TYPE_KEY> keySet() //returns a set containing all the keys in the map.
 * public Collection <BASE_TYPE_VALUES> values() //returns a collection containing all the values in the map.
 */

public class HashMapDemo
{
	public static void main(String[] args)
	{
		HashMap<String, Integer> mountains = new HashMap<String, Integer>();
		
		mountains.put("Everest", 29029);
		mountains.put("K2", 28251);
		mountains.put("Kangchenjunga", 28169);
		mountains.put("Denali", 20335);
		printMap(mountains);
		System.out.println("Denali in the map: " + mountains.containsKey("Denali"));
		System.out.println("Changing height of Denali.");
		mountains.put("Denali", 20320);
		printMap(mountains);
		System.out.println("Removing Kangchenjunga");
		mountains.remove("Kangchenjunga");
		printMap(mountains);
	}
	
	public static void printMap(HashMap<String, Integer> map)
	{
		System.out.println("Map contains:");
		for(String keyMountainName : map.keySet())
		{
			Integer height = map.get(keyMountainName);
			System.out.println(keyMountainName + " --> " +
					height.intValue() + " feet.");
		}
	}
}
