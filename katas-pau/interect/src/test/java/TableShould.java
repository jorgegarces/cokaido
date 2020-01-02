import org.junit.Assert;
import org.junit.Test;

public class TableShould {
    @Test
    public void work_when_vectors_share_size_and_element_values(){
        double[] v1 = {2,2,2,2};
        double[] v2 = {2,2,2,2};
        double[] expected = {2};
        Assert.assertArrayEquals(expected, Table.intersection(v1, v2), 0);
    }

    @Test
    public void work_when_vectors_share_size_but_no_element_values_are_repeated(){
        double[] v1 = {2,2,2,2};
        double[] v2 = {1,1,1,1};
        double[] expected = {};
        Assert.assertArrayEquals(expected, Table.intersection(v1, v2), 0);
    }

    @Test
    public void work_when_vectors_share_size_and_multiple_element_values_are_repeated(){
        double[] v1 = {2,3,3,7};
        double[] v2 = {2,3,3,7};
        double[] expected = {2,3,7};
        Assert.assertArrayEquals(expected, Table.intersection(v1, v2), 0);
    }

    @Test
    public void work_when_vectors_share_size_and_no_element_values_are_repeated(){
        double[] v1 = {1,2,3,4};
        double[] v2 = {5,6,7,8};
        double[] expected = {};
        Assert.assertArrayEquals(expected, Table.intersection(v1, v2), 0);
    }

    @Test
    public void work_when_vector_size_differs_and_no_element_values_are_repeated(){
        double[] v1 = {1,4};
        double[] v2 = {2,3,3,7,4};
        double[] expected = {};
        Assert.assertArrayEquals(expected, Table.intersection(v1, v2), 0);
    }

    @Test
    public void work_when_vector_size_differs_and_multiple_element_values_are_repeated(){
        double[] v1 = {2,3,3,7};
        double[] v2 = {2,7};
        double[] expected = {2,7};
        Assert.assertArrayEquals(expected, Table.intersection(v1, v2), 0);
    }

    @Test
    public void work_when_vector_size_differs_and_one_element_is_repeated(){
        double[] v1 = {1,2,5,7};
        double[] v2 = {3,4,5};
        double[] expected = {5};
        Assert.assertArrayEquals(expected, Table.intersection(v1, v2), 0);
    }

    @Test
    public void work_when_vectors_contain_zeros_as_starting_elements(){
        double[] v1 = {0,0,1,2,3};
        double[] v2 = {0,0,1,2,3};
        double[] expected = {0,1,2,3};
        Assert.assertArrayEquals(expected, Table.intersection(v1, v2), 0);
    }

    @Test
    public void meh_work_when_vectors_contain_zeros_as_starting_elements(){
        double[] v1 = {-2,0};
        double[] v2 = {-1,0};
        double[] expected = {0};
        Assert.assertArrayEquals(expected, Table.intersection(v1, v2), 0);
    }
}