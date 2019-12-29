package wg.grpc.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.grpc.internal.testing.StreamRecorder;

import org.junit.Test;

import com.proto.demo.DemoRequest;
import com.proto.demo.DemoResponse;

public class DemoServiceTest {

    private DemoService service = new DemoService();

    @Test
    public void demo() {
        DemoRequest request = DemoRequest.newBuilder()
            .setNumber(1)
            .build();

        StreamRecorder<DemoResponse> responseObserver = StreamRecorder.create();

        service.demo(request, responseObserver);

        assertNull(responseObserver.getError());
        assertEquals("Received: 1", responseObserver.getValues().get(0).getResult());
    }
}