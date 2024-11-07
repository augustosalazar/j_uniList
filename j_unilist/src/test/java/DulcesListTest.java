import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.uninorte.DulcesList;

public class DulcesListTest {
    
    // create all test for the DulcesList class

    // test the add method
    @Test
    public void testAdd() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    // test the get method
    @Test
    public void testGet() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
    }

    // test the remove method
    @Test
    public void testRemove() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
    }

    // test the size method
    @Test
    public void testSize() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    // test the clear method
    @Test
    public void testClear() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
    }

    // test the isEmpty method
    @Test
    public void testIsEmpty() {
        DulcesList list = new DulcesList();
        assertEquals(true, list.isEmpty());
    }

    // test the contains method
    @Test
    public void testContains() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(true, list.contains(2));
    }

    // test the indexOf method
    @Test
    public void testIndexOf() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.indexOf(2));
    }

    // test the lastIndexOf method
    @Test
    public void testLastIndexOf() {
        DulcesList list = new DulcesList();
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
        DulcesList list = new DulcesList();
        DulcesList list2 = new DulcesList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.addAll(list2);
        assertEquals(3, list.size());
    }


    // test the addAll method with index
    @Test
    public void testAddAllIndex() {
        DulcesList list = new DulcesList();
        DulcesList list2 = new DulcesList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.addAll(0, list2);
        assertEquals(3, list.size());
    }

    // test the set method
    @Test
    public void testSet() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);
        assertEquals(4, list.get(1));
    }

    // test the remove with index method
    @Test
    public void testRemoveIndex() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
    }

    // test the remove with object method
    @Test
    public void testRemoveObject() {
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(Integer.valueOf(2));
        assertEquals(2, list.size());
    }

    // test the removeAll method
    @Test
    public void testRemoveAll() {
        DulcesList list = new DulcesList();
        DulcesList list2 = new DulcesList();
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
        DulcesList list = new DulcesList();
        DulcesList list2 = new DulcesList();
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
        DulcesList list = new DulcesList();
        DulcesList list2 = new DulcesList();
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
        DulcesList list = new DulcesList();
        list.add(1);
        list.add(2);
        list.add(3);
        DulcesList list2 = (DulcesList) list.subList(0, 2);
        assertEquals(2, list2.size());
    }

    // test the iterator method
    // test the listIterator method
    // test the listIterator method with index



}
