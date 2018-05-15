package db;

import java.sql.Connection;

import domain.value.Message;

public class SampleDao extends Dao{

	public SampleDao(Connection con) {
		super(con);
	}

	public Message getMessage() {
		return new Message("メッセージです。");
	}

}
