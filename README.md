# Kafka example application
This simple application is listening for all
messages in Kafka's 'applicationTopic' topic and
publishes there 100 messages after start.

Also, this service can receive messages via
`POST http://localhost:8080/api/v1/messages`

### Run
Use **wsl** on windows, build app and run there
with Kafka