package hello;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Application {

	@RequestMapping("/")
	public String home(@RequestParam("name") String name) throws InterruptedException, ExecutionException {
		Future<String> helloWorldResult = new CommandHelloWorld(name).queue();
		return helloWorldResult.get();	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}