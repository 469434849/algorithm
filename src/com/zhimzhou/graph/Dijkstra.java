package com.zhimzhou.graph;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 单源最短路径算法
 * Dijkstra：最短路径算法，一个点到其他所有点的最短路径
 *
 * @author zhimzhou
 * @date 2019/1/24 16:58
 **/
public class Dijkstra {

	private static final int INF = Integer.MAX_VALUE;
	private static final char[] VERTICES = new char[]{
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'
	};

	/**
	 * 存放终点的数据以及起点到终点的权值
	 */
	public static class Enode {
		/**
		 * 边的起点
		 */
		char data;
		int weight;
		Enode nextEnode;

		public Enode() {
		}

		public Enode(char data) {
			this.data = data;
			this.nextEnode = null;
		}

		public Enode(char data, int weight) {
			this.data = data;
			this.weight = weight;
			this.nextEnode = null;
		}
	}

	/**
	 * 顶点，存放顶点数据，以及相邻的第一条边信息
	 */
	public static class Vnode {
		char data;
		Enode enode;

		public Vnode(char data) {
			this.data = data;
			this.enode = null;
		}

		public Vnode(char data, Enode enode) {
			this.data = data;
			this.enode = enode;
		}

	}

	public static class ResultNode {
		char data;
		int pathWeight;
		Enode enode;

		public ResultNode(char data, int pathWeight) {
			this.data = data;
			this.pathWeight = pathWeight;
			this.enode = null;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || this.getClass() != o.getClass()) {
				return false;
			}
			ResultNode that = (ResultNode) o;
			return data == that.data &&
					pathWeight == that.pathWeight;
		}

