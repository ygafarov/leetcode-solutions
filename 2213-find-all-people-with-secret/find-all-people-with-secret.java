class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        DSU dsu = new DSU(n);
        dsu.union(0, firstPerson);

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int[] meeting : meetings) {
            int time = meeting[2];
            int human1 = meeting[0];
            int human2 = meeting[1];
            List<int[]> list = map.getOrDefault(time, new ArrayList<>());
            list.add(new int[]{human1, human2});
            map.put(time, list);
        }

        for (int time : map.keySet()) {
            Set<Integer> metPeople = new HashSet<>();

            List<int[]> list = map.get(time);
            for (int[] meeting : list) {
                int human1 = meeting[0];
                int human2 = meeting[1];
                dsu.union(human1, human2);
                metPeople.add(human1);
                metPeople.add(human2);
            }
            for (int human : metPeople) {
                if (!dsu.isConnected(human, 0)) {
                    dsu.reset(human);
                }
            }

        }
        ArrayList<Integer> peopleWithSecret = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (dsu.isConnected(i, 0))
                peopleWithSecret.add(i);
        return peopleWithSecret;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    DSU(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int v) {
        if (v == parent[v])
            return v;
        return parent[v] = find(parent[v]);
    }

    boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }

    void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    void reset(int v) {
        parent[v] = v;
        rank[v] = 0;
    }
}