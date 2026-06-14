# 🚂 CODELAB: The Trans-Java Network

Welcome to the Code Lab! Your mission is to build the digital infrastructure for the **Trans-Java Railway** using the Graph Data Structure.

---

## 🛠️ Mission 1: The Iron Tracks - Graph Implementation
**File:** `GraphExercise.java`

**Objective:**
Help the **Chief Engineer** connect the major cities of Java! You must implement an **Adjacency List** to represent stations and the tracks linking them.

**Core Concepts:**
*   **Vertex (Station):** A node in the graph.
*   **Edge (Track):** A connection between two nodes.
*   **Adjacency List:** A collection where each node maps to a list of its neighbors.

**Your Tasks:**
1.  **Station Log (`addVertex`)**: Ensure stations are registered in the system (Already provided).
2.  **Track Laying (`addEdge`)**: Implement the logic to connect two stations.
    *   Since trains go both ways (Undirected), if A connects to B, then B must connect to A.
    *   *Hint*: Add the destination to the source's list, and vice versa.

---

## 🗺️ Mission 2: Route Planning - BFS & DFS
**File:** `GraphExercise.java`

**Objective:**
Now that the tracks are laid, we need navigation systems! Implement **BFS** (Breadth-First Search) for checking nearby stations and **DFS** (Depth-First Search) for long-distance path exploration.

**Your Tasks:**
1.  **Radar Scan (`bfs`)**: Implement BFS using a **Queue**.
    *   Start at a station, visit neighbors, then neighbors' neighbors.
    *   *Hint*: Use `queue.poll()` and check the `visited` set.
2.  **Deep Exploration (`dfs`)**: Implement DFS using **Recursion**.
    *   Go deep into one path until you hit a dead end or visited node, then backtrack.
    *   *Hint*: Recursively call the function for unvisited neighbors.

**Visual Guide (Railway Map):**
```
    [Jakarta]
        |
    [Bandung] ---- [Jogja] ---- [Solo]
                                   |
                                [Madiun] ---- [Surabaya]
                                   |             |
                                [Malang] --------+
```

---

## 📝 How to Submit
1. Open `GraphExercise.java`.
2. Fill in the `____` blanks.
3. Run the code to verify your Railway Network!

*Maju Terus Perkeretaapian Indonesia!* 🇮🇩
