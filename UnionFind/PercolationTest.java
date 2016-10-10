import static org.junit.Assert.*;
import org.junit.Test;

public class PercolationTest
{
    @Test
    public void test1()
    {
        Percolation per = new Percolation(2);
        assertFalse(per.percolates());
    }
}
