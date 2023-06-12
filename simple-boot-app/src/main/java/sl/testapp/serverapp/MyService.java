package sl.testapp.serverapp;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class MyService {

	private final MyRepository myRepository;
}