		@Override
		public int hashCode() {

			return Objects.hash(data, pathWeight);
		}
	}

	public static class EData {
		char c1;
		char c2;
		int weight;

		public EData(char c1, char c2, int weight) {
			this.c1 = c1;
			this.c2 = c2;
			this.weight = weight;
		}
	}

	/**
	 * 顶点数组
	 */
	private static Vnode[] mVexs;

	private static final EData[] E_DATA_ARRAY = new EData[]{
			new EData('A', 'B', 12),
			new EData('A', 'F', 16),
			new EData('A', 'G', 14),
			new EData('B', 'C', 10),
			new EData('B', 'F', 7),
			new EData('C', 'D', 3),
			new EData('C', 'E', 5),
			new EData('C', 'F', 6),
			new EData('D', 'E', 4),
			new EData('E', 'F', 2),
			new EData('E', 'G', 8),
			new EData('F', 'G', 9),
	};

	/**
	 * D(0)C(3)E(4)F(6)G(12)B(13)A(22)
	 */
	public static void main(String[] args) {
		mVexs = udgListByConstructor(E_DATA_ARRAY);
		printUdgList(mVexs);
		getMinimumPath(mVexs, 3);
	}

	/**
	 * A(INF)->D  B(INF)->D  C(INF)->D E(INF)->D F(INF)->D G(INF)->D
	 * F(9)->C->D
	 *
	 * @param mVertices
	 * @param start
	 */
	public static void getMinimumPath(Vnode[] mVertices, int start) {
		ArrayList<ResultNode> chooseResult = new ArrayList<>();
		ArrayList<ResultNode> notChooseResult = new ArrayList<>();
		ResultNode startNode = new ResultNode(mVertices[start].data, 0);
		chooseResult.add(startNode);
		for (int i = 0; i < mVertices.length; i++) {
			if (i != start) {
				ResultNode node = new ResultNode(mVertices[i].data, INF);
				node.enode = new Enode(startNode.data);
				notChooseResult.add(node);
			}
		}

		while (notChooseResult.size() > 0) {
			updateNotChooseResultByChooseResult(mVertices, chooseResult, notChooseResult);
		}

		System.out.println("顶点" + mVertices[start].data + "到其他各个点的最短距离：");
		chooseResult.forEach(resultNode -> System.out.print(resultNode.data + "(" + resultNode.pathWeight + ")"));

	}

	/**
	 * 根据已经选择的集合，更新未选择集合中的最短路径
	 *
	 * @param chooseResult    已经选择的最短路径集合
	 * @param notChooseResult 未确定最终最短路径的集合
	 */
	public static void updateNotChooseResultByChooseResult(Vnode[] mVertices, ArrayList<ResultNode> chooseResult, ArrayList<ResultNode> notChooseResult) {
		for (int i = 0; i < chooseResult.size(); i++) {
			ResultNode resultNode = chooseResult.get(i);
			Vnode mVertex = mVertices[resultNode.data - 'A'];
			Enode enode = mVertex.enode;
			while (enode != null) {
				char data = enode.data;
				int weight = enode.weight;
				//如果已选择节点集合中不存在当前节点
				if (!isContainsVnodeData(chooseResult, data)) {
					//更新notChooseResult的距离,带上原来的距离
					updateNotChooseResult(data, weight + resultNode.pathWeight, notChooseResult);
				}
				enode = enode.nextEnode;
			}
		}

		int min = INF;
		char minData = ' ';
		//把未选择的集合中的最小距离的数据加入到已选择集合
		for (ResultNode node : notChooseResult) {
			if (node.pathWeight < min) {
				min = node.pathWeight;
				minData = node.data;
				Enode enode = new Enode(minData, min);
				node.enode = enode;
			}
		}
		ResultNode tempNode = new ResultNode(minData, min);
		notChooseResult.remove(tempNode);
		chooseResult.add(tempNode);
	}

	public static void updateNotChooseResult(char data, int weight, ArrayList<ResultNode> notChooseResult) {
		for (ResultNode node : notChooseResult) {
			if (node.data == data && weight < node.pathWeight) {
				node.pathWeight = weight;
				break;
			}
		}
	}

	public static Boolean isContainsVnodeData(ArrayList<ResultNode> list, char data) {
		for (ResultNode aList : list) {
			if (aList.data == data) {
				return true;
			}
		}
		return false;
	}

	public static Vnode[] udgListByConstructor(EData[] eDataArray) {
		Vnode[] vNodes = new Vnode[VERTICES.length];
		for (int i = 0; i < VERTICES.length; i++) {
			vNodes[i] = new Vnode(VERTICES[i]);
		}
		for (EData anEDataArray : eDataArray) {
			char c1 = anEDataArray.c1;
			char c2 = anEDataArray.c2;
			int index1 = c1 - 'A';
			int index2 = c2 - 'A';
			int weight = anEDataArray.weight;
			addENodeToVNodeLast(vNodes, index1, index2, weight);
		}
		Vnode[] temp = null;
		for (int i = 0; i < VERTICES.length; i++) {
			if (vNodes[i].enode == null) {
				temp = new Vnode[i];
				System.arraycopy(vNodes, 0, temp, 0, i);
				break;
			}
		}
		return temp;
	}

	/**
	 * 把enode添加到vnode最后一个
	 * 和enode对应节点末尾添加vnode数据
	 * A-B  10        B-A 10
	 */
	public static void addENodeToVNodeLast(Vnode[] vNodes, int index1, int index2, int weight) {
		Vnode vNode1 = vNodes[index1];
		Vnode vNode2 = vNodes[index2];
		Enode eNode1 = new Enode(vNode2.data, weight);
		Enode eNode2 = new Enode(vNode1.data, weight);
		Enode vLastOneENode = vNode1.enode;
		if (vLastOneENode == null) {
			vNode1.enode = eNode1;
		} else {
			while (vLastOneENode.nextEnode != null) {
				vLastOneENode = vLastOneENode.nextEnode;
			}
			vLastOneENode.nextEnode = eNode1;
		}

		vLastOneENode = vNode2.enode;
		if (vLastOneENode == null) {
			vNode2.enode = eNode2;
		} else {
			while (vLastOneENode.nextEnode != null) {
				vLastOneENode = vLastOneENode.nextEnode;
			}
			vLastOneENode.nextEnode = eNode2;
		}

	}

	/**
	 * 打印无向图邻接表
	 *
	 * @param vNodes
	 */
	public static void printUdgList(Vnode[] vNodes) {
		System.out.println("邻接表表示：");
		for (Vnode temp : vNodes) {
			Enode tempENode = temp.enode;
			System.out.print(temp.data);
			while (tempENode != null) {
				System.out.print("->" + tempENode.data + "(" + tempENode.weight + ")");
				tempENode = tempENode.nextEnode;
			}
			System.out.println();
		}

	}


}
