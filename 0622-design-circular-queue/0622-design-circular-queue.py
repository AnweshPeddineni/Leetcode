############################################################
# Queue.py 
# Implements Queue object
# Author: Jagadeesh Vasudevamurthy
# Copyright: Jagadeesh Vasudevamurthy 2022
###########################################################

###########################################################
#  class Queue
# Our Queue is finite size k
###########################################################   
class Queue():
    def __init__(self, k: int):
        self._a = [None] * k
        self._MAX = k
        self._front = 0
        self._back = 0
        self._count = 0

    def enQueue(self, x: int) -> bool:
        if self._count == self._MAX:
            return False
        self._a[self._back] = x
        self._back = (self._back + 1) % self._MAX
        self._count += 1
        return True

    def deQueue(self) -> bool:
        if self._count == 0:
            return False
        self._front = (self._front + 1) % self._MAX
        self._count -= 1
        return True

    def Front(self) -> int:
        if self._count == 0:
            return -1
        return self._a[self._front]

    def Rear(self) -> int:
        if self._count == 0:
            return -1
        return self._a[(self._back - 1 + self._MAX) % self._MAX]

    def isEmpty(self) -> bool:
        return self._count == 0

    def isFull(self) -> bool:
        return self._count == self._MAX

    def __len__(self) -> int:
        return self._count

    


if (True):
     MyCircularQueue = Queue