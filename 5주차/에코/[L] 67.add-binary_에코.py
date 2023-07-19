#
# @lc app=leetcode id=67 lang=python3
#
# [67] Add Binary
#

# @lc code=start
from typing import Tuple


STR2BIN = {"1":1,"0":0}

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        rev_a = list(reversed(a))
        rev_b = list(reversed(b))
        (big,small) = (rev_a,rev_b) if len(rev_a) >= len(rev_b) else (rev_b,rev_a)
        sum_adder = []
        flag = False
        for i in range(len(big)):
            if i < len(small):
                adder_flag = False
                temp,new_flag = one_adder(big[i],small[i])
                if flag:
                    temp,adder_flag = one_adder(temp,"1")
                sum_adder.append(temp)
                flag = new_flag or adder_flag
            else:
                if flag:
                    temp,new_flag = one_adder(big[i],"1")
                else:
                    temp,_ = one_adder(big[i],"0")
                sum_adder.append(temp)
                flag = new_flag
        if flag:
            sum_adder.append("1")
        
        return "".join(reversed(sum_adder))
            
                
    
def one_adder(a:str,b:str) -> Tuple[str,bool]:
    add = STR2BIN[a] + STR2BIN[b]
    if add == 2:
        return ("0",True)
    return (str(add),False)

        
# @lc code=end

