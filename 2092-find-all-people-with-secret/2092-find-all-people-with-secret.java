class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind union = new UnionFind(n);
        union.union(0, firstPerson);
        Map<Integer, List<int[]>> meetMap = new TreeMap<>();
        for (int[] meet: meetings) {
            meetMap.computeIfAbsent(meet[2], k -> new ArrayList<>()).add(new int[] {meet[0], meet[1]});
        }
        for (Map.Entry<Integer, List<int[]>> entry: meetMap.entrySet()) {
            int t = entry.getKey();
            List<int[]> meets = entry.getValue();
            for (int[] meet: meets) {
                union.union(meet[0], meet[1]);
            }
            for (int[] meet: meets) {
                if (!union.connected(meet[0], 0)) {
                    union.reset(meet[0]);
                    union.reset(meet[1]);
                }
            }
        }
        return union.peopleInGroup(union.find(0));
    }
}

class UnionFind {

    int[] ranks;
    int[] groups;
    int groupsNum;

    public UnionFind(int n) {
        groupsNum = n;
        ranks = new int[n];
        groups = new int[n];
        Arrays.fill(ranks, 1);
        for (int i = 0; i < n; i++) {
            groups[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int q) {
        while (groups[q] != q) {
            groups[q] = groups[groups[q]];
            q = groups[q];
        }
        return q;
    }

    public void reset(int q) {
        groups[q] = q;
        ranks[q] = 1;
    }

    public boolean union(int p, int q) {
        int gp = find(p);
        int gq = find(q);
        if (gp == gq) {
            return false;
        }
        if (ranks[gp] < ranks[gq]) {
            groups[gp] = gq;
            ranks[gq] += ranks[gp];
        } else {
            groups[gq] = gp;
            ranks[gp] += ranks[gq];
        }
        groupsNum--;
        return true;
    }

    public List<Integer> peopleInGroup(int g) {
        return IntStream.range(0, groups.length).filter(i -> find(i) == g).boxed().toList();
    }
}