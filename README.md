# spring-grpc

Basic SpringBoot application with gRPC unary server and client

# structure
- `grpc-interface` -> module with `.proto` files and place for auto-generated gRPC classes
- `server` -> module with gRPC Java server
- `client` -> module with gRPC Java client

# start
- run `run_db.sh` to start MongoDB docker container on `localhost:27017`
- download and configure `Robo 3T` to check your database:
https://robomongo.org/
- run `generateProto` gradle task to generate gRPC files based on `.proto` definition
- run `ServerApplication` to launch the server on port `50051`. You can configure port in `application.yml` file
- run `ClientApplication` to send request to the server

You can play with fully compatible gRPC Python server and client from:
https://github.com/WojciechGalecki/python_grpc_api

More info about gRPC with Spring:
https://github.com/yidongnan/grpc-spring-boot-starter
