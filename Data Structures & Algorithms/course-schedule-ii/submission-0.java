
class Solution {
    boolean hasCycle = false;

    void DFS(ArrayList<ArrayList<Integer>> adj, int u,
             boolean[] visited, boolean[] inRecursion,
             Stack<Integer> st) {

        visited[u] = true;
        inRecursion[u] = true;

        // First, process all adjacent nodes
        for (int v : adj.get(u)) {

            if (inRecursion[v]) {
                hasCycle = true;
                return;
            }

            if (!visited[v]) {
                DFS(adj, v, visited, inRecursion, st);
            }
        }

        // Push the current node after its children
        st.push(u);
        inRecursion[u] = false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];

        hasCycle = false;

        Stack<Integer> st = new Stack<>();

        // Build adjacency list: b -> a
        for (int[] vec : prerequisites) {
            int a = vec[0];
            int b = vec[1];

            adj.get(b).add(a);
        }

        // Perform DFS
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                DFS(adj, i, visited, inRecursion, st);
            }
        }

        // If cycle exists, return empty array
        if (hasCycle) {
            return new int[0];
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while (!st.isEmpty()) {
            result[idx++] = st.pop();
        }

        return result;
    }
}
