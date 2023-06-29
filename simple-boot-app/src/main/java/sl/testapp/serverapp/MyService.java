package sl.testapp.serverapp;

import org.springframework.stereotype.Service;

@Service
class MyService {

	private final MyRepository myRepository;

	public MyService(MyRepository myRepository) {
		this.myRepository = myRepository;
	}
}
