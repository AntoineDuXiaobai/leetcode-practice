//  134. 加油站
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0, currTank = 0;
        int startingStation = 0;

        for(int i=0; i<gas.length; i++){
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            // currTank在gas[i]>0, 说明在该索引处可以出发
            // 如果当前累积油量小于0，无法从当前起点到达下一个站点
            if(currTank<0){
                startingStation = i+1; // 尝试下一个站点作为起点
                currTank = 0;  // 重置当前油量
            }
        }

        // totalTank的值>=0, 那么说明能转完一圈

        return totalTank >= 0 ? startingStation : -1;
    }
}
