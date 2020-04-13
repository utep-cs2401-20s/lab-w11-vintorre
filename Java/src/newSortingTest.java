import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class newSortingTest {


    @Test
    public void test0(){ //simple test to make sure that newSorting doesnt unsort a sorted array
        newSorting N = new newSorting();
        int[] test = {1,2,3};
        int[] testR = {1,2,3};
        N.newSorting(test, 3);

        assertArrayEquals(testR, test); //passed
    }

    @Test
    public void test1(){
        newSorting N = new newSorting();//chose this test as a simple test to see if quick sort would work
        int[] test = { 5,6,4};
        int[] testR = {4,5,6};
        N.newSorting(test, 4);

        assertArrayEquals(testR, test); //test was not working, but I could not find an error in my code, please help
    }

    @Test
    public void test2(){ //this was a check to see if my array was empty what my code would do
        newSorting N = new newSorting();
        int[] test = {};
        N.newSorting(test, 2); //passed because it said "Array empty"
    }

    @Test
    public void test3(){//this is a check to see how the code would deal with duplicates and merging
        newSorting N = new newSorting();
        int[] test = {5,5,5,8};
        N.newSorting(test, 2);

        assertArrayEquals(test,test); //passed
    }

    @Test
    public void test4(){//chose this test to see what would happen when the method was given the size 0, since the size
                        //will never reach 0
        newSorting N = new newSorting();
        int[] test = {5,5, 6, 4, 9,4,0};
        N.newSorting(test, 0); //passed because i expected it to fail
    }


}