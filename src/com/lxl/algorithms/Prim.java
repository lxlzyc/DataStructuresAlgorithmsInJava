package com.lxl.algorithms;

/**
 * Prim算法和Kruskal算法都能从连通图找出最小生成树。区别在于Prim算法是挨个找，而Kruskal是先排序再找。
 * Prim算法实现的是找出一个有权重连通图中的最小生成树，即：具有最小权重且连接到所有结点的树。(强调的是树，树是没有回路的)。
 * 
 * Prim算法是这样来做的：
 * 
 * 首先以一个结点作为最小生成树的初始结点，然后以迭代的方式找出与最小生成树中各结点权重最小边，并加入到最小生成树中。 加入之后如果产生回路则跳过这条
 * 边，选择下一个结点。当所有结点都加入到最小生成树中之后，就找出了连通图中的最小生成树了。
 * 
 * 若候选轻边集中的轻边不止一条，可任选其中的一条扩充到T中。 　连通网的最小生成树不一定是惟一的，但它们的权相等。
 * 该算法的特点是当前形成的集合T始终是一棵树。将T中U和TE分别看作红点和红边集，V-U看作蓝点集。 算法的每一步均是在连接红、蓝点集的紫边中选择
 * 一条轻边扩充进T中。MST性质保证了此边是安全的。 T从任意的根r开始，并逐渐生长直至U=V，即T包含了
 * C中所有的顶点为止。MST性质确保此时的T是G的一棵MST。 因为每次添加的边是使树中的权尽可能小，因此这是一种"贪心"的策略。
 * 　该算法的时间复杂度为O(n2)。与图中边数无关，该算法适合于稠密图。
 * 
 * @author Administrator
 * 
 */
public class Prim {

}
