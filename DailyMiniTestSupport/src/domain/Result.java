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

import domain.value.Score;
import domain.value.date.AnswerDate;
import domain.value.id.ResultID;

public class Result implements List<ResultItem>{
 private ResultID resultid;
 private User user;
 private Test test;
 private Score score;
 private List<ResultItem> resultItemList = new ArrayList<ResultItem>();
 private AnswerDate answerDate;

public AnswerDate getAnswerDate() {
	return answerDate;
}
public void setAnswerDate(AnswerDate answerDate) {
	this.answerDate = answerDate;
}
public ResultID getResultid() {
	return resultid;
}
public User getUser() {
	return user;
}
public Test getTest() {
	return test;
}
public Score getScore() {
	return score;
}

public void setResultid(ResultID resultid) {
	this.resultid = resultid;
}
public void forEach(Consumer<? super ResultItem> action) {
	resultItemList.forEach(action);
}
public int size() {
	return resultItemList.size();
}
public boolean isEmpty() {
	return resultItemList.isEmpty();
}
public boolean contains(Object o) {
	return resultItemList.contains(o);
}
public Iterator<ResultItem> iterator() {
	return resultItemList.iterator();
}
public Object[] toArray() {
	return resultItemList.toArray();
}
public <T> T[] toArray(T[] a) {
	return resultItemList.toArray(a);
}
public boolean add(ResultItem e) {
	return resultItemList.add(e);
}
public boolean remove(Object o) {
	return resultItemList.remove(o);
}
public boolean containsAll(Collection<?> c) {
	return resultItemList.containsAll(c);
}
public boolean addAll(Collection<? extends ResultItem> c) {
	return resultItemList.addAll(c);
}
public boolean addAll(int index, Collection<? extends ResultItem> c) {
	return resultItemList.addAll(index, c);
}
public boolean removeAll(Collection<?> c) {
	return resultItemList.removeAll(c);
}
public boolean retainAll(Collection<?> c) {
	return resultItemList.retainAll(c);
}
public void replaceAll(UnaryOperator<ResultItem> operator) {
	resultItemList.replaceAll(operator);
}
public boolean removeIf(Predicate<? super ResultItem> filter) {
	return resultItemList.removeIf(filter);
}
public void sort(Comparator<? super ResultItem> c) {
	resultItemList.sort(c);
}
public void clear() {
	resultItemList.clear();
}
public boolean equals(Object o) {
	return resultItemList.equals(o);
}
public int hashCode() {
	return resultItemList.hashCode();
}
public ResultItem get(int index) {
	return resultItemList.get(index);
}
public ResultItem set(int index, ResultItem element) {
	return resultItemList.set(index, element);
}
public void add(int index, ResultItem element) {
	resultItemList.add(index, element);
}
public Stream<ResultItem> stream() {
	return resultItemList.stream();
}
public ResultItem remove(int index) {
	return resultItemList.remove(index);
}
public Stream<ResultItem> parallelStream() {
	return resultItemList.parallelStream();
}
public int indexOf(Object o) {
	return resultItemList.indexOf(o);
}
public int lastIndexOf(Object o) {
	return resultItemList.lastIndexOf(o);
}
public ListIterator<ResultItem> listIterator() {
	return resultItemList.listIterator();
}
public ListIterator<ResultItem> listIterator(int index) {
	return resultItemList.listIterator(index);
}
public List<ResultItem> subList(int fromIndex, int toIndex) {
	return resultItemList.subList(fromIndex, toIndex);
}
public Spliterator<ResultItem> spliterator() {
	return resultItemList.spliterator();
}
public void setUser(User user) {
	this.user = user;
}
public void setTest(Test test) {
	this.test = test;
}
public void setScore(Score score) {
	this.score = score;
}


}
