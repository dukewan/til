# MongoDB

Two ways to configure MongoDB connection details:

+ specify details in application.yml in the format required for MongoDB connection:
```plain
spring:
	data:
        mongodb:
            uri: "mongodb://your.ip.adress.here:27017/yourdbname"  
```
and it's all set!

+ define a freeform configuration in application.yml
```plain
mongodb:
    # list of all servers in the mongo cluster (one line per server)
    servers:
        - {host: your.ip.adress.here, port: 27017}
    dbNames:
        sortRankDB: yourdbname
```
then, write a config class to extend `AbstractMongoConfiguration` , we need to override several methods: `mongo()`,  `getDatabaseName()`.
Some impeletation:
```java
@Override
    @Bean
    public Mongo mongo() throws UnknownHostException {
        return null == mongoClient ? createMongoClient(getServerAddresses()) : mongoClient;
    }

    @Override
    public String getDatabaseName() {
        return dbNames.get("sortRankDB");
    }

    protected MongoClient createMongoClient(List<ServerAddress> servers) {
        return new MongoClient(servers);
    }

    private List<ServerAddress> getServerAddresses() throws UnknownHostException {
        final List<ServerAddress> serverAddressList = new ArrayList<>();
        for (final MongoServer server : getServers()) {
            serverAddressList.add(new ServerAddress(server.getHost(), server.getPort()));
        }
        return serverAddressList;
    }
```
