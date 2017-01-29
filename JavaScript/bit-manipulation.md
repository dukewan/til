# Bit Manipulation

To get a bit mask:

```javascript
var mask = 1 << 5; // gets the 6th bit
```
To test if a bit is set:

```javascript
if ((n & mask) != 0) {
  // bit is set
} else {
  // bit is not set
}
```
To set a bit:

```javascript
n |= mask;
```

To clear a bit:

```javascript
n &= ~mask;
```

To toggle a bit:

```javascript
n ^= mask;
```

