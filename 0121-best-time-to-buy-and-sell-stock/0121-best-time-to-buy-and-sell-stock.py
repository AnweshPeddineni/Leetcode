############################################################
# Solution.py
# Author: Jagadeesh Vasudevamurthy
# Copyright: Jagadeesh Vasudevamurthy 2022
###########################################################
############################################################
# All imports
###########################################################
from typing import List


class Solution:
    def __init__(self):
        pass
        ## YoU can have what ever you want here
        

    ##LEETCODE INTERFACE.  DO NOT CHANGE
    ## YOU CANNOT CHANGE ANYTHING
    def maxProfit(self, prices: List[int]) -> int:
        if False:
            [sellday, buyday, work] = self.nsquare_time_constant_space(prices)
        if True:
            [sellday, buyday, work] = self.nlogn_time_logn_space(prices)
        if False:
            [sellday, buyday, work] = self.ntime_constant_space(prices)
        p = self._compute_profit(prices, sellday, buyday)
        return p

    #############################################
    # All public function here. 
    #############################################

    def _nsquare_time_constant_space(self, a: List[int]):
        sellday, buyday, work, profit = 0, 0, 0, 0
        for i in range(len(a)):
            for j in range(i+1,len(a)):
                work+=1
                if (a[j] - a[i]) > profit:
                    buyday, sellday, profit = i, j, (a[j] - a[i])
        return [sellday, buyday, work]
                
    def _nlogn_time_logn_space(self, a: List[int]):
        start, end, work = 0, len(a)-1, 0
        profit, buyday, sellday, work = self.profitcalc(a, start, end, work)
        return [sellday, buyday, work]   
        
    def _ntime_constant_space(self,a: List[int]):
        
        sellday, buyday, work, profit, minm = 0, 0, 0, 0, 0
        for i in range(1, len(a)):
            work += 1
            if a[minm] < a[i]:
                if (a[i] - a[minm]) > profit:
                    buyday, sellday, profit = minm, i, (a[i] - a[minm])
            else: minm = i
        return [sellday, buyday, work]
    
    # Helper Functions for nlogn calc function above
    def profitcalc(self, a, start, end, work):
        work += 1
        if start >= end:
            return [0, start, end, work]

        
        mid = start + (end - start) // 2 
        # Calculating left profit
        left_profit, left_min_index, left_max_index, work = self.profitcalc(a, start, mid, work)
        # Calculating right profit
        right_profit, right_min_index, right_max_index, work = self.profitcalc(a, mid + 1, end, work)
        # Calculating cross profit
        cross_profit, cross_min_index, cross_max_index, work = self.crossprofitcalc(a, start, mid, end, work)

        # Calculating the maximum out of left profit, cross profit and right profit and respective indexes
        if right_profit >= left_profit and right_profit >= cross_profit:
            return [right_profit, right_min_index, right_max_index, work]
        elif left_profit >= right_profit and left_profit >= cross_profit:
            return [left_profit, left_min_index, left_max_index, work]
        else:
            return [cross_profit, cross_min_index, cross_max_index, work]

    def crossprofitcalc(self, a, start, mid, end, work):
        cross_left_index, left_min = start, a[start]
        cross_right_index, right_max = mid + 1, a[mid + 1]
        
        for i in range(start + 1, mid + 1):
            work += 1
            if a[i] < left_min:
                left_min = a[i]
                cross_left_index = i
    
        for i in range(mid + 2, end + 1):
            work += 1
            if a[i] > right_max:
                right_max = a[i]
                cross_right_index = i
                
        return [right_max - left_min, cross_left_index, cross_right_index, work]

    ########################################
    # TIME:THETA(N^2)
    # Space:THETA(1)
    # CANNOT CHANGE ANYTHING BELOW
    #########################################
    def nsquare_time_constant_space(self, a: List[int]) -> "[sellday,buyday,work]":
        return self._nsquare_time_constant_space(a) 


    ########################################
    # TIME:THETA(NlogN)
    # Space:THETA(logn)
    # CANNOT CHANGE ANYTHING BELOW
    #########################################
    def nlogn_time_logn_space(self, a: List[int]) -> "[sellday,buyday,work]":
        return self._nlogn_time_logn_space(a)

    ########################################
    # TIME:THETA(N)
    # Space:THETA(1)
    # CANNOT CHANGE ANYTHING BELOW
    #########################################
    def ntime_constant_space(self, a: List[int]) -> "[sellday,buyday,work]":
        return self._ntime_constant_space(a)
        

    #############################################
    # All private function here. 
    # WRIYE CODE BELOW
    # You can have any number of private functions and variables
    # NOTHING CAN BE CHABGED BELOW
    #############################################
    def _compute_profit(self, a: List[int], s: "int", b: "int") -> "int":
        n = len(a)
        if n == 0:
            return 0
        assert s >= 0 and s < n
        assert b >= 0 and b < n
        assert s >= b
        p = a[s] - a[b]
        return p

        