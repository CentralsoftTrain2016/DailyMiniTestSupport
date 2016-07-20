package domain;

import domain.value.Text;

public class ResultItemText extends ResultItem {

	public ResultItemText(Result result, Question question) {
		super(result, question);
	}

	private Text text;

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
}
