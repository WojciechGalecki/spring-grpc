package wg.grpc.server;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import com.proto.demo.DemoRequest;
import com.proto.demo.DemoResponse;
import com.proto.demo.DemoServiceGrpc;

@GrpcService
@Slf4j
public class DemoService extends DemoServiceGrpc.DemoServiceImplBase {

    @Override
    public void demo(DemoRequest request, StreamObserver<DemoResponse> responseObserver) {
        log.info("Received demo request: {}", request.getNumber());

        responseObserver.onNext(DemoResponse.newBuilder()
            .setResult("Received: " + request.getNumber())
            .build());

        responseObserver.onCompleted();
    }
}
