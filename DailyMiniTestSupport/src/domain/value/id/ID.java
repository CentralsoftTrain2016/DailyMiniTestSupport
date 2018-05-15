package domain.value.id;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import domain.value.Value;

public class ID extends Value{

	private String id;

	public ID(String id) {
		super();
		this.id = id;
	}
	public ID(BigDecimal id) {
		super();
		DecimalFormat df = new DecimalFormat("00000000000000000000");
		this.id = df.format(id);
	}


	public String getValue(){
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id.equals(obj.toString());
	}

}
