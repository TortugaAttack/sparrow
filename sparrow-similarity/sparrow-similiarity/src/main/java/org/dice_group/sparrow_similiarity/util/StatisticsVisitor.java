package org.dice_group.sparrow_similiarity.util;

import org.apache.jena.graph.Node;
import org.apache.jena.sparql.syntax.Element;
import org.apache.jena.sparql.syntax.ElementFilter;
import org.apache.jena.sparql.syntax.ElementGroup;
import org.apache.jena.sparql.syntax.ElementOptional;
import org.apache.jena.sparql.syntax.ElementPathBlock;
import org.apache.jena.sparql.syntax.ElementUnion;
import org.apache.jena.sparql.syntax.ElementVisitorBase;
import org.apache.jena.sparql.syntax.RecursiveElementVisitor;


public class StatisticsVisitor extends RecursiveElementVisitor{

	public boolean filter;
	public boolean union;
	public boolean optional;
	private boolean started;
	private Element where;
	public int bgps;
	
	public StatisticsVisitor() {
		super(new ElementVisitorBase());
	}

	public void startElement(ElementGroup el) {
		if (!started && el.equals(where)) {
			// root element found
			started = true;

		} 
	}

	public void setElementWhere(Element el) {
		this.where = el;
	}

	public void endElement(ElementPathBlock el) {

		if (started) {
			bgps+=el.getPattern().getList().size();
		}
	
	}
	
    public void startElement(ElementFilter el) {this.filter=true;} 
    public void startElement(ElementUnion el) {this.union=true;}
    public void startElement(ElementOptional el) {this.optional=true;}

}
