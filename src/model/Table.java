package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TABLE")
public class Table {

	@XmlElement(name = "ROW")
	private List<Row> rows;
	private String errors;

	public List<Row> getLstRows() {
		return rows;
	}

	public void setLstRows(List<Row> rows) {
		this.rows = rows;
	}

	public String getErrors() {
		return errors;
	}

	public boolean validateSudoku() {
		StringBuilder builder = new StringBuilder();
		Set<Integer> set = new HashSet<Integer>();
		int counter = 1;
		boolean isValid = true;
		for (Row row : rows) {
			for (Column column : row.getColumns()) {
				// do the range check and check for duplicates
				if (!column.isInRange() || !set.add(column.getValue())) {
					isValid = false;
					builder.append(((counter++) + ". " + row + " " + column + "\n"));
				}
			}
		}
		isValid = isValid
				&& set.stream().mapToInt(Integer::intValue).sum() == 45;
		errors = builder.toString();
		return isValid;
	}
}
