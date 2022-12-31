Overview:

-In this project, we created two new data structure (FastSparrow and WhatTheFast) that extends the functionality of a stack and a deque by adding extra additional operations all highlighted in the secifications.

-All these operations have a time complexity of O(1), meaning that they can be executed in constant time regardless of the size of the stack or deque.

Implementation:

-To achieve a time complexity of O(1) operations, we implemented a secondary data structure to store additional information about the elements in the stack.

-This secondary data structure is updated whenever elements are added or removed from the stack, allowing us to quickly retrieve the maximum value or sum of the top k elements.

-We also implemented a set of unit tests to ensure the correctness and efficiency of our data structure and its operations.

Conclusion:

Our new data structure represents a significant improvement over a standard stack, as it allows for quick and efficient retrieval of the maximum value or sum of the top k elements, etc.

This can be particularly useful in scenarios where these values are needed frequently, as it eliminates the need to perform additional searches or calculations.

Overall, this project demonstrates the power of combining different data structures and algorithms in creative ways to solve complex problems.
