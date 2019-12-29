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

    /*ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
        // disable SSL/TLS - for local development
        //.usePlaintext()
            .build();

    private DemoServiceGrpc.DemoServiceBlockingStub client = DemoServiceGrpc.newBlockingStub(channel);*/

    @PostConstruct
    public String getDemo() {
        DemoRequest request = DemoRequest.newBuilder()
            .setNumber(100)
            .build();

        log.info("Sending request to the server...");
        DemoResponse response = client.demo(request);
        log.info("Response: {}", response.toString());

        return response.getResult();
    }
}