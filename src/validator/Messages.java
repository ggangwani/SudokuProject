package validator;

public enum Messages {
	
	INVALID_FILE_ERROR("File does not exist"),
	INPUT_FILE("Please enter the Sudoku file name"),
	VALIDATING("Validating Sudoku grid"),
	SUCCESS("Sudoku grid is valid"),
	FAILED("Found following invalid numbers:");
	
	private String error;
	Messages(String error){
		this.error = error;
	}

	@Override
	public String toString() {
		return error;
	}
	
}
