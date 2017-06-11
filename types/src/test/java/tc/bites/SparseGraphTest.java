package tc.bites;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

public class SparseGraphTest {
    private SparseGraph<Integer, Integer> ig = new SparseGraph<>();
    @BeforeMethod
    public void clearGraph() {
        this.ig.clear();
    }
    @Test
    public void testSize_Empty() {
        Assert.assertEquals(this.ig.size(), 0);
    }
    @Test
    public void testAddNode_GetNodes() {
        final int NUMNODES = 4;
        for (int i = 0; i < NUMNODES; ++i) {
            this.ig.addNode(i);
        }
        Set<Integer> nodes = this.ig.getNodes();
        Assert.assertEquals(nodes.size(), NUMNODES);
        for (int i = 0; i < NUMNODES; ++i) {
            nodes.remove(i);
        }
        Assert.assertEquals(nodes.size(), 0);
    }
    @Test
    public void testAddEdge_AutoNodes() {
        final int NUMNODES = 128;
        final int WEIGHT = 3;
        for (int i = 0; i < NUMNODES-1; ++i) {
            this.ig.addEdge(i, i+1, WEIGHT);
        }
        Assert.assertEquals(this.ig.size(), NUMNODES);
        for (int i = 0; i < NUMNODES-1; ++i) {
            Assert.assertEquals(this.ig.getNeighbours(i).size(), 1);
        }
        Assert.assertEquals(this.ig.getNeighbours(NUMNODES-1).size(), 0);
    }
    @Test
    public void testAddEdge_GetNeighbours() {
        final int NUMNODES = 512;
        for (int k = 0; k < NUMNODES; ++k) {
            int dLo = 2 * k + 1;
            int dHi = 2 * k + 2;
            if (dLo < NUMNODES) {
                this.ig.addEdge(k, dLo, 1);
            }
            if (dHi < NUMNODES) {
                this.ig.addEdge(k, dHi, 2);
            }
        }
        for (int k = 0; k < (NUMNODES - 2)/ 2; ++k) {
            Map<Integer,Integer> nodeEdges = this.ig.getNeighbours(k);
            Assert.assertEquals(nodeEdges.size(), 2, String.format("%d edges = %d", k, nodeEdges.size()));
            int lo = 2*k + 1;
            int hi = 2*k + 2;
            Assert.assertTrue(nodeEdges.containsKey(lo));
            Assert.assertTrue(nodeEdges.containsKey(hi));
            int wLo = nodeEdges.get(lo);
            int wHi = nodeEdges.get(hi);
            Assert.assertEquals(wLo, 1, String.format("%d-%d:%d ?= 1", k, lo, wLo));
            Assert.assertEquals(wHi, 2, String.format("%d-%d:%d ?= 1", k, hi, wHi));
        }
    }
    @Test
    public void testDelNode() {
        this.ig.addEdge(1, 2, 2);
        this.ig.addEdge(2, 3, 2);
        this.ig.addEdge(1,3,2);
        this.ig.delNode(2);
        Assert.assertEquals(this.ig.size(), 2);
        Assert.assertEquals(this.ig.getNeighbours(1).size(), 1);
        Assert.assertEquals(this.ig.getNeighbours(3).size(), 0);
    }
    @Test
    public void testDelEdge() {
        for (int i = 1; i < 8; ++i) {
            this.ig.addEdge(0, i, i);
        }
        for (int i = 2; i < 8; i += 2) {
            this.ig.delEdge(0, i);
        }
        Map<Integer,Integer> remainingEdges = this.ig.getNeighbours(0);
        for (Map.Entry<Integer,Integer> kv: remainingEdges.entrySet()) {
            Assert.assertTrue(kv.getKey() % 2 == 1);
            Assert.assertEquals(kv.getKey(), kv.getValue());
        }
    }
}
