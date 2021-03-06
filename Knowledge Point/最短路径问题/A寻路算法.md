# A*寻路算法
* 英文名：A* Search,是一种用于寻找有效路径的算法。
## 场景描述
![](https://i.imgur.com/7gxbsra.jpg)
* 如图假设有一个7*5大小的迷宫，绿色的格子是起点，红色的格子是终点，中间三个蓝色格子是一堵墙。游戏规则是从起点开始，每一步只能向上下左右移动一格，且不能穿越墙壁。如何让AI用最少的步数到达终点呢？
## 解决思路
1. 首先引入两个集合和一个公式：`[OpenList]`,`[CloseList]`,`[F= G + H ]`;
	* `[OpenList]`：存储可到达的格子
	* `[CloseList]`：存储已到达的格子
	* 公式`F = G + H`，则是对格子价值的评估。
		* 其中G代表从起点走到当前格的成本，也就是走了多少步。
		* H代表从当前格走到目标格的距离，也就是再不考虑障碍的情况下，离目标还有多远。
		* 至于F,则是对G和H的综合评估。显然我们应该尽量选择步数更少，离目标更近的格子。所以F的值越小越好。
		* 