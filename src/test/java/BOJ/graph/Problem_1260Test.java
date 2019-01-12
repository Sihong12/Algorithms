package BOJ.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Problem_1260Test {

	@Test
	public void example_DFS() {
		int n = 4;
		boolean[][] graph = new boolean[n + 1][n + 1];
		setDirection(graph, 1, 2);
		setDirection(graph, 1, 3);
		setDirection(graph, 1, 4);
		setDirection(graph, 2, 4);
		setDirection(graph, 3, 4);

		int start = 1;
		assertThat(Problem_1260.DFS(graph, start)).isEqualTo("1 2 4 3");
	}

	@Test
	public void example_BFS() {
		int n = 4;
		boolean[][] graph = new boolean[n + 1][n + 1];
		setDirection(graph, 1, 2);
		setDirection(graph, 1, 3);
		setDirection(graph, 1, 4);
		setDirection(graph, 2, 4);
		setDirection(graph, 3, 4);

		int start = 1;
		assertThat(Problem_1260.BFS(graph, start)).isEqualTo("1 2 3 4");
	}

	private void setDirection(boolean[][] graph, int start, int end) {
		graph[start][end] = graph[end][start] = true;
	}
}