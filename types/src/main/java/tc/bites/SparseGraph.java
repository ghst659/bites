package tc.bites;

import java.util.*;

/**
 * Representation of a sparse weighted graph.  Nodes are any immutable data type.
 * Weights are any Number.
 * If the symmetricEdges property is set,the addition of any edge from A to B
 * will add a symmetric edge from B to A.
 */
public class SparseGraph<V, W extends Comparable> {
    /**
     * Internal class to represent a unidirectional weighted edge.
     * Bidirectional edges would require two instances of this Edge.
     */
    protected class Edge<V, W extends Comparable> {
        private V destination;
        private W weight;
        /**
         * Construct an edge
         * @param destination endpoint of the edge.
         * @param weight weighting of the edge.
         */
        public Edge(V destination, W weight) {
            this.destination = destination;
            this.weight = weight;
        }
        public V getDestination() {
            return destination;
        }
        public void setDestination(V destination) {
            this.destination = destination;
        }
        public W getWeight() {
            return weight;
        }
        public void setWeight(W weight) {
            this.weight = weight;
        }
    }
    //******************************************************************
    protected Map<V, List<Edge<V,W>>> edgeMap = new HashMap<>();
    protected boolean symmetricEdges = false;

    /**
     * Return the number of nodes in the graph.
     * @return integer number of nodes.
     */
    public synchronized int size() {
        return this.edgeMap.size();
    }

    /**
     * Remove all nodes and edges in the graph.
     */
    public synchronized void clear() {
        for (Map.Entry<V,List<Edge<V,W>>> nodeData: this.edgeMap.entrySet()) {
            nodeData.getValue().clear();
        }
        this.edgeMap.clear();
    }

    /**
     * Gets the state of the symmetricEdges flag.
     * @return value of the symmetricEdges property.
     */
    public synchronized boolean isSymmetricEdges() {
        return symmetricEdges;
    }

    /**
     * Sets the symmetricEgges property.
     * @param symmetricEdges new value of the symmetricEdges property.
     */
    public synchronized void setSymmetricEdges(boolean symmetricEdges) {
        this.symmetricEdges = symmetricEdges;
    }

    /**
     * Add NODE to the graph, if it does not already exist.
     * @param node node to be added to the graph.
     */
    public synchronized void addNode(V node) {
        if (! this.edgeMap.containsKey(node)) {
            List<Edge<V,W>> edges = new LinkedList<>();
            this.edgeMap.put(node, edges);
        }
    }

    /**
     * Remove NODE from the graph, if it exists.
     * @param node node to remove.
     */
    public synchronized void delNode(V node) {
        if (this.edgeMap.containsKey(node)) {
            for (V source : this.edgeMap.keySet()) {
                if (! source.equals(node)) {
                    List<Edge<V,W>> newEdges = new LinkedList<>();
                    List<Edge<V,W>> oldEdges = this.edgeMap.get(source);
                    for (Edge<V,W> e : oldEdges) {
                        if (!e.getDestination().equals(node)) {
                            newEdges.add(e);
                        }
                    }
                    oldEdges.clear();
                    this.edgeMap.put(source, newEdges);
                }
            }
            this.edgeMap.get(node).clear();
            this.edgeMap.remove(node);
        }
    }

    /**
     * Retrieve all nodes in the graph.
     * @return a set of nodes.
     */
    public Set<V> getNodes() {
        Set<V> result = new HashSet<>();
        result.addAll(this.edgeMap.keySet());
        return result;
    }

    /**
     * Check if NODE is in the graph.
     * @param node the node to search for.
     * @return true if the node is in the graph.
     */
    public boolean hasNode(V node) {
        return this.edgeMap.containsKey(node);
    }

    /**
     * Add a single edge to the graph between SOURCE and DESTINATION with WEIGHT.
     * @param source origin of the edge.
     * @param destination target of the edge.
     * @param weight the weight of the edge.
     */
    protected synchronized void addOneEdge(V source, V destination, W weight) {
        List<Edge<V,W>> edges = this.edgeMap.get(source);
        boolean existed = false;
        for (Edge<V,W> e : edges) {
            if (e.getDestination().equals(destination)) {
                existed = true;
                e.setWeight(weight);
                break;
            }
        }
        if (!existed) {
            Edge e = new Edge(destination, weight);
            edges.add(e);
        }
    }

    /**
     * Remove the edge (if any) from SOURCE to DESTINATION.
     * @param source the source of the edge.
     * @param destination the destination of the edge.
     */
    protected synchronized void delOneEdge(V source, V destination) {
        List<Edge<V,W>> edges = this.edgeMap.get(source);
        int position = -1;
        int index = 0;
        for (Edge e: edges) {
            if (e.getDestination().equals(destination)) {
                position = index;
                break;
            }
            ++index;
        }
        if (position >= 0) {
            edges.remove(position);
        }
    }

    /**
     * Remove the edge (if any) between SOURCE AND DESTINATION from the graph.
     * If symmetricEdges is true,the edge between DESTINATION and SOURCE
     * (if any) is also removed.
     * @param source the source of the edge.
     * @param destination the destination of the edge.
     */
    public synchronized void delEdge(V source, V destination) {
        if (! source.equals(destination) && this.edgeMap.containsKey(source) && this.edgeMap.containsKey(destination)) {
            this.delOneEdge(source, destination);
            if (this.symmetricEdges) {
                this.delOneEdge(destination, source);
            }
        }
    }

    /**
     * Add an edge between SOURCE and DESTINATION with WEIGHT.  The source
     * and destination nodes are added to the graph if not already present.
     * If the edge already exists, its weight is adjusted to the new WEIGHT.
     * @param source the source of the edge.
     * @param destination the target of the edge.
     * @param weight the weight of the edge.
     */
    public synchronized void addEdge(V source, V destination, W weight) {
        if (! source.equals(destination)) {
            this.addNode(source);
            this.addNode(destination);
            this.addOneEdge(source, destination, weight);
            if (this.symmetricEdges) {
                this.addOneEdge(destination, source, weight);
            }
        }
    }

    /**
     * Retrieve the edges from SOURCE.
     * @param source the node from which to retrieve edges.
     * @return a map of destination nodes to edge weights.
     */
    public synchronized Map<V,W> getNeighbours(V source) {
        Map<V, W> result = new HashMap<>();
        if (this.edgeMap.containsKey(source)) {
            List<Edge<V,W>> edges = this.edgeMap.get(source);
            for (Edge<V,W> e: edges) {
                result.put(e.getDestination(), e.getWeight());
            }
        }
        return result;
    }
}
