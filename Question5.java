import java.util.*;

class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        int n = mat.length;
        if (n == 0) return new ArrayList<>();
        int m = mat[0].length;
        
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        
        for (int i = 0; i < n; i++) {
            if (m > 0) {
                minHeap.offer(new Element(mat[i][0], i, 0));
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (!minHeap.isEmpty()) {
            Element curr = minHeap.poll();
            result.add(curr.value);
            
            if (curr.col + 1 < m) {
                minHeap.offer(new Element(mat[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }
        
        return result;
    }
    
    private static class Element {
        int value, row, col;
        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
}
