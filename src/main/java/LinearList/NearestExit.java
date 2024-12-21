package LinearList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 寻找迷宫最近的出口
 * @author chengxiyang
 */
public class NearestExit {
    public int nearestExit (char[][] maze, int[] entrance){
        //left, up, right, down
        char vacuum = '.';
        char wall = '+';
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int xLen = maze.length;
        int yLen = maze[0].length;

        Queue<Node> path = new LinkedList<>();
        Node start = new Node();
        start.x = entrance[0];
        start.y = entrance[1];
        start.d = 0;
        path.offer(start);
        maze[start.x][start.y] = wall;

        while (!path.isEmpty()) {
            Node cur = path.poll();
            boolean isExit =
                    cur != start && (
                            cur.x == 0 || cur.x == xLen -1 ||
                                    cur.y == 0 || cur.y == yLen - 1);
            if (isExit) {
                return cur.d;
            }
            //try to get next node
            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                boolean isValid =
                        0 <= nx && xLen > nx &&
                                0 <= ny && yLen > ny &&
                                (maze[nx][ny] == vacuum);
                if (isValid) {
                    Node tmp = new Node();
                    tmp.x = nx;
                    tmp.y = ny;
                    tmp.d = cur.d + 1;
                    path.offer(tmp);
                    maze[tmp.x][tmp.y] = wall;
                }
            }
        }
        return -1;
    }

    //this is an approximate algorithm for most case
    public int dfs(char[][] maze, int[] entrance) {
        //left, up, right, down
        char vacuum = '.';
        char wall = '+';
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int xLen = maze.length;
        int yLen = maze[0].length;
        int minNode = xLen * yLen;
        boolean flag = false;

        Stack<int[]> path = new Stack<>();
        int stackSize = 0;
        int[] cur = {entrance[0], entrance[1]};
        path.push(cur);
        ++stackSize;
        maze[cur[0]][cur[1]] = wall;

        while (!path.isEmpty()) {
            int[] next = {-1, -1};
            //try to get next node
            for (int i = 0; i < 4; ++i) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                boolean isValid = (0 <= nx && xLen > nx) && (0 <= ny && yLen > ny) && (maze[nx][ny] == vacuum);
                if (isValid) {
                    next[0] = nx;
                    next[1] = ny;
                    break;
                }
            }
            if (next[0] == -1 && next[1] == -1) {
                path.pop();
                --stackSize;
                if (path.isEmpty()) {
                    break;
                }
                cur = path.peek();
            } else {
                cur = next;
                path.push(cur);
                ++stackSize;
                maze[cur[0]][cur[1]] = wall;
                boolean isBoundary = (cur[0] == 0 || cur[0] == xLen - 1) || (cur[1] == 0 || cur[1] == yLen - 1);
                if (isBoundary) {
                    flag = true;
                    if (minNode > stackSize) {
                        minNode = stackSize;
                    }
                    path.pop();
                    --stackSize;
                    cur = path.peek();
                }
            }
        }
        if (!flag) {
            return -1;
        }
        return minNode - 1;
    }

    static class Node {
        Node p;
        int x;
        int y;
        int d;
    }

}
