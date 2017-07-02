package tc.bites;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example
 * to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges,
 * not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
    private enum VisitState {
        WIP,
        POSSIBLE,
        IMPOSSIBLE
    };
    private Map<Integer,List<Integer>> prereqs = new HashMap<>();
    private Map<Integer, VisitState> possible = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        studyPrereqs(numCourses, prerequisites);
        boolean allPossible = true;
        for (int course = 0; allPossible && course < numCourses; ++course) {
            allPossible = checkCourse(course);
        }
        return allPossible;
    }
    private boolean checkCourse(int course) {
        boolean isPossible = true;
        if (possible.containsKey(course)) {
            switch (possible.get(course)) {
                case WIP:
                    isPossible = false;
                    possible.put(course, VisitState.IMPOSSIBLE);
                    break;
                case POSSIBLE:
                    isPossible = true;
                    break;
                case IMPOSSIBLE:
                    isPossible = false;
                    break;
                default:
                    System.err.println("impossible state");
                    break;
            }
        } else {
            possible.put(course, VisitState.WIP);
            if (prereqs.containsKey(course)) {
                for (Integer pre: prereqs.get(course)) {
                    if (! checkCourse(pre)) {
                        isPossible = false;
                        break;
                    }
                }
            }
            possible.put(course, isPossible ? VisitState.POSSIBLE : VisitState.IMPOSSIBLE);
        }
        return isPossible;
    }
    private void studyPrereqs(int numCourses, int[][] prerequisites) {
        for (int[] pair: prerequisites) {
            int course = pair[0];
            if (! prereqs.containsKey(course)) {
                prereqs.put(course, new LinkedList<>());
            }
            prereqs.get(course).add(pair[1]);
        }
    }
}
