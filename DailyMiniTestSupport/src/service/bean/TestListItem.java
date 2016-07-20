package service.bean;

import domain.Result;
import domain.Test;

public class TestListItem extends Bean{

	private Test test;		// テスト
	private Result result;	// テスト結果

	/* コンストラクタ */
	public TestListItem(){
		super();
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
