package domain;

import domain.value.CommentaryText;
import domain.value.Text;
import domain.value.Enum.IsCorrectEnum;
import domain.value.id.ChoiceID;

public class Choice {

	private ChoiceID choiceID;				// 選択肢ID
	private Question question;			// 問題ID
	private Text text;						// 選択肢の文
	private CommentaryText commentaryText;	// 選択肢解説
	private IsCorrectEnum isCorrect;			//



	public Choice(ChoiceID choiceID, Question question, Text text, CommentaryText commentaryText,
			IsCorrectEnum isCorrect) {
		super();
		this.choiceID = choiceID;
		this.question = question;
		this.text = text;
		this.commentaryText = commentaryText;
		this.isCorrect = isCorrect;
	}

	public IsCorrectEnum getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(IsCorrectEnum isCorrect) {
		this.isCorrect = isCorrect;
	}

	public ChoiceID getChoiceID() {
		return choiceID;
	}

	public void setChoiceID(ChoiceID choiceID) {
		this.choiceID = choiceID;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public CommentaryText getCommentaryText() {
		return commentaryText;
	}

	public void setCommentaryText(CommentaryText commentaryText) {
		this.commentaryText = commentaryText;
	}

	@Override
	public String toString() {
		return "Choice [choiceID=" + choiceID + ", question=" + question + ", text=" + text + ", commentaryText="
				+ commentaryText + ", isCorrect=" + isCorrect + "]";
	}

}
