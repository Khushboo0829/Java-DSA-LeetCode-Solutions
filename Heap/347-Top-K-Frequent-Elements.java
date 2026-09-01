import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        final HashMap<Integer, Integer> frequency =
                new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }

        Comparator<Integer> frequencyComparator =
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                       return frequency.get(a) - frequency.get(b);
                    }
                };

        PriorityQueue<Integer> minHeap =
               new PriorityQueue<Integer>(k + 1, frequencyComparator);

        for (int num : frequency.keySet()) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            answer[i] = minHeap.poll();
        }

        return answer;
    }
}