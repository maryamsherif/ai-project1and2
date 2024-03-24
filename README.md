# Live Long and Prosper

#### Project Description:

```
A town requires critical resources (food, materials, and energy) to support its residents and develop new structures.
The town's prosperity level reflects the well-being of its residents. Buildings are essential for increasing the town's
wealth, and these constructions necessitate specialized resources. The goal of this project is to create a search agent tasked
with designing a plan to increase the town's prosperity to 100. The consequences of various activities on prosperity and resource
levels differ. We are given a $100,000 budget with no other sources of income. The town has a resource storage limit of 50 units
per resource, and each action the agent does depletes these resources. A delivery must be ordered to replenish the
level of a resource. Using resources incurs costs, which indicate the cost of these resources. Our objective is to
develop a search agent capable of investigating and, if possible, devising a plan to raise the town's prosperity to level 100.
```
#### A discussion of our implementation of the search-tree node ADT

```
The 'State' Java class represents a state in the context of a search problem. Each instance of this class represents
 the current state of a system as defined by various attributes such as prosperity, food, materials, energy,
money spent, and so on. The class is intended for use in search algorithms, where actions can be used to move
from one state to another. The state contains information such as the search tree depth, the action that resulted
in this state, and a reference to its parent state. The constructor sets the state's values for prosperity, food,
materials, energy, money spent, total money owned, food, materials, and energy delays, the depth of the search tree,
the action associated with this state, and a reference to its parent state. To facilitate proper comparison and hashing
of state objects, the class overrides the 'equals' and 'hashCode' methods. The class includes getter methods for accessing
various state attributes as well as setter methods for modifying the action and parent attributes. The class also defines
a method for generating successor states based on a set of predefined actions, ensuring that valid state transitions are
taken into account.The 'toString' method returns a human-readable string representation of the state that displays
its various attributes. Overall, the 'State' class, with its representation of system states and their relationships,
serves as a fundamental building block for modeling and solving search problems.
```
#### A discussion of our implementation of the search problem ADT.

```
GenericSearch code defines an abstract class named GenericSearch serving as a template for various search algorithms.
The class includes static methods for common algorithms such as Breadth-First Search (BFS), Depth-First Search (DFS)
with a depth limit, Iterative Deepening Depth-First Search (IDDFS), Greedy Best-First Search, and A* Search. Each method
takes a State parameter, implying their applicability to tree structures, and currently returns null as a placeholder
for the actual implementation. The class is designed to be extended by concrete subclasses, allowing for the specific
 implementation details of each search algorithm and the structure of the
```
#### A discussion of our implementation of the LLAP problem.

```
Our LLAP problem is structured using object-oriented programming principles with classes like Initials and Actions.
 This helps organize the code and encapsulate related functionalities.
```
**- Initials Class:**
```
* Initialization: The Initials class efficiently initializes the state of the town based on the provided input string.
 The use of a constructor that parses the input string ensures a clean and organized way to set initial parameters.
* Attributes: The class effectively represents the state of the town with attributes like prosperity,
food, materials, energy, and various parameters for requests and building constructions.
```

**- State Class**
```
The State class represents the state of the town in the LLAP problem. It encapsulates essential information,
including prosperity level, resource quantities (food, materials, energy), money spent, delays, depth in the
search tree, the action performed, and a reference to the parent state.
```
**- Actions Class**
```
The Actions class provides methods to perform various actions in the town, such as requesting food, materials, or energy,
 waiting, and building. It calculates the effects of these actions on the state and returns the resulting state.
The performAction method serves as a dispatcher for different actions, making the code modular and easy to extend.
```
**- Search Algorithms**
Our implementation incorporates several search algorithms to find an optimal plan for achieving a prosperity level of 100.
These algorithms include Breadth-First Search (BFS), Depth-First Search (DFS), Uniform Cost Search (UCS), 
Iterative Deepening Search (IDS), Greedy Search with two heuristics (Greedy1 and Greedy2),
and A* Search with two heuristics (A1 and A2).

1. **BFS:** The Breadth-First Search explores states level by level, utilizing a priority queue based on
the depth of each state. This ensures that shallower states are explored first, making it complete
and optimal for finding the deepest path to the goal state.
4. **DFS:** The Depth-First Search explores deeper states first using a stack. While not guaranteed
    to be optimal, DFS can be more memory-efficient than BFS.
6. **UCS:** The Uniform Cost Search prioritizes states based on the total money spent.
   It guarantees optimality by always selecting the path with the minimum cumulative cost.
8. **IDS:** The Iterative Deepening Search is a depth-limited strategy that systematically increases the depth limit
    until the goal state is found. It combines the advantages of DFS and BFS, providing an efficient and complete solution.
10. **GreedySearch:** The Greedy Search algorithm uses two heuristics (Greedy1 and Greedy2) to prioritize states.
     Greedy1 estimates the remaining distance to the goal based on prosperity, while Greedy2 considers the prosperity-to-cost ratio.
12. **AStar Search:** The AStar Search algorithm utilizes two admissible heuristics (A1 and A2) to guide the search efficiently.
     A1 estimates the remaining prosperity needed, and A2 estimates resource shortages. Both heuristics ensure admissibility and optimality


#### Main Functions:
* **RequestFood, RequestMaterials, RequestEnergy:** These actions request a delivery of a resource to the town. A delivery increases the level of the resource by a certain amount. However, a deliveries are not immediate, so the increase in the  amount of a resource is not necessarily effective in the next step. Hence, each of the three actions is parameterized by two parameters, amount and delay, that will be provided in the problem initialization. During the delay period following the request of a delivery, no other delivery can be requested (for the same or a different resource). Thus, the agent can only wait or build during that time. Delivery actions have no effect on prosperity level.
* **WAIT:** This action allows the agent to wait for a delivery to arrive without building or requesting a new delivery. It is only allowed while a delivery is pending. This action has no effect on prosperity level.
* **BUILD1, BUILD2:** These are the only actions that affect the town’s prosperity level. However, they consume a large amount of resources and an added price. They represent two different types of builds and each has different resource consumption, price and increase in prosperity. These parameters are also given in the problem initialization.

### Comparison of the performance of the different algorithms 
| Algorithm | Completeness | Optimality | RAM Usage | CPU Utilization | Expanded Nodes |
|----------|----------|----------|----------|----------|----------|
| BFS | Complete | Optimal only if the path to any node is equal to one | 1.4 MB| 48 ms | 388 |
| DFS | Incomplete | Not Optimal | 1.03 MB | 22 ms | 58 |
| UCS | Complete only if we do not have negative cost or the cost of the sol. is not very big | Optimal only if the cost is a non-decreasing func. as we go deeper into the tree | 2.71 MB | 33 ms | 1771|
| IDS | Complete | Optimal provided that the path cost is a non-decreasing function in the depth of the tree | 1.67 MB | 48 ms | 348 |
| GR1 | Complete | Not Optimal | 1.03 MB | 12 ms | 21 |
| GR2 | Complete | Not Optimal | 1.43 MB | 52 ms | 461 |
| A*1 | Complete | Optimal |2.74 MB | 48 ms | 1737 |
| A*2 | Complete | Optimal | 2.71 MB | 48 ms | 1771 |
