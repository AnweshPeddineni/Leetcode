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

class QueueUsingStack():
    def __init__(self):
        self.s1 = Stack()
        self.s2 = Stack()

    def push(self, x: int) -> None:
        while not self.s1.empty():
            self.s2.push(self.s1.pop())
        self.s1.push(x)
        while not self.s2.empty():
            self.s1.push(self.s2.pop())

    def pop(self) -> int:
        return self.s1.pop() if not self.s1.empty() else None

    def peek(self) -> int:
        return self.s1.top() if not self.s1.empty() else None

    def empty(self) -> bool:
        return self.s1.empty()

    def __len__(self) -> int:
        return len(self.s1)


if (True):
    MyQueue = QueueUsingStack