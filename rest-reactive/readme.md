
### run docker image
```shell
docker run -d --name mongodb -p 27017:27017 \
-e MONGO_INITDB_ROOT_USERNAME=admin \
-e MONGO_INITDB_ROOT_PASSWORD=admin mongo:latest
```


### request stream of data 
``` shell
curl -H "accept: text/event-stream" -X GET 'http://localhost:8081/account?username=oscar'
```