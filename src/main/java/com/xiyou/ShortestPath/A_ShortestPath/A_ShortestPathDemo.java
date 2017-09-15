package com.xiyou.ShortestPath.A_ShortestPath;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A*寻路算法
 * 没有回溯，算法局限性较大
 * @author cc
 * @create 2017-09-13-23:58
 */

public class A_ShortestPathDemo {
    public static void main(String[] args) {
        //矩阵初始化
        int[][] data = new int[7][9];
        for(int i = 0 ; i < data.length; i++){
            data[i][0] = data[i][data[0].length-1] = -1;
        }
        for (int i = 0 ; i < data[0].length ; i++){
            data[0][i] = data[data.length-1][i] = -1;
        }
        //设置墙壁
        data[2][4] = data[3][4] = data[4][4] = -1;
        //移动方向
        int[][] next = {{1,-1,0,0},{0,0,1,-1}};
        //设置终点
        Point end = new Point(3,6);
        List<Point> CloseList = new ArrayList<Point>();
        CloseList.add(new Point(3,2));
        A_ShortestPathDemo(data,CloseList,end,next);
        for (Point p : CloseList){
            System.out.println("x: "+(p.getX()-1)+" -  y: "+(p.getY()-1));
        }
    }
    public static void A_ShortestPathDemo(int[][] data,List<Point> CloseList,Point end, int[][] next){
        Point before = CloseList.get(CloseList.size()-1);
        if (before == null || before.equals(end)){
            return;
        }
        Point Maxpoint = null;
        int maxF = Integer.MAX_VALUE;
        for(int i = 0 ; i < next[0].length ; i++){
            int x = before.x + next[0][i];
            int y = before.y + next[1][i];
            if (data[x][y] != -1){
                Point point = new Point(x,y);
                data[x][y] = -1;
                int F = CloseList.size() + getDistance(point,end);
                if (F < maxF){
                    maxF = F;
                    Maxpoint = point;
                }
            }
        }
        if (Maxpoint == null ){
            CloseList.clear();
        }else {
            CloseList.add(Maxpoint);
            A_ShortestPathDemo(data, CloseList, end, next);
        }
    }
    public static int getDistance(Point p1, Point p2){
        int distance;
        distance = Math.abs(p1.x-p2.y) + Math.abs(p1.y - p2.y);
        return distance;
    }

}
