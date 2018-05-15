package service.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import domain.Result;
import domain.User;
import domain.value.id.ResultID;

public class ScoreListBean extends PagingBean implements List<Result>{

	private List<Result> resultList = new ArrayList<Result>();
	private List<User> userList = new ArrayList<User>();
	private Map<String, Result> scoreListItemMap = new HashMap<String, Result>();
	private int allPage;				// 前ページ数
	private int nowPage;				// 現在のページ番号
	private int items;					// レコード数

	/* コンストラクタ */
	public ScoreListBean(){
		super();
	}

	// 比較
	private Result searchTest(ResultID resultID){
		return scoreListItemMap.get(resultID.toString());
	}



	public void forEach(Consumer<? super Result> action) {
	resultList.forEach(action);
	}

	public int size() {
		return resultList.size();
	}

	public boolean isEmpty() {
		return resultList.isEmpty();
	}

	public boolean contains(Object o) {
		return resultList.contains(o);
	}

	public Iterator<Result> iterator() {
		return resultList.iterator();
	}

	public Object[] toArray() {
		return resultList.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return resultList.toArray(a);
	}

	public boolean add(Result e) {
		return resultList.add(e);
	}

	public boolean remove(Object o) {
		return resultList.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return resultList.containsAll(c);
	}

	public boolean addAll(Collection<? extends Result> c) {
		return resultList.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Result> c) {
		return resultList.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return resultList.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return resultList.retainAll(c);
	}

	public void replaceAll(UnaryOperator<Result> operator) {
		resultList.replaceAll(operator);
	}

	public boolean removeIf(Predicate<? super Result> filter) {
		return resultList.removeIf(filter);
	}

	public void sort(Comparator<? super Result> c) {
		resultList.sort(c);
	}

	public void clear() {
		resultList.clear();
	}

	public boolean equals(Object o) {
		return resultList.equals(o);
	}

	public int hashCode() {
		return resultList.hashCode();
	}

	public Result get(int index) {
		return resultList.get(index);
	}

	public Result set(int index, Result element) {
		return resultList.set(index, element);
	}

	public void add(int index, Result element) {
		resultList.add(index, element);
	}

	public Stream<Result> stream() {
		return resultList.stream();
	}

	public Result remove(int index) {
		return resultList.remove(index);
	}

	public Stream<Result> parallelStream() {
		return resultList.parallelStream();
	}

	public int indexOf(Object o) {
		return resultList.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return resultList.lastIndexOf(o);
	}

	public ListIterator<Result> listIterator() {
		return resultList.listIterator();
	}

	public ListIterator<Result> listIterator(int index) {
		return resultList.listIterator(index);
	}

	public List<Result> subList(int fromIndex, int toIndex) {
		return resultList.subList(fromIndex, toIndex);
	}

	public Spliterator<Result> spliterator() {
		return resultList.spliterator();
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Result> getResultList() {
		return resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}

	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
}
