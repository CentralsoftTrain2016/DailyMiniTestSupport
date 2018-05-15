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

import domain.Test;
import domain.value.id.TestID;

public class TestListBean extends PagingBean implements List<TestListItem>{

	private List<TestListItem> testListItemList = new ArrayList<TestListItem>();	// テストリストアイテム
	private Map<String, Test> testListItemMap = new HashMap<String, Test>();
	int allPage;
	int nowPage;
	int items;

	/* コンストラクタ */
	public TestListBean(){
		super();
	}

	// 特殊なAddメソッド
	public void addUniqueTest(TestListItem testListItem){
		Test test = searchTest(testListItem.getTest().getTestID());
		// テストが同じ問題をまとめる
		if(test != null){
			test.add(testListItem.getTest().get(0));
		}else{
			testListItemList.add(testListItem);
			testListItemMap.put(testListItem.getTest().getTestID().toString(), testListItem.getTest());
		}
	}

	// 比較
	private Test searchTest(TestID testID){
		return testListItemMap.get(testID.toString());
//		for(TestListItem testListItem : testListItemList){
//			boolean flg = testListItem.getTest().getTestID().equals(testID);
//			if(flg){
//				return testListItem.getTest();
//			}
//		}
//		return null;
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

	public List<TestListItem> getTestListItemList() {
		return testListItemList;
	}

	public void setTestListItemList(List<TestListItem> testListItemList) {
		this.testListItemList = testListItemList;
	}

	public void forEach(Consumer<? super TestListItem> action) {
		testListItemList.forEach(action);
	}

	public int size() {
		return testListItemList.size();
	}

	public boolean isEmpty() {
		return testListItemList.isEmpty();
	}

	public boolean contains(Object o) {
		return testListItemList.contains(o);
	}

	public Iterator<TestListItem> iterator() {
		return testListItemList.iterator();
	}

	public Object[] toArray() {
		return testListItemList.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return testListItemList.toArray(a);
	}

	public boolean add(TestListItem e) {
		return testListItemList.add(e);
	}

	public boolean remove(Object o) {
		return testListItemList.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return testListItemList.containsAll(c);
	}

	public boolean addAll(Collection<? extends TestListItem> c) {
		return testListItemList.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends TestListItem> c) {
		return testListItemList.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return testListItemList.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return testListItemList.retainAll(c);
	}

	public void replaceAll(UnaryOperator<TestListItem> operator) {
		testListItemList.replaceAll(operator);
	}

	public boolean removeIf(Predicate<? super TestListItem> filter) {
		return testListItemList.removeIf(filter);
	}

	public void sort(Comparator<? super TestListItem> c) {
		testListItemList.sort(c);
	}

	public void clear() {
		testListItemList.clear();
	}

	public boolean equals(Object o) {
		return testListItemList.equals(o);
	}

	public int hashCode() {
		return testListItemList.hashCode();
	}

	public TestListItem get(int index) {
		return testListItemList.get(index);
	}

	public TestListItem set(int index, TestListItem element) {
		return testListItemList.set(index, element);
	}

	public void add(int index, TestListItem element) {
		testListItemList.add(index, element);
	}

	public Stream<TestListItem> stream() {
		return testListItemList.stream();
	}

	public TestListItem remove(int index) {
		return testListItemList.remove(index);
	}

	public Stream<TestListItem> parallelStream() {
		return testListItemList.parallelStream();
	}

	public int indexOf(Object o) {
		return testListItemList.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return testListItemList.lastIndexOf(o);
	}

	public ListIterator<TestListItem> listIterator() {
		return testListItemList.listIterator();
	}

	public ListIterator<TestListItem> listIterator(int index) {
		return testListItemList.listIterator(index);
	}

	public List<TestListItem> subList(int fromIndex, int toIndex) {
		return testListItemList.subList(fromIndex, toIndex);
	}

	public Spliterator<TestListItem> spliterator() {
		return testListItemList.spliterator();
	}


}
