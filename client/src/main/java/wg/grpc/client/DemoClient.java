package wg.grpc.client;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;

import org.springframework.stereotype.Service;

import com.proto.demo.DemoRequest;
import com.proto.demo.DemoResponse;
import com.proto.demo.DemoServiceGrpc;

@Service
@Slf4j
public class DemoClient {

    @GrpcClient("localhost:9090")
    private DemoServiceGrpc.DemoServiceBlockingStub client;

    //@PostConstruct
    public String getDemo() {
        DemoRequest request = DemoRequest.newBuilder()
            .setNumber(100)
            .build();

        log.info("Sending demo request to the server...");
        DemoResponse response = client.demo(request);
        log.info("Demo response: {}", response.toString());

        return response.getResult();
    }
}