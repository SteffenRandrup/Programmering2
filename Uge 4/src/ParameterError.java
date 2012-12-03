
public class ParameterError extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1386087346158872839L;

	public ParameterError(){

	}
	
	public String toString(){
		return "ParameterError: Specify at least 3 parameters (2 input files and the file to output to)";
	}
}
