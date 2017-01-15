# Array

+ `Array.push()` returns the new length of the array instead of the array itself.
+ `Array.unshift()` add a new element to the front of the array.
+ We **can't** use `new Array(4).fill(new Array(3))` to create 2D arrays, because each element of Array(4) will point to the same Array(3). So when you update an element in this 2D array, all rows will be updated.

