package BOJ.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 프린터 큐 (https://www.acmicpc.net/problem/1966)
 */
public class Problem_1966 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			Queue<Document> queue = new ArrayDeque<>();
			for (int index = 0; index < n; index++) {
				queue.add(new Document(index == m, scanner.nextInt()));
			}

			int count = 0;
			while (!queue.isEmpty()) {
				Document document = queue.remove();
				boolean isHighPriority = false;
				for (Document otherDocument : queue) {
					if (document.priority < otherDocument.priority) {
						isHighPriority = true;
						break;
					}
				}
				if (isHighPriority) {
					queue.add(document);
					continue;
				}

				++count;
				if (document.isTarget) {
					System.out.println(count);
					break;
				}
			}
		}
	}

	static class Document {
		boolean isTarget;
		int priority;

		public Document(boolean isTarget, int priority) {
			this.isTarget = isTarget;
			this.priority = priority;
		}
	}
}
