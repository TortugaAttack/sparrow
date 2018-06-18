package org.dice_group.sparrow.owl;

import java.util.LinkedList;
import java.util.List;

public class OWLQuery {

	public List<OWLNode> sequence = new LinkedList<OWLNode>();
	
	public void addOWLNode(OWLNode node) {
		sequence.add(node);
	}
	
	public void putOWLNode(OWLNode node, int index) {
		sequence.add(index, node);
	}
	
	public List<OWLNode> getOWLNodeByName(String name) {
		return null;
	}
	
	public OWLNode getOWLNodeByIndex(int index) {
		return sequence.get(index);
	}
	
	@Override
	public String toString() {
		StringBuilder owlString = new StringBuilder();
		for(OWLNode node : sequence) {
			owlString.append(node.toString()).append(" ");
		}
		return owlString.toString();
	}
}