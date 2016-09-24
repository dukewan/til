# Configuration and Retrieve Info

+ Use application.yml to store the configuration infos
+ eg: mongodb config in application.yml:

```yml
mongodb:
    # list of all servers in the mongo cluster (one line per server)
    servers:
        - {host: your.ip.address.here, port: 27017}
    dbNames:
        sortRankDB: yourdbname
```
+ Use below to retrieve the configurations and reflection to Java classes:

```java
@Configuration
@ConfigurationProperties(prefix = "mongodb", ignoreUnknownFields = false)
@EnableConfigurationProperties
@EnableAutoConfiguration
```

+ Need to implement every property in the Java class, otherwise properties in configuration cann't be binded to class property and errors arise
