struct comp {
    bool operator() (pair<int, char>& a, pair<int, char>& b) {
        return a.first < b.first || (a.first == b.first && a.second > b.second);
    }    
};

class Solution {
public:
    string frequencySort(string s) {
        int f[256];
        memset(f, 0, sizeof(f));
        for (char c : s) {
            f[c]++;
        }
        priority_queue<pair<int, char>, vector<pair<int, char>>, comp> q;
        for (int i=0; i<256; i++) {
            if (f[i]) {
                char c = (char)(i);
                q.push(make_pair(f[i], c));
            }
        }
        string str;
        while(!q.empty()) {
            char c = q.top().second;
            int fr = q.top().first;
            q.pop();
            while(fr--) {
                str += c;
            }
        }
        return str;
    }
};