package service.bean;

import java.util.Map;

import domain.Choice;
import domain.Question;
import domain.Test;
import domain.Theme;
import domain.User;
import domain.value.CommentaryText;
import domain.value.Text;
import domain.value.Enum.IsCorrectEnum;
import domain.value.Enum.IsReleasedEnum;
import domain.value.Enum.IsSavedEnum;
import domain.value.Enum.QuestionTypeEnum;
import domain.value.date.RegistrationDate;
import domain.value.id.TestID;
import domain.value.id.ThemeID;

public class CreateTestBean  extends Bean {

	//ThemePeriod themePeriod;
	Test test =new Test();
	IsSavedEnum isSaved = IsSavedEnum.UN_SAVED;

	public CreateTestBean()
	{
		super();

	}



	public IsSavedEnum isSaved() {
		return isSaved;
	}



	public void setIsSaved(IsSavedEnum isSaved) {
		this.isSaved = isSaved;
	}



	public void setFromPrameter(Map<String, String[]> parameterMap, User user) {
		isSaved = IsSavedEnum.valueOf( parameterMap.get( IsSavedEnum.class.getName() )[0] );

		//test = new Test();
		test.setCreateUser(user);
		test.setTestID( new TestID( parameterMap.get( TestID.class.getName() )[0] ) );
		test.setIsReleased(IsReleasedEnum.PROGLESS);
		test.setRegistrationDate(RegistrationDate.now());

		for( int questionNum = 1 ; questionNum <= 3; questionNum++)
		{
			Question q = this.getQuestionFromRequest(questionNum, parameterMap);
			q.setTest(test);
			test.add(q);
		}


	}



	private Question getQuestionFromRequest(int questionNum, Map<String, String[]>  request)
	{
		String questionText = request.get(  "question" + questionNum)[0];
		String comentaryText = request.get(  "comentary" + questionNum)[0];
		String questionType =  request.get(  "questiontype" + questionNum)[0];
		String[] themaIDs =  request.get(  "theme" + questionNum);
		String themaID = null;
		if(themaIDs != null )
		{
			themaID = themaIDs[0];
		}

		Theme thema = test.getThemePeriod().get( new ThemeID(themaID));

		Question question = new Question(
								null,
								null,
								thema,
								new Text( questionText),
								new CommentaryText(comentaryText),
								QuestionTypeEnum.getQuestionTypeEnumByHtmlName(questionType));

		getChoiceFromRequest(questionNum, question, request);

		return question;
	}

	private void getChoiceFromRequest(int questionNum, Question question, Map<String, String[]>  request)
	{
		String[] choices= request.get("choice"+questionNum);
		String[] choiceComentaries= request.get("choiceComentary"+questionNum);

		int choiceSelectNum =0;
		String[] choiceSelects= request.get("choiceSelect"+questionNum);
		if (choiceSelects!=null )
		{
			choiceSelectNum = Integer.parseInt(choiceSelects[0]);
		}

		for( int i =0; i < choices.length; i++)
		{
			IsCorrectEnum isCorrect = IsCorrectEnum.FAIL;
			if(isContain(choiceSelects, i) ){
				isCorrect = IsCorrectEnum.CORRECT;
			}

			Choice choice= new Choice(
								null,
								question,
								new Text(choices[i]),
								new CommentaryText(choiceComentaries[i]),
								isCorrect);
			choice.setQuestion(question);
			question.add(choice);
		}
	}

	private boolean isContain( String[] list, int i )
	{
		if( list == null )
			return false;

		for( String str :list )
		{
			if( str.equals( String.valueOf(i))) return true;
		}
		return false;
	}


	public void initForFirstOpen()
	{
		//test = new Test();
		Question q1 = new Question(null, test, test.getThemePeriod().get(0), new Text(""), new CommentaryText(""), QuestionTypeEnum.RADIO_BUTTON);
		q1.add(new Choice(null, q1, new Text(""),  new CommentaryText(""),  IsCorrectEnum.FAIL));
		test.add(q1);
		Question q2 = new Question(null, test, test.getThemePeriod().get(0), new Text(""), new CommentaryText(""), QuestionTypeEnum.RADIO_BUTTON);
		q2.add(new Choice(null, q2,  new Text(""),  new CommentaryText(""),  IsCorrectEnum.FAIL));
		test.add(q2);
		Question q3 = new Question(null, test, test.getThemePeriod().get(0), new Text(""), new CommentaryText(""), QuestionTypeEnum.RADIO_BUTTON);
		q3.add(new Choice(null, q3,  new Text(""),  new CommentaryText(""),  IsCorrectEnum.FAIL));
		test.add(q3);

		test.setRegistrationDate( RegistrationDate.now());
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}





}
