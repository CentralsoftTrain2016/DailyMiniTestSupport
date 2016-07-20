package service;

import db.SampleDao;
import domain.value.Message;
import service.bean.SampleBean;

public class SampleService extends Service {
	private SampleDao sampleDao;

	@Override
	void prePare() {
		sampleDao = new SampleDao(this.con);
	}

	public SampleBean doSometing() {
		Message message = sampleDao.getMessage();

		SampleBean sampleBean =  new SampleBean();
		sampleBean.setMessage( message);
		return sampleBean;
	}

}
