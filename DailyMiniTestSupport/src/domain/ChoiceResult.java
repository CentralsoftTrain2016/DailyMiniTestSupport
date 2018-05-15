package domain;

public class ChoiceResult extends ResultItem{
	private Choice choice;

	public ChoiceResult(Result result,Question question) {
		super(result, question);
	}
	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}
}
