package BOJ.graph;

import static java.util.stream.Collectors.joining;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * DFS와 BFS (https://www.acmicpc.net/problem/1260)
 */
public class Problem_1260 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int start = scanner.nextInt();

		boolean[][] graph = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			setDirection(graph, scanner.nextInt(), scanner.nextInt());
		}

		System.out.println(DFS(graph, start));
		System.out.println(BFS(graph, start));
	}

	public static void setDirection(boolean[][] graph, int start, int end) {
		graph[start][end] = graph[end][start] = true;
	}

	public static String DFS(boolean[][] graph, int start) {
		List<Integer> visitedPoints = new ArrayList<>();
		boolean[] isVisited = new boolean[graph.length];
		searchByDFS(isVisited, visitedPoints, graph, start);
		return joinVisitedPoint(visitedPoints);
	}

	private static void searchByDFS(boolean[] isVisited, List<Integer> visitedPoints, boolean[][] graph, int start) {
		if (!isVisited[start]) {
			visitedPoints.add(start);
			isVisited[start] = true;
			for (int next = 1; next < graph.length; next++) {
				if (graph[start][next] && !isVisited[next]) {
					searchByDFS(isVisited, visitedPoints, graph, next);
				}
			}
		}
	}

	public static String BFS(boolean[][] graph, int start) {
		List<Integer> visitedPoints = new ArrayList<>();
		boolean[] isVisited = new boolean[graph.length];

		Queue<Integer> queue = new ArrayDeque<>();
		visitByBFS(visitedPoints, isVisited, queue, start);
		while (!queue.isEmpty()) {
			Integer point = queue.remove();
			for (int next = 0; next < graph.length; next++) {
				if (graph[point][next] && !isVisited[next]) {
					visitByBFS(visitedPoints, isVisited, queue, next);
				}
			}
		}
		return joinVisitedPoint(visitedPoints);
	}

	private static void visitByBFS(List<Integer> visitedPoints, boolean[] isVisited, Queue<Integer> queue, int point) {
		visitedPoints.add(point);
		isVisited[point] = true;
		queue.add(point);
	}

	private static String joinVisitedPoint(List<Integer> visitedPoints) {
		return visitedPoints.stream()
				.map(integer -> integer.toString())
				.collect(joining(" "));
	}
}
