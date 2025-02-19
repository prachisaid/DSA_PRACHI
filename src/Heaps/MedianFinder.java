package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;
	double median;

	public MedianFinder() {
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		minHeap = new PriorityQueue<>();
		median = -1;
	}

	public void addNum(int num) {
		call_median(num);
	}

	private void call_median(int element) {
		int diff = Integer.compare(maxHeap.size(), minHeap.size());

		if(diff == 0) {
			if(element > median) {
				minHeap.add(element);
				median = minHeap.peek();
			}
			else {
				maxHeap.add(element);
				median = maxHeap.peek();
			}
		}

		else if(diff == 1) {
			if(element > median) {
				minHeap.add(element);
			}
			else {
				minHeap.add(maxHeap.poll());
				maxHeap.add(element);
			}

			median = (minHeap.peek() + maxHeap.peek()) / 2.0;
		}

		else if(diff == -1) {
			if(element > median) {
				maxHeap.add(minHeap.poll());
				minHeap.add(element);
			}
			else {
				maxHeap.add(element);
			}

			median = (minHeap.peek() + maxHeap.peek()) / 2.0;
		}
	}

	public double findMedian() {
		return median;
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
