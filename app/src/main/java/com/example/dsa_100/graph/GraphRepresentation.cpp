#include <iostream>
#include <vector>

using namespace std;

void printGraph(int n, int adj[][101]) {
    cout << "Adjacency Matrix:" << endl;
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            cout << adj[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    // Use a fixed size for the second dimension of the array
    int adj[101][101] = {0}; // Initialize all elements to 0

    // Read the edges and populate the adjacency matrix
    for (int i = 0; i < m; ++i) {
        int u, v;
        cin >> u >> v;
        if (u >= 1 && u <= n && v >= 1 && v <= n) {
            adj[u][v] = 1;
            adj[v][u] = 1; // Assuming an undirected graph
        }
    }

    // Print the adjacency matrix
    printGraph(n, adj);

    return 0;
}