import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.uninorte.AndresyMaria;


public class AndresListTest {
    
    // create all test for the List class

    // test the add method
    @Test
    public void testAdd() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    // test the get method
    @Test
    public void testGet() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
    }

    // test the remove method
    @Test
    public void testRemove() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
    }

    // test the size method
    @Test
    public void testSize() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    // test the clear method
    @Test
    public void testClear() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
    }

    // test the isEmpty method
    @Test
    public void testIsEmpty() {
        List<Integer> list = new AndresyMaria<>();
        assertEquals(true, list.isEmpty());
    }

    // test the contains method
    @Test
    public void testContains() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(true, list.contains(2));
    }

    // test the indexOf method
    @Test
    public void testIndexOf() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.indexOf(2));
    }

    // test the lastIndexOf method
    @Test
    public void testLastIndexOf() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        assertEquals(3, list.lastIndexOf(2));
    }

    // test the toArray method

    // test the addAll method
    @Test
    public void testAddAll() {
        List<Integer> list = new AndresyMaria<>();
        List<Integer> list2 = new AndresyMaria<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.addAll(list2);
        assertEquals(3, list.size());
    }


    // test the addAll method with index
    @Test
    public void testAddAllIndex() {
        List<Integer> list = new AndresyMaria<>();
        List<Integer> list2 = new AndresyMaria<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.addAll(0, list2);
        assertEquals(3, list.size());
    }

    // test the set method
    @Test
    public void testSet() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);
        assertEquals(4, list.get(1));
    }

    // test the remove with index method
    @Test
    public void testRemoveIndex() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
    }

    // test the remove with object method
    @Test
    public void testRemoveObject() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(Integer.valueOf(2));
        assertEquals(2, list.size());
    }

    // test the removeAll method
    @Test
    public void testRemoveAll() {
        List<Integer> list = new AndresyMaria<>();
        List<Integer> list2 = new AndresyMaria<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeAll(list2);
        assertEquals(0, list.size());
    }

    // test the retainAll method
    @Test
    public void testRetainAll() {
        List<Integer> list = new AndresyMaria<>();
        List<Integer> list2 = new AndresyMaria<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.retainAll(list2);
        assertEquals(3, list.size());
    }

    // test the containsAll method
    @Test
    public void testContainsAll() {
        List<Integer> list = new AndresyMaria<>();
        List<Integer> list2 = new AndresyMaria<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(true, list.containsAll(list2));
    }

    // test the subList method
    @Test
    public void testSubList() {
        List<Integer> list = new AndresyMaria<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list2 = (List<Integer>) list.subList(0, 2);
        assertEquals(2, list2.size());
    }

    // test the iterator method
    // test the listIterator method
    // test the listIterator method with index



}