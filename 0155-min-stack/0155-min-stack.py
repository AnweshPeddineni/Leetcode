class Stack():
    def __init__(self):
        self._a = []
        self._max_size = 0

    def push(self, x: int) -> None:
        self._a.append(x)
        self._max_size = max(self._max_size, len(self._a))

    def pop(self) -> int:
        return self._a.pop() if self._a else None

    def top(self) -> int:
        return self._a[-1] if self._a else None

    def empty(self) -> bool:
        return len(self._a) == 0

    def __len__(self) -> int:
        return len(self._a)

    def space(self) -> int:
        return self._max_size
        
class MinStack():
    def __init__(self):
        self.stack = Stack()
        self.minStack = Stack()

    def push(self, x: int) -> None:
        self.stack.push(x)
        if self.minStack.empty() or x <= self.minStack.top():
            self.minStack.push(x)

    def pop(self) -> None:
        if self.stack.top() == self.minStack.top():
            self.minStack.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack.top()

    def getMin(self) -> int:
        return self.minStack.top()        
        

if (True):
    MinStack = MinStack