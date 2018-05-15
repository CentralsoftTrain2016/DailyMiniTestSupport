package domain;

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

import domain.value.date.EndDate;
import domain.value.date.StartDate;
import domain.value.id.CreateUserID;
import domain.value.id.ID;
import domain.value.id.ThemePeriodID;

public class ThemePeriod implements List<Theme>{

	private ThemePeriodID themePeriodID;	// テーマ期間ID
	private CreateUserID createUserID;		// ユーザID
	private StartDate startDate;			// テーマ開始日
	private EndDate endDate;				// テーマ終了日

	// テーマリスト
	private List <Theme> themeList = new ArrayList<Theme>();
	private Map <String, Theme> themeMap = new HashMap<String,Theme>();


	/* コンストラクタ */
	public ThemePeriod(ThemePeriodID themePeriodID, CreateUserID createUserID, StartDate startDate
									, EndDate endDate){
		this.themePeriodID = themePeriodID;
		this.createUserID = createUserID;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public ThemePeriodID getThemePeriodID() {
		return themePeriodID;
	}



	public void setThemePeriodID(ThemePeriodID themePeriodID) {
		this.themePeriodID = themePeriodID;
	}



	public CreateUserID getCreateUserID() {
		return createUserID;
	}



	public void setCreateUserID(CreateUserID createUserID) {
		this.createUserID = createUserID;
	}



	public StartDate getStartDate() {
		return startDate;
	}



	public void setStartDate(StartDate startDate) {
		this.startDate = startDate;
	}



	public EndDate getEndDate() {
		return endDate;
	}



	public void setEndDate(EndDate endDate) {
		this.endDate = endDate;
	}



	public Theme get(ID key) {
		return themeMap.get(key.toString());
	}



	public  void forEach(Consumer<? super Theme> action) {
		themeList.forEach(action);
	}


	public int size() {
		return themeList.size();
	}


	public boolean isEmpty() {
		return themeList.isEmpty();
	}


	public boolean contains(Object o) {
		return themeList.contains(o);
	}


	public Iterator<Theme> iterator() {
		return themeList.iterator();
	}


	public Object[] toArray() {
		return themeList.toArray();
	}


	public <T> T[] toArray(T[] a) {
		return themeList.toArray(a);
	}


	public boolean add(Theme e) {
		themeMap.put(e.getThemeID().toString(), e);
		return themeList.add(e);
	}


	public boolean remove(Object o) {
		themeMap.remove((String)o);
		return themeList.remove(o);
	}


	public boolean containsAll(Collection<?> c) {
		//themeMap.putAll(c);
		return themeList.containsAll(c);
	}


	public boolean addAll(Collection<? extends Theme> c) {
		return themeList.addAll(c);
	}


	public boolean addAll(int index, Collection<? extends Theme> c) {
		return themeList.addAll(index, c);
	}


	public boolean removeAll(Collection<?> c) {
		return themeList.removeAll(c);
	}


	public boolean retainAll(Collection<?> c) {
		return themeList.retainAll(c);
	}


	public  void replaceAll(UnaryOperator<Theme> operator) {
		themeList.replaceAll(operator);
	}


	public  boolean removeIf(Predicate<? super Theme> filter) {
		return themeList.removeIf(filter);
	}


	public  void sort(Comparator<? super Theme> c) {
		themeList.sort(c);
	}


	public void clear() {
		themeMap.clear();
		themeList.clear();
	}


	public boolean equals(Object o) {
		return themeList.equals(o);
	}


	public int hashCode() {
		return themeList.hashCode();
	}


	public Theme get(int index) {
		return themeList.get(index);
	}


	public Theme set(int index, Theme element) {
		return themeList.set(index, element);
	}


	public void add(int index, Theme element) {
		themeMap.put(element.getThemeID().toString(), element);
		themeList.add(index, element);
	}


	public  Stream<Theme> stream() {
		return themeList.stream();
	}


	public Theme remove(int index) {
		return themeList.remove(index);
	}


	public  Stream<Theme> parallelStream() {
		return themeList.parallelStream();
	}


	public int indexOf(Object o) {
		return themeList.indexOf(o);
	}


	public int lastIndexOf(Object o) {
		return themeList.lastIndexOf(o);
	}


	public ListIterator<Theme> listIterator() {
		return themeList.listIterator();
	}


	public ListIterator<Theme> listIterator(int index) {
		return themeList.listIterator(index);
	}


	public List<Theme> subList(int fromIndex, int toIndex) {
		return themeList.subList(fromIndex, toIndex);
	}


	public  Spliterator<Theme> spliterator() {
		return themeList.spliterator();
	}


	@Override
	public String toString() {
		return "ThemePeriod [themePeriodID=" + themePeriodID + ", createUserID=" + createUserID + ", startDate="
				+ startDate + ", endDate=" + endDate + ", themeList=" + themeList + "]";
	}


}
