package domain;

import domain.value.Enum.IsCorrectEnum;
import domain.value.id.ResultItemID;

public abstract class ResultItem {
	private ResultItemID resultItemID;
	private Result result;
	private IsCorrectEnum isCorrect;
	private Question question;



	public ResultItemID getResultItemID() {
		return resultItemID;
	}

	public void setResultItemID(ResultItemID resultItemID) {
		this.resultItemID = resultItemID;
	}

	public Result getResult() {
		return result;
	}

	public Question getQuestion() {
		return question;
	}

	public ResultItem(Result result, Question question) {
		super();
		this.result = result;
		this.question = question;
	}

	public IsCorrectEnum getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(IsCorrectEnum isCorrect) {
		this.isCorrect = isCorrect;
	}


}
