package tc.bites;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tsc on 3/12/17.
 */
public class DijkstraTest {
    private SparseGraph<String,Long> net = new SparseGraph<>();
    private Dijkstra<String> solver = new Dijkstra<>(net);
    @BeforeMethod
    public void beforeMethod() {
        this.net.clear();
    }
    protected static List<String> makeList(String...nodes) {
        List<String> result = Arrays.asList(nodes);
        return result;
    }
    @Test
    public void testTwoNode() {
        this.net.addEdge("Src","Dst", 1L);
        List<String> result = this.solver.path("Src", "Dst");
        List<String> expected = makeList("Src", "Dst");
        Assert.assertEquals(result, expected);
    }
    @Test
    public void testFourNode() {
        this.net.addEdge("Src", "Mid0", 1L);
        this.net.addEdge("Src", "Mid1", 10L);
        this.net.addEdge("Mid0", "Dst", 1L);
        this.net.addEdge("Mid1", "Dst", 10L);
        List<String> result = this.solver.path("Src", "Dst");
        List<String> expected = makeList("Src", "Mid0", "Dst");
        Assert.assertEquals(result, expected);
    }
    @Test
    public void testOpenField() {
        final int NROW = 5;
        final int NCOL = 6;
        this.net.setSymmetricEdges(true);
        for (int r = 0; r < NROW; ++r) {
            int rs = r + 1;
            for (int c = 0; c < NCOL; ++c) {
                int cs = c + 1;
                String n00 = nName(r,c);
                String n10 = nName(rs, c);
                String n01 = nName(r, cs);
                if (rs < NROW) {
                    this.net.addEdge(n00, n10, 1L);
                    // System.err.println(n00 + "->" + n10);
                }
                if (cs < NCOL) {
                    this.net.addEdge(n00, n01, 2L);
                    // System.err.println(n00 + "->" + n01);
                }
            }
        }
        this.net.delEdge("4,1","4,2");
        this.net.delEdge("3,1","3,2");
        this.net.delEdge("0,0","0,1");
        this.net.delEdge("1,0","1,1");
        this.net.delEdge("2,2","3,2");
        this.net.delEdge("2,2","2,3");
        this.net.delEdge("1,2","1,3");
        this.net.delEdge("4,4","4,5");
        this.net.delEdge("3,4","3,5");
        this.net.delEdge("2,4","2,5");
        List<String> result = this.solver.path(nName(0,0), nName(NROW-1,NCOL-1));
        System.err.println(result);
    }
    protected String nName(int r, int c) {
        return String.format("%d,%d", r, c);
    }
}
