package org.joolzminer.examples.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class Pizza {
	protected String name;
	
	public void prepare() {
		System.out.println("Preparing " + name);
	}
	
	public void bake() {
		System.out.println("Baking " + name);
	}
	
	public void cut() {
		System.out.println("Cutting " + name);
	}
	
	public void box() {
		System.out.println("Boxing " + name);
	}

	public String getName() {
		return name;
	}	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
					.append("name", name)
					.toString();
	}
}
