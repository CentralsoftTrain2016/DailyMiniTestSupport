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

import domain.value.Enum.IsReleasedEnum;
import domain.value.date.RegistrationDate;
import domain.value.id.TestID;

public class Test implements List<Question>{
	private TestID testID = new TestID("");
	private User createUser;
	private RegistrationDate registrationDate;
	private List<Question> questionList = new ArrayList<Question>();
	private IsReleasedEnum isReleased;
	private ThemePeriod themePeriod;


	public ThemePeriod getThemePeriod() {
		return themePeriod;
	}

	public void setThemePeriod(ThemePeriod themePeriod) {
		this.themePeriod = themePeriod;
	}

	// 3つのテーマを1つの文字列として連結
	public String getThemeListString(){
		StringBuffer sb = new StringBuffer();

		for(Question q : questionList){
			sb.append(q.getTheme().getText()).append("/");
		}

		return sb.toString();
	}

	public IsReleasedEnum getIsReleased() {
		return isReleased;
	}
	public void setIsReleased(IsReleasedEnum isReleased) {
		this.isReleased = isReleased;
	}
	public TestID getTestID() {
		return testID;
	}
	public User getCreateUser() {
		return createUser;
	}
	public void forEach(Consumer<? super Question> action) {
		questionList.forEach(action);
	}
	public int size() {
		return questionList.size();
	}
	public boolean isEmpty() {
		return questionList.isEmpty();
	}
	public boolean contains(Object o) {
		return questionList.contains(o);
	}
	public Iterator<Question> iterator() {
		return questionList.iterator();
	}
	public Object[] toArray() {
		return questionList.toArray();
	}
	public <T> T[] toArray(T[] a) {
		return questionList.toArray(a);
	}
	public boolean add(Question e) {
		return questionList.add(e);
	}
	public boolean remove(Object o) {
		return questionList.remove(o);
	}
	public boolean containsAll(Collection<?> c) {
		return questionList.containsAll(c);
	}
	public boolean addAll(Collection<? extends Question> c) {
		return questionList.addAll(c);
	}
	public boolean addAll(int index, Collection<? extends Question> c) {
		return questionList.addAll(index, c);
	}
	public boolean removeAll(Collection<?> c) {
		return questionList.removeAll(c);
	}
	public boolean retainAll(Collection<?> c) {
		return questionList.retainAll(c);
	}
	public void replaceAll(UnaryOperator<Question> operator) {
		questionList.replaceAll(operator);
	}
	public boolean removeIf(Predicate<? super Question> filter) {
		return questionList.removeIf(filter);
	}
	public void sort(Comparator<? super Question> c) {
		questionList.sort(c);
	}
	public void clear() {
		questionList.clear();
	}
	public boolean equals(Object o) {
		return questionList.equals(o);
	}
	public int hashCode() {
		return questionList.hashCode();
	}
	public Question get(int index) {
		return questionList.get(index);
	}
	public Question set(int index, Question element) {
		return questionList.set(index, element);
	}
	public void add(int index, Question element) {
		questionList.add(index, element);
	}
	public Stream<Question> stream() {
		return questionList.stream();
	}
	public Question remove(int index) {
		return questionList.remove(index);
	}
	public Stream<Question> parallelStream() {
		return questionList.parallelStream();
	}
	public int indexOf(Object o) {
		return questionList.indexOf(o);
	}
	public int lastIndexOf(Object o) {
		return questionList.lastIndexOf(o);
	}
	public ListIterator<Question> listIterator() {
		return questionList.listIterator();
	}
	public ListIterator<Question> listIterator(int index) {
		return questionList.listIterator(index);
	}
	public List<Question> subList(int fromIndex, int toIndex) {
		return questionList.subList(fromIndex, toIndex);
	}
	public Spliterator<Question> spliterator() {
		return questionList.spliterator();
	}
	public RegistrationDate getRegistrationDate() {
		return registrationDate;
	}
	public void setTestID(TestID testID) {
		this.testID = testID;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	public void setRegistrationDate(RegistrationDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "Test [testID=" + testID + ", createUser=" + createUser + ", registrationDate=" + registrationDate
				+ ", questionList=" + questionList + ", isReleased=" + isReleased + "]";
	}


}
