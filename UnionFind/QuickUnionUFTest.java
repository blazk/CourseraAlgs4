import static org.junit.Assert.*;
import org.junit.Test;

public class QuickUnionUFTest
{
    @Test
    public void testIt()
    {
        QuickUnionUF uf = new QuickUnionUF(5);
        uf.union(0,4);
        assertTrue(uf.connected(0,4));
    }
}
