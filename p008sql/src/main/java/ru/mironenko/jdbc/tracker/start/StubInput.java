package ru.mironenko.jdbc.tracker.start;


public class StubInput implements Input{
	
	private String[] answers;

	private int position = 0;
	
	public StubInput(String[] answers){
		this.answers = answers;
	}
	public String ask(String question){
		return answers[position++];
	}
	
	public int ask(String question, int[] range){
		//throw new UnsupportedOperationException("Unsupported operation");
		//return -1;
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range){
			if (value == key){
				exist = true;
				break;
			}
		}
		if (exist){
			return key;
		}else{
			throw new MenuOutException("out of menu range");
		}
	}
}	