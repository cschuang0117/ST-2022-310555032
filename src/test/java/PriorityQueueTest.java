import com.sun.jdi.connect.Connector;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PriorityQueueTest {
    static Stream<Arguments> streamProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{-3, -1, -2, 5}, new int[]{-3, -2, -1, 5}),
                Arguments.of(new int[]{3, -2, -5, -1, 2}, new int[]{-5, -2, -1, 2, 3}),
                Arguments.of(new int[]{-3, 1, 11, 0, 9, 3}, new int[]{-3, 0, 1, 3, 9, 11}),
                Arguments.of(new int[]{3, 7, 2, -1, -2}, new int[]{-2, -1, 2, 3, 7})
        );
    }


    @ParameterizedTest(name = "#{index} - Test with Argument = {0}, {1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array,int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];
        for(int i = 0 ; i < random_array.length; i++) {
            test.add(random_array[i]);
        }
        for(int i = 0 ; i < random_array.length; i++) {
            result[i] = test.poll();
        }
        assertArrayEquals(correct_array, result);
    }
    @Test
    public void whenExceptionThrown_NullPointerException1(){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        Exception exception = assertThrows(NullPointerException.class, ()->{test.offer(null);});
        /*String expectedMessage = "For input String";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));*/
    }
    @Test
    public void whenExceptionThrown_NullPointerException2(){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        Exception exception = assertThrows(NullPointerException.class, ()->{test.add(null);});
        /*String expectedMessage = "For input String";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));*/
    }
    @Test
    public void whenExceptionThrown_NullPointerException3(){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        Object a[] = null;
        //System.out.println(test.toArray(a));
        //System.out.println("??");
	//
        Exception exception = assertThrows(NullPointerException.class, ()->{test.toArray();});
    }
}
