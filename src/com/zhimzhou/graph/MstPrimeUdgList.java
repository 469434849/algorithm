package com.zhimzhou.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 邻接表实现Prime
 *
 * @author zhimzhou
 * @date 2019/1/21 17:43
 **/
public class MstPrimeUdgList {
	private static Scanner scanner = new Scanner(System.in);
	private static final int INF = Integer.MAX_VALUE;
	private static final char[] VERTICES = new char[]{
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'
	};

	/**
	 * 存放终点的数据以及起点到终点的权值
	 */
	public static class Enode {
		char data;
		int weight;
		Enode nextEnode;

		public Enode() {
		}

		public Enode(char data, int weight) {
			this.data = data;
			this.weight = weight;
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

	private static final EData[] eDataArray = new EData[]{
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

	public static void main(String[] args) {
		//mVexs = udgListByInput();
		//printUdgList(mVexs);
		mVexs = udgListByConstructor(eDataArray);
		printUdgList(mVexs);
		mst(mVexs, 'A');
		//最小生成树的权值:
		//12	7	2	4	3	8
		//最小生成树的顶点:
		//A	B	F	E	D	C	G
	}

	public static void mst(Vnode[] vNodes, char beginNode) {
		//已选择顶点集合
		ArrayList<Character> chooseNode = new ArrayList<>();
		ArrayList<Integer> weight = new ArrayList<>();
		chooseNode.add(beginNode);
		//未选择顶点集合
		ArrayList<Character> notChooseNode = new ArrayList<>();
		for (Vnode vNode : vNodes) {
			if (vNode.data != beginNode) {
				notChooseNode.add(vNode.data);
			}
		}
		//只要未选择的集合里面还有节点
		while (notChooseNode.size() > 0) {
			int min = INF;
			Character tempChooseNode = null;
			for (Character c : chooseNode) {
				Vnode vNode = vNodes[c - 'A'];
				Enode enode = vNode.enode;
				while (enode != null) {
					//当前节点在未选择集合里
					if (notChooseNode.contains(enode.data) && enode.weight < min) {
						min = enode.weight;
						tempChooseNode = enode.data;
					}
					enode = enode.nextEnode;
				}
			}
			chooseNode.add(tempChooseNode);
			notChooseNode.remove(tempChooseNode);
			weight.add(min);
		}

		System.out.println("最小生成树的权值:");
		weight.forEach(integer -> System.out.print(integer + "\t"));
		System.out.println();
		System.out.println("最小生成树的顶点:");
		chooseNode.forEach(character -> System.out.print(character + "\t"));

	}

	/**
	 * 手动构造无向图邻接表
	 *
	 * @param eDataArray
	 * @return
	 */
	private static Vnode[] udgListByConstructor(EData[] eDataArray) {
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
	 * 手动输入初始化无向图邻接表
	 */
	private static Vnode[] udgListByInput() {
		System.out.println("请输入顶点个数:");
		int mVertices = scanner.nextInt();
		System.out.println("请输入边数目:");
		int mEdges = scanner.nextInt();
		Vnode[] vNodes = new Vnode[mVertices];
		//初始化vNodes
		for (int i = 0; i < mVertices; i++) {
			vNodes[i] = new Vnode(VERTICES[i]);
		}
		for (int i = 0; i < mEdges; i++) {
			System.out.println("输入第" + (i + 1) + "条边的起点:");
			char c1 = scanner.next().charAt(0);
			System.out.println("输入第" + (i + 1) + "条边的终点:");
			char c2 = scanner.next().charAt(0);
			System.out.println("请输入边的大小:");
			int weight = scanner.nextInt();
			//从vNodes里获取该data的节点
			int index1 = c1 - 'A';
			int index2 = c2 - 'A';
			addENodeToVNodeLast(vNodes, index1, index2, weight);
		}

		return vNodes;
	}

	/**
	 * 把enode添加到vnode最后一个
	 * 和enode对应节点末尾添加vnode数据
	 * A-B  10        B-A 10
	 */
	private static void addENodeToVNodeLast(Vnode[] vNodes, int index1, int index2, int weight) {
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
	private static void printUdgList(Vnode[] vNodes) {
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
