### Reconcile Service


##### Run Tests

`gradle test`

##### Run the service

An endpoint expecting an HTTP POST method will be exposed at: [http://localhost:8080/reconcile](http://localhost:8080/reconcile) when the following command is run:

`gradle bootrun`

##### Make example request

`curl -X POST -H "Content-Type: application/json" -d {}  http://localhost:8080/reconcile`

##### Build a jar

`gradle assemble`

##### Run using the jar

`java -jar build/libs/service-0.0.1-SNAPSHOT.jar` 
