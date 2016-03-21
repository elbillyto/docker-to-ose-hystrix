package hello;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * The obligatory "Hello World!" showing a simple implementation of a {@link HystrixCommand}.
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    protected CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("SpringBootGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception{
        return "Hello " + name + "!";
    }    

}
