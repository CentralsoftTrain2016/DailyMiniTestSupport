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

import domain.value.AverageScore;
import domain.value.LoginUserName;
import domain.value.Password;
import domain.value.TestCount;
import domain.value.UserName;
import domain.value.Enum.LoginRoleEnum;
import domain.value.id.UserID;

public class User implements List<Result>{
	private UserID userid;
	private UserName username;
	private LoginUserName loginusername;
	private Password password;
	private AverageScore averagescore;
	private LoginRoleEnum loginRoleEnum;
	private List<Result> myResultList = new ArrayList<Result>();
	private TestCount testCount;


	public User() {
		super();
	}


	public User(UserID userid) {
		super();
		this.userid = userid;
	}

	public TestCount getTestCount() {
		return testCount;
	}

	public void setTestCount(TestCount testCount) {
		this.testCount = testCount;
	}

	public LoginRoleEnum getLoginRoleEnum() {
		return loginRoleEnum;
	}

	public void setLoginRoleEnum(LoginRoleEnum loginRoleEnum) {
		this.loginRoleEnum = loginRoleEnum;
	}

	public void forEach(Consumer<? super Result> action) {
		myResultList.forEach(action);
	}

	public int size() {
		return myResultList.size();
	}

	public boolean isEmpty() {
		return myResultList.isEmpty();
	}

	public boolean contains(Object o) {
		return myResultList.contains(o);
	}

	public Iterator<Result> iterator() {
		return myResultList.iterator();
	}

	public Object[] toArray() {
		return myResultList.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return myResultList.toArray(a);
	}

	public boolean add(Result e) {
		return myResultList.add(e);
	}

	public boolean remove(Object o) {
		return myResultList.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return myResultList.containsAll(c);
	}

	public boolean addAll(Collection<? extends Result> c) {
		return myResultList.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Result> c) {
		return myResultList.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return myResultList.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return myResultList.retainAll(c);
	}

	public void replaceAll(UnaryOperator<Result> operator) {
		myResultList.replaceAll(operator);
	}

	public boolean removeIf(Predicate<? super Result> filter) {
		return myResultList.removeIf(filter);
	}

	public void sort(Comparator<? super Result> c) {
		myResultList.sort(c);
	}

	public void clear() {
		myResultList.clear();
	}

	public boolean equals(Object o) {
		return myResultList.equals(o);
	}

	public int hashCode() {
		return myResultList.hashCode();
	}

	public Result get(int index) {
		return myResultList.get(index);
	}

	public Result set(int index, Result element) {
		return myResultList.set(index, element);
	}

	public void add(int index, Result element) {
		myResultList.add(index, element);
	}

	public Stream<Result> stream() {
		return myResultList.stream();
	}

	public Result remove(int index) {
		return myResultList.remove(index);
	}

	public Stream<Result> parallelStream() {
		return myResultList.parallelStream();
	}

	public int indexOf(Object o) {
		return myResultList.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return myResultList.lastIndexOf(o);
	}

	public ListIterator<Result> listIterator() {
		return myResultList.listIterator();
	}

	public ListIterator<Result> listIterator(int index) {
		return myResultList.listIterator(index);
	}

	public List<Result> subList(int fromIndex, int toIndex) {
		return myResultList.subList(fromIndex, toIndex);
	}

	public Spliterator<Result> spliterator() {
		return myResultList.spliterator();
	}

	public UserID getUserid() {
		return userid;
	}

	public UserName getUsername() {
		return username;
	}

	public LoginUserName getLoginusername() {
		return loginusername;
	}

	public Password getPassword() {
		return password;
	}

	public AverageScore getAveragescore() {
		return averagescore;
	}

	public void setUserid(UserID userid) {
		this.userid = userid;
	}

	public void setUsername(UserName username) {
		this.username = username;
	}

	public void setLoginusername(LoginUserName loginusername) {
		this.loginusername = loginusername;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public void setAveragescore(AverageScore averagescore) {
		this.averagescore = averagescore;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", loginusername=" + loginusername + ", password="
				+ password + ", averagescore=" + averagescore + ", loginRoleEnum=" + loginRoleEnum + ", myResultList="
				+ myResultList + ", testCount=" + testCount + "]";
	}

}
