package tc.bites;

import java.util.*;

/**
 * Engine to calculate the Dijkstra shortest path
 * between nodes in a graph..
 */
public class Dijkstra<V> {
    protected SparseGraph<V,Long> net = null;
    public Dijkstra(SparseGraph<V,Long> net) {
        this.net = net;
    }
    protected V nextIter(V current, Set<V> unvisited, Map<V,Long> distance) {
        V result = null;
        unvisited.remove(current);
        for (V newNode: unvisited) {
            if (distance.containsKey(newNode)) {
                if (result == null) {
                    result = newNode;
                } else if (distance.get(result).compareTo(distance.get(newNode)) > 0) {
                    result = newNode;
                }
            }
        }
        return result;
    }
    public List<V> path(V origin, V target) {
        LinkedList<V> result = new LinkedList<>();
        if (this.net != null && this.net.hasNode(origin) && this.net.hasNode(target)) {
            Set<V> unvisited = new HashSet<>();
            unvisited.addAll(this.net.getNodes());
            unvisited.remove(origin);
            Map<V,Long> distance = new HashMap<>();
            Map<V,V> predecessor= new HashMap<>();
            distance.put(origin, 0L);
            for (V current = origin;
                 current != null && unvisited.contains(target);
                 current = nextIter(current, unvisited, distance)) {
                // System.err.println(current);
                for (Map.Entry<V,Long> edge: this.net.getNeighbours(current).entrySet()) {
                    V neighbour = edge.getKey();
                    if (unvisited.contains(neighbour)) {
                        Long altDist = distance.get(current).longValue() + edge.getValue().longValue();
                        if (! distance.containsKey(neighbour) || altDist < distance.get(neighbour)) {
                            distance.put(neighbour, altDist);
                            predecessor.put(neighbour, current);
                        }
                    }
                }
            }
            if (! unvisited.contains(target)) {
                V current = target;
                for (; predecessor.containsKey(current); current = predecessor.get(current)) {
                    result.addFirst(current);
                }
                result.addFirst(current);
            }
        }
        return result;
    }
}
