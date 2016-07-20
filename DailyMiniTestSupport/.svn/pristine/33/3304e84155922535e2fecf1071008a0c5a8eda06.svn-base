package domain.value.Enum;

import java.util.HashMap;
import java.util.Map;

import domain.Choice;
import domain.ChoiceResult;
import domain.ChoicesResult;
import domain.Question;
import domain.ResultItem;
import domain.ResultItemText;

public enum QuestionTypeEnum {

	RADIO_BUTTON("radio")
	{
		@Override
		public ResultItem getExamResult(ResultItem resultItem, Question question)
		{
			ChoiceResult cr = (ChoiceResult)resultItem;

			if(cr.getChoice().getIsCorrect() == IsCorrectEnum.CORRECT){
				cr.setIsCorrect(IsCorrectEnum.CORRECT);
			}else{
				cr.setIsCorrect(IsCorrectEnum.FAIL);
			}

			return null;
		}
	},
	CHECK_BOX("checkbox")
	{
		@Override
		public ResultItem getExamResult(ResultItem resultItem, Question question)
		{
			ChoicesResult csr = (ChoicesResult)resultItem;
			boolean flg = false;


			for(Choice c : csr)
			{
				if(c.getIsCorrect() == IsCorrectEnum.CORRECT){
					flg = true;
				}else{
					// 一つでも間違えていたら×
					csr.setIsCorrect(IsCorrectEnum.FAIL);
					flg = false;
					break;
				}
			}

			// 選んだ選択肢が全て正解なら〇
			if(flg == true){
				csr.setIsCorrect(IsCorrectEnum.CORRECT);
			}

			return null;
		}
	},
	TEXT("text")
	{
		@Override
		public ResultItem getExamResult(ResultItem resultItem, Question question)
		{
			ResultItemText tr = (ResultItemText)resultItem;

			if(tr.getText().toString().equals(question.get(0))){
				tr.setIsCorrect(IsCorrectEnum.CORRECT);
			}else{
				tr.setIsCorrect(IsCorrectEnum.FAIL);
			}

			return null;
		}
	};

	private String htmlInputTypeStr;
	private static Map<String, QuestionTypeEnum>  map = new HashMap<String, QuestionTypeEnum>();
	static{
		map.put(RADIO_BUTTON.getHtmlInputType(), RADIO_BUTTON);
		map.put(CHECK_BOX.getHtmlInputType(), CHECK_BOX);
		map.put(TEXT.getHtmlInputType(), TEXT);
	}

	private QuestionTypeEnum(String htmlInputTypeStr) {
		this.htmlInputTypeStr = htmlInputTypeStr;
	}

	public static QuestionTypeEnum getQuestionTypeEnumByHtmlName( String name)
	{
		return map.get(name);
	}

	public abstract ResultItem getExamResult(ResultItem result, Question question);

	public  String getHtmlInputType(){ return htmlInputTypeStr;}
}
