问题描述：
```
Problem one: Trains
The local commuter railroad services a number of towns in Kiwiland.  Because of monetary concerns, all of the tracks are 'one-way.'  That is, a route from Kaitaia to Invercargill does not imply the existence of a route from Invercargill to Kaitaia.  In fact, even if both of these routes do happen to exist, they are distinct and are not necessarily the same distance!
 
The purpose of this problem is to help the railroad provide its customers with information about the routes.  In particular, you will compute the distance along a certain route, the number of different routes between two towns, and the shortest route between two towns.
 
Input:  A directed graph where a node represents a town and an edge represents a route between two towns.  The weighting of the edge represents the distance between the two towns.  A given route will never appear more than once, and for a given route, the starting and ending town will not be the same town.
 
Output: For test input 1 through 5, if no such route exists, output 'NO SUCH ROUTE'.  Otherwise, follow the route as given; do not make any extra stops!  For example, the first problem means to start at city A, then travel directly to city B (a distance of 5), then directly to city C (a distance of 4).
The distance of the route A-B-C.
The distance of the route A-D.
The distance of the route A-D-C.
The distance of the route A-E-B-C-D.
The distance of the route A-E-D.
The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
The length of the shortest route (in terms of distance to travel) from A to C.
The length of the shortest route (in terms of distance to travel) from B to B.
The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.
 
Test Input:
For the test input, the towns are named using the first few letters of the alphabet from A to D.  A route between two towns (A to B) with a distance of 5 is represented as AB5.
Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
Expected Output:
Output #1: 9
Output #2: 5
Output #3: 13
Output #4: 22
Output #5: NO SUCH ROUTE
Output #6: 2
Output #7: 3
Output #8: 9
Output #9: 9
Output #10: 7
```
思路分析：
```
问题可以分为两大类：
1.根据用户输入的路径判断是否存在并求该路径的距离(1-5题)
2.根据用户设定的条件求合适的路径列表（6-10题）
  i.不允许重新遍历之前遍历过的节点，且不需要设置响应的条件（最短路径8,9题）
  ii.允许重新遍历之前遍历过的节点，且需要设置对象步数或者距离(6,7,10题)
  
解法：1.只需要将路径丢到map里面去遍历找是否存在对应的路径即可并计算距离返回
      2.构建有向有环图并且根据相应的条件跳出循环并返回路径，最后筛选
        
```
核心目录结构
```
APP启动类
core包里面的Graph核心图构建和遍历类
entity对应实体类
handler业务处理包及1-10输出类
predicates图遍历判定条件
```
