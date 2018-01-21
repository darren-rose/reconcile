### Reconcile Service

##### Run Tests

`gradle test`

##### Run the service

An endpoint expected an HTTP POST method will be exposed at: [http://localhost:8080/reconcile](http://localhost:8080/reconcile)

`gradle bootrun`

##### Make example request

`curl -X POST -H "Content-Type: application/json" -d {}  http://localhost:8080/reconcile`