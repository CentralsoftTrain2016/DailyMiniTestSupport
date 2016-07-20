package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import domain.value.CommentaryText;
import domain.value.Text;
import domain.value.Enum.QuestionTypeEnum;
import domain.value.id.QuestionID;

public class Question implements List<Choice> {

	private QuestionID questionID;			// 問題ID
	private Test test;						// テスト
	private Theme theme;					// テーマ
	private Text text;						// 問題文
	private CommentaryText commentaryText;	// 問題解説
	private QuestionTypeEnum questionTypeEnum;
	private List<Choice> choiceList = new ArrayList<Choice>();

	/* コンストラクタ */
	public Question(
				QuestionID questionID,
				Test test,
				Theme theme,
				Text text,
				CommentaryText commentaryText,
				QuestionTypeEnum questionTypeEnum
			)
	{
		super();
		this.questionID = questionID;
		this.test = test;
		this.theme = theme;
		this.text = text;
		this.commentaryText = commentaryText;
		this.questionTypeEnum = questionTypeEnum;
	}

	public Question() {
	}


	public String isSelected(QuestionTypeEnum qte)
	{
		if( questionTypeEnum == qte )
			return "selected";

		return "";
	}
	public String isSelected(Theme thm)
	{
		if( this.theme.getText().toString().equals(thm.getText().toString()))
			return "selected";

		return "";
	}


	public QuestionTypeEnum getQuestionTypeEnum() {
		return questionTypeEnum;
	}



	public void setQuestionTypeEnum(QuestionTypeEnum questionTypeEnum) {
		this.questionTypeEnum = questionTypeEnum;
	}



	public Test getTest() {
		return test;
	}



	public void forEach(Consumer<? super Choice> action) {
		choiceList.forEach(action);
	}

	public ResultItem getExamResult(ResultItem result){
		return questionTypeEnum.getExamResult(result, this);
	}

	public int size() {
		return choiceList.size();
	}



	public boolean isEmpty() {
		return choiceList.isEmpty();
	}



	public boolean contains(Object o) {
		return choiceList.contains(o);
	}



	public Iterator<Choice> iterator() {
		return choiceList.iterator();
	}



	public Object[] toArray() {
		return choiceList.toArray();
	}



	public <T> T[] toArray(T[] a) {
		return choiceList.toArray(a);
	}



	public boolean add(Choice e) {
		return choiceList.add(e);
	}



	public boolean remove(Object o) {
		return choiceList.remove(o);
	}



	public boolean containsAll(Collection<?> c) {
		return choiceList.containsAll(c);
	}



	public boolean addAll(Collection<? extends Choice> c) {
		return choiceList.addAll(c);
	}



	public boolean addAll(int index, Collection<? extends Choice> c) {
		return choiceList.addAll(index, c);
	}



	public boolean removeAll(Collection<?> c) {
		return choiceList.removeAll(c);
	}



	public boolean retainAll(Collection<?> c) {
		return choiceList.retainAll(c);
	}



	public void replaceAll(UnaryOperator<Choice> operator) {
		choiceList.replaceAll(operator);
	}



	public boolean removeIf(Predicate<? super Choice> filter) {
		return choiceList.removeIf(filter);
	}



	public void sort(Comparator<? super Choice> c) {
		choiceList.sort(c);
	}



	public void clear() {
		choiceList.clear();
	}



	public boolean equals(Object o) {
		return choiceList.equals(o);
	}



	public int hashCode() {
		return choiceList.hashCode();
	}



	public Choice get(int index) {
		return choiceList.get(index);
	}



	public Choice set(int index, Choice element) {
		return choiceList.set(index, element);
	}



	public void add(int index, Choice element) {
		choiceList.add(index, element);
	}



	public Stream<Choice> stream() {
		return choiceList.stream();
	}



	public Choice remove(int index) {
		return choiceList.remove(index);
	}



	public Stream<Choice> parallelStream() {
		return choiceList.parallelStream();
	}



	public int indexOf(Object o) {
		return choiceList.indexOf(o);
	}



	public int lastIndexOf(Object o) {
		return choiceList.lastIndexOf(o);
	}



	public ListIterator<Choice> listIterator() {
		return choiceList.listIterator();
	}



	public ListIterator<Choice> listIterator(int index) {
		return choiceList.listIterator(index);
	}



	public List<Choice> subList(int fromIndex, int toIndex) {
		return choiceList.subList(fromIndex, toIndex);
	}



	public Spliterator<Choice> spliterator() {
		return choiceList.spliterator();
	}



	// 仮
	public Result getExamResult(){
		return null;
	}


	public QuestionID getQuestionID() {
		return questionID;
	}

	public void setQuestionID(QuestionID questionID) {
		this.questionID = questionID;
	}



	public void setTest(Test test) {
		this.test = test;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
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
		return "Question [questionID=" + questionID + ", test=" + test + ", theme=" + theme + ", text=" + text
				+ ", commentaryText=" + commentaryText + ", questionTypeEnum=" + questionTypeEnum + ", choiceList="
				+ choiceList + "]";
	}

}
