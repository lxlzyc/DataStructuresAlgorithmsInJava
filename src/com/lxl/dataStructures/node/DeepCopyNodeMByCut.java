package com.lxl.dataStructures.node;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * 截断式复制图。
 * @author lxl
 *
 */
public class DeepCopyNodeMByCut {

	private Map<NodeM, NodeM[]> oldArr;
	private Set<NodeM> nodeMset;
	private Set<NodeM> newnodeMset;
	public NodeM[] cutAll(NodeM node){
		NodeM[] nodearr = node.getNodeArr();
		node.setNodeArr(null);
		return nodearr;
	}
	
	public void addNodeM(NodeM node){
		if(!nodeMset.contains(node)){
			nodeMset.add(node);
			for(NodeM nodetemp:node.getNodeArr()){
				if(!nodeMset.contains(nodetemp)){
					addNodeM(nodetemp);
				}
			}
		}
	} 
	
	public void deepCopy(NodeM node){
		this.addNodeM(node);
		//每一个都替换掉
		for(NodeM nodem:nodeMset){
			int nodeSize = nodem.getNodeSize();
			NodeM[] nodeArr = nodem.getNodeArr();
			NodeM newnode = new NodeM();
			newnode.setNodeSize(nodeSize);
			newnode.setNodeArr(nodeArr);
			//记录原来的连接
			oldArr.put(nodem, nodeArr);
			//把原来的连接断掉
			nodem.setNodeArr(null);
			
			
			
			newnodeMset.add(newnode);
			//用新的替换掉旧的相连接点的连接
			for(NodeM nodem2:nodeArr){
				NodeM[] nodeArrInner = nodem2.getNodeArr();

				int j = -1;
				for(int i = 0,l = nodeArrInner.length;i<l;i++){
					if(nodeArrInner[i].getNodeArr() == null){
						j = i;
						i = l;
					}
				}
				nodeArrInner[j] = newnode;
			}
		}
		//恢复旧的连接
		this.regetOldNode();
	}
	//恢复旧的连接
	public void regetOldNode() {
		// TODO Auto-generated method stub
		for(NodeM nodem:nodeMset){
			nodem.setNodeArr(oldArr.get(nodem));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
