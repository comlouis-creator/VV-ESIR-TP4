package fr.istic.vv;
import net.jqwik.api.*;


public class BinaryHeapTest {
    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }
    
    private BinaryHeap<Integer> heap;

    @BeforeEach
    void setUp() {
        heap = new BinaryHeap<>(Comparator.naturalOrder());
    }

    @Property
    void popReturnsMinimumElement(@ForAll int element) {
        heap.push(element);
        int minElement = Collections.min(heap.getElements());
        assertEquals(minElement, heap.pop());
    }
    
}
