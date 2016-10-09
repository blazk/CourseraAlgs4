import static org.junit.Assert.*;
import org.junit.Test;

public class QuickUnionUFTest
{
    @Test
    public void testConnected()
    {
        QuickUnionUF uf = new QuickUnionUF(5);
        uf.union(0,4);
        assertTrue(uf.connected(0, 4));
    }

    @Test
    public void testNotConnected()
    {
        QuickUnionUF uf = new QuickUnionUF(5);
        assertFalse(uf.connected(0, 4));
    }

    @Test
    public void testReflexiveRelation()
    {
        QuickUnionUF uf = new QuickUnionUF(3);
        assertTrue(uf.connected(2, 2));
    }

    @Test
    public void testTransitiveRelation()
    {
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(4,3);
        uf.union(8,4);
        assertTrue(uf.connected(8, 3));
    }

    @Test
    public void testSymmetricRelation()
    {
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(4, 6);
        assertTrue(uf.connected(6, 4));
    }
}
